import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class TestBoxLayout {

	//BoxLayout布局管理器
	Frame frame = new Frame();
	//定义水平摆放组件
	private Box box1 = Box.createHorizontalBox();
	//创建竖直摆放的组件
	private Box box2 = Box.createVerticalBox();
	public void init(){
		//按钮竖直排列
		box1.add(new Button("水平按钮1"));
		box1.add(new Button("水平按钮2"));
		box2.add(new Button("竖直按钮1"));
		box2.add(new Button("竖直按钮2"));
		frame.add(box1,BorderLayout.NORTH);
		frame.add(box2);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new TestBoxLayout().init();
	}
}
