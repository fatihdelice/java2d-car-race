import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class MyCar {
    static int skor;
    private int dx;
    public int x = 250;
    public int y = 420;
    private int w;
    private int h;
    private Image image;

    public MyCar() {

        loadImage();
    }

    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("sarı.png");
        image = ii.getImage(); 
        
        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public void move() {
        
        x += dx;
        
    }

    public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return w;
    }
    
    public int getHeight() {
        
        return h;
    }    

    public Image getImage() {
        
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        // if (key == KeyEvent.VK_UP) {
        //     dy = -2;
        // }

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

    }
}