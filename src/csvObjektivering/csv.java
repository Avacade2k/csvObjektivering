package csvObjektivering;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class csv extends JPanel implements ActionListener {

	JFrame window = new JFrame("Interface");
	JLabel info = new JLabel("csvObjektivering");
	JButton addButton = new JButton("Add row");
	JButton sortButton = new JButton("Sort");
	DefaultTableModel model;
	JTable table;
	
	csv(){
		//Constructing interface
		this.setBackground(Color.WHITE);
		window.add(this);
		
		addButton.addActionListener(this);
		sortButton.addActionListener(this);
		
		//Interface window
		window.setSize(1000,500);
		window.setLocation(200,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] columnNames = { "OrderDate", "Region", "Rep1", "Rep2", "Item", "Units", "UnitCost", "Total"}; 
		String[][] data = readCSV.getDataArray();
		//String[][] data = {{"placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder"}};
		
		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		table.setBounds(30, 40, 200, 300);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout( new FlowLayout(FlowLayout.TRAILING));
		btnPanel.add(sortButton, BorderLayout.PAGE_START);
		btnPanel.add(addButton, BorderLayout.PAGE_END);
		
		window.add(scrollPane, BorderLayout.PAGE_START);
		window.add(btnPanel, BorderLayout.PAGE_END);
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			model.addRow(new Object[]{"", ""});
		}
		else if(e.getSource() == sortButton) {
			
		}
	}
	
}
