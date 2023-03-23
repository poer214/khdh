import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MapClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 서버에 연결
        Socket socket = new Socket("localhost", 5000);
        System.out.println("서버 연결");

        // Map 객체 생성
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("orange", 1);
        System.out.println("보내는 데이터: " + map);

        // 서버로 Map 객체를 전송
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(map);
        objectOutputStream.flush();

        // 서버에서 보낸 Map 객체를 읽어옴
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Map<String, Integer> resultMap = (Map<String, Integer>) objectInputStream.readObject();
        System.out.println("받은 데이터: " + resultMap);

        // 소켓을 닫음
        socket.close();
    }
}