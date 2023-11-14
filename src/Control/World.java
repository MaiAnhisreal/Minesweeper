package Control;

import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.xml.crypto.dsig.CanonicalizationMethod;

import GameDisplay.ButtonPlay;
import GameDisplay.ButtonSmile;
import GameDisplay.GamePanel;
import GameDisplay.LabelNumber;

public class World {
	private Random rd;
	private int boom;
	private ButtonPlay[][] arrayButton;
	private int[][] arrayboom; //so boom = -1
	
	private boolean[][] arrayBoolean;
	private boolean[][] arrayCamco;
	
	private int flag;
	
	private boolean isComplete;
	private boolean isEnd;
	private ButtonSmile buttonSmile;
	private LabelNumber lbTime,lbBoom;
	
	private GamePanel game;
	
	public World(int w, int h, int boom, GamePanel game) {
		this.game = game;
		this.boom = boom;
		arrayButton = new ButtonPlay[w][h];
		arrayboom = new int[w][h];
		arrayBoolean = new boolean[w][h];
		arrayCamco = new boolean[w][h];

		rd = new Random();
		createArrayboom(boom,w,h);
		enternumber();
	}
	public boolean clickDouble(int i , int j) {
		
		boolean isBoom = false;
		
		for(int a = i - 1; a<= i+1; a++ ) {	
			for(int b = j - 1; b <= j+1; b++ ) {
				if(a >= 0 && a <=arrayboom.length -1 && b>=0 && b <= arrayboom[i].length -1 )
				{  
					if(!arrayCamco[a][b]) {
					 if(arrayboom[a][b]==-1) {
					isBoom = true;
					arrayButton[a][b].setNumber(12);
					arrayButton[a][b].repaint();
					arrayBoolean[a][b] = true;
				}
					else if(!arrayBoolean[a][b]) {
						if(arrayboom[a][b] == 0) {
							open(a,b);
						}else {
						arrayButton[a][b].setNumber(arrayboom[a][b]);
						
						arrayButton[a][b].repaint();
						arrayBoolean[a][b] = true;	
						}
					}
					}
				}
			}
		}
		
		if(isBoom) {			
			
			for (int j2 = 0; j2 < arrayBoolean.length; j2++) {
				for (int b = 0; b < arrayBoolean[i].length; b++) {
					if(arrayboom[j2][b]==-1 && !arrayBoolean[j2][b]) {
						arrayButton[j2][b].setNumber(10);
						arrayButton[j2][b].repaint();
					}
				}
			}
			return false;
		}
		return true;
	}
	public void camco(int i , int j) {
		if(!arrayBoolean[i][j]) {
			if(arrayCamco[i][j]) {
				
				arrayCamco[i][j] = false;
				arrayButton[i][j].setNumber(-1);
				arrayButton[i][j].repaint();
				flag--;
				game.getP1().updateLbBoom();
			}else if(flag < boom ){
			
				arrayCamco[i][j] = true;
				arrayButton[i][j].setNumber(9);
				arrayButton[i][j].repaint();
				flag++;
				game.getP1().updateLbBoom();
			}
		}
	}
	public boolean open(int i, int j) {
		
		if(!isComplete&& !isEnd) {
		if(!arrayBoolean[i][j]) {
			if(arrayboom[i][j] == 0) {
				
				arrayBoolean[i][j] = true;
				arrayButton[i][j].setNumber(0);
				arrayButton[i][j].repaint();
				if (checkWin()){
					isEnd = true;
					return false;
				}
				for(int a = i - 1; a<= i+1; a++ ) {	
					for(int b = j - 1; b <= j+1; b++ ) {
						if(a >= 0 && a <=arrayboom.length -1 && b>=0 && b <= arrayboom.length -1 )
						{    
							if(!arrayBoolean[a][b]) {
							open(a,b);

							}
						
					}
					}
					}
				if (checkWin()){
					isEnd = true;
					return false;
				}
			}else {
		int number= arrayboom[i][j];	
		if(number != -1) {
			arrayBoolean[i][j] = true;
			
		arrayButton[i][j].setNumber(number);
		arrayButton[i][j].repaint();
		if (checkWin()){
			isEnd = true;
			return false;
		}
		return true;
		      }
	      }
		}
		if(arrayboom[i][j] == -1) {
			arrayButton[i][j].setNumber(11);
			arrayButton[i][j].repaint();
			isComplete = true;
			
			for (int j2 = 0; j2 < arrayBoolean.length; j2++) {
				for (int b = 0; b < arrayBoolean[i].length; b++) {
					if(arrayboom[j2][b]==-1 && !arrayBoolean[j2][b]) {
						if(j2 != i || b != j )
						arrayButton[j2][b].setNumber(10);
						arrayButton[j2][b].repaint();
					}
				}
			}
			
			return false;
		}else {
			if (checkWin()){
				isEnd = true;
				return false;
			}
			return true;
		}
		}else 
			return false;
		} 		
	   
