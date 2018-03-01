import java.awt.Button;
import java.awt.Frame;

public class TestNullLayOut {

	//测试绝对定位
	
	Frame frame = new Frame();
	Button b1 = new Button("按钮1");
	Button b2 = new Button("按钮2");
	public void init(){
		
		//设置布局管理器为null
		frame.setLayout(null);
		b1.setBounds(20,30, 90, 28);
		frame.add(b1);
		b2.setBounds(50,45, 120, 35);
		frame.add(b2);
		frame.setBounds(50, 50, 200, 100);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new TestNullLayOut().init();
	}
}
