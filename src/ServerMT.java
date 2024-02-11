import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread{
   int nbClients;
 @Override
public void run() {
	// TODO Auto-generated method stub
	 try {
		ServerSocket ss= new ServerSocket(11000);
		System.out.println("Starting of the server multi clients...");
		while(true) {
		Socket s=ss.accept();
		 nbClients++;
		new Chat(s,nbClients).start();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 public class Chat extends Thread{
	 private Socket socketClient;
	 private int nbClients;
	 public Chat(Socket socketClient,int nbClients) {
		super();
		this.socketClient = socketClient;
		this.nbClients=nbClients;
	}
	@Override
	 public void run() {
	 	// code for chatting  input & output 
		
		try{
			InputStream is = socketClient.getInputStream();
			InputStreamReader isr= new InputStreamReader(is);
			BufferedReader br= new BufferedReader(isr);
			
			OutputStream os=socketClient.getOutputStream();
			PrintWriter pw=new PrintWriter(os,true);
			String ip=socketClient.getRemoteSocketAddress().toString();
			System.out.println("connexion du client num:"+nbClients+", IP= "+ip);
			pw.println("bienvenue our client "+nbClients);
			while(true) {
				String req= br.readLine();
				if(req!=null) {
				String resp= "size="+req.length();
				pw.println(resp);}
			}
			
		 
		 	
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 }
		
 
 
 
 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          new ServerMT().start();
	}

}
