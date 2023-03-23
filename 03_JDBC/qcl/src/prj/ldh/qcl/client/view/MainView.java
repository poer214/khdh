package prj.ldh.qcl.client.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame {
    private JLabel title;
    private JLabel idLabel;
    private JLabel pwLabel;
//    private PrintWriter writer;
//    private BufferedReader reader;
    
	public MainView() {
		// UI 구성
//        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton loginButton = new JButton("LOGIN");
        JButton joinButton = new JButton("JOIN");

        JPanel panel = new JPanel();
//        panel.add(textField);
        panel.add(loginButton);
        panel.add(joinButton);

//        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // 버튼과 텍스트 필드 리스너 등록
//        sendButton.addActionListener(this);
//        textField.addActionListener(this);

        // 소켓 연결
//        try {
//            Socket socket = new Socket("localhost", 9000); // 서버 주소와 포트번호
//            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            Thread receiveThread = new Thread(new ReceiveThread());
//            receiveThread.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // UI 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
	}

    // 메시지 전송 처리
//    public void actionPerformed(ActionEvent e) {
//        String message = textField.getText();
//        if (message != null && message.length() > 0) {
//            writer.println(message);
//            writer.flush();
//            textField.setText("");
//        }
//    }

    // 메시지 수신 처리
//    class ReceiveThread implements Runnable {
//        public void run() {
//            try {
//                String message = null;
//                while ((message = reader.readLine()) != null) {
//                    textArea.append(message + "\n");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}