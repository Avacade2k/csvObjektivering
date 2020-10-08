package csvObjektivering;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class csv extends JPanel implements ActionListener {

	JFrame window = new JFrame("Interface");
	JLabel info = new JLabel("csvObjektivering");
	JButton addButton = new JButton("Add data");
	JButton sortButton = new JButton("Sort");
	JTextField newData = new JTextField("New data");
	JTable table;
	
	csv(){
		//Constructing interface
		this.setBackground(Color.WHITE);
		window.add(this);
		
		addButton.addActionListener(this);
		sortButton.addActionListener(this);
		
		//Interface window
		window.setSize(800,400);
		window.setLocation(200,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] columnNames = { "OrderDate", "Region", "Rep1", "Rep2", "Item", "Units", "UnitCost", "Total"}; 
		String[][] data = readCSV.getDataArray();
		//String[][] data = {{"placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder"}};
		
		table = new JTable(data, columnNames);
		table.setBounds(30, 40, 200, 300);
		JScrollPane scrollPane = new JScrollPane(table);
		
		window.add(scrollPane, BorderLayout.PAGE_START);
		window.add(sortButton, BorderLayout.PAGE_END);
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		System.out.println(ae.getSource().toString());
	}
	
}
