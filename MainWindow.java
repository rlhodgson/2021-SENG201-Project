import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

public class MainWindow {

	private JFrame mainFrame;
	private GameEnvironment gameEnv;

	
	public MainWindow(GameEnvironment gameEnviro) {
		gameEnv = gameEnviro;
		initialize();
		mainFrame.setVisible(true);
	}
	
	public void closeWindow() {
		mainFrame.dispose();
	}
	
	public void finishedWindow() {
		gameEnv.closeMainWindow(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 800, 460);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel("What would you like to do?");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuestion.setBounds(10, 11, 260, 25);
		mainFrame.getContentPane().add(lblQuestion);
		
		JLabel lblName = new JLabel("Name");
		lblName.setText(gameEnv.getName());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(432, 21, 142, 45);
		mainFrame.getContentPane().add(lblName);
		
		JLabel lblCurIsland = new JLabel("Current Island:");
		lblCurIsland.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurIsland.setBounds(402, 129, 142, 45);
		mainFrame.getContentPane().add(lblCurIsland);
		
		JLabel lblIsland = new JLabel((String) null);
		lblIsland.setText(gameEnv.getCurrentIslandName());
		lblIsland.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsland.setBounds(550, 129, 142, 45);
		mainFrame.getContentPane().add(lblIsland);
		
		JLabel lblYourShip = new JLabel("Your Ship:");
		lblYourShip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourShip.setBounds(432, 194, 309, 45);
		mainFrame.getContentPane().add(lblYourShip);
		
		JLabel lblShip = new JLabel("");
		lblShip.setText(gameEnv.getShipName());
		lblShip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip.setBounds(550, 194, 142, 45);
		mainFrame.getContentPane().add(lblShip);
		

		DefaultListModel<Item> listPurchasedModel = new DefaultListModel<Item>();
		JList<Item> listPurchased = new JList<Item>(listPurchasedModel);
		listPurchased.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		listPurchased.setBounds(432, 224, 309, -135);
		mainFrame.getContentPane().add(listPurchased);
		
		DefaultListModel<Item> listSoldGoodsModel = new DefaultListModel<Item>();
		JList<Item> listSoldGoods = new JList<Item>(listSoldGoodsModel);
		listSoldGoods.setBounds(426, 400, 332, -159);
		mainFrame.getContentPane().add(listSoldGoods);
		
		JButton btnViewMoney = new JButton("View amount of money");
		btnViewMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame, "You have $" + String.valueOf(gameEnv.getMoney()));
			}
		});
		btnViewMoney.setVisible(false);
		btnViewMoney.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewMoney.setBounds(489, 236, 214, 52);
		mainFrame.getContentPane().add(btnViewMoney);
		
		JButton btnStoreViewPurchased = new JButton("View purchased items");
		btnStoreViewPurchased.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame, gameEnv.viewPurchasedGoods());
			}
		});
		btnStoreViewPurchased.setVisible(false);
		btnStoreViewPurchased.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStoreViewPurchased.setBounds(489, 308, 214, 52);
		mainFrame.getContentPane().add(btnStoreViewPurchased);
		
		JLabel lblDistance1Text = new JLabel("Days:");
		lblDistance1Text.setVisible(false);
		lblDistance1Text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistance1Text.setBounds(442, 134, 102, 34);
		mainFrame.getContentPane().add(lblDistance1Text);
		
		JLabel lblCost1Text = new JLabel("Cost:");
		lblCost1Text.setVisible(false);
		lblCost1Text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCost1Text.setBounds(442, 161, 102, 34);
		mainFrame.getContentPane().add(lblCost1Text);
		
		JLabel lblCost2Text = new JLabel("Cost:");
		lblCost2Text.setVisible(false);
		lblCost2Text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCost2Text.setBounds(609, 161, 102, 34);
		mainFrame.getContentPane().add(lblCost2Text);
		
		JLabel lblDistance2Text = new JLabel("Days:");
		lblDistance2Text.setVisible(false);
		lblDistance2Text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistance2Text.setBounds(609, 134, 102, 34);
		mainFrame.getContentPane().add(lblDistance2Text);
		
		JLabel lblCost3Text = new JLabel("Cost:");
		lblCost3Text.setVisible(false);
		lblCost3Text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCost3Text.setBounds(442, 326, 102, 34);
		mainFrame.getContentPane().add(lblCost3Text);
		
		JLabel lblDistance3Text = new JLabel("Days:");
		lblDistance3Text.setVisible(false);
		lblDistance3Text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistance3Text.setBounds(442, 299, 102, 34);
		mainFrame.getContentPane().add(lblDistance3Text);
		
		JLabel lblCost4Text = new JLabel("Cost:");
		lblCost4Text.setVisible(false);
		lblCost4Text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCost4Text.setBounds(619, 326, 102, 34);
		mainFrame.getContentPane().add(lblCost4Text);
		
		JLabel lblDistance4Text = new JLabel("Days:");
		lblDistance4Text.setVisible(false);
		lblDistance4Text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistance4Text.setBounds(619, 299, 102, 34);
		mainFrame.getContentPane().add(lblDistance4Text);
		
		JLabel lblCostofFirstTrip = new JLabel("");
		lblCostofFirstTrip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostofFirstTrip.setBounds(509, 161, 102, 34);
		mainFrame.getContentPane().add(lblCostofFirstTrip);
		
		JLabel lblDaysOfFirstTrip = new JLabel("");
		lblDaysOfFirstTrip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDaysOfFirstTrip.setBounds(509, 134, 102, 34);
		mainFrame.getContentPane().add(lblDaysOfFirstTrip);
		
		JLabel lblCostofSecondTrip = new JLabel("");
		lblCostofSecondTrip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostofSecondTrip.setBounds(674, 161, 102, 34);
		mainFrame.getContentPane().add(lblCostofSecondTrip);
		
		JLabel lblDaysOfFSecondTrip = new JLabel("");
		lblDaysOfFSecondTrip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDaysOfFSecondTrip.setBounds(674, 134, 102, 34);
		mainFrame.getContentPane().add(lblDaysOfFSecondTrip);
		
		JLabel lblCostofThirdTrip = new JLabel("");
		lblCostofThirdTrip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostofThirdTrip.setBounds(509, 326, 102, 34);
		mainFrame.getContentPane().add(lblCostofThirdTrip);
		
		JLabel lblDaysOfThirdTrip = new JLabel("");
		lblDaysOfThirdTrip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDaysOfThirdTrip.setBounds(509, 299, 102, 34);
		mainFrame.getContentPane().add(lblDaysOfThirdTrip);
		
		JLabel lblCostofFourthTrip = new JLabel("");
		lblCostofFourthTrip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostofFourthTrip.setBounds(684, 326, 102, 34);
		mainFrame.getContentPane().add(lblCostofFourthTrip);
		
		JLabel lblDaysOfFourthTrip = new JLabel("");
		lblDaysOfFourthTrip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDaysOfFourthTrip.setBounds(684, 299, 102, 34);
		mainFrame.getContentPane().add(lblDaysOfFourthTrip);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSell.setVisible(false);
		btnSell.setBounds(551, 377, 89, 23);
		mainFrame.getContentPane().add(btnSell);
		
		JButton btnSetSail = new JButton("Set sail");
		JButton btnVisitStore = new JButton("Visit store");
		
		btnVisitStore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVisitStore.setBounds(10, 299, 382, 52);
		mainFrame.getContentPane().add(btnVisitStore);
		
		btnSetSail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSetSail.setBounds(10, 360, 382, 52);
		mainFrame.getContentPane().add(btnSetSail);
		
		JButton btnGoBack = new JButton("Back");
		btnGoBack.setVisible(false);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
				finishedWindow();
			}
		});
		
		
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuit.setBounds(697, 11, 79, 34);
		mainFrame.getContentPane().add(btnQuit);
		
		JButton btnViewItemsSold = new JButton("Items for Sale");
		
		DefaultListModel<Item> listItemsToSellModel = new DefaultListModel<Item>();
		JList<Item> listItemsToSell = new JList<Item>(listItemsToSellModel);
		
		

		JButton btnViewItemsBought = new JButton("Items the Store will buy");
		btnViewItemsBought.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listItemsToSellModel.removeAllElements();
				listItemsToSellModel.addAll(gameEnv.getItemsStoreBuys());
				listItemsToSell.setVisible(false);
				listItemsToSell.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				listItemsToSell.setBounds(442, 83, 301, 285);
				mainFrame.getContentPane().add(listItemsToSell);
				
				btnStoreViewPurchased.setVisible(false);
				btnViewItemsBought.setVisible(false);
				btnViewItemsSold.setVisible(false);
				btnViewMoney.setVisible(false);
				btnGoBack.setVisible(true);
				
				btnSell.setVisible(true);
				listItemsToSell.setVisible(true);
				
			}
		});
		
		btnViewItemsBought.setVisible(false);
		btnViewItemsBought.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewItemsBought.setBounds(489, 161, 214, 52);
		mainFrame.getContentPane().add(btnViewItemsBought);
		
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listItemsToSell.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(mainFrame, "You haven't selected an item");
				} else {
					Item item1 = listItemsToSell.getSelectedValue();
					if (gameEnv.sellItem(item1) == true) {
						JOptionPane.showMessageDialog(mainFrame, "You have successfully sold the item!");
					} else {
						JOptionPane.showMessageDialog(mainFrame, "You do not have this item to sell!");
					}
					
				}
			}
		});
	
		DefaultListModel<Item> listItemsForSaleModel = new DefaultListModel<Item>();
		JList<Item> listItemsForSale = new JList<Item>(listItemsForSaleModel);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGoBack.setVisible(true);
				if (listItemsForSale.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(mainFrame, "You have not selected anything");
				} else {
					Item item1 = listItemsForSale.getSelectedValue();
					if (gameEnv.purchaseItem(item1) == true) {
						JOptionPane.showMessageDialog(mainFrame, "Item purchased successfully!");
						boolean isGameOver = gameEnv.checkGameEnd();
						
						if (isGameOver == true) {
							JOptionPane.showMessageDialog(mainFrame,"You no longer have enough money to sail anywhere!"
									+ "\nHint: keep an eye on how much money you have after buying stuff");
							JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
							finishedWindow();
						}
					} else {
						JOptionPane.showMessageDialog(mainFrame, "Item was not purchased, \nyou may not have enough money or cargo space!");
					}
				}
			}
		});
		
		
		btnBuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuy.setVisible(false);
		btnBuy.setBounds(551, 377, 89, 23);
		mainFrame.getContentPane().add(btnBuy);


		btnViewItemsSold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listItemsForSaleModel.removeAllElements();
				listItemsForSaleModel.addAll(gameEnv.getItemsStoreSells());
				listItemsForSale.setVisible(false);
				listItemsForSale.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				listItemsForSale.setBounds(442, 83, 301, 285);
				mainFrame.getContentPane().add(listItemsForSale);
				
				btnStoreViewPurchased.setVisible(false);
				btnViewItemsBought.setVisible(false);
				btnViewItemsSold.setVisible(false);
				btnViewMoney.setVisible(false);
				btnGoBack.setVisible(true);
				
				btnBuy.setVisible(true);
				listItemsForSale.setVisible(true);
			}
		});
		
		btnViewItemsSold.setVisible(false);
		btnViewItemsSold.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewItemsSold.setBounds(489, 82, 214, 52);
		mainFrame.getContentPane().add(btnViewItemsSold);
		
		
		JButton btnFirstIsland = new JButton("");
		btnFirstIsland.setVisible(false);
		
		
		btnFirstIsland.setBounds(426, 69, 148, 52);
		mainFrame.getContentPane().add(btnFirstIsland);
		
		JButton btnSecondIsland = new JButton("");
		btnSecondIsland.setVisible(false);
		
		
		btnSecondIsland.setBounds(609, 71, 148, 52);
		mainFrame.getContentPane().add(btnSecondIsland);
		
		JButton btnThirdIsland = new JButton("");
		btnThirdIsland.setVisible(false);
		
		
		btnThirdIsland.setBounds(426, 236, 148, 52);
		mainFrame.getContentPane().add(btnThirdIsland);
		
		JButton btnFourthIsland = new JButton("");
		btnFourthIsland.setVisible(false);
		
		
		btnFourthIsland.setBounds(609, 236, 148, 52);
		mainFrame.getContentPane().add(btnFourthIsland);
		
		JButton btnViewStats = new JButton("View amount of money and days remaining");
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStoreViewPurchased.setVisible(false);
				btnViewItemsBought.setVisible(false);
				btnViewItemsSold.setVisible(false);
				btnViewMoney.setVisible(false);
				btnGoBack.setVisible(false);
				btnBuy.setVisible(false);
				btnSell.setVisible(false);
				
				lblShip.setText("");
				lblIsland.setText("");
				lblCurIsland.setText("You have $" + gameEnv.getMoney());
				lblYourShip.setText("And you have " + gameEnv.getDays() + " days remaining");
	
	
				lblDistance1Text.setVisible(false);
				lblCost1Text.setVisible(false);
				lblDistance2Text.setVisible(false);
				lblCost2Text.setVisible(false);
				lblDistance3Text.setVisible(false);
				lblCost3Text.setVisible(false);
				lblDistance4Text.setVisible(false);
				lblCost4Text.setVisible(false);
				lblCostofFirstTrip.setVisible(false);
				lblDaysOfFirstTrip.setVisible(false);
				lblCostofSecondTrip.setVisible(false);
				lblDaysOfFSecondTrip.setVisible(false);
				lblDaysOfThirdTrip.setVisible(false);
				lblCostofThirdTrip.setVisible(false);
				lblDaysOfFourthTrip.setVisible(false);
				lblCostofFourthTrip.setVisible(false);
				btnFirstIsland.setVisible(false);
				btnSecondIsland.setVisible(false);
				btnThirdIsland.setVisible(false);
				btnFourthIsland.setVisible(false);
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
				
			}
		});
		
		btnViewStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewStats.setBounds(10, 47, 382, 52);
		mainFrame.getContentPane().add(btnViewStats);
		
		JButton btnViewShipStats = new JButton("View properties of ship");
		btnViewShipStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnStoreViewPurchased.setVisible(false);
				btnViewItemsBought.setVisible(false);
				btnViewItemsSold.setVisible(false);
				btnViewMoney.setVisible(false);
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
				btnGoBack.setVisible(false);
				btnBuy.setVisible(false);
				btnSell.setVisible(false);
				
				JOptionPane.showMessageDialog(mainFrame, gameEnv.viewShipDetails());
				
				lblDistance1Text.setVisible(false);
				lblCost1Text.setVisible(false);
				lblDistance2Text.setVisible(false);
				lblCost2Text.setVisible(false);
				lblDistance3Text.setVisible(false);
				lblCost3Text.setVisible(false);
				lblDistance4Text.setVisible(false);
				lblCost4Text.setVisible(false);
				lblCostofFirstTrip.setVisible(false);
				lblDaysOfFirstTrip.setVisible(false);
				lblCostofSecondTrip.setVisible(false);
				lblDaysOfFSecondTrip.setVisible(false);
				lblDaysOfThirdTrip.setVisible(false);
				lblCostofThirdTrip.setVisible(false);
				lblDaysOfFourthTrip.setVisible(false);
				lblCostofFourthTrip.setVisible(false);	
				btnFirstIsland.setVisible(false);
				btnSecondIsland.setVisible(false);
				btnThirdIsland.setVisible(false);
				btnFourthIsland.setVisible(false);
				
			}
		});
		
		btnViewShipStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewShipStats.setBounds(10, 110, 382, 52);
		mainFrame.getContentPane().add(btnViewShipStats);
		
		JButton btnViewPurchasedGoods = new JButton("View purchased goods");
		btnViewPurchasedGoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnStoreViewPurchased.setVisible(false);
				btnViewItemsBought.setVisible(false);
				btnViewItemsSold.setVisible(false);
				btnViewMoney.setVisible(false);
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
				btnGoBack.setVisible(false);
				btnBuy.setVisible(false);
				btnSell.setVisible(false);
				
				JOptionPane.showMessageDialog(mainFrame, gameEnv.viewPurchasedGoods());
				
				lblDistance1Text.setVisible(false);
				lblCost1Text.setVisible(false);
				lblDistance2Text.setVisible(false);
				lblCost2Text.setVisible(false);
				lblDistance3Text.setVisible(false);
				lblCost3Text.setVisible(false);
				lblDistance4Text.setVisible(false);
				lblCost4Text.setVisible(false);
				lblCostofFirstTrip.setVisible(false);
				lblDaysOfFirstTrip.setVisible(false);
				lblCostofSecondTrip.setVisible(false);
				lblDaysOfFSecondTrip.setVisible(false);
				lblDaysOfThirdTrip.setVisible(false);
				lblCostofThirdTrip.setVisible(false);
				lblDaysOfFourthTrip.setVisible(false);
				lblCostofFourthTrip.setVisible(false);
				btnFirstIsland.setVisible(false);
				btnSecondIsland.setVisible(false);
				btnThirdIsland.setVisible(false);
				btnFourthIsland.setVisible(false);
	
			}
		});
		
		btnViewPurchasedGoods.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewPurchasedGoods.setBounds(10, 173, 382, 52);
		mainFrame.getContentPane().add(btnViewPurchasedGoods);
		
		JButton btnViewIslands = new JButton("View islands");
		btnViewIslands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea lblForInfo = new JTextArea(gameEnv.getIslandsInfo());
				lblForInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JOptionPane.showMessageDialog(mainFrame, lblForInfo);
				btnStoreViewPurchased.setVisible(false);
				btnViewItemsBought.setVisible(false);
				btnViewItemsSold.setVisible(false);
				btnViewMoney.setVisible(false);
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
				btnGoBack.setVisible(false);
				btnBuy.setVisible(false);
				btnSell.setVisible(false);
				
				lblDistance1Text.setVisible(false);
				lblCost1Text.setVisible(false);
				lblDistance2Text.setVisible(false);
				lblCost2Text.setVisible(false);
				lblDistance3Text.setVisible(false);
				lblCost3Text.setVisible(false);
				lblDistance4Text.setVisible(false);
				lblCost4Text.setVisible(false);
				lblCostofFirstTrip.setVisible(false);
				lblDaysOfFirstTrip.setVisible(false);
				lblCostofSecondTrip.setVisible(false);
				lblDaysOfFSecondTrip.setVisible(false);
				lblDaysOfThirdTrip.setVisible(false);
				lblCostofThirdTrip.setVisible(false);
				lblDaysOfFourthTrip.setVisible(false);
				lblCostofFourthTrip.setVisible(false);
				btnFirstIsland.setVisible(false);
				btnSecondIsland.setVisible(false);
				btnThirdIsland.setVisible(false);
				btnFourthIsland.setVisible(false);
			}
		});
		btnViewIslands.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewIslands.setBounds(10, 236, 382, 52);
		mainFrame.getContentPane().add(btnViewIslands);
		
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGoBack.setVisible(false);
				btnBuy.setVisible(false);
				btnSell.setVisible(false);
				listItemsToSell.setVisible(false);
				listItemsForSale.setVisible(false);
				btnStoreViewPurchased.setVisible(true);
				btnViewItemsBought.setVisible(true);
				btnViewItemsSold.setVisible(true);
				btnViewMoney.setVisible(true);
				btnGoBack.setVisible(false);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoBack.setBounds(427, 375, 89, 29);
		mainFrame.getContentPane().add(btnGoBack);
	
		
		
		
		btnVisitStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
				
				btnStoreViewPurchased.setVisible(true);
				btnViewItemsBought.setVisible(true);
				btnViewItemsSold.setVisible(true);
				btnViewMoney.setVisible(true);
				
				btnGoBack.setVisible(false);
				btnBuy.setVisible(false);
				btnSell.setVisible(false);

				lblIsland.setText("");
				lblShip.setText("");
				lblYourShip.setText("");
				lblCurIsland.setText("");
				
				lblDistance1Text.setVisible(false);
				lblCost1Text.setVisible(false);
				lblDistance2Text.setVisible(false);
				lblCost2Text.setVisible(false);
				lblDistance3Text.setVisible(false);
				lblCost3Text.setVisible(false);
				lblDistance4Text.setVisible(false);
				lblCost4Text.setVisible(false);
				lblCostofFirstTrip.setVisible(false);
				lblDaysOfFirstTrip.setVisible(false);
				lblCostofSecondTrip.setVisible(false);
				lblDaysOfFSecondTrip.setVisible(false);
				lblDaysOfThirdTrip.setVisible(false);
				lblCostofThirdTrip.setVisible(false);
				lblDaysOfFourthTrip.setVisible(false);
				lblCostofFourthTrip.setVisible(false);
				btnFirstIsland.setVisible(false);
				btnSecondIsland.setVisible(false);
				btnThirdIsland.setVisible(false);
				btnFourthIsland.setVisible(false);

				
				lblCurIsland.setText("");
				lblYourShip.setText("");
	
			}
		});
		
		
		
		btnSetSail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGoBack.setVisible(false);
				btnBuy.setVisible(false);
				btnSell.setVisible(false);
				btnStoreViewPurchased.setVisible(false);
				btnViewItemsBought.setVisible(false);
				btnViewItemsSold.setVisible(false);
				btnViewMoney.setVisible(false);
				lblIsland.setVisible(false);
				lblShip.setVisible(false);
				lblCurIsland.setText("");
				lblYourShip.setText("");
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
				
				int damageCost = gameEnv.getShipDamageCost();
				if (gameEnv.getMoney() - damageCost < 0) {
					JOptionPane.showMessageDialog(mainFrame, "You need to repair your ship before you can sail! You might need to sell some items to afford it");
				}else {
					if (damageCost > 0) {
						gameEnv.payDamage();
						JOptionPane.showMessageDialog(mainFrame, "You paid $" + damageCost + " to fix your ship before departing");
					}
					Island island = gameEnv.getIsland();
					Route route1 = island.getRoute(0);
					Route route2 = island.getRoute(1);
					Route route3 = island.getRoute(2);
					Route route4 = island.getRoute(3);
					
					
					
					btnFirstIsland.setText(route1.getDestination());
					btnFirstIsland.setVisible(true);
					lblCostofFirstTrip.setText(String.valueOf(gameEnv.getDailyWage() * route1.getDays()));
					lblDaysOfFirstTrip.setText(String.valueOf(route1.getDays()));
				
					btnSecondIsland.setText(route2.getDestination());
					btnSecondIsland.setVisible(true);
					lblCostofSecondTrip.setText(String.valueOf(gameEnv.getDailyWage() * route2.getDays()));
					lblDaysOfFSecondTrip.setText(String.valueOf(route2.getDays()));


					btnThirdIsland.setText(route3.getDestination());
					btnThirdIsland.setVisible(true);
					lblCostofThirdTrip.setText(String.valueOf(gameEnv.getDailyWage() * route3.getDays()));
					lblDaysOfThirdTrip.setText(String.valueOf(route3.getDays()));

					
					btnFourthIsland.setText(route4.getDestination());
					btnFourthIsland.setVisible(true);
					lblCostofFourthTrip.setText(String.valueOf(gameEnv.getDailyWage() * route4.getDays()));
					lblDaysOfFourthTrip.setText(String.valueOf(route4.getDays()));
					
					
					lblDistance1Text.setVisible(true);
					lblCost1Text.setVisible(true);
					lblDistance2Text.setVisible(true);
					lblCost2Text.setVisible(true);
					lblDistance3Text.setVisible(true);
					lblCost3Text.setVisible(true);
					lblDistance4Text.setVisible(true);
					lblCost4Text.setVisible(true);
					lblCostofFirstTrip.setVisible(true);
					lblDaysOfFirstTrip.setVisible(true);
					lblCostofSecondTrip.setVisible(true);
					lblDaysOfFSecondTrip.setVisible(true);
					lblDaysOfThirdTrip.setVisible(true);
					lblCostofThirdTrip.setVisible(true);
					lblDaysOfFourthTrip.setVisible(true);
					lblCostofFourthTrip.setVisible(true);
			
				}
			}
		});
		
		
		
		btnFirstIsland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(mainFrame, gameEnv.setSail(1));
				boolean lostToPirates = gameEnv.lostToPirates();
				
				if (lostToPirates == true) {
					JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
					finishedWindow();
				}else {
					boolean isGameOver = gameEnv.checkGameEnd();
					
					if (isGameOver == true) {
						JOptionPane.showMessageDialog(mainFrame, "You do not have enough money or days to sail anywhere!");
						JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
						finishedWindow();
					}
				}
				
				lblCurIsland.setText("You have $" + gameEnv.getMoney());
				lblYourShip.setText("And you have " + gameEnv.getDays() + " days remaining");
				lblDistance1Text.setVisible(false);
				lblCost1Text.setVisible(false);
				lblDistance2Text.setVisible(false);
				lblCost2Text.setVisible(false);
				lblDistance3Text.setVisible(false);
				lblCost3Text.setVisible(false);
				lblDistance4Text.setVisible(false);
				lblCost4Text.setVisible(false);
				lblCostofFirstTrip.setVisible(false);
				lblDaysOfFirstTrip.setVisible(false);
				lblCostofSecondTrip.setVisible(false);
				lblDaysOfFSecondTrip.setVisible(false);
				lblDaysOfThirdTrip.setVisible(false);
				lblCostofThirdTrip.setVisible(false);
				lblDaysOfFourthTrip.setVisible(false);
				lblCostofFourthTrip.setVisible(false);
				btnFirstIsland.setVisible(false);
				btnSecondIsland.setVisible(false);
				btnThirdIsland.setVisible(false);
				btnFourthIsland.setVisible(false);
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
			}
		});
		
		btnSecondIsland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(mainFrame, gameEnv.setSail(2));
				boolean lostToPirates = gameEnv.lostToPirates();
				
				if (lostToPirates == true) {
					JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
					finishedWindow();
				}else {
					boolean isGameOver = gameEnv.checkGameEnd();
					
					if (isGameOver == true) {
						JOptionPane.showMessageDialog(mainFrame, "You do not have enough money or days to sail anywhere!");
						JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
						finishedWindow();
					}
				}
				
				lblCurIsland.setText("You have $" + gameEnv.getMoney());
				lblYourShip.setText("And you have " + gameEnv.getDays() + " days remaining");
				lblDistance1Text.setVisible(false);
				lblCost1Text.setVisible(false);
				lblDistance2Text.setVisible(false);
				lblCost2Text.setVisible(false);
				lblDistance3Text.setVisible(false);
				lblCost3Text.setVisible(false);
				lblDistance4Text.setVisible(false);
				lblCost4Text.setVisible(false);
				lblCostofFirstTrip.setVisible(false);
				lblDaysOfFirstTrip.setVisible(false);
				lblCostofSecondTrip.setVisible(false);
				lblDaysOfFSecondTrip.setVisible(false);
				lblDaysOfThirdTrip.setVisible(false);
				lblCostofThirdTrip.setVisible(false);
				lblDaysOfFourthTrip.setVisible(false);
				lblCostofFourthTrip.setVisible(false);
				btnFirstIsland.setVisible(false);
				btnSecondIsland.setVisible(false);
				btnThirdIsland.setVisible(false);
				btnFourthIsland.setVisible(false);
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
			}
		});
		
		btnThirdIsland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(mainFrame, gameEnv.setSail(3));
				boolean lostToPirates = gameEnv.lostToPirates();
				
				if (lostToPirates == true) {
					JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
					finishedWindow();
				}else {
					boolean isGameOver = gameEnv.checkGameEnd();
					
					if (isGameOver == true) {
						JOptionPane.showMessageDialog(mainFrame, "You do not have enough money or days to sail anywhere!");
						JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
						finishedWindow();
					}
				}
				
				lblCurIsland.setText("You have $" + gameEnv.getMoney());
				lblYourShip.setText("And you have " + gameEnv.getDays() + " days remaining");
				lblDistance1Text.setVisible(false);
				lblCost1Text.setVisible(false);
				lblDistance2Text.setVisible(false);
				lblCost2Text.setVisible(false);
				lblDistance3Text.setVisible(false);
				lblCost3Text.setVisible(false);
				lblDistance4Text.setVisible(false);
				lblCost4Text.setVisible(false);
				lblCostofFirstTrip.setVisible(false);
				lblDaysOfFirstTrip.setVisible(false);
				lblCostofSecondTrip.setVisible(false);
				lblDaysOfFSecondTrip.setVisible(false);
				lblDaysOfThirdTrip.setVisible(false);
				lblCostofThirdTrip.setVisible(false);
				lblDaysOfFourthTrip.setVisible(false);
				lblCostofFourthTrip.setVisible(false);
				btnFirstIsland.setVisible(false);
				btnSecondIsland.setVisible(false);
				btnThirdIsland.setVisible(false);
				btnFourthIsland.setVisible(false);
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
			}
		});
		
		btnFourthIsland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(mainFrame, gameEnv.setSail(4));
				boolean lostToPirates = gameEnv.lostToPirates();
				
				if (lostToPirates == true) {
					JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
					finishedWindow();
				}else {
					boolean isGameOver = gameEnv.checkGameEnd();
					
					if (isGameOver == true) {
						JOptionPane.showMessageDialog(mainFrame, "You do not have enough money or days to sail anywhere!");
						JOptionPane.showMessageDialog(mainFrame, gameEnv.getEndStatement());
						finishedWindow();
					}
				}
				
				lblCurIsland.setText("You have $" + gameEnv.getMoney());
				lblYourShip.setText("And you have " + gameEnv.getDays() + " days remaining");
				lblDistance1Text.setVisible(false);
				lblCost1Text.setVisible(false);
				lblDistance2Text.setVisible(false);
				lblCost2Text.setVisible(false);
				lblDistance3Text.setVisible(false);
				lblCost3Text.setVisible(false);
				lblDistance4Text.setVisible(false);
				lblCost4Text.setVisible(false);
				lblCostofFirstTrip.setVisible(false);
				lblDaysOfFirstTrip.setVisible(false);
				lblCostofSecondTrip.setVisible(false);
				lblDaysOfFSecondTrip.setVisible(false);
				lblDaysOfThirdTrip.setVisible(false);
				lblCostofThirdTrip.setVisible(false);
				lblDaysOfFourthTrip.setVisible(false);
				lblCostofFourthTrip.setVisible(false);
				btnFirstIsland.setVisible(false);
				btnSecondIsland.setVisible(false);
				btnThirdIsland.setVisible(false);
				btnFourthIsland.setVisible(false);
				listItemsForSale.setVisible(false);
				listItemsToSell.setVisible(false);
			}
		});

	}
}
