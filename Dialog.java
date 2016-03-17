//pag246

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Dial extends JDialog implements ActionListener
{
	JButton buton = new JButton("Inchide cutia");
	JTextField txt = new JTextField(10);
	Container y;
	String sir = txt.getText();
	Dial (JFrame parinte,String mesaj, boolean modal)
	{
		super(parinte,mesaj,modal);
		y = getContentPane();
		setSize(200,200);
		y.setLayout(new FlowLayout());
		y.add(buton);
		y.add(txt);
		buton.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		//inchide cutia
		setVisible(false);
	}
}

class Fer extends JFrame implements ActionListener
{
	Dial cutie = null;
	public Fer(String titlu)
	{
		super(titlu);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container x = getContentPane();
		x.setLayout(new FlowLayout());
		JButton A = new JButton("Afiseaza cutia");
		x.add(A);
		A.addActionListener(this);
		JButton B = new JButton("Ce-am citi?");
		x.add(B);
		B.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		//Daca a fost apasat butonul "Afiseaza cutia"
		if(e.getActionCommand().compareTo("Afiseaza cutia")==0)
			//daca cutia nu a fost afisata
			if(cutie == null) cutie = new Dial(this,"Cutie de dialog",true);
		//daca cutia a fost afisata
		else
			cutie.setVisible(true);
		else
			//daca a fost apasat butonul "Ce-am citit?"
			if(cutie!=null)
			{
				//recuperez container-ul cutiei
				Container t = cutie.y;
				//recuperez referinta catre edit
				JTextField com = (JTextField)t.getComponent(1);
				//recuperez continutului edit-ului
				JOptionPane.showMessageDialog(this,com.getText());
			}
			//daca vreu sa vad ce-am scris fara sa fi afisat cutia
			else
				JOptionPane.showMessageDialog(this,"Mai intai afiseaza cutia de dialog");

	}
}

public  class Dialog
{
	public static void main(String[] args)
	{
		Fer fp = new Fer("Fereastra din care apelez cutia");
	}
}