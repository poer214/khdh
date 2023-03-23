package server.function;


import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import server.thread.ClientThread;


public class SendHash {
	ClientThread clientT;
	HashMap response;
	
	public SendHash(ClientThread clientT ,HashMap response) {
		this.clientT = clientT;
		this.response = response;
	}
	
	public void send() {
		try {
			clientT.oout.writeObject(response);
		} catch (IOException e) {
			try {
				clientT.in.close();
				clientT.out.close();
				clientT.oout.close();
				clientT.oin.close();
				clientT.socket.close();
			} catch (Exception e1) {
			}
			synchronized(clientT.accept.clients) {
				clientT.accept.clients.remove(clientT);
			}
		}
	}
	
}	
