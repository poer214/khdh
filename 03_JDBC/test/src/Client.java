import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int port = 12345;
        ObjectMapper objectMapper = new ObjectMapper();
        try (Socket socket = new Socket(serverAddress, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 서버에 보낼 메시지를 JSON 문자열로 변환
            Message messageToSend = new Message("Client", "Hello, Server!");
            out.println(objectMapper.writeValueAsString(messageToSend));

            // 서버로부터 응답 메시지를 받아 Message 객체로 변환하고 출력
            Message receivedMessage = objectMapper.readValue(in.readLine(), Message.class);
            System.out.println("Received message from " + receivedMessage.getSender() + ": " + receivedMessage.getContent());
        }
    }
}