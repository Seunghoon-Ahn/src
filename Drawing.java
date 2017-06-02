import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Rectangle {
	int x, y, w, h;
	
	public Rectangle(int x, int y, int p, int q) {
		this.x = x;
		this.y = y;
		this.w = Math.abs(p - x);
		this.h = Math.abs(q - y);
	}	
}

public class Drawing extends JFrame{
	JLabel Start_X, Start_Y, Height, Width;
	JTextField X, Y, H, W;
	
	Drawing() {
		setTitle("사각형 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*Container c = getContentPane();
		c.setLayout(new FlowLayout());
		Start_X = new JLabel("Start_X");
		X = new JTextField(10);
		Start_Y = new JLabel("Start_Y");
		Y = new JTextField(10);
		Height = new JLabel("Height");
		H = new JTextField(10);
		Width = new JLabel("Width");
		W = new JTextField(10);
		c.add(Start_X);
		c.add(X);
		c.add(Start_Y);
		c.add(Y);
		c.add(Height);
		c.add(H);
		c.add(Width);
		c.add(W);
		
		*/
		setSize(500, 500);
		setVisible(true);		
	}

	class MyMouseListener extends MouseAdapter {
		Point startP = null;
		Point endP = null;
		public void mouseMoved(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e){
			startP = e.getPoint(); // 클릭한부분을 시작점으로
		}
		public void mouseReleased(MouseEvent e){
			endP = e.getPoint(); // 드래그 한부분을 종료점으로
			Graphics g = getGraphics();
			g.drawRect(startP.x, startP.y, endP.x - startP.x, endP.y - startP.y);
		}
		
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	public static void main(String[] args) {
		new Drawing();
	}
}
