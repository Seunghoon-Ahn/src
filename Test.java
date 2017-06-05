import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Test extends JFrame {
	private JFrame mainFrame;
	private JPanel northP, southP, centerP, eastP, westP;
	private JTabbedPane tabbedPanel;
	private JToolBar toolBar;
	private int NOC;
	private JLabel show_x, show_y;
	
	private JComponent la;
	private JTextField tab_x, tab_y;
	JLabel Start_X, Start_Y, Height, Width;
	JTextField X, Y, H, W;

	Test() {
		setTitle("Drawing Square");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);

		setLayout(new BorderLayout(10, 10));
		
		la = new JButton("Hello");
		la.setSize(100,100);

		show_x = new JLabel("x");
		show_x.setSize(30, 20);
		show_x.setLocation(0, 0);

		show_y = new JLabel("y");
		show_y.setSize(30, 20);
		show_y.setLocation(30, 0);
		
		
		mkNorthP();
		mkSouthP();
		mkCenterP();
		mkEastP();
		mkWestP();
		centerP.addMouseListener(new MyMouseListener());
		
		centerP.add(la);
		centerP.add(show_x);
		centerP.add(show_y);

		JMenuBar MB = new JMenuBar();
		JMenu m_File = new JMenu("File");

		JMenuItem mi_New = new JMenuItem("New");
		m_File.add(mi_New);
		JMenuItem mi_Open = new JMenuItem("Open");
		m_File.add(mi_Open);
		JMenuItem mi_Save = new JMenuItem("Save");
		m_File.add(mi_Save);

		MB.add(m_File);
		setJMenuBar(MB);
		setVisible(true);
	}

	void mkNorthP() {
		northP = new JPanel();
		add(northP, BorderLayout.NORTH);

		northP.setLayout(new BorderLayout());

		toolBar = new JToolBar();
		toolBar.setRollover(true);
		northP.add(toolBar);

		toolBar.add(new JButton("New"));
		toolBar.add(new JButton("Open"));
		toolBar.add(new JButton("Save"));
		northP.setVisible(true);
	}

	void mkSouthP() {
		southP = new JPanel();
		add(southP, BorderLayout.SOUTH);
	}

	void mkCenterP() {
		centerP = new JPanel(null);
		add(centerP, BorderLayout.CENTER);
		centerP.setBackground(Color.white);
		
		MyComponent mc = new MyComponent("text", 30, 30, new Dimension(100,20));
		
		centerP.add(mc.c);
		
		//centerP.add(mc.c);
		
		// setContentPane(centerP);

		/*
		 * Start_X = new JLabel("Start_X"); X = new JTextField(10); Start_Y =
		 * new JLabel("Start_Y"); Y = new JTextField(10); Height = new
		 * JLabel("Height"); H = new JTextField(10); Width = new
		 * JLabel("Width"); W = new JTextField(10); centerP.add(Start_X);
		 * centerP.add(X); centerP.add(Start_Y); centerP.add(Y);
		 * centerP.add(Height); centerP.add(H); centerP.add(Width);
		 * centerP.add(W);
		 */
	}

	void mkEastP() {
		eastP = new JPanel();
		add(eastP, BorderLayout.EAST);
	}

	void mkWestP() {
		westP = new JPanel();
		add(westP, BorderLayout.WEST);
		tabbedPanel = new JTabbedPane();
		tabbedPanel.setMinimumSize(new Dimension(100, 100));
		westP.add(tabbedPanel);

		for (NOC = 0; NOC < 1; NOC++) {
			mkTab();
		}
	}

	void mkTab() {
		JPanel TP = new JPanel();
		TP.setPreferredSize(new Dimension(200, 100));
		westP.add(TP, BorderLayout.NORTH);

		JTextField nameText = new JTextField("tab" + Integer.toString(NOC + 1));
		tab_x = new JTextField(show_x.getText());
		tab_y = new JTextField(show_y.getText());
		TP.setLayout(new GridLayout(0, 2));

		TP.add(new JLabel("�̸� : "));
		TP.add(nameText);
		nameText.setEnabled(false);
		TP.add(new JLabel("x��ǥ : "));
		TP.add(tab_x);
		TP.add(new JLabel("y��ǥ : "));
		TP.add(tab_y);
		TP.add(new JLabel("�ʺ� : "));
		TP.add(new JTextField(1));
		TP.add(new JLabel("���� : "));
		TP.add(new JTextField(1));

		tabbedPanel.addTab("tab" + Integer.toString(NOC + 1), TP);

	}

	public static void main(String[] args) {
		new Test();
	}

	class MyMouseListener implements MouseListener {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			la.setLocation(x, y);
			
			System.out.println(x);
			System.out.println(y);
			System.out.println(la.getX());
			System.out.println(la.getY());
			show_x.setText(Integer.toString(x));
			show_y.setText(Integer.toString(y));
			tab_x.setText(Integer.toString(x));
			tab_y.setText(Integer.toString(y));
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

	}

	class MyPanel extends JPanel {

		Point startP = null;
		Point endP = null;

		Vector<Point> sv = new Vector<Point>(); // ����
		Vector<Point> se = new Vector<Point>(); // ����

		public MyPanel() {
			MyMouseListener m = new MyMouseListener();

			this.addMouseListener(m);
			this.addMouseMotionListener(m);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (sv.size() != 0) {
				for (int i = 0; i < se.size(); i++) {
					Point sp = sv.get(i);
					Point ep = se.get(i);
					g.drawRect(sp.x, sp.y, ep.x - sp.x, ep.y - sp.y);
				}
			}
			if (startP != null)//
				g.drawRect(startP.x, startP.y, endP.x - startP.x, endP.y - startP.y);
		}

		class MyMouseListener extends MouseAdapter implements MouseMotionListener {
			public void mousePressed(MouseEvent e) {
				startP = e.getPoint();
				sv.add(e.getPoint()); // Ŭ���Ѻκ��� ����������
			}

			public void mouseReleased(MouseEvent e) {
				se.add(e.getPoint()); // �巡�� �Ѻκ��� ����������
				endP = e.getPoint();
				repaint(); // �ٽñ׷���
			}

			public void mouseDragged(MouseEvent e) {
				endP = e.getPoint();
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
			}
		}
	}
}

