import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {
	Map<String, Socket> clients = Collections.synchronizedMap(new HashMap<>());
	public Test() {
	}
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			System.out.println();
			serverSocket = new ServerSocket(9999);
			while(true) {
				socket = serverSocket.accept();
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Test();
	}
	
	class ServerReceiver extends Thread {
		Socket socket; DataInputStream in; DataOutputStream out;
		ServerReceiver(Socket socket){
			this.socket = socket;
		
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch(Exception e) {e.printStackTrace();}
		}
	}
}
