import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;

public class TestDialog {

	//测试对话框（Dialog）
	Frame frame = new Frame();
	Dialog dialog1 = new Dialog(frame,"模式对话框",true);
	Dialog dialog2 = new Dialog(frame,"非模式对话框",false);
	Button b1 = new Button("打开模式对话框");
	Button b2 = new Button("打开非模式对话框");
	public void init(){
		
		dialog1.setBounds(20,30,300,400);
		dialog2.setBounds(20,30,300,400);
		b1.addActionListener(e->dialog1.setVisible(true));
		b2.addActionListener(e->dialog2.setVisible(true));
		frame.add(b1);
		frame.add(b2,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		
		new TestDialog().init();
	}
}
