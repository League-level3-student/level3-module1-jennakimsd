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
	int lives = 10;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	static Stack<String> c = new Stack<String>();

	
	public static void main(String[] args) {
		new HangMan().createUI();
		String s = JOptionPane.showInputDialog("Welcome to Hangman! How many words would you like to guess?");
		int p = Integer.parseInt(s);
		for(int i = 0; i < p; i++) {
			c.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}	
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
		panel.add(label);
		frame.pack();
		frame.setTitle("Hang Man");
		String p = "";
		for(int i = 0; i < c.pop().length(); i++) {
			p+="_";
		}
		label.setText(p);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

