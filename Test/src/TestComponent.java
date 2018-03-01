import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.Box;

public class TestComponent {

	//常用组件
	Frame frame = new Frame();
	//按钮组件
	Button button = new Button("确认");
	//定义单选框组
	CheckboxGroup checkboxGroup = new CheckboxGroup();
	//定义单选框内容
	Checkbox checkbox1 = new Checkbox("男",checkboxGroup,true);
	Checkbox checkbox2 = new Checkbox("女",checkboxGroup,false);
	//定义复选框，初始默认没有选中
	Checkbox checkbox3 = new Checkbox("是否已婚？",false);
	//定义下拉选择框
	Choice choice = new Choice();
	//定义列表选择框
	List colorList = new List(0,false);
	//定义一个5行20列的多行文本
	TextArea textArea = new TextArea(5,20);
	//定义50列单行文本
	TextField name = new TextField(50);
	public void init(){
		
		colorList.add("红色");
		colorList.add("绿色");
		colorList.add("蓝色");
		colorList.add("红色");
		colorList.add("绿色");
		colorList.add("蓝色");
		choice.add("红色1");
		choice.add("绿色2");
		choice.add("蓝色3");
		//创建一个装载了文本框、按钮的panel
		Panel bottomPanel = new Panel();
		bottomPanel.add(name);
		bottomPanel.add(button);
		frame.add(bottomPanel,BorderLayout.SOUTH);
		//创建一个装载了下拉列表和三个Checkbox的组件
		Panel panel1 = new Panel();
		panel1.add(choice);
		panel1.add(checkbox1);
		panel1.add(checkbox2);
		panel1.add(checkbox3);
		//创建一个	垂直排列 
		Box topleft = Box.createVerticalBox();
		topleft.add(textArea);
		topleft.add(panel1);
		//创建一个水平的
		Box top = Box.createHorizontalBox();
		top.add(topleft);
		top.add(colorList);
		frame.add(top);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new TestComponent().init();
	}
}
