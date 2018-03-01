import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;

public class TestFileDialog {

	//测试文件对话框
	Frame frame = new Frame("测试");
	FileDialog fileDialog1 = new FileDialog(frame,"选择需要打开的文件路径",FileDialog.LOAD);
	FileDialog fileDialog2 = new FileDialog(frame,"选择选择需要保存的路径",FileDialog.SAVE);
	Button button1 = new Button("打开文件");
	Button button2 = new Button("保存文件");
	public void init(){
		
		button1.addActionListener(e->{
			//定义事件处理,显示文件文件对话框,控制台输出文件路径与文件名
			fileDialog1.setVisible(true);
			System.out.println("文件路径："+fileDialog1.getDirectory()
			+"文件名："+fileDialog1.getFile());
		});
		button2.addActionListener(e->{
			//定义事件处理，显示文件对话框，控制台输出文件路径与文件名
			fileDialog2.setVisible(true);
			System.out.println("文件路径："+fileDialog2.getDirectory()
			+"文件名："+fileDialog2.getFile());
		});
		frame.add(button1);
		frame.add(button2,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		
		new TestFileDialog().init();
	}
}
