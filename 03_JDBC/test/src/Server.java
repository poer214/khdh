import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 9000;
        ObjectMapper objectMapper = new ObjectMapper();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // 클라이언트로부터 JSON 문자열을 받아 Message 객체로 변환
//                Message receivedMessage = objectMapper.readValue(in.readLine(), Message.class);
//                System.out.println("Received message from " + receivedMessage.getSender() + ": " + receivedMessage.getContent());
//
//                // 응답 메시지를 JSON 문자열로 변환하여 클라이언트에게 전송
//                Message responseMessage = new Message("Server", "Message received!");
//                out.println(objectMapper.writeValueAsString(responseMessage));
                Scanner sc = new Scanner(System.in);
                
                while(true) {
                	String message = sc.nextLine();
                	RequestData requestData = new RequestData("message",message);
                	out.println(objectMapper.writeValueAsString(requestData));
                }
            }
        }
    }
}
