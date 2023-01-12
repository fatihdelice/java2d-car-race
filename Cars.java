import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Cars {
	Random r = new Random();
	public int x = r.nextInt(450 - 100 + 1) + 100;
	public int y = -80;
	
	public int x3 = r.nextInt(450 - 100 + 1) + 100;
	public int y3 = -520;
	private Image image3;
	
	public int x4 = r.nextInt(450 - 100 + 1) + 100;
	public int y4 = -550;
	private Image image4;
	
	public int x5 = r.nextInt(450 - 100 + 1) + 100;
	public int y5 = -300;
	private Image image5;
	
	public int x6 = r.nextInt(450 - 100 + 1) + 100;
	public int y6 = -200;

	public int x7 = 0;
	public int y7 = -100;

	public int x8 =  0;
	public int y8 = -200;
	private Image image6;
	
	private Image image1;
	private Image image2;
	private Image image7;
	private Image image8;
	private int w;
	private int h;
	private int dx;
	private int dy;
	public int x2 = 220;
	public int y2 = -150;
	
	private int gecenSure = 0;
	
	
	public int getGecenSure() {
		return gecenSure;
	}

	public Cars() {

		initCars();

	}

	private void initCars() {
		ImageIcon i1 = new ImageIcon("beyaz.png");
		image1 = i1.getImage();
		
		ImageIcon i2 = new ImageIcon("gas.png");
		image2 = i2.getImage();
		
		ImageIcon i3 = new ImageIcon("bugatti.png");
		image3 = i3.getImage();
		
		ImageIcon i4 = new ImageIcon("mor.png");
		image4 = i4.getImage();
		
		ImageIcon i5 = new ImageIcon("mor2.png");
		image5 = i5.getImage();
		
		ImageIcon i6 = new ImageIcon("yesil.png");
		image6 = i6.getImage();

		ImageIcon i7 = new ImageIcon("inek1.png");
		image7 = i7.getImage();

		ImageIcon i8 = new ImageIcon("tree1.png");
		image8 = i8.getImage();
		

		w = image1.getWidth(null);
		h = image1.getHeight(null);
	}
	
	public void move() { 
		gecenSure += 20;
		
		if(gecenSure>15000) {
			y2 = y2 + 7;
			if(y2> 600) {
				y2 = -50;
			}
			y = y + 7;
			if(y>600) {
				y = -150;
			}
			y3 = y3 + 7;
			if(y3 > 600) {
				y3 = -450;
			}
			y4 = y4 + 7;
			if(y4>600) {
				y4 =-550;
			}
			y5 = y5 + 7;
			if(y5 > 600) {
				y5 = -400;
			}
			y6 = y6 + 7;
			if(y6>600) {
				y6 = -200;
			}
			y7 = y6 + 7;
			if(y6>600) {
				y6 = -200;
			}

			y8 = y6 + 7;
			if(y6>600) {
				y6 = -200;
			}
		
		}if(gecenSure<15000) {
			y2 = y2 + 5;
			if(y2> 600) {
				y2 = -50;
			}
			y = y + 5;
			if(y>600) {
				y = -150;
			}
			y3 = y3 + 5;
			if(y3 > 600) {
				y3 = -550;
			}
			y4 = y4 + 5;
			if(y4>600) {
				y4 =-550;
			}
			y5 = y5 + 5;
			if(y5 > 600) {
				y5 = -400;
			}
			y6 = y6 + 5;
			if(y6>600) {
				y6 = -200;
			}

			y7 = y7 + 5;
			if(y7>600) {
				y7 = -200;
			}

			y8 = y8 + 5;
			if(y8>600) {
				y8 = -200;
			}

		}
		
				
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image1;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public Image getImage2() {
		return image2;
	}

	public int getX3() {
		return x3;
	}

	public int getY3() {
		return y3;
	}

	public Image getImage3() {
		return image3;
	}

	public int getX4() {
		return x4;
	}

	public int getY4() {
		return y4;
	}

	public Image getImage4() {
		return image4;
	}

	public int getX5() {
		return x5;
	}

	public int getY5() {
		return y5;
	}

	public Image getImage5() {
		return image5;
	}

	public Image getImage7() {
		return image7;
	}

	public Image getImage8() {
		return image8;
	}

	public int getX6() {
		return x6;
	}

	public int getY6() {
		return y6;
	}
	public int getX7() {
		return x7;
	}

	public int getY7() {
		return y7;
	}

	public int getX8() {
		return x8;
	}

	public int getY8() {
		return y8;
	}
	public Image getImage6() {
		return image6;
	}
	
	

}
