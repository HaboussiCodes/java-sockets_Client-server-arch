import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	ServerSocket ss= new ServerSocket(22000);
	System.out.println("waiting connextion from client");
	Socket s=ss.accept();
	InputStream is = s.getInputStream();
	InputStreamReader isr= new InputStreamReader(is);
	BufferedReader br= new BufferedReader(isr);
	String str= br.readLine();
	System.out.println("receiving from client "+str);
	OutputStream os=s.getOutputStream();
	PrintWriter pw=new PrintWriter(os,true);
	pw.println("salem");
	
	s.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
