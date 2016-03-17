//pag239

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

class Fer extends JFrame implements ActionListener
{
	JTable table;
	public Fer(String titlu)
	{
		super(titlu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container x = getContentPane();
		x.setLayout(new FlowLayout());
		table = new JTable(3, 4);
		JScrollPane panel = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(200, 30));
		x.add(panel);
		JButton A = new JButton("Afiseaza");
		x.add(A);
		A.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(table.getCellEditor() != null)
			table.getCellEditor().stopCellEditing();
		for ( int i = 0; i < 2;i++)
			for ( int j = 0; j < 4; j++)
				System.out.println(i + " " + j + " " + table.getValueAt(i,j));
	}
}


public class Meniu9
{
	public static void main(String[] args)
	{
		Fer fp = new Fer("Table");
	}
}