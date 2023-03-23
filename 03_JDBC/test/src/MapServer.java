import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MapServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 서버 소켓 생성
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("서버 시작");
        // 클라이언트의 연결 요청을 기다림
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트 연결");

        // 클라이언트로부터 Map 객체를 읽어옴
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Map<String, Integer> map = (Map<String, Integer>) objectInputStream.readObject();
        System.out.println("클라이언트로부터 받은 데이터: " + map);

        // Map 객체에 새로운 데이터 추가
        map.put("grape", 4);

        // 클라이언트로 Map 객체를 전송
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(map);
        objectOutputStream.flush();

        // 소켓과 서버 소켓을 닫음
        socket.close();
        serverSocket.close();
    }
}