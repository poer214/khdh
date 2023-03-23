package client.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import client.form.ChattingForm;
import client.form.UploadForm;
import client.thread.UploadBar;


public class UploadEvent implements ActionListener{
	ChattingForm chat;
	public UploadEvent(ChattingForm chat) {
		this.chat=chat;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		File file = new UploadForm(chat).uploadForm();
		if(file!=null) {
			new UploadBar(file,chat).start();
		}
	}

}
