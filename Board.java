import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.stream.Stream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.Timer;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Board extends JPanel implements ActionListener {

	private Timer timer;	
	private RoadLines yol1, yol2, yol3,yol4,yol5,yol6;
	private MyCar araba;
	private Cars car;
	private int delay = 30;
	private int score = 0;
	private boolean isPaused = false;
	private Image odul;
	private Image kupa;
	private Image can,can1,can2,can3;
	private int cansayisi = 3;
	private int w;
	private int h;
	private int a;
	private int prizex ,prizey;
	public int highScore = 0;
	ImageIcon ii2;
	public boolean lo = false;
	long lastTime = System.currentTimeMillis();
	Integer data;
	boolean d =true;
	public int benzin = 0;
	public Random r1 = new Random(); 
	public Board() {

		initBoard();
	}

	private void initBoard() {
		
		yol1 = new RoadLines();
		yol2 = new RoadLines();
		yol3 = new RoadLines();
		yol4 = new RoadLines();
		yol5 = new RoadLines();
		yol6 = new RoadLines();
		ImageIcon ii5 = new ImageIcon("katman.png");
		kupa = ii5.getImage();
		ImageIcon ii1 = new ImageIcon("heart.png");
		can1 = ii1.getImage();
		ImageIcon ii2 = new ImageIcon("heart.png");
		can2 = ii2.getImage();
		ImageIcon ii3 = new ImageIcon("heart.png");
		can3 = ii3.getImage();
		ImageIcon ii4 = new ImageIcon("gas.png");
		odul = ii4.getImage();
		// w = odul.getWidth(null);
		// h = odul.getHeight(null);
		
		setBackground(Color.darkGray);
		addKeyListener(new TAdapter());
		setFocusable(true);
		
		araba = new MyCar();
		car = new Cars();
		
		timer = new Timer(delay, this);
		timer.start();
		
	}

	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		// score += car.getGecenSure();
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	public boolean kontrolEt() {
		if(new Rectangle(car.getX(),car.getY(),40,90).intersects(new Rectangle(araba.getX(),araba.getY(),40,100)) 
				// || new Rectangle(car.getX2(),car.getY2(),40,80).intersects(new Rectangle(araba.getX(),araba.getY(),40,90))
				|| new Rectangle(car.getX3(),car.getY3(),40,90).intersects(new Rectangle(araba.getX(),araba.getY(),40,100))
				|| new Rectangle(car.getX4(),car.getY4(),40,90).intersects(new Rectangle(araba.getX(),araba.getY(),40,100))
				|| new Rectangle(car.getX5(),car.getY5(),40,90).intersects(new Rectangle(araba.getX(),araba.getY(),40,100))
				|| new Rectangle(car.getX6(),car.getY6(),40,80).intersects(new Rectangle(araba.getX(),araba.getY(),15,100))
				// || new Rectangle(0,0,62,600).intersects(new Rectangle(araba.getX(),araba.getY(),20,100))
				// || new Rectangle(530,0,70,600).intersects(new Rectangle(araba.getX(),araba.getY(),43,100))
				){
										
					return true;	
					

		}
		if (lo){

            if(new Rectangle(car.getX2(),car.getY2(),40,90).intersects(new Rectangle(araba.getX(),araba.getY(),40,100))){

                
                car.y2 = 580;
                benzin += 10;
				
				lo = false;
				car.x2 =r1.nextInt(450 - 100 + 1) + 100;
            }
            return false;

        }
		if(
		 new Rectangle(0,0,62,600).intersects(new Rectangle(araba.getX(),araba.getY(),20,100))
		){
			araba.x = 62;
		}
		if( new Rectangle(500,0,70,600).intersects(new Rectangle(araba.getX(),araba.getY(),20,100))){
			araba.x = 480;
		}
		return false;
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.green);
		g2d.fillRect(0, 0, 70, 600);
		g2d.fillRect(530, 0, 70, 600);
		
		g2d.drawImage(yol1.getImage(), yol1.getX1(), yol1.getY1(), this);
		g2d.drawImage(yol2.getImage(), yol2.getX2(), yol2.getY2(), this);
		g2d.drawImage(yol3.getImage(), yol3.getX3(), yol3.getY3(), this);
		g2d.drawImage(yol4.getImage(), yol4.getX4(), yol4.getY4(), this);
		g2d.drawImage(yol5.getImage(), yol5.getX5(), yol5.getY5(), this);
		g2d.drawImage(yol6.getImage(), yol6.getX6(), yol6.getY6(), this);
		Random r = new 	Random();
		if(car.getY() == 600){
            car.x = r.nextInt(450 - 100 + 1) + 100;
            car.y = -80;
        }
        if(car.getY3() == 600){
            car.x3 = r.nextInt(450 - 100 + 1) + 100;

            car.y3 = -520;
        }
        if(car.getY4() == 600){
            car.x4 = r.nextInt(450 - 100 + 1) + 100;
            car.y4 =-550;
        }
        if(car.getY5() == 600){
            car.x5 = r.nextInt(450 - 100 + 1) + 100;
            car.y5 = -300;
        }
        if(car.getY6() == 600){
            car.x6 = r.nextInt(450 - 100 + 1) + 100;
            car.y6 = -200;
        }

		if (car.getGecenSure() > 8000){
            if(car.getGecenSure()%10000 == 0){
                lo = true;
                car.y2 = -150;
            }
            if(lo){
                if(car.getY2() == 550){
                    lo = false;
                    car.x2 =r.nextInt(450 - 100 + 1) + 100;

                }
                g2d.drawImage(car.getImage2(),car.getX2(), car.getY2(), this);
            }


        }
		g2d.drawImage(araba.getImage(), araba.getX(), araba.getY(), this);
		g2d.drawImage(car.getImage(), car.getX(), car.getY(), this);
		// g2d.drawImage(car.getImage2(), car.getX2(), car.getY2(), this);
		g2d.drawImage(car.getImage3(), car.getX3(), car.getY3(), this);
		g2d.drawImage(car.getImage4(), car.getX4(), car.getY4(), this);
		g2d.drawImage(car.getImage5(), car.getX5(), car.getY5(), this);
		g2d.drawImage(car.getImage6(), car.getX6(), car.getY6(), this);
		
		long currentTime = System.currentTimeMillis();
		if (currentTime - lastTime >= 15000){
		delay -= 5;}

		
		g2d.setPaint(Color.GRAY);
		g2d.fillOval(278, 24, 50, 50);
		g2d.setPaint(Color.GREEN);
		
		g2d.drawString("SKOR",285 ,50);
		score = benzin + car.getGecenSure()/4000*2;
		g2d.drawString(String.valueOf(score),300,68);
	
		

		
		
		
				
		
		if(kontrolEt()) {
				
				if(cansayisi == 3){
					can3 = null;
						
		
					cansayisi -= 1;
					car.y = -80;
					car.y3 = -520;
					car.y4 = -550;
					car.y5 = -300;
					car.y6 = -200;
					
				}else if (cansayisi == 2)	{
					can2 = null;
				
					cansayisi -= 1;
					car.y = -80;
					car.y3 = -520;
					car.y4 = -550;
					car.y5 = -300;
					car.y6 = -200;
					
				}else if(cansayisi == 1){
					can1 = null;
					cansayisi -= 1;
					g2d.drawImage(can1, 5, 15, this);
					g2d.drawImage(can2, 25, 15, this);
					g2d.drawImage(can3, 45, 15, this);
					timer.stop();
				
					try {
						File myObj = new File("highscores.txt");
						Scanner myReader = new Scanner(myObj);
						data = myReader.nextInt();
						System.out.println(data);
						myReader.close();
					  } catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					  }

					if(score > data){
						data = score;
						try {
							FileWriter myWriter = new FileWriter("highscores.txt");
							myWriter.write(String.valueOf(score));
							myWriter.close();
							System.out.println("Successfully wrote to the file.");
						  } catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						  }
						  try {
							File myObj = new File("highscores.txt");
							Scanner myReader = new Scanner(myObj);
							
							  data = myReader.nextInt();
							  System.out.println(data);
							
							myReader.close();
						  } catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						  }
						  }
					else if(data == 0){
						data = score;
						try {
							FileWriter myWriter = new FileWriter("highscores.txt");
							myWriter.write(String.valueOf(score));
							myWriter.close();
							// System.out.println("Successfully wrote to the file.");
						  } catch (IOException e) {
							// System.out.println("An error occurred.");
							e.printStackTrace();
						  }
						  
						  try {
							File myObj = new File("highscores.txt");
							Scanner myReader = new Scanner(myObj);
							data = myReader.nextInt();
							System.out.println(data);
							myReader.close();
						  } catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						  }

					}else{
						try {
							File myObj = new File("highscores.txt");
							Scanner myReader = new Scanner(myObj);
							data = myReader.nextInt();
							System.out.println(data);
							myReader.close();
						  } catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						  }
					}		  
					
				
					
					if(data > score){
						String message = "Oyun Bitti... Kaybettin\n"
					+ "Geçen Süre : " + car.getGecenSure()/1000.0
					+ "\nSkor : " + car.getGecenSure()/4000*2
					+ "\nEn Yüksek Skor : " + data;	
					JOptionPane.showMessageDialog(this, message);					
					System.exit(0);	

					}
					else{					
						String message = "Kazandın\n"
						+ "Geçen Süre : " + car.getGecenSure()/1000.0					
						+ "\nYeni En Yüksek Skor : " + data;	
						JOptionPane.showMessageDialog(null, message, "Kupa",
						JOptionPane.INFORMATION_MESSAGE,   new ImageIcon(kupa));	
						System.exit(0);	

					}
					
				
								

				}
			
				

			} 	
				g2d.drawImage(can1, 5, 15, this);
				g2d.drawImage(can2, 25, 15, this);
				g2d.drawImage(can3, 45, 15, this);
		}
		
	

	@Override
	public void actionPerformed(ActionEvent e) {

		step();
	}

	private void step() {
		
		if(isPaused){
			repaint();
		}
		else{
			yol1.move();
			yol2.move();
			yol3.move();
			yol4.move();
			yol5.move();
			yol6.move();	
			araba.move();
			car.move();			
			repaint();
			}
			
	}

	private class TAdapter extends KeyAdapter {
												
		@Override
		public void keyReleased(KeyEvent e) {
			araba.keyReleased(e);
			delay = 30;
			timer.setDelay(delay);  
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			araba.keyPressed(e);
			if (key == KeyEvent.VK_SPACE) {
				isPaused = !isPaused;
       
			}
			if (key == KeyEvent.VK_UP) {
				delay -= 5;
				if(delay <= 0){
					delay = 0;
				}
				timer.setDelay(delay);     			
       
			}
			if (key == KeyEvent.VK_DOWN) {
				delay += 2;
				if(delay >= 70){
					delay = 70;
				}
				timer.setDelay(delay);     			
       
			}
			if (key == KeyEvent.VK_W && key == KeyEvent.VK_D ) {
				 araba.x += 5; 		
				 araba.y -= 5; 		
       
			}
			if (key == KeyEvent.VK_DOWN && key == KeyEvent.VK_RIGHT ) {
				araba.x += 5; 		
				araba.y -= 5; 		
	  
		   }
		}
	}
	
}