//pag237

import java.awt.*;
import javax.swing.*;

class Fer extends JFrame
{
	public Fer(String titlu)
	{
		super(titlu);
		setSize(600,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container x = getContentPane();
		JToolBar bara = new JToolBar();
		bara.setBackground(Color.red);
		bara.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		JComboBox lista = new JComboBox();
		x.setLayout(new BorderLayout());
		x.add(bara,BorderLayout.NORTH);
		x.add(panel,BorderLayout.CENTER);
		JButton A = new JButton("Buton 1");
		bara.add(A);
		A.setPreferredSize(new Dimension (70,30));
		JButton B = new JButton("Buton 2");
		B.setPreferredSize(new Dimension (70,30));
		bara.add(B);
		bara.addSeparator();
		lista.addItem("Optiunea 1");
		lista.addItem("Optiunea 2");
		bara.add(lista);
		lista.setPreferredSize(new Dimension(100,30));
		setVisible(true);
	}
}

public class Meniu8
{
	public static void main(String[] args)
	{
		Fer fp = new Fer("Bara cu unelte");
	}
}