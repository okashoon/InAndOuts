import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;



public class InOut {
	
	ArrayList<JButton> inButtonsArrayList = new ArrayList<JButton>();
	ArrayList<JButton> outButtonsArrayList = new ArrayList<JButton>();
	ArrayList<JLabel> inLabelArrayList = new ArrayList<JLabel>();
	ArrayList<JLabel> outLabelArrayList = new ArrayList<JLabel>();
	
	ArrayList<JLabel> hours = new ArrayList<JLabel>();
	
	
	long[] hoursPerDay = new long[32];
	
	
	
	ArrayList<time> inTime = new ArrayList<time>();
	ArrayList<time> outTime = new ArrayList<time>();
	
	JLabel sumLabel ;
	
	int counterin = 0;
	int counterout = 0;
	
	
	
	
	public void buildGui(){
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setSize(500, 500);
		panel.setLayout(new GridBagLayout());
		
		
		
		
		
		for ( int i = 0; i <32 ; i++){
			
		JButton inButton = new JButton("in");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = i;
		c.anchor = GridBagConstraints.WEST;
		panel.add(inButton,c);
		inButtonsArrayList.add(inButton);
		
		inButton.addActionListener(new inButtonActionListener());
		
		}
		
		
		for ( int i = 0; i <32 ; i++){
			
			JButton outButton = new JButton("out");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 2;
			c.gridy = i;
			c.insets = new Insets(0, 10, 0, 0);
			panel.add(outButton,c);
			outButtonsArrayList.add(outButton);
			
			outButton.addActionListener(new outButtonActionListener());
		}


		for ( int i = 0; i <32 ; i++){

			JLabel inLabel = new JLabel("in");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 3;
			c.gridy = i;
			c.insets = new Insets(0, 150, 0, 0);
			panel.add(inLabel,c);
			inLabelArrayList.add(inLabel);

		}
		
		for ( int i = 0; i <32 ; i++){

			JLabel outLabel = new JLabel("out");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 4;
			c.gridy = i;
			c.insets = new Insets(0, 30, 0, 0);
			panel.add(outLabel,c);
			outLabelArrayList.add(outLabel);
			
			JLabel hoursLabel = new JLabel("hours");
			GridBagConstraints d = new GridBagConstraints();
			d.fill = GridBagConstraints.VERTICAL;
			d.gridx = 5;
			d.gridy = i;
			d.insets = new Insets(0, 30, 0, 0);
			panel.add(hoursLabel,d);
			hours.add(hoursLabel);

		}
		
		
		JButton sumButton = new JButton("sum");
		sumButton.addActionListener(new sumActionListener());
		
		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.VERTICAL;
		d.gridx = 0;
		d.gridy = 32;
		d.insets = new Insets(30, 40, 0, 0);
		d.ipadx = 50;
		
		panel.add(sumButton,d);
		
		
		sumLabel = new JLabel("sum");
		
		GridBagConstraints l = new GridBagConstraints();
		l.fill = GridBagConstraints.VERTICAL;
		l.gridx = 5;
		l.gridy = 32;
		l.insets = new Insets(30, 0, 0, 0);
		l.ipadx = 50;
		
		panel.add(sumLabel,l);
		
		
		
		



		JScrollPane scroller = new JScrollPane(panel);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.add(scroller);
		frame.setSize(700, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public class inButtonActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			JLabel jc = inLabelArrayList.get(counterin);  //extracts jLabel from the inlabelArray
			time t = new time();
			
			inTime.add(t);
			
			jc.setText(t.getTime());

			inButtonsArrayList.get(counterin).setEnabled(false);
			counterin++;
		}



	}
	
	public class sumActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			
			long total = 0;
			for( int i = 0; i <32 ; i++){
				
				long sum = hoursPerDay[i];
				total = total + sum;
				
			}
			sumLabel.setText(time.longFormatted(total));
		

		}



	}


	public class outButtonActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			JLabel jc = outLabelArrayList.get(counterout);  //get JLabel out of arraylist
			
			time t = new time();
			
			outTime.add(t);
			
			
			jc.setText(t.getTime());
			
			outButtonsArrayList.get(counterout).setEnabled(false);
			
			time i = inTime.get(counterout);
			time o = outTime.get(counterout);
			long difference = time.getDifference(o,i);
			
			hoursPerDay[counterout] = difference;
			
			
			JLabel hpd =hours.get(counterout);
			hpd.setText(time.longFormatted(difference));
			
			
			
			counterout++;
			
			
		}
		
		



	}

	public static void main(String[] args) {
		InOut g = new InOut();
		g.buildGui();

	}

}


 

