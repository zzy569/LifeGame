package LifeGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class GMap extends JFrame {
	private boolean isRunning;
	private boolean isDead;
	private Thread thread;
	public map m=new map();
	public JButton[][] grid=new JButton[50][50];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GMap frame = new GMap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Show() {
		int[][] Cell = m.getMap();
		for(int i=0; i<50; i++) {
			for(int j=0; j<50; j++) {
				if(Cell[i+1][j+1] == 1) {
					grid[i][j].setBackground(Color.BLACK);
				}else { grid[i][j].setBackground(Color.white); }
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public GMap() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 800, 800);
		JPanel backPanel, centerPanel, bottomPanel;
		backPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel(new GridLayout(50, 50,0,0));
		bottomPanel = new JPanel();
		this.setContentPane(backPanel);
		backPanel.add(centerPanel, "Center");
		backPanel.add(bottomPanel, "South");
		for(int i=0; i<50; i++) {
			for(int j=0; j<50; j++){
				grid[i][j] = new JButton("");
				grid[i][j].setBackground(Color.white);
				centerPanel.add(grid[i][j]);
			}
		}

		JButton BTN1 = new JButton("\u521D\u59CB\u5316");
		BTN1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m.ini();
				Show();
			}
		});
		BTN1.setFont(new Font("宋体", Font.BOLD, 28));
		bottomPanel.add(BTN1);
		
		JButton BTN2 = new JButton("\u4E0B\u4E00\u6B65");
		BTN2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m.next();
				Show();
			}
		});
		BTN2.setFont(new Font("宋体", Font.BOLD, 28));
		bottomPanel.add(BTN2);
		
		JButton BTN3 = new JButton("\u66F4\u65B0");
		BTN3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isRunning = true;
				thread = new Thread(new Runnable() {
					public void run() {
						while (isRunning) {
							m.next();
							Show();
							try {
								Thread.sleep(500);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							if (isDead) {
								isRunning = false;
								thread = null;
							}
						}
					}
				});
				thread.start();
			}
		});
		BTN3.setFont(new Font("宋体", Font.BOLD, 28));
		bottomPanel.add(BTN3);
		
		JButton BTN4 = new JButton("\u505C\u6B62");
		BTN4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		BTN4.setFont(new Font("宋体", Font.BOLD, 28));
		bottomPanel.add(BTN4);
	}
}

