package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	ArrayList <Song> s = new ArrayList<Song>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		Song walls = new Song("walls.mp3");
		Song strong = new Song("strong.mp3");
		Song fineLine = new Song("fineLine.mp3");
		Song heartbreakWeather = new Song("heartbreakWeather.mp3");
		Song BW = new Song("BW.mp3");
		Song watermelonSugar = new Song("watermelonSugar.mp3");
		s.add(walls);
		s.add(strong);
		s.add(fineLine);
		s.add(heartbreakWeather);
		s.add(BW);
		s.add(watermelonSugar);
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		frame.setVisible(true);
		frame.add(panel);
		button1.setText("Suprise Me!");
		button2.setText("Stop Song");
		button1.addActionListener(this);
		button2.addActionListener(this);
		panel.add(button1);
		panel.add(button2);
		frame.pack();
		frame.setTitle("iPod Shuffle");
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		Random r = new Random();
		int random = r.nextInt(s.size());
		if (buttonPressed == button1) {
			s.get(random).play();
		}
		else if(buttonPressed == button2) {
			for(int i = 0; i < s.size(); i++) {
				s.get(i).stop();
			}
		}
	}
}

