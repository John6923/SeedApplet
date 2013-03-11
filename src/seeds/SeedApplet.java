package seeds;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SeedApplet extends JApplet {
	
	SeedPanel seedPanel = new SeedPanel();
	JPanel dataPanel = new JPanel();
	JLabel angleLabel = new JLabel("Angle: ");
	JTextField angle = new JTextField("0");
	JPanel anglePanel = new JPanel();
	JLabel numSeedsLabel = new JLabel("Seeds: ");
	JTextField numSeeds = new JTextField("0");
	JPanel numSeedsPanel = new JPanel();
	JLabel moduloLabel = new JLabel("Modulo");
	JTextField modulo = new JTextField("0");
	JPanel moduloPanel = new JPanel();
	JLabel upd8Label = new JLabel("By John Dood");
	JButton upd8Button = new JButton("Update!");
	JPanel upd8Panel = new JPanel();
	
	@Override
	public void init() {
		upd8Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					seedPanel.setAngle(Double.parseDouble(angle.getText()));
					seedPanel.setSeeds(Integer.parseInt(numSeeds.getText()));
					seedPanel.setMod(Integer.parseInt(modulo.getText()));
					seedPanel.repaint();
				}
				catch (NumberFormatException e) {
					//e.printStackTrace();
				}
			}
		});
		anglePanel.setLayout(new GridLayout(2,1));
		anglePanel.add(angleLabel);
		anglePanel.add(angle);
		numSeedsPanel.setLayout(new GridLayout(2,1));
		numSeedsPanel.add(numSeedsLabel);
		numSeedsPanel.add(numSeeds);
		moduloPanel.setLayout(new GridLayout(2,1));
		moduloPanel.add(moduloLabel);
		moduloPanel.add(modulo);
		upd8Panel.setLayout(new GridLayout(2,1));
		upd8Panel.add(upd8Label);
		upd8Panel.add(upd8Button);
		dataPanel.setLayout(new GridLayout(1,3));
		dataPanel.setLayout(new GridLayout(1,4));
		dataPanel.add(anglePanel);
		dataPanel.add(numSeedsPanel);
		dataPanel.add(moduloPanel);
		dataPanel.add(upd8Panel);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(seedPanel,BorderLayout.CENTER);
		c.add(dataPanel, BorderLayout.SOUTH);
		setSize(500,550);
		setVisible(true);
	}

}
