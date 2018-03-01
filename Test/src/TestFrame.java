import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class TestFrame {
	//测试布局	
	Frame frame = new Frame("测试窗口");
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	GridBagLayout gridBagLayout = new GridBagLayout();
	Button[] button = new Button[10];
	//测试窗口
	public void init() {
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1;
		frame.setLayout(gridBagLayout);
		for(int i = 0; i < button.length;i++){
			
			button[i]= new Button("按钮"+i);
		}
		
		addButton(button[0]);
		addButton(button[1]);
		addButton(button[2]);
		gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
		addButton(button[3]);
		//所有组件都可以在横向纵向向上扩大
		gridBagConstraints.weightx = 0;
		addButton(button[4]);
		//横跨两个网格
		gridBagConstraints.gridwidth = 2;
		addButton(button[5]);
		gridBagConstraints.gridwidth=GridBagConstraints.REMAINDER;
		addButton(button[6]);
		gridBagConstraints.gridheight=2;
		gridBagConstraints.gridwidth=1;
		gridBagConstraints.weighty=1;
		addButton(button[7]);
		gridBagConstraints.weighty=0;
		gridBagConstraints.gridheight=1;
		gridBagConstraints.gridwidth=GridBagConstraints.REMAINDER;
		addButton(button[8]);
		addButton(button[9]);
		frame.pack();
		frame.setVisible(true);
	}
	public void addButton(Button button){
		
		gridBagLayout.setConstraints(button, gridBagConstraints);
		frame.add(button);
	}
	public static void main(String[] args) {
		
		new TestFrame().init();
	}
}
