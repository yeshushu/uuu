import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestSimpleMenu {

	//测试简单菜单
	Frame frame = new Frame("菜单");
	MenuBar menuBar = new MenuBar();
	Menu file = new Menu("文件");
	Menu edit = new Menu("编辑");
	MenuItem newItem = new MenuItem("新建");
	MenuItem saveItem = new MenuItem("保存");
	MenuItem exitItem = new MenuItem("退出",new MenuShortcut(KeyEvent.VK_X));
	//CheckboxMenuItem   复选菜单框组件
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
	MenuItem copyItem = new MenuItem("复制");
	MenuItem pasteItem = new MenuItem("粘贴");
	Menu format = new Menu("格式");
	CheckboxMenuItem autoWrap1 = new CheckboxMenuItem("自动换行");
	MenuItem copyItem1 = new MenuItem("复制");
	MenuItem pasteItem1 = new MenuItem("粘贴");
	//创建commentItem菜单项，指定使用"ctrl+shirt+/"快捷键
	MenuItem commentItem = new MenuItem("注释",new 
			MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem canceliItem = new MenuItem("取消注释");
	TextArea textArea = new TextArea(6,40);
	//右键菜单栏
	PopupMenu popupMenu = new PopupMenu();
	public void init(){
		
		//以lambda表达式创建菜单事件监听器
		ActionListener menuListener = e->
		{
			String cmd = e.getActionCommand();
			textArea.append("单击"+cmd+"\n");
			if(cmd.equals("退出")){
				System.exit(0);
			}
		};
		commentItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		edit.add(autoWrap);
		//添加分割线
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		format.add(commentItem);
		format.add(canceliItem);
		//添加分割线
		edit.add(new MenuItem("-"));
		edit.add(format);
		//将file、edit菜单添加到MenuBar
		menuBar.add(file);
		menuBar.add(edit);
		//为f窗口设置菜单条
		frame.setMenuBar(menuBar);
		//为右键菜单添加子项
		popupMenu.add(autoWrap1);
		popupMenu.add(copyItem1);
		popupMenu.add(pasteItem1);
		
		//创建监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		Panel panel = new Panel();
		panel.add(popupMenu);
		panel.setPreferredSize(new Dimension(300,150));
		//创建邮件监听器
		panel.add(popupMenu);
		panel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e){
				//释放右键
				if(e.isPopupTrigger()){
					if(e.isPopupTrigger()){
						popupMenu.show(panel,e.getX(),e.getY());
					}
				}
			}
		});
		frame.add(panel,BorderLayout.SOUTH);
		frame.add(textArea);
		frame.pack();
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new TestSimpleMenu().init();
	}
}
