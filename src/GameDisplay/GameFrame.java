package GameDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Logo.LoadData;

public class GameFrame extends JFrame{
	
	  private LoadData loadData;
	  
	  private JMenuBar  menuBar;
	  private JMenu menu;
	  private JMenuItem easy,normal, hard , newGame, exit;
	  
	  private GamePanel gamePanel;
	
      public GameFrame(int w, int h, int boom ) {
    	  loadData = new LoadData();
    	  setJMenuBar(menuBar = new JMenuBar());
    	  
    	  menuBar.add(menu = new JMenu("Game"));
    	  menu.add(newGame = new JMenuItem("New Game"));
    	  menu.addSeparator();
    	  
    	  menu.add(easy = new JMenuItem("Easy"));
    	  menu.add(normal = new JMenuItem("Normal"));
    	  menu.add(hard = new JMenuItem("Hard"));
    	  menu.addSeparator();
    	  
    	  menu.add(exit = new JMenuItem("Exit"));
    	  if(w == 8) {
    		  easy.setIcon(new ImageIcon(loadData.getListImage().get("tick")));
    	  }else if(w == 16) {
    		  normal.setIcon(new ImageIcon(loadData.getListImage().get("tick")));
    	  }else {
    		  hard.setIcon(new ImageIcon(loadData.getListImage().get("tick")));
    	  }
    	  
          easy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameFrame(8, 8, 10);
			}
		});
          normal.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent e) {
  		
  				setVisible(false);
				new GameFrame(16, 16, 40);
  			}
  		});
          hard.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent e) {
  				setVisible(false);
				new GameFrame(16, 30, 99);
  			}
  		});
          newGame.addActionListener(new ActionListener() {
    			
  			@Override
  			public void actionPerformed(ActionEvent e) {
  				setVisible(false);
				new GameFrame(w, h, boom);
  			}
  		});
          exit.addActionListener(new ActionListener() {
    			
  			@Override
  			public void actionPerformed(ActionEvent e) {
  				System.exit(0);  			}
  		});
    	  
    	  add(gamePanel = new GamePanel(w,h, boom, this));
    	  setIconImage(loadData.getListImage().get("title"));
    	  pack();//đóng gói để vừa với kích cỡ giao diện ta tạo ra//
    	  setResizable(false);//khóa giao diện (không thể thay đổi kích thước giao diện)
    	  setLocationRelativeTo(null);//cân chính giữ//
    	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//tắt giao diện//
    	  setVisible(true);
      }
      
      public static void main(String[] args) {
    	  new GameFrame(8,8,10);
      }

	public LoadData getLoadData() {
		return loadData;
	}

	public void setLoadData(LoadData loadData) {
		this.loadData = loadData;
	}
      
}
