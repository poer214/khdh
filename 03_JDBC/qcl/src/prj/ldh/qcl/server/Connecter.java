package prj.ldh.qcl.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import prj.ldh.qcl.common.dto.Data;

public class Connecter extends Thread {
	ServerSocket ss;
	Socket clientSocket;
	ObjectMapper objectMapper = new ObjectMapper();
	BufferedReader in;
	PrintWriter out;
	
	public Connecter() {
		while (true) {
			try {
				ss = new ServerSocket(9000);
				clientSocket = ss.accept();
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				this.start();
				Scanner sc = new Scanner(System.in);
				while (true) {
					String message = sc.nextLine();
					Data requestData = new Data("message", message);
					out.println(objectMapper.writeValueAsString(requestData));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Data receivedMessage = objectMapper.readValue(in.readLine(), Data.class);
				System.out.println(receivedMessage.getType() + ": " + receivedMessage.getContent());
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}