import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class TestDraw {

	//测试绘制普通图形
	Frame frame = new Frame("画布");
	Button button1 = new Button("绘制矩形 ");
	Button button2 = new Button("绘制椭圆形");
	MyCanvas myCanvas = new MyCanvas();
	String shape = "";
	public void init(){
		Panel panel =new Panel();
		//添加关闭监听器
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		//为绘制矩形按钮添加监听器
		button1.addActionListener(e->{
			
			//设置shape变量为rect
			shape = "rect";
			myCanvas.repaint();
		});
		//为绘制椭圆按钮添加监听器
		button2.addActionListener(e->{
			shape="oval";
			myCanvas.repaint();
		});
		panel.add(button1);
		panel.add(button2);
		myCanvas.setPreferredSize(new Dimension(250,180));
		frame.add(myCanvas);
		frame.add(panel,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestDraw().init();
	}
	class MyCanvas extends Canvas{
		
		//重写paint方法
		public void paint(Graphics g){
			Random random = new Random();
			if(shape.equals("rect")){
				//画矩形
				g.setColor(new Color(220,100,80));
				g.drawRect(random.nextInt(220),random.nextInt(120),
						40,60);
			}
			if(shape.equals("oval")){
				//画椭圆形
				g.setColor(new Color(80,100,200));
				g.drawOval(random.nextInt(220),random.nextInt(120),
						50,40);
			}
		}
	}
}
