package GameDisplay;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class ButtonSmile extends JButton{
	
	public static final int win = 0;
	public static final int lost = 1;
	public static final int press = 2;
	public static final int wow = 3;
	public static final int now = 4;
	
	private PanelNotification p;
	
	private int stage;
	
	public ButtonSmile(PanelNotification p) {
		this.p = p;
		setPreferredSize(new Dimension(50,50));
		
		stage = now;
	}
	@Override
	public void paint(Graphics g) {
		switch (stage) {
		case win:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("iconWin"),0,0, getPreferredSize().width,getPreferredSize().height, null);
			break;
	    case lost:
	    	g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("iconLost"),0,0, getPreferredSize().width,getPreferredSize().height, null);
			break;
	    case press:
	    	g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("iconPress"),0,0, getPreferredSize().width,getPreferredSize().height, null);
			break;
	    case wow:
	    	g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("iconPressPlay"),0,0, getPreferredSize().width,getPreferredSize().height, null);
			break;
	    case now:
	    	g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("icon"),0,0, getPreferredSize().width,getPreferredSize().height, null);
			break;
			
		default:
			break;
		}
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public static int getWin() {
		return win;
	}
	public static int getLost() {
		return lost;
	}
	public static int getPress() {
		return press;
	}
	public static int getWow() {
		return wow;
	}
	public static int getNow() {
		return now;
	}
	

}
