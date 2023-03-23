package prj.ldh.qcl.server.run;

import prj.ldh.qcl.server.server.QCLServer;

public class QCLServerRun {
	
	private QCLServerRun(){
		new QCLServer();
	}
	
	public static void main(String[] args) {
		new QCLServerRun();
	}
}