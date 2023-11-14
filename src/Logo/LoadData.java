package Logo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class LoadData {
	private HashMap<String,BufferedImage> listImage;
	
	public LoadData() {
		listImage = new HashMap<String,BufferedImage>();
		
		try {
			BufferedImage img = ImageIO.read(new File("minesweeper.png"));
			
			listImage.put("title", img.getSubimage(1, 85, 25, 22));
			listImage.put("square", img.getSubimage(0, 39, 17, 17));
			listImage.put("icon", img.getSubimage(1, 56, 24, 25));
			listImage.put("flag", img.getSubimage(16, 39, 16, 16));
			listImage.put("boom", img.getSubimage(65, 39, 16, 16));
			listImage.put("boomRed", img.getSubimage(33, 40, 15, 15));
			listImage.put("boomx", img.getSubimage(49, 39, 16, 16));
			listImage.put("iconPress", img.getSubimage(28, 57, 23, 23));
			listImage.put("iconPressPlay", img.getSubimage(54, 57, 23, 23));
			listImage.put("iconLost", img.getSubimage(79, 57, 23, 23));
			listImage.put("iconWin", img.getSubimage(105, 57, 23, 23));
			listImage.put("0", img.getSubimage(0, 0, 13, 23));
			listImage.put("1", img.getSubimage(14, 0, 13, 23));
			listImage.put("2", img.getSubimage(27, 0, 13, 23));
			listImage.put("3", img.getSubimage(39, 0, 13, 23));
			listImage.put("4", img.getSubimage(52, 0, 13, 23));
			listImage.put("5", img.getSubimage(65, 0, 13, 23));
			listImage.put("6", img.getSubimage(78, 0, 13, 23));
			listImage.put("7", img.getSubimage(91, 0, 13, 23));
			listImage.put("8", img.getSubimage(104, 0, 13, 23));
			listImage.put("9", img.getSubimage(117, 0, 13, 23));
			listImage.put("b0", img.getSubimage(1, 24, 15, 15));
			listImage.put("b1", img.getSubimage(17, 24, 15, 15));
			listImage.put("b2", img.getSubimage(33, 24, 15, 15));
			listImage.put("b3", img.getSubimage(49, 24, 15, 15));
			listImage.put("b4", img.getSubimage(65, 24, 15, 15));
			listImage.put("b5", img.getSubimage(81, 24, 15, 15));
			listImage.put("b6", img.getSubimage(97, 24, 15, 15));
			listImage.put("b7", img.getSubimage(113, 0, 15, 15));
			listImage.put("b8", img.getSubimage(129, 0, 15, 15));
			listImage.put("tick", img.getSubimage(139, 49, 8, 8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public HashMap<String, BufferedImage> getListImage() {
		return listImage;
	}

	public void setListImage(HashMap<String, BufferedImage> listImage) {
		this.listImage = listImage;
	}
	

}
