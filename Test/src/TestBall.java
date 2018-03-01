import java.awt.Canvas;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Timer;

public class TestBall {

	//测试弹球
	//定义桌面面积
	final int Table_WIDTH = 300;
	final int Table_HEIGHT = 400;
	//球拍处置距离
	final int RACKET_Y = 340;
	//定义球拍的高度和宽度
	final int RACKET_WIDTH = 60;
	final int RACKET_HEIGHT = 20;
	//小球大小
	final int ball_size = 16;
	private Frame frame = new Frame("弹球游戏");
	Random random = new Random();
	//小球纵向运行速度
	int ySpeed = 10;
	//返回-0.5到0.5，用于控制小球方向
	double xyRate = random.nextDouble()-0.5;
	//小球横向运行速度
	int xspeed = (int)(ySpeed*xyRate*2);
	int ballx = random.nextInt(200)+20;
	int bally = random.nextInt(10)+10;
	//球拍的水平位置
	int racketX = random.nextInt(200);
	MyCanvs tableArea = new MyCanvs();
	Timer timer;
	//结束标志
	boolean isLose = false;
	//初始化方法
	public void init(){
		//创建退出监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
				}
			});
		
		//设置桌面区域的大小
		tableArea.setPreferredSize(new Dimension(Table_WIDTH,Table_HEIGHT));
		frame.add(tableArea);
		//定义键盘监听器
		KeyAdapter keyProcessor = new KeyAdapter() {
			public void keyPressed(KeyEvent ke){
				//摁下向右向左键的时候，球拍水平坐标分别减少增加
				if(ke.getKeyCode()==KeyEvent.VK_LEFT){
					if(racketX>0){
						racketX -= 10;
					}
				}
				if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
					if(racketX<Table_WIDTH - RACKET_WIDTH){
						racketX += 10;
					}
				}
			}
		};
		
		//为窗口和tableArea对象分别添加键盘监听器
		frame.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		//定义每0.1秒执行一次的事件监听器
		ActionListener taskPerformer = evt->
		{
			//如果小球碰到左边框
			if(ballx<=0||ballx>=Table_WIDTH-ball_size){
				xspeed = -xspeed;
			}
			//如果小球高度超出球拍的位置，切横向不再球拍范围之内，游戏结束
			if(bally>=RACKET_Y-ball_size&&(ballx<racketX||ballx>racketX+RACKET_WIDTH)){
				timer.stop();
				//设置游戏是否结束
				isLose = true;
				tableArea.repaint();
			}
			//如果小球位于球拍之内，且到达球拍位置，反弹
			else if(bally<=0||(bally>=RACKET_Y-ball_size&&ballx>racketX
					&&ballx<=racketX+RACKET_WIDTH)){
				ySpeed=-ySpeed;
			}
			//小球坐标增加
			bally+=ySpeed;
			ballx+=xspeed;
			tableArea.repaint();
		};
		timer = new Timer(100, taskPerformer);
		timer.start();
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		
		new TestBall().init();
	}
	
	//继承canvas类重写paint方法
	class MyCanvs extends Canvas
	{
		//重写
		public void paint(Graphics g) {
			//如果游戏已经结束
			if(isLose){
				g.setColor(new Color(255,0,0));
				g.setFont(new Font("Times",Font.BOLD,30));
				g.drawString("游戏结束",50,200);
			}
			//如果游戏还未结束
			else
			{
				//设置颜色，并绘制小球
				g.setColor(new Color(240,240,80));
				g.fillOval(ballx,bally,ball_size, ball_size);
				//设置颜色，并绘制球拍
				g.setColor(new Color(80,80,200));
				g.fillRect(racketX,RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
		}
	}
	
}
