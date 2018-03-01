import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class TestBoxLayout2 {

	//测试boxlayout的组件间隔
	private Frame frame = new Frame();
	//创建水平组件
	private Box box1 = Box.createHorizontalBox();
	//创建竖直组件
	private Box box2 = Box.createVerticalBox();
	
	private void init(){
		
		//创建水平按钮
		box1.add(new Button("水平按钮1"));
		box1.add(Box.createHorizontalStrut(10));
		box1.add(new Button("水平按钮2"));
		box1.add(Box.createHorizontalStrut(20));
		box1.add(new Button("水平按钮3"));
		box2.add(new Button("竖直按钮1"));
		box2.add(Box.createVerticalStrut(10));
		box2.add(new Button("竖直按钮2"));
		frame.add(box1,BorderLayout.NORTH);
		frame.add(box2);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new TestBoxLayout2().init();
	}
}
