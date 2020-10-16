package csvObjektivering;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class saveCSV {
	
	public static void saveMap() {
		try {
			StringBuilder sb = new StringBuilder();
			DefaultTableModel dtm = (DefaultTableModel) csv.getTable().getModel();
			int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
			for (int x = 0 ; x < nCol ; x++) {
				sb.append(dtm.getColumnName(x));
				if (x != nCol-1) sb.append(",");
			}
			sb.append(System.getProperty("line.separator"));
			for (int i = 0 ; i < nRow ; i++) {
				for (int j = 0 ; j < nCol ; j++) {
					if(dtm.getValueAt(i,j) != null) sb.append(dtm.getValueAt(i,j));
					else sb.append(" ");
					if (j != nCol-1) sb.append(",");
					}
				sb.append(System.getProperty("line.separator"));
				
			}
			JFileChooser chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new File("/home/me/Documents"));
		    int retrival = chooser.showSaveDialog(null);
		    if (retrival == JFileChooser.APPROVE_OPTION) {
		    	try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".csv")) {
		    	    fw.write(sb.toString());
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		        
			
		}catch(Exception e) {
			System.out.println("Something went wrong trying to save the file /n" + e);
			JOptionPane.showMessageDialog(null, "Something went wrong trying to save the file!",
				      "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

}
