package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> log = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	
	public static void main(String[] args) {
		new _02_LogSearch().createUI();
	}
	private void createUI() {
		frame.add(panel);
		frame.setVisible(true);
		button1.setText("Add Entry");
		button2.setText("Search by ID");
		button3.setText("View List");
		button4.setText("Remove Entry");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		frame.setTitle("Log Search");
		frame.pack();
	}
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == button1) {
			String s = JOptionPane.showInputDialog("enter an ID number");
			int i = Integer.parseInt(s);
			String n = JOptionPane.showInputDialog("enter a name");
			log.put(i, n);
		}
		if (buttonPressed == button2) {
			String s = JOptionPane.showInputDialog("enter an ID number");
			int i = Integer.parseInt(s);
			if(log.containsKey(i)) {
				JOptionPane.showMessageDialog(null, log.get(i));
			}
			else {
				JOptionPane.showMessageDialog(null, "this entry doesn't exist");
			}
		}
		if (buttonPressed == button3) {
			String s = "";
			System.out.println(log.keySet());
			for(Integer i: log.keySet()) {
				s += "ID: " + i + " Name: " + log.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, s);
		}
		if (buttonPressed == button4) {
			String s = JOptionPane.showInputDialog("enter an ID number");
			int i = Integer.parseInt(s);
			if(log.containsKey(i)) {
				log.remove(i);
			}
			else {
				JOptionPane.showMessageDialog(null, "this entry doesn't exist");
			}
		}
	}
	
}
