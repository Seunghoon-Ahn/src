import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.Point;

public class MyComponent extends JComponent {
	JComponent c = new JButton();
	private String name = "unknown";
	private Point p = new Point(100,100);
	private Dimension d = new Dimension(10,10);

	MyComponent() {// ����Ʈ ������
		setName("unknown");
		setLocation(new Point(0, 0));
		setSize(new Dimension(10, 10));
		c = new JButton(name);
		System.out.println("d-c");
	}

	MyComponent(int x, int y, Dimension d) {// ��ġ, ũ��
		setName("unknown");
		setLocation(new Point(x, y));
		setSize(d);
		c = new JButton(name);
		System.out.println("xyd-c");
	}

	MyComponent(String name, int x, int y, Dimension d) {// �̸�, ��ġ, ũ��
		setName(name);
		setLocation(new Point(x, y));
		setSize(d);
		c = new JButton(name);
		System.out.println("nxyd-c");
	}

	public void setName(String name) {
		this.name = name;
		c.setName(name);
		
		System.out.println("setname : "+name);
	}

	public void setLocation(Point p) {
		this.p = p;
		c.setLocation(p);
		System.out.println("setLocation : "+c.getX()+","+c.getY());
	}

	public void setSize(Dimension d) {
		this.d = d;
		c.setSize(d);
		System.out.println("setSize : "+c.getHeight()+","+c.getWidth());
	}
}

