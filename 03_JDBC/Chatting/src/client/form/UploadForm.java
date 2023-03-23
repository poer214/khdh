package client.form;

import java.io.File;

import javax.swing.JFileChooser;



public class UploadForm extends JFileChooser{
	ChattingForm chat;
	String fileName;
	File file;
	
	public UploadForm(ChattingForm chat) {
		this.chat = chat;
	}
	
	public File uploadForm() {
		int kind = this.showOpenDialog(chat);
		if (kind == this.APPROVE_OPTION) {
			file = this.getSelectedFile();
			fileName = file.getName();
		}
		return file;
	}

}
