package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class HangMan implements KeyListener{
	 /*Step 1: When the program starts, it will ask the user for a number (up to the total words in the file). Then the 
    program will read that many words from the "dictionary.txt" file and push them to a Stack. 
    Use the readRandomLineFromFile method in the Utilities class. The words should be selected randomly so 
    not every game is played with the same set of words. You can use the Stack's contains() method to make sure
    there are no duplicate words. */
	int lives = 5;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel livess = new JLabel();
	static Stack<String> c = new Stack<String>();
	String underlines = "";
	String word = "";

	
	public static void main(String[] args) {
		HangMan h = new HangMan();
		h.setup();
		h.createUI();
		
	}

	/*Step 2: Pop the word off the top of the stack and use a JLabel to display a blank line for all the characters in the word. 
    Collect key inputs from the user. If the user guesses a letter, fill in the blank space. Otherwise, take off a life.*/
	

	
	/*Step 3: When a word has been solved, pop the next one off the stack and start a new round. It is up to you if you want to 
    reset the lives.*/



	//Step 4: If they run out of lives, give them a game over message.
	

	/*Step 5: Don't end the program on game over. Ask the user if they would like to play again and run the game again with new 
    words if they choose yes.*/
	
	
	private void createUI() {
		frame.add(panel);
		frame.setVisible(true);
		frame.addKeyListener(this);
		livess.setText("lives: " + lives);
		panel.add(label);
		panel.add(livess);
		frame.setTitle("Hang Man");
		getWord();
		frame.pack();
	}
	
	public void getWord() {
		underlines = "";
		word = c.pop();
		System.out.println(word);
		for(int i = 0; i < word.length(); i++) {
			underlines+="_ ";
		}
		label.setText(underlines);
		livess.setText("lives: " + lives);
	}
	
	public void setup() {
		String s = JOptionPane.showInputDialog("Welcome to Hangman! How many words would you like to guess?");
		int p = Integer.parseInt(s);
		for(int i = 0; i < p; i++) {
			c.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char letterPressed = e.getKeyChar();
		boolean found = false;
		StringBuilder sb = new StringBuilder(underlines);
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == letterPressed) {
				sb.replace(i*2, (i*2)+1, letterPressed + "");
				found = true;
				livess.setText("lives: " + lives);
			}
		}
		if(!found) {
			lives--;
			livess.setText("lives: " + lives);
			if(lives==0) {
				String[] options = {"yes", "no"};
		        Integer[] choice = {0,1};
				JOptionPane.showOptionDialog(null, "Would you like to play again?", "Game Over",  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, choice);
			}
		}
		underlines = sb.toString();
		label.setText(underlines);
		if(!underlines.contains("_")) {
			getWord();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

