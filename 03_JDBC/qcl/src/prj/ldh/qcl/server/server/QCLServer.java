package prj.ldh.qcl.server.server;

import java.io.IOException;
import java.net.ServerSocket;

public class QCLServer {
	ServerSocket ss;

	public QCLServer() {
		while (true) {
			try {
				ss = new ServerSocket(9000);
				ss.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}