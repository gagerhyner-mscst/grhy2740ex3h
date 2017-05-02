package grhyner2740ex3h;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel totalLabel;
	private JLabel averageLabel;
	private JLabel maxLabel;
	private JLabel minLabel;
	private JTextField inputMonthTextField;
	private String [] strRainfall = {
			"1.2", "2.7", "2.2", "3.1", "2.9", "5.1",
			"3.2", "2.7", "3.6", "1.8", "2.2", "1.7"};
	private JButton updateButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RainfallForm() {
		setTitle("COMC2740 GRhyner ex3h");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly rainfall");
		lblMonthlyRainfall.setBounds(10, 11, 93, 14);
		contentPane.add(lblMonthlyRainfall);
		
		JList monthList = new JList();
		monthList.setBackground(UIManager.getColor("Label.background"));
		monthList.setEnabled(false);
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sept", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthList.setBounds(10, 35, 50, 234);
		contentPane.add(monthList);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(70, 36, 50, 219);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(130, 53, 50, 14);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setBounds(130, 78, 61, 14);
		contentPane.add(lblAverage);
		
		JLabel lblMaximum = new JLabel("Maximum:");
		lblMaximum.setBounds(130, 103, 61, 14);
		contentPane.add(lblMaximum);
		
		JLabel lblMininum = new JLabel("Mininum:");
		lblMininum.setBounds(130, 128, 61, 14);
		contentPane.add(lblMininum);
		
		totalLabel = new JLabel("0.0");
		lblTotal.setLabelFor(totalLabel);
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setBounds(206, 47, 56, 18);
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		lblAverage.setLabelFor(averageLabel);
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setBounds(206, 74, 56, 18);
		contentPane.add(averageLabel);
		
		maxLabel = new JLabel("0.0");
		lblMaximum.setLabelFor(maxLabel);
		maxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maxLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		maxLabel.setBounds(206, 99, 56, 18);
		contentPane.add(maxLabel);
		
		minLabel = new JLabel("0.0");
		lblMininum.setLabelFor(minLabel);
		minLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		minLabel.setBounds(206, 124, 56, 18);
		contentPane.add(minLabel);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_calculateButton_actionPerformed(arg0);
			}
		});
		calculateButton.setBounds(173, 153, 89, 23);
		contentPane.add(calculateButton);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputMonthTextField.setText("0.0");
		inputMonthTextField.setBounds(72, 266, 50, 20);
		contentPane.add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
		
		updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_actionPerformed(e);
			}
		});
		updateButton.setBounds(55, 297, 89, 23);
		updateButton.setEnabled(false);
		contentPane.add(updateButton);
	}
	protected void do_calculateButton_actionPerformed(ActionEvent arg0) {
		Rainfall rainfall = new Rainfall(strRainfall);
		
		DecimalFormat fmt1 = new DecimalFormat("0.0");
		totalLabel.setText(fmt1.format(rainfall.getTotal()));
		DecimalFormat fmt2 = new DecimalFormat("0.0");
		averageLabel.setText(fmt2.format(rainfall.getAverage()));
		DecimalFormat fmt3 = new DecimalFormat("0.0");
		minLabel.setText(fmt3.format(rainfall.getLowest()));
		DecimalFormat fmt4 = new DecimalFormat("0.0");
		totalLabel.setText(fmt4.format(rainfall.getHighest()));
		
	}
	
	protected void do_updateButton_actionPerformed(ActionEvent e) {
		int selectedIndex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(inputMonthTextField.getText());
		strRainfall[selectedIndex] = Double.toString(r);
		rainfallList.repaint();
		
		inputMonthTextField.setText("0.0");
		updateButton.setEnabled(false);
		totalLabel.setText("");
		averageLabel.setText("");
		minLabel.setText("");
		maxLabel.setText("");
		
	}
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		updateButton.setEnabled(true);
		inputMonthTextField.setText((String)rainfallList.getSelectedValue());
		inputMonthTextField.requestFocus();
		inputMonthTextField.selectAll();
	}
}
