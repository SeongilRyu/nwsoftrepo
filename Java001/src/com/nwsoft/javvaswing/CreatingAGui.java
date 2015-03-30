package com.nwsoft.javvaswing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CreatingAGui extends JComponent {
	protected static void displayGUI(final String title, final JComponent component) {
		final JFrame frame = new JFrame(title);
		//종료 버튼 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(component, BorderLayout.CENTER);
		frame.pack();
		//
		//화면에 표시
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		final CreatingAGui c = new CreatingAGui();
		c.setPreferredSize(new Dimension(290, 227));
		
		//Event Dispatching Thread
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
				displayGUI("Hello window!",c);
				System.out.println("Window created...");
//			}
//		});

	}

}
