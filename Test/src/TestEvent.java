import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestEvent {

	//事件监听器
	Frame frame = new Frame("测试事件监听");
	Button button = new Button("ok");
	TextField textField = new TextField(30);
	public void init(){
		
		//注册事件监听
		button.addActionListener(new OkListener());
		frame.add(textField);
		frame.add(button,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	//定义事件监听
	class OkListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("用户单击了ok按钮");
			textField.setText("hello");
		}
		
	}
	public static void main(String[] args) {
		new TestEvent().init();
	}
}
