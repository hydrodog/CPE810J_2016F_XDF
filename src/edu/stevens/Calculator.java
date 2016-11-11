import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
准备起飞
public class Calculator {
	public Calculator() {
		JButton b;
		GridBagConstraints c;
		int gridx, gridy, gridwidth, gridheight, anchor, fill, ipadx, ipady;
		double weightx, weighty;
		Insets inset;

		JFrame f = new JFrame();
		GridBagLayout gridbag = new GridBagLayout();
		Container contentPane = f.getContentPane();
		contentPane.setLayout(gridbag);
		
		JTextField t=new JTextField();
		gridx = 0;
		gridy = 0;
		gridwidth = 4;
		gridheight = 1;
		weightx = 1;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(t, c);
		contentPane.add(t);
		
		b = new JButton("AC");
		gridx = 0;
		gridy = 1;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHWEST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);

		b = new JButton("+/-");
		gridx = 1;
		gridy = 1;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);

		b = new JButton("%");
		gridx = 2;
		gridy = 1;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);

		b = new JButton("/");
		gridx = 3;
		gridy = 1;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHEAST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);

		b = new JButton("7");
		gridx = 0;
		gridy = 2;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHWEST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("8");
		gridx = 1;
		gridy = 2;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);

		b = new JButton("9");
		gridx = 2;
		gridy = 2;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);

		b = new JButton("＊");
		gridx = 3;
		gridy = 2;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHEAST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("4");
		gridx = 0;
		gridy = 3;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHWEST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("5");
		gridx = 1;
		gridy = 3;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("6");
		gridx = 2;
		gridy = 3;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("-");
		gridx = 3;
		gridy = 3;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHEAST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("1");
		gridx = 0;
		gridy = 4;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHWEST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("2");
		gridx = 1;
		gridy = 4;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("3");
		gridx = 2;
		gridy = 4;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("+");
		gridx = 3;
		gridy = 4;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHEAST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("0");
		gridx = 0;
		gridy = 5;
		gridwidth = 2;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHWEST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton(".");
		gridx = 2;
		gridy = 5;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTH;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		b = new JButton("=");
		gridx = 3;
		gridy = 5;
		gridwidth = 1;
		gridheight = 1;
		weightx = 10;
		weighty = 1;
		anchor = GridBagConstraints.NORTHEAST;
		fill = GridBagConstraints.HORIZONTAL;
		inset = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(b, c);
		contentPane.add(b);
		
		f.setTitle("Calculator");
		f.pack();
		f.setBounds(100, 100, 200, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
	}

	public static void main(String[] args) {
		new Calculator();
	}
}