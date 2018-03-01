import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestMultiListener {

	//测试一个监听器控制多个组件，与一个组件被多个监听器控制
	Frame frame = new Frame();
	TextArea textArea = new TextArea(6,40);
	Button button1 = new Button("按钮1");
	Button button2 = new Button("按钮2");
	public void init(){
		
		frame.addWindowListener(new close());
		//给组建添加监听器
		Listen1 listen1 = new Listen1();
		button1.addActionListener(listen1);
		button1.addActionListener(new listen2());
		button2.addActionListener(listen1);
		Panel panel = new Panel();
		panel.add(button1);
		panel.add(button2);
		frame.add(textArea);
		frame.add(panel,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		
	}
	//监听器1
	class Listen1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			textArea.append("监听器1事件源："+e.getActionCommand()+"\n");
		}
	}
	//监听器2
	class listen2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//获事件源e.getActionCommand()
			textArea.append("监听器2事件源："+e.getActionCommand()+"\n");
		}
	}
	//关闭窗口监听器
	class close implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			//关闭窗口
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[] args) {
		
		new TestMultiListener().init();
	}
	
}
