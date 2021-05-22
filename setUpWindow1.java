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

public class setUpWindow1 {

	private JFrame frmIslandAdventure;
	private JTextField textFieldName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GameEnvironment gameEnv;
	
	public setUpWindow1(GameEnvironment ingameEnv) {
		gameEnv = ingameEnv;
		initialize();
		frmIslandAdventure.setVisible(true);
	}
	
	public void closeWindow() {
		frmIslandAdventure.dispose();
	}
	
	public void finishedWindow() {
		gameEnv.closesetUpWindow1(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setUpWindow1 window = new setUpWindow1();
					window.frmIslandAdventure.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public setUpWindow1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIslandAdventure = new JFrame();
		frmIslandAdventure.setTitle("Island Adventure");
		frmIslandAdventure.setBounds(100, 100, 800, 460);
		frmIslandAdventure.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIslandAdventure.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Island Trader");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcome.setBounds(10, 11, 249, 37);
		frmIslandAdventure.getContentPane().add(lblWelcome);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(10, 59, 109, 30);
		frmIslandAdventure.getContentPane().add(lblName);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDays.setBounds(375, 59, 109, 30);
		frmIslandAdventure.getContentPane().add(lblDays);
		
		JLabel lblNameRequirements = new JLabel("Name must be between 3 and 15 characters long");
		lblNameRequirements.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNameRequirements.setBounds(10, 95, 341, 30);
		frmIslandAdventure.getContentPane().add(lblNameRequirements);
		
		JLabel lblDaysRequirement = new JLabel("You can play between 20 and 50 days");
		lblDaysRequirement.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDaysRequirement.setBounds(375, 95, 332, 30);
		frmIslandAdventure.getContentPane().add(lblDaysRequirement);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(83, 63, 164, 28);
		frmIslandAdventure.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JSlider daysSlider = new JSlider();
		daysSlider.setPaintLabels(true);
		daysSlider.setValue(35);
		daysSlider.setPaintTicks(true);
		daysSlider.setMinorTickSpacing(5);
		daysSlider.setMajorTickSpacing(10);
		daysSlider.setMaximum(50);
		daysSlider.setMinimum(20);
		daysSlider.setBounds(441, 58, 200, 45);
		frmIslandAdventure.getContentPane().add(daysSlider);
		
		JLabel lblSelectShip = new JLabel("Please Select Your Ship");
		lblSelectShip.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectShip.setBounds(10, 128, 241, 30);
		frmIslandAdventure.getContentPane().add(lblSelectShip);
		
		JRadioButton rdbtnShip1 = new JRadioButton("Voyager");
		buttonGroup.add(rdbtnShip1);
		rdbtnShip1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnShip1.setBounds(40, 379, 111, 23);
		frmIslandAdventure.getContentPane().add(rdbtnShip1);
		
		JRadioButton rdbtnShip2 = new JRadioButton("Midnight");
		buttonGroup.add(rdbtnShip2);
		rdbtnShip2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnShip2.setBounds(212, 379, 111, 23);
		frmIslandAdventure.getContentPane().add(rdbtnShip2);
		
		JRadioButton rdbtnShip3 = new JRadioButton("Summer");
		buttonGroup.add(rdbtnShip3);
		rdbtnShip3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnShip3.setBounds(406, 379, 111, 23);
		frmIslandAdventure.getContentPane().add(rdbtnShip3);
		
		JRadioButton rdbtnShip4 = new JRadioButton("Black Pearl");
		buttonGroup.add(rdbtnShip4);
		rdbtnShip4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnShip4.setBounds(596, 379, 111, 23);
		frmIslandAdventure.getContentPane().add(rdbtnShip4);
		
		JLabel lblShip1Img = new JLabel("");
		lblShip1Img.setIcon(new ImageIcon(setUpWindow1.class.getResource("/img/ship1.jpg")));
		lblShip1Img.setBounds(40, 169, 100, 100);
		frmIslandAdventure.getContentPane().add(lblShip1Img);
		
		JLabel lblShip2Img = new JLabel("");
		lblShip2Img.setIcon(new ImageIcon(setUpWindow1.class.getResource("/img/shi2.jpg")));
		lblShip2Img.setBounds(212, 169, 100, 100);
		frmIslandAdventure.getContentPane().add(lblShip2Img);
		
		JLabel lblShip3Img = new JLabel("");
		lblShip3Img.setIcon(new ImageIcon(setUpWindow1.class.getResource("/img/ship3.jpg")));
		lblShip3Img.setBounds(406, 136, 100, 136);
		frmIslandAdventure.getContentPane().add(lblShip3Img);
		
		JLabel lblShip4Img = new JLabel("");
		lblShip4Img.setIcon(new ImageIcon(setUpWindow1.class.getResource("/img/ship4.jpg")));
		lblShip4Img.setBounds(596, 169, 100, 100);
		frmIslandAdventure.getContentPane().add(lblShip4Img);
		
		JLabel lblShip1Name = new JLabel("Voyager");
		lblShip1Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShip1Name.setBounds(59, 272, 60, 28);
		frmIslandAdventure.getContentPane().add(lblShip1Name);
		
		JLabel lblShip2Name = new JLabel("Midnight");
		lblShip2Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShip2Name.setBounds(234, 272, 60, 28);
		frmIslandAdventure.getContentPane().add(lblShip2Name);
		
		JLabel lblShip3Name = new JLabel("Summer");
		lblShip3Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShip3Name.setBounds(423, 272, 60, 28);
		frmIslandAdventure.getContentPane().add(lblShip3Name);
		
		JLabel lblShip4Name = new JLabel("Black Pearl");
		lblShip4Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShip4Name.setBounds(618, 272, 100, 28);
		frmIslandAdventure.getContentPane().add(lblShip4Name);
		
		JLabel lblCrewMembers = new JLabel("Crew members:");
		lblCrewMembers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers.setBounds(22, 298, 118, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers);
		
		JLabel lblWagePerDay = new JLabel("Wage per day:");
		lblWagePerDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWagePerDay.setBounds(22, 324, 97, 28);
		frmIslandAdventure.getContentPane().add(lblWagePerDay);
		
		JLabel lblCargoSpace = new JLabel("Cargo space:");
		lblCargoSpace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace.setBounds(22, 351, 97, 28);
		frmIslandAdventure.getContentPane().add(lblCargoSpace);
		
		JLabel lblCrewMembers_1 = new JLabel("Crew members:");
		lblCrewMembers_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_1.setBounds(205, 298, 118, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_1);
		
		JLabel lblWagePerDay_1 = new JLabel("Wage per day:");
		lblWagePerDay_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWagePerDay_1.setBounds(205, 324, 97, 28);
		frmIslandAdventure.getContentPane().add(lblWagePerDay_1);
		
		JLabel lblCargoSpace_1 = new JLabel("Cargo space:");
		lblCargoSpace_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace_1.setBounds(205, 351, 97, 28);
		frmIslandAdventure.getContentPane().add(lblCargoSpace_1);
		
		JLabel lblCrewMembers_2 = new JLabel("Crew members:");
		lblCrewMembers_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_2.setBounds(406, 298, 118, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_2);
		
		JLabel lblWagePerDay_2 = new JLabel("Wage per day:");
		lblWagePerDay_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWagePerDay_2.setBounds(406, 324, 97, 28);
		frmIslandAdventure.getContentPane().add(lblWagePerDay_2);
		
		JLabel lblCargoSpace_2 = new JLabel("Cargo space:");
		lblCargoSpace_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace_2.setBounds(406, 351, 97, 28);
		frmIslandAdventure.getContentPane().add(lblCargoSpace_2);
		
		JLabel lblCrewMembers_3 = new JLabel("Crew members:");
		lblCrewMembers_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_3.setBounds(589, 298, 118, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_3);
		
		JLabel lblWagePerDay_3 = new JLabel("Wage per day:");
		lblWagePerDay_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWagePerDay_3.setBounds(589, 324, 97, 28);
		frmIslandAdventure.getContentPane().add(lblWagePerDay_3);
		
		JLabel lblCargoSpace_3 = new JLabel("Cargo space:");
		lblCargoSpace_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoSpace_3.setBounds(589, 351, 97, 28);
		frmIslandAdventure.getContentPane().add(lblCargoSpace_3);
		
		JLabel lblCrewMembers_4 = new JLabel("12");
		lblCrewMembers_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4.setBounds(129, 298, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4);
		
		JLabel lblCrewMembers_4_1 = new JLabel("16");
		lblCrewMembers_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_1.setBounds(312, 298, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_1);
		
		JLabel lblCrewMembers_4_2 = new JLabel("20");
		lblCrewMembers_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_2.setBounds(513, 298, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_2);
		
		JLabel lblCrewMembers_4_3 = new JLabel("24");
		lblCrewMembers_4_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_3.setBounds(696, 298, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_3);
		
		JLabel lblCrewMembers_4_4 = new JLabel("$20");
		lblCrewMembers_4_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_4.setBounds(129, 324, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_4);
		
		JLabel lblCrewMembers_4_5 = new JLabel("40");
		lblCrewMembers_4_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_5.setBounds(129, 351, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_5);
		
		JLabel lblCrewMembers_4_6 = new JLabel("$24");
		lblCrewMembers_4_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_6.setBounds(312, 324, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_6);
		
		JLabel lblCrewMembers_4_7 = new JLabel("44");
		lblCrewMembers_4_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_7.setBounds(312, 351, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_7);
		
		JLabel lblCrewMembers_4_8 = new JLabel("$28");
		lblCrewMembers_4_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_8.setBounds(513, 324, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_8);
		
		JLabel lblCrewMembers_4_9 = new JLabel("48");
		lblCrewMembers_4_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_9.setBounds(513, 351, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_9);
		
		JLabel lblCrewMembers_4_10 = new JLabel("$32");
		lblCrewMembers_4_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_10.setBounds(696, 324, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_10);
		
		JLabel lblCrewMembers_4_11 = new JLabel("52");
		lblCrewMembers_4_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewMembers_4_11.setBounds(696, 351, 39, 28);
		frmIslandAdventure.getContentPane().add(lblCrewMembers_4_11);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tname = textFieldName.getText();
				String name = null;
				if (tname.length() >= 3 && tname.length() <= 15 && tname.matches("[ a-zA-Z]+")) {
					name = tname;
				} else {
					lblNameRequirements.setText("You must enter a name within 3-15 characters long!");
					lblNameRequirements.setForeground(Color.red);
				}

				int days = daysSlider.getValue();
				
				Ship ship = null;
				if (rdbtnShip1.isSelected() == true) {
					ship = new Ship("Voyager", 12, 20, 40);
				} else if (rdbtnShip2.isSelected() == true) {
					ship = new Ship("Midnight", 16, 24, 44);
				} else if (rdbtnShip3.isSelected() == true) {
					ship = new Ship("Summer", 20, 28, 48);
				} else if (rdbtnShip4.isSelected() == true) {
					ship = new Ship("Black Pearl", 24, 32, 52);
				} else {
					lblSelectShip.setText("You must select a ship!");
					lblSelectShip.setForeground(Color.red);
				}
								
				if (name != null && ship != null) {
					gameEnv.name = name;
					gameEnv.days = days;
					gameEnv.initialDays = days;
					gameEnv.myShip = ship;
					finishedWindow();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(687, 11, 89, 23);
		frmIslandAdventure.getContentPane().add(btnNewButton);
	}
}
