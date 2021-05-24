import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;

public class SetUpWindow {

	private JFrame setUpFrame;
	private JTextField textFieldName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GameEnvironment gameEnv;
	
	public SetUpWindow(GameEnvironment gameEnviro) {
		gameEnv = gameEnviro;
		initialize();
		setUpFrame.setVisible(true);
	}
	
	public void closeWindow() {
		setUpFrame.dispose();
	}
	
	public void finishedWindow() {
		gameEnv.closeSetUpWindow(this);
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetUpWindow window = new SetUpWindow();
					window.setUpFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public SetUpWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setUpFrame = new JFrame();
		setUpFrame.setTitle("Island Adventure");
		setUpFrame.setBounds(100, 100, 800, 460);
		setUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUpFrame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Island Trader");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcome.setBounds(10, 11, 249, 37);
		setUpFrame.getContentPane().add(lblWelcome);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(10, 59, 109, 30);
		setUpFrame.getContentPane().add(lblName);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDays.setBounds(375, 59, 109, 30);
		setUpFrame.getContentPane().add(lblDays);
		
		JLabel lblNameRequirements = new JLabel("Must be between 3 and 15 letters and contain no special characters");
		lblNameRequirements.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNameRequirements.setBounds(10, 95, 341, 30);
		setUpFrame.getContentPane().add(lblNameRequirements);
		
		JLabel lblDaysRequirement = new JLabel("You can play between 20 and 50 days");
		lblDaysRequirement.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDaysRequirement.setBounds(375, 95, 332, 30);
		setUpFrame.getContentPane().add(lblDaysRequirement);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(83, 63, 164, 28);
		setUpFrame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblDaysCount = new JLabel("");
		lblDaysCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaysCount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDaysCount.setBounds(513, 36, 61, 16);
		setUpFrame.getContentPane().add(lblDaysCount);
		
		JSlider daysSlider = new JSlider();
		daysSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblDaysCount.setText(String.valueOf(daysSlider.getValue()));
			}
		});
		daysSlider.setPaintLabels(true);
		daysSlider.setValue(35);
		daysSlider.setPaintTicks(true);
		daysSlider.setMinorTickSpacing(5);
		daysSlider.setMajorTickSpacing(10);
		daysSlider.setMaximum(50);
		daysSlider.setMinimum(20);
		daysSlider.setBounds(441, 58, 200, 45);
		setUpFrame.getContentPane().add(daysSlider);
		
		JLabel lblSelectShip = new JLabel("Please Select Your Ship");
		lblSelectShip.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectShip.setBounds(10, 128, 241, 30);
		setUpFrame.getContentPane().add(lblSelectShip);
		
		JRadioButton rdbtnShip1 = new JRadioButton("Voyager");
		buttonGroup.add(rdbtnShip1);
		rdbtnShip1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnShip1.setBounds(40, 403, 111, 23);
		setUpFrame.getContentPane().add(rdbtnShip1);
		
		JRadioButton rdbtnShip2 = new JRadioButton("Midnight");
		buttonGroup.add(rdbtnShip2);
		rdbtnShip2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnShip2.setBounds(212, 403, 111, 23);
		setUpFrame.getContentPane().add(rdbtnShip2);
		
		JRadioButton rdbtnShip3 = new JRadioButton("Summer");
		buttonGroup.add(rdbtnShip3);
		rdbtnShip3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnShip3.setBounds(406, 403, 111, 23);
		setUpFrame.getContentPane().add(rdbtnShip3);
		
		JRadioButton rdbtnShip4 = new JRadioButton("Black Pearl");
		buttonGroup.add(rdbtnShip4);
		rdbtnShip4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnShip4.setBounds(596, 403, 111, 23);
		setUpFrame.getContentPane().add(rdbtnShip4);
		
		JLabel lblShip1Img = new JLabel("");
		lblShip1Img.setIcon(null);
		lblShip1Img.setBounds(40, 169, 100, 100);
		setUpFrame.getContentPane().add(lblShip1Img);
		
		JLabel lblShip2Img = new JLabel("");
		lblShip2Img.setIcon(null);
		lblShip2Img.setBounds(212, 169, 100, 100);
		setUpFrame.getContentPane().add(lblShip2Img);
		
		JLabel lblShip3Img = new JLabel("");
		lblShip3Img.setIcon(null);
		lblShip3Img.setBounds(406, 136, 100, 136);
		setUpFrame.getContentPane().add(lblShip3Img);
		
		JLabel lblShip4Img = new JLabel("");
		lblShip4Img.setIcon(null);
		lblShip4Img.setBounds(596, 169, 100, 100);
		setUpFrame.getContentPane().add(lblShip4Img);
		
		JLabel lblShip1Name = new JLabel("Voyager");
		lblShip1Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShip1Name.setBounds(59, 272, 60, 28);
		setUpFrame.getContentPane().add(lblShip1Name);
		
		JLabel lblShip2Name = new JLabel("Midnight");
		lblShip2Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShip2Name.setBounds(234, 272, 60, 28);
		setUpFrame.getContentPane().add(lblShip2Name);
		
		JLabel lblShip3Name = new JLabel("Summer");
		lblShip3Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShip3Name.setBounds(423, 272, 60, 28);
		setUpFrame.getContentPane().add(lblShip3Name);
		
		JLabel lblShip4Name = new JLabel("Black Pearl");
		lblShip4Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShip4Name.setBounds(618, 272, 100, 28);
		setUpFrame.getContentPane().add(lblShip4Name);
		
		JLabel lblCrewMembers1 = new JLabel("Crew members:");
		lblCrewMembers1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers1.setBounds(22, 298, 118, 28);
		setUpFrame.getContentPane().add(lblCrewMembers1);
		
		JLabel lblSpeed1 = new JLabel("Speed:");
		lblSpeed1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpeed1.setBounds(22, 324, 97, 28);
		setUpFrame.getContentPane().add(lblSpeed1);
		
		JLabel lblCargoSpace1 = new JLabel("Cargo space:");
		lblCargoSpace1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace1.setBounds(22, 351, 97, 28);
		setUpFrame.getContentPane().add(lblCargoSpace1);
		
		JLabel lblCrewMembers2 = new JLabel("Crew members:");
		lblCrewMembers2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers2.setBounds(205, 298, 118, 28);
		setUpFrame.getContentPane().add(lblCrewMembers2);
		
		JLabel lblSpeed2 = new JLabel("Speed:");
		lblSpeed2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpeed2.setBounds(205, 324, 97, 28);
		setUpFrame.getContentPane().add(lblSpeed2);
		
		JLabel lblCargoSpace2 = new JLabel("Cargo space:");
		lblCargoSpace2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace2.setBounds(205, 351, 97, 28);
		setUpFrame.getContentPane().add(lblCargoSpace2);
		
		JLabel lblCrewMembers3 = new JLabel("Crew members:");
		lblCrewMembers3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers3.setBounds(406, 298, 118, 28);
		setUpFrame.getContentPane().add(lblCrewMembers3);
		
		JLabel lblSpeed3 = new JLabel("Speed:");
		lblSpeed3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpeed3.setBounds(406, 324, 97, 28);
		setUpFrame.getContentPane().add(lblSpeed3);
		
		JLabel lblCargoSpace3 = new JLabel("Cargo space:");
		lblCargoSpace3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace3.setBounds(406, 351, 97, 28);
		setUpFrame.getContentPane().add(lblCargoSpace3);
		
		JLabel lblCrewMembers4 = new JLabel("Crew members:");
		lblCrewMembers4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers4.setBounds(589, 298, 118, 28);
		setUpFrame.getContentPane().add(lblCrewMembers4);
		
		JLabel lblSpeed4 = new JLabel("Speed:");
		lblSpeed4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpeed4.setBounds(589, 324, 97, 28);
		setUpFrame.getContentPane().add(lblSpeed4);
		
		JLabel lblCargoSpace4 = new JLabel("Cargo space:");
		lblCargoSpace4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace4.setBounds(589, 351, 97, 28);
		setUpFrame.getContentPane().add(lblCargoSpace4);
		
		JLabel lblCrewMembers1Value = new JLabel("12");
		lblCrewMembers1Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers1Value.setBounds(129, 298, 39, 28);
		setUpFrame.getContentPane().add(lblCrewMembers1Value);
		
		JLabel lblCrewMembers2Value = new JLabel("16");
		lblCrewMembers2Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers2Value.setBounds(312, 298, 39, 28);
		setUpFrame.getContentPane().add(lblCrewMembers2Value);
		
		JLabel lblCrewMembers3Value = new JLabel("20");
		lblCrewMembers3Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers3Value.setBounds(513, 298, 39, 28);
		setUpFrame.getContentPane().add(lblCrewMembers3Value);
		
		JLabel lblCrewMembers4Value = new JLabel("24");
		lblCrewMembers4Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers4Value.setBounds(696, 298, 39, 28);
		setUpFrame.getContentPane().add(lblCrewMembers4Value);
		
		JLabel lblSpeed1Value = new JLabel("30");
		lblSpeed1Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpeed1Value.setBounds(129, 324, 39, 28);
		setUpFrame.getContentPane().add(lblSpeed1Value);
		
		JLabel lblCargoSpace1Value = new JLabel("35");
		lblCargoSpace1Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace1Value.setBounds(129, 351, 39, 28);
		setUpFrame.getContentPane().add(lblCargoSpace1Value);
		
		JLabel lblSpeed2Value = new JLabel("25");
		lblSpeed2Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpeed2Value.setBounds(312, 324, 39, 28);
		setUpFrame.getContentPane().add(lblSpeed2Value);
		
		JLabel lblCargoSpace2Value = new JLabel("40");
		lblCargoSpace2Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace2Value.setBounds(312, 351, 39, 28);
		setUpFrame.getContentPane().add(lblCargoSpace2Value);
		
		JLabel lblSpeed3Value = new JLabel("20");
		lblSpeed3Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpeed3Value.setBounds(513, 324, 39, 28);
		setUpFrame.getContentPane().add(lblSpeed3Value);
		
		JLabel lblCargoSpace3Value = new JLabel("45");
		lblCargoSpace3Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace3Value.setBounds(513, 351, 39, 28);
		setUpFrame.getContentPane().add(lblCargoSpace3Value);
		
		JLabel lblSpeed4Value = new JLabel("15");
		lblSpeed4Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpeed4Value.setBounds(696, 324, 39, 28);
		setUpFrame.getContentPane().add(lblSpeed4Value);
		
		JLabel lblCargoSpace4Value = new JLabel("52");
		lblCargoSpace4Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace4Value.setBounds(696, 351, 39, 28);
		setUpFrame.getContentPane().add(lblCargoSpace4Value);
		
		JButton btnNextScreen = new JButton("Next");
		btnNextScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gameEnv.setDays(daysSlider.getValue());
				String name = textFieldName.getText();
				boolean validName = gameEnv.checkName(name);
				
				if (validName == true) {
					gameEnv.setName(name);
					lblNameRequirements.setForeground(Color.black);
				}else {
					lblNameRequirements.setForeground(Color.red);
				}
				
				
				boolean shipChosen = false;
				
				if (rdbtnShip1.isSelected() == true) {
					gameEnv.setShip("Voyager");
					lblSelectShip.setForeground(Color.black);
					shipChosen = true;
				} else if (rdbtnShip2.isSelected() == true) {
					gameEnv.setShip("Midnight");
					lblSelectShip.setForeground(Color.black);
					shipChosen = true;
				} else if (rdbtnShip3.isSelected() == true) {
					gameEnv.setShip("Summer");
					shipChosen = true;	
					lblSelectShip.setForeground(Color.black);
				} else if (rdbtnShip4.isSelected() == true) {
					gameEnv.setShip("Black Pearl");
					lblSelectShip.setForeground(Color.black);
					shipChosen = true;
				} else {
					lblSelectShip.setForeground(Color.red); // if no ship is selected this text turns red to show that it is not complete
				}
				
				
				if (validName == true && shipChosen == true){
					finishedWindow();
				}
				
			}
		});
		btnNextScreen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNextScreen.setBounds(687, 11, 89, 23);
		setUpFrame.getContentPane().add(btnNextScreen);
		
		JLabel lblHealth1 = new JLabel("Health:");
		lblHealth1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth1.setBounds(22, 385, 61, 16);
		setUpFrame.getContentPane().add(lblHealth1);
		
		JLabel lblHealth2 = new JLabel("Health:");
		lblHealth2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth2.setBounds(205, 386, 61, 16);
		setUpFrame.getContentPane().add(lblHealth2);
		
		JLabel lblHealth3 = new JLabel("Health:");
		lblHealth3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth3.setBounds(406, 386, 61, 16);
		setUpFrame.getContentPane().add(lblHealth3);
		
		JLabel lblHealth4 = new JLabel("Health:");
		lblHealth4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth4.setBounds(589, 386, 61, 16);
		setUpFrame.getContentPane().add(lblHealth4);
		
		JLabel lblHealth1Value = new JLabel("70");
		lblHealth1Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth1Value.setBounds(129, 386, 61, 16);
		setUpFrame.getContentPane().add(lblHealth1Value);
		
		JLabel lblHealth2Value = new JLabel("80");
		lblHealth2Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth2Value.setBounds(312, 386, 61, 16);
		setUpFrame.getContentPane().add(lblHealth2Value);
		
		JLabel lblHealth3Value = new JLabel("90");
		lblHealth3Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth3Value.setBounds(513, 386, 61, 16);
		setUpFrame.getContentPane().add(lblHealth3Value);
		
		JLabel lblHealth4Value = new JLabel("100");
		lblHealth4Value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth4Value.setBounds(696, 386, 61, 16);
		setUpFrame.getContentPane().add(lblHealth4Value);
		
		
	}
}
