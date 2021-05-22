import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class mainWindow {

	private JFrame frame;
	private GameEnvironment gameEnv;

	
	public mainWindow(GameEnvironment in) {
		gameEnv = in;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		gameEnv.closemainWindow(this);
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel("What would you like to do?");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuestion.setBounds(10, 11, 260, 25);
		frame.getContentPane().add(lblQuestion);
		
		JLabel lblName = new JLabel("Name");
		lblName.setText(gameEnv.name);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(432, 21, 142, 45);
		frame.getContentPane().add(lblName);
		
		JLabel lblCurIsland = new JLabel("Current Island:");
		lblCurIsland.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurIsland.setBounds(402, 129, 142, 45);
		frame.getContentPane().add(lblCurIsland);
		
		JLabel lblIsland = new JLabel((String) null);
		lblIsland.setText(gameEnv.currentIsland.name);
		lblIsland.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsland.setBounds(550, 129, 142, 45);
		frame.getContentPane().add(lblIsland);
		
		JLabel lblYourShip = new JLabel("Your Ship:");
		lblYourShip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourShip.setBounds(432, 194, 309, 45);
		frame.getContentPane().add(lblYourShip);
		
		JLabel lblShip = new JLabel("");
		lblShip.setText(gameEnv.myShip.name);
		lblShip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip.setBounds(550, 194, 142, 45);
		frame.getContentPane().add(lblShip);
		

		DefaultListModel<Item> listPurchasedModel = new DefaultListModel<Item>();
		JList<Item> listPurchased = new JList<Item>(listPurchasedModel);
		listPurchased.setBounds(432, 224, 309, -135);
		frame.getContentPane().add(listPurchased);
		
		DefaultListModel<Item> listSoldGoodsModel = new DefaultListModel<Item>();
		JList<Item> listSoldGoods = new JList<Item>(listSoldGoodsModel);
		listSoldGoods.setBounds(426, 400, 332, -159);
		frame.getContentPane().add(listSoldGoods);
		
		JButton btn5AmtMon = new JButton("View amount of money");
		btn5AmtMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "$" + String.valueOf(gameEnv.money));
			}
		});
		btn5AmtMon.setVisible(false);
		btn5AmtMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5AmtMon.setBounds(489, 236, 214, 52);
		frame.getContentPane().add(btn5AmtMon);
		
		JButton btn5PrevPurs = new JButton("View purchased items");
		btn5PrevPurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, gameEnv.viewPurchasedGoods());
			}
		});
		btn5PrevPurs.setVisible(false);
		btn5PrevPurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5PrevPurs.setBounds(489, 308, 214, 52);
		frame.getContentPane().add(btn5PrevPurs);
		
		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setVisible(false);
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistance.setBounds(442, 134, 102, 34);
		frame.getContentPane().add(lblDistance);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setVisible(false);
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCost.setBounds(442, 161, 102, 34);
		frame.getContentPane().add(lblCost);
		
		JLabel lblCost_1 = new JLabel("Cost:");
		lblCost_1.setVisible(false);
		lblCost_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCost_1.setBounds(609, 161, 102, 34);
		frame.getContentPane().add(lblCost_1);
		
		JLabel lblDistance_1 = new JLabel("Distance:");
		lblDistance_1.setVisible(false);
		lblDistance_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistance_1.setBounds(609, 134, 102, 34);
		frame.getContentPane().add(lblDistance_1);
		
		JLabel lblCost_2 = new JLabel("Cost:");
		lblCost_2.setVisible(false);
		lblCost_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCost_2.setBounds(442, 326, 102, 34);
		frame.getContentPane().add(lblCost_2);
		
		JLabel lblDistance_2 = new JLabel("Distance:");
		lblDistance_2.setVisible(false);
		lblDistance_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistance_2.setBounds(442, 299, 102, 34);
		frame.getContentPane().add(lblDistance_2);
		
		JLabel lblCost_3 = new JLabel("Cost:");
		lblCost_3.setVisible(false);
		lblCost_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCost_3.setBounds(619, 326, 102, 34);
		frame.getContentPane().add(lblCost_3);
		
		JLabel lblDistance_3 = new JLabel("Distance:");
		lblDistance_3.setVisible(false);
		lblDistance_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistance_3.setBounds(619, 299, 102, 34);
		frame.getContentPane().add(lblDistance_3);
		
		JLabel lblCostFirst = new JLabel("");
		lblCostFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostFirst.setBounds(509, 161, 102, 34);
		frame.getContentPane().add(lblCostFirst);
		
		JLabel lblDistFirst = new JLabel("");
		lblDistFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistFirst.setBounds(509, 134, 102, 34);
		frame.getContentPane().add(lblDistFirst);
		
		JLabel lblCostSecond = new JLabel("");
		lblCostSecond.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostSecond.setBounds(674, 161, 102, 34);
		frame.getContentPane().add(lblCostSecond);
		
		JLabel lblDistSecond = new JLabel("");
		lblDistSecond.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistSecond.setBounds(674, 134, 102, 34);
		frame.getContentPane().add(lblDistSecond);
		
		JLabel lblCostThird = new JLabel("");
		lblCostThird.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostThird.setBounds(509, 326, 102, 34);
		frame.getContentPane().add(lblCostThird);
		
		JLabel lblDistThird = new JLabel("");
		lblDistThird.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistThird.setBounds(509, 299, 102, 34);
		frame.getContentPane().add(lblDistThird);
		
		JLabel lblCostFourth = new JLabel("");
		lblCostFourth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostFourth.setBounds(684, 326, 102, 34);
		frame.getContentPane().add(lblCostFourth);
		
		JLabel lblDistFourth = new JLabel("");
		lblDistFourth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistFourth.setBounds(684, 299, 102, 34);
		frame.getContentPane().add(lblDistFourth);
		
		JButton btn5Sale = new JButton("Items for Sale");
		
		DefaultListModel<Item> listItemsToSellModel = new DefaultListModel<Item>();
		JList<Item> listItemsToSell = new JList<Item>(listItemsToSellModel);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSell.setVisible(false);
		btnSell.setBounds(551, 377, 89, 23);
		frame.getContentPane().add(btnSell);

		JButton btn5Buy = new JButton("Items the Store will buy");
		btn5Buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listItemsToSellModel.removeAllElements();
				listItemsToSellModel.addAll(gameEnv.currentIsland.store.itemsPurchased);
				listItemsToSell.setVisible(false);
				listItemsToSell.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				listItemsToSell.setBounds(442, 83, 301, 285);
				frame.getContentPane().add(listItemsToSell);
				
				btn5PrevPurs.setVisible(false);
				btn5Buy.setVisible(false);
				btn5Sale.setVisible(false);
				btn5AmtMon.setVisible(false);
				
				btnSell.setVisible(true);
				listItemsToSell.setVisible(true);
				
			}
		});
		
		btn5Buy.setVisible(false);
		btn5Buy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5Buy.setBounds(489, 161, 214, 52);
		frame.getContentPane().add(btn5Buy);
		
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listItemsToSell.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(frame, "You haven't selected an item");
				} else {
					Item item1 = listItemsToSell.getSelectedValue();
					if (gameEnv.sellItem(item1) == true) {
						JOptionPane.showMessageDialog(frame, "You have successfully sold the item!");
					} else {
						JOptionPane.showMessageDialog(frame, "You do not have this item to sell!");
					}
					
				btnSell.setVisible(false);
				listItemsToSell.setVisible(false);
				btn5PrevPurs.setVisible(true);
				btn5Buy.setVisible(true);
				btn5Sale.setVisible(true);
				btn5AmtMon.setVisible(true);
				}
			}
		});
	
		DefaultListModel<Item> listItemsForSaleModel = new DefaultListModel<Item>();
		JList<Item> listItemsForSale = new JList<Item>(listItemsForSaleModel);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listItemsForSale.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(frame, "You have not selected anything");
				} else {
					Item item1 = listItemsForSale.getSelectedValue();
					if (gameEnv.purchaseItem(item1) == true) {
						JOptionPane.showMessageDialog(frame, "Item purchased successfully!");
					} else {
						JOptionPane.showMessageDialog(frame, "Item was not purchased successfully, \nyou may not have enough money!");
					}
					
				btnBuy.setVisible(false);
				listItemsForSale.setVisible(false);
				btn5PrevPurs.setVisible(true);
				btn5Buy.setVisible(true);
				btn5Sale.setVisible(true);
				btn5AmtMon.setVisible(true);
				}

			}
			
		});
		btnBuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuy.setVisible(false);
		btnBuy.setBounds(551, 377, 89, 23);
		frame.getContentPane().add(btnBuy);


		btn5Sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listItemsForSaleModel.removeAllElements();
				listItemsForSaleModel.addAll(gameEnv.currentIsland.store.itemsSold);
				listItemsForSale.setVisible(false);
				listItemsForSale.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				listItemsForSale.setBounds(442, 83, 301, 285);
				frame.getContentPane().add(listItemsForSale);
				
				btn5PrevPurs.setVisible(false);
				btn5Buy.setVisible(false);
				btn5Sale.setVisible(false);
				btn5AmtMon.setVisible(false);
				
				btnBuy.setVisible(true);
				listItemsForSale.setVisible(true);
			}
		});
		
		btn5Sale.setVisible(false);
		btn5Sale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5Sale.setBounds(489, 82, 214, 52);
		frame.getContentPane().add(btn5Sale);
		
		
		JButton btnfirst = new JButton("");
		btnfirst.setVisible(false);
		btnfirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setSail();
				int dam = gameEnv.checkDamage();
				
				if (dam == 0 || dam == 1) {
					
					if (gameEnv.random != null) {
						if (gameEnv.random.pirates == true) {
							JOptionPane.showMessageDialog(frame, gameEnv.random.ans + "Game Over!" );
							JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
							finishedWindow();
						} else {
							JOptionPane.showMessageDialog(frame, gameEnv.random.ans );
							if (dam == 1) {
								String ans = gameEnv.payDamage();
								JOptionPane.showMessageDialog(frame, ans);
							}
							String btnName = btnfirst.getText();
							ArrayList<String> ans = gameEnv.sail(btnName);
							
							if (ans.get(0) == "false") {
								JOptionPane.showMessageDialog(frame, "Unable to travel to this island. \nCheck your money and days remaining");
							} else {
								JOptionPane.showMessageDialog(frame, "You have successfully travelled to " + ans.get(1));
							}
						}
					}
					
				} else {
					JOptionPane.showMessageDialog(frame, "You do not have enough money to fix the damage to your ship!");
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
					finishedWindow();
				}
			}
		});
		btnfirst.setBounds(426, 69, 148, 52);
		frame.getContentPane().add(btnfirst);
		
		JButton btnsecond = new JButton("");
		btnsecond.setVisible(false);
		btnsecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dam = gameEnv.checkDamage();
				
				if (dam == 0 || dam == 1) {
					
					if (gameEnv.random != null) {
						if (gameEnv.random.pirates == true) {
							JOptionPane.showMessageDialog(frame, gameEnv.random.ans + "Game Over!" );
							JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
							finishedWindow();
						} else {
							JOptionPane.showMessageDialog(frame, gameEnv.random.ans );
							if (dam == 1) {
								String ans = gameEnv.payDamage();
								JOptionPane.showMessageDialog(frame, ans);
							}
							String btnName = btnfirst.getText();
							ArrayList<String> ans = gameEnv.sail(btnName);
							
							if (ans.get(0) == "false") {
								JOptionPane.showMessageDialog(frame, "Unable to travel to this island. \nCheck your money and days remaining");
							} else {
								JOptionPane.showMessageDialog(frame, "You have successfully travelled to " + ans.get(1));
							}
						}
					}
					
				} else {
					JOptionPane.showMessageDialog(frame, "You do not have enough money to fix the damage to your ship!");
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
					finishedWindow();
				}
			}
		});
		btnsecond.setBounds(609, 71, 148, 52);
		frame.getContentPane().add(btnsecond);
		
		JButton btnthird = new JButton("");
		btnthird.setVisible(false);
		btnthird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dam = gameEnv.checkDamage();

				if (dam == 0 || dam == 1) {
					
					if (gameEnv.random != null) {
						if (gameEnv.random.pirates == true) {
							JOptionPane.showMessageDialog(frame, gameEnv.random.ans + "Game Over!" );
							JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
							finishedWindow();
						} else {
							JOptionPane.showMessageDialog(frame, gameEnv.random.ans );
							if (dam == 1) {
								String ans = gameEnv.payDamage();
								JOptionPane.showMessageDialog(frame, ans);
							}
							String btnName = btnfirst.getText();
							ArrayList<String> ans = gameEnv.sail(btnName);
							
							if (ans.get(0) == "false") {
								JOptionPane.showMessageDialog(frame, "Unable to travel to this island. \nCheck your money and days remaining");
							} else {
								JOptionPane.showMessageDialog(frame, "You have successfully travelled to " + ans.get(1));
							}
						}
					}
					
					
				} else {
					JOptionPane.showMessageDialog(frame, "You do not have enough money to fix the damage to your ship!");
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
					finishedWindow();
				}
			}
		});
		btnthird.setBounds(426, 236, 148, 52);
		frame.getContentPane().add(btnthird);
		
		JButton btnfourth = new JButton("");
		btnfourth.setVisible(false);
		btnfourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dam = gameEnv.checkDamage();

				if (dam == 0 || dam == 1) {
					if (gameEnv.random != null) {
						if (gameEnv.random.pirates == true) {
							JOptionPane.showMessageDialog(frame, gameEnv.random.ans + "Game Over!" );
							JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
							finishedWindow();
						} else {
							JOptionPane.showMessageDialog(frame, gameEnv.random.ans );
							if (dam == 1) {
								String ans = gameEnv.payDamage();
								JOptionPane.showMessageDialog(frame, ans);
							}
							String btnName = btnfirst.getText();
							ArrayList<String> ans = gameEnv.sail(btnName);
							
							if (ans.get(0) == "false") {
								JOptionPane.showMessageDialog(frame, "Unable to travel to this island. \nCheck your money and days remaining");
							} else {
								JOptionPane.showMessageDialog(frame, "You have successfully travelled to " + ans.get(1));
							}
						}
					}
					
				} else {
					JOptionPane.showMessageDialog(frame, "You do not have enough money to fix the damage to your ship!");
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
					finishedWindow();
				}
			}
		});
		btnfourth.setBounds(609, 236, 148, 52);
		frame.getContentPane().add(btnfourth);
		
		JButton btnCase1 = new JButton("View amount of money and days remaining");
		btnCase1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((gameEnv.days > 5) && (gameEnv.money > 100)) {
					btn5PrevPurs.setVisible(false);
					btn5Buy.setVisible(false);
					btn5Sale.setVisible(false);
					btn5AmtMon.setVisible(false);
					gameEnv.choice = 1;
					lblShip.setText("");
					lblIsland.setText("");
					lblCurIsland.setText("You have $" + gameEnv.money);
					lblYourShip.setText("And you have " + gameEnv.days + " days remaining");
	
	
				} else {
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
					finishedWindow();

				}
				lblDistance.setVisible(false);
				lblCost.setVisible(false);
				lblDistance_1.setVisible(false);
				lblCost_1.setVisible(false);
				lblDistance_2.setVisible(false);
				lblCost_2.setVisible(false);
				lblDistance_3.setVisible(false);
				lblCost_3.setVisible(false);
				lblCostFirst.setVisible(false);
				lblDistFirst.setVisible(false);
				lblCostSecond.setVisible(false);
				lblDistSecond.setVisible(false);
				lblDistThird.setVisible(false);
				lblCostThird.setVisible(false);
				lblDistFourth.setVisible(false);
				lblCostFourth.setVisible(false);
				btnfirst.setVisible(false);
				btnsecond.setVisible(false);
				btnthird.setVisible(false);
				btnfourth.setVisible(false);
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
				
			}
		});
		btnCase1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCase1.setBounds(10, 47, 382, 52);
		frame.getContentPane().add(btnCase1);
		
		JButton btnCase2 = new JButton("View properties of ship");
		btnCase2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((gameEnv.days > 5) && (gameEnv.money > 100)) {

					gameEnv.choice = 2;
					btn5PrevPurs.setVisible(false);
					btn5Buy.setVisible(false);
					btn5Sale.setVisible(false);
					btn5AmtMon.setVisible(false);
					listItemsForSale.setVisible(false);
					listItemsToSell.setVisible(false);
					JOptionPane.showMessageDialog(frame, gameEnv.viewShipDetails());
					
					lblDistance.setVisible(false);
					lblCost.setVisible(false);
					lblDistance_1.setVisible(false);
					lblCost_1.setVisible(false);
					lblDistance_2.setVisible(false);
					lblCost_2.setVisible(false);
					lblDistance_3.setVisible(false);
					lblCost_3.setVisible(false);
					lblCostFirst.setVisible(false);
					lblDistFirst.setVisible(false);
					lblCostSecond.setVisible(false);
					lblDistSecond.setVisible(false);
					lblDistThird.setVisible(false);
					lblCostThird.setVisible(false);
					lblDistFourth.setVisible(false);
					lblCostFourth.setVisible(false);
					
				} else {
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());			
					finishedWindow();
				}
			}
		});
		btnCase2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCase2.setBounds(10, 110, 382, 52);
		frame.getContentPane().add(btnCase2);
		
		JButton btnCase3 = new JButton("View purchased goods");
		btnCase3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((gameEnv.days > 5) && (gameEnv.money > 100)) {

					gameEnv.choice = 3;
					btn5PrevPurs.setVisible(false);
					btn5Buy.setVisible(false);
					btn5Sale.setVisible(false);
					btn5AmtMon.setVisible(false);
					listItemsForSale.setVisible(false);
					listItemsToSell.setVisible(false);
					JOptionPane.showMessageDialog(frame, gameEnv.viewPurchasedGoods());
					
					lblDistance.setVisible(false);
					lblCost.setVisible(false);
					lblDistance_1.setVisible(false);
					lblCost_1.setVisible(false);
					lblDistance_2.setVisible(false);
					lblCost_2.setVisible(false);
					lblDistance_3.setVisible(false);
					lblCost_3.setVisible(false);
					lblCostFirst.setVisible(false);
					lblDistFirst.setVisible(false);
					lblCostSecond.setVisible(false);
					lblDistSecond.setVisible(false);
					lblDistThird.setVisible(false);
					lblCostThird.setVisible(false);
					lblDistFourth.setVisible(false);
					lblCostFourth.setVisible(false);
	
	
				} else {
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
					finishedWindow();
					}
			}
		});
		btnCase3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCase3.setBounds(10, 173, 382, 52);
		frame.getContentPane().add(btnCase3);
		
		JButton btnCase4 = new JButton("View islands");
		btnCase4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((gameEnv.days > 5) && (gameEnv.money > 100)) {

					gameEnv.choice = 4;
					JOptionPane.showMessageDialog(frame, gameEnv.viewIslands());
					btn5PrevPurs.setVisible(false);
					btn5Buy.setVisible(false);
					btn5Sale.setVisible(false);
					btn5AmtMon.setVisible(false);
					listItemsForSale.setVisible(false);
					listItemsToSell.setVisible(false);
					
					lblDistance.setVisible(false);
					lblCost.setVisible(false);
					lblDistance_1.setVisible(false);
					lblCost_1.setVisible(false);
					lblDistance_2.setVisible(false);
					lblCost_2.setVisible(false);
					lblDistance_3.setVisible(false);
					lblCost_3.setVisible(false);
					lblCostFirst.setVisible(false);
					lblDistFirst.setVisible(false);
					lblCostSecond.setVisible(false);
					lblDistSecond.setVisible(false);
					lblDistThird.setVisible(false);
					lblCostThird.setVisible(false);
					lblDistFourth.setVisible(false);
					lblCostFourth.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
					finishedWindow();
				}
			}
		});
		btnCase4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCase4.setBounds(10, 236, 382, 52);
		frame.getContentPane().add(btnCase4);
	
		
		
		JButton btnCase5 = new JButton("Visit store");
		btnCase5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((gameEnv.days > 5) && (gameEnv.money > 100)) {

					gameEnv.choice = 5;
					listItemsForSale.setVisible(false);
					listItemsToSell.setVisible(false);
					
					btn5PrevPurs.setVisible(true);
					btn5Buy.setVisible(true);
					btn5Sale.setVisible(true);
					btn5AmtMon.setVisible(true);
					
					btnBuy.setVisible(false);
					btnSell.setVisible(false);

					lblIsland.setText("");
					lblShip.setText("");
					lblYourShip.setText("");
					lblCurIsland.setText("");
					
					lblDistance.setVisible(false);
					lblCost.setVisible(false);
					lblDistance_1.setVisible(false);
					lblCost_1.setVisible(false);
					lblDistance_2.setVisible(false);
					lblCost_2.setVisible(false);
					lblDistance_3.setVisible(false);
					lblCost_3.setVisible(false);
					lblCostFirst.setVisible(false);
					lblDistFirst.setVisible(false);
					lblCostSecond.setVisible(false);
					lblDistSecond.setVisible(false);
					lblDistThird.setVisible(false);
					lblCostThird.setVisible(false);
					lblDistFourth.setVisible(false);
					lblCostFourth.setVisible(false);
					btnfirst.setVisible(false);
					btnsecond.setVisible(false);
					btnthird.setVisible(false);
					btnfourth.setVisible(false);
	
					
					lblCurIsland.setText("");
					lblYourShip.setText("");
	
				} else {
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
					finishedWindow();

				}
			}
		});
		btnCase5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCase5.setBounds(10, 299, 382, 52);
		frame.getContentPane().add(btnCase5);
		
		JButton btnCase6 = new JButton("Set sail");
		btnCase6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((gameEnv.days > 5) && (gameEnv.money > 100)) {

					gameEnv.choice = 6;
					btn5PrevPurs.setVisible(false);
					btn5Buy.setVisible(false);
					btn5Sale.setVisible(false);
					btn5AmtMon.setVisible(false);
					lblIsland.setVisible(false);
					lblShip.setVisible(false);
					lblCurIsland.setText("");
					lblYourShip.setText("");
					listItemsForSale.setVisible(false);
					listItemsToSell.setVisible(false);
					
					
					lblDistance.setVisible(true);
					lblCost.setVisible(true);
					lblDistance_1.setVisible(true);
					lblCost_1.setVisible(true);
					lblDistance_2.setVisible(true);
					lblCost_2.setVisible(true);
					lblDistance_3.setVisible(true);
					lblCost_3.setVisible(true);
					lblCostFirst.setVisible(true);
					lblDistFirst.setVisible(true);
					lblCostSecond.setVisible(true);
					lblDistSecond.setVisible(true);
					lblDistThird.setVisible(true);
					lblCostThird.setVisible(true);
					lblDistFourth.setVisible(true);
					lblCostFourth.setVisible(true);
					

					ArrayList<Island> islands = new ArrayList<Island>();
					islands = gameEnv.setIslands();
					
					btnfirst.setText(islands.get(0).toString());
					btnfirst.setVisible(true);
					Route route1 = gameEnv.currentIsland.routes.get(0);
					int dist1 = route1.tripDist;
					lblCostFirst.setText(String.valueOf(gameEnv.myShip.dailyWage * dist1));
					lblDistFirst.setText(String.valueOf(dist1));
				
					btnsecond.setText(islands.get(1).toString());
					btnsecond.setVisible(true);
					Route route2 = gameEnv.currentIsland.routes.get(1);
					int dist2 = route2.tripDist;
					lblCostSecond.setText(String.valueOf(gameEnv.myShip.dailyWage * dist2));
					lblDistSecond.setText(String.valueOf(dist2));


					btnthird.setText(islands.get(2).toString());
					btnthird.setVisible(true);
					Route route3 = gameEnv.currentIsland.routes.get(2);
					int dist3 = route3.tripDist;
					lblCostThird.setText(String.valueOf(gameEnv.myShip.dailyWage * dist3));
					lblDistThird.setText(String.valueOf(dist3));

					
					btnfourth.setText(islands.get(3).toString());
					btnfourth.setVisible(true);
					Route route4 = gameEnv.currentIsland.routes.get(3);
					int dist4 = route4.tripDist;
					lblCostFourth.setText(String.valueOf(gameEnv.myShip.dailyWage * dist4));
					lblDistFourth.setText(String.valueOf(dist4));
					
				} else {
					JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
					finishedWindow();
				}
			}
		});
		btnCase6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCase6.setBounds(10, 360, 382, 52);
		frame.getContentPane().add(btnCase6);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, gameEnv.endStatement());
				finishedWindow();
			}
		});
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuit.setBounds(697, 11, 79, 34);
		frame.getContentPane().add(btnQuit);
		

	}


}
