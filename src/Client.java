import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Socket s= new Socket("192.168.1.10",32000);
	//InputStream is = s.getInputStream();
	//OutputStream os=s.getOutputStream();
	//Scanner scanner = new Scanner(System.in);
	//System.out.print(" write a number: ");  
	//int nb= scanner.next();
	//os.write(nb);
	//int rep=is.read();
	//System.out.println("Results = "+rep);
	OutputStream os=s.getOutputStream();
	PrintWriter pw=new PrintWriter(os,true);
	pw.println(" hello msg");
	
	InputStream is = s.getInputStream();
	InputStreamReader isr= new InputStreamReader(is);
	BufferedReader br= new BufferedReader(isr);
	String str= br.readLine();
	System.out.println("receiving from server"+str);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
