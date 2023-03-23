package prj.ldh.qcl.server.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import prj.ldh.qcl.common.dto.Data;

public class ReceiveThread extends Thread{
	Socket client;
	ObjectMapper objectMapper;
	BufferedReader in;
	PrintWriter out;
	public ReceiveThread(Socket client) {
		super();
		this.client = client;
		objectMapper = new ObjectMapper();
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream());
			Data receivedMessage = objectMapper.readValue(in.readLine(), Data.class);
			System.out.println(receivedMessage.getType() + ": " + receivedMessage.getId()+receivedMessage.getPw());
		} catch (IOException e) {
			e.printStackTrace();
		}
//		start();
	}
	@Override
	public void run() {
		while(true) {
			try {
				Data receivedMessage = objectMapper.readValue(in.readLine(), Data.class);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}