	public boolean[][] getArrayCamco() {
		return arrayCamco;
	}
	public void setArrayCamco(boolean[][] arrayCamco) {
		this.arrayCamco = arrayCamco;
	}
	public boolean checkWin() {
		int count = 0;
		for(int i =0; i < arrayboom.length ; i++) {
			for(int j =0; j < arrayboom[i].length ; j++) {
				if(!arrayBoolean[i][j]) {
					count++;
				}
			}
		}
		if(count == boom) return true;
		else 
			return false;
	}
	
	public void enternumber() {
		for(int i =0; i < arrayboom.length ; i++) {
			for(int j =0; j < arrayboom[i].length ; j++) {
				if(arrayboom[i][j] == 0) {
					int count=0;
					for(int a = i - 1; a<= i+1; a++ ) {	
						for(int b = j - 1; b <= j+1; b++ ) {
							if(a >= 0 && a <=arrayboom.length -1 && b>=0 && b <= arrayboom.length -1 )
							if(arrayboom[a][b] == -1) {
								count++;
							}
						}
					}
					arrayboom[i][j] = count;
				}
			}
		}
	}
	
	public void createArrayboom(int boom, int w, int h) {
		int locationx = rd.nextInt(w);
		int locationy = rd.nextInt(h);
		
		arrayboom[locationx][locationy] = -1;
		int count = 1;
		while(count !=boom) {
			locationx = rd.nextInt(w);
			locationy = rd.nextInt(h);
			if(arrayboom[locationx][locationy] != -1) {
			arrayboom[locationx][locationy] = -1;
			count =0;
			for(int i =0; i < arrayboom.length ; i++) {
				for(int j =0; j < arrayboom[i].length ; j++) {
					if(arrayboom[i][j] == -1)
						count++;
				}
			}
		}
	}
	}
	
	public void fulltrue() {
		for(int i =0; i < arrayBoolean.length ; i++) {
			for(int j =0; j < arrayBoolean[i].length ; j++) {
				if(!arrayBoolean[i][j]) {
					arrayBoolean[i][j] = true;
				}
				
			}
		}
	}
	
	public ButtonPlay[][] getArrayButton() {
		return arrayButton;
	}
	public void setArrayButton(ButtonPlay[][] arrayButton) {
		this.arrayButton = arrayButton;
	}
	public ButtonSmile getButtonSmile() {
		return buttonSmile;
	}
	public void setButtonSmile(ButtonSmile buttonSmile) {
		this.buttonSmile = buttonSmile;
	}
	public LabelNumber getLbTime() {
		return lbTime;
	}
	public void setLbTime(LabelNumber lbTime) {
		this.lbTime = lbTime;
	}
	public LabelNumber getLbBoom() {
		return lbBoom;
	}
	public void setLbBoom(LabelNumber lbBoom) {
		this.lbBoom = lbBoom;
	}
	public boolean[][] getArrayBoolean() {
		return arrayBoolean;
	}
	public void setArrayBoolean(boolean[][] arrayBoolean) {
		this.arrayBoolean = arrayBoolean;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public boolean isEnd() {
		return isEnd;
	}
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
}

