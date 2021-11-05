package Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import UI.OrderInvoiceUI;

public class Restaurant {

	public static ArrayList<Table> tables;
	public static Menu menu;
	public static ArrayList<Order> orders;
	public static ArrayList<OrderInvoiceUI> invoices;
	public static ArrayList<Staff> staffs;
	public static ArrayList<Reservation> reservations;

	public static void initializeRestaurant() {
		try {
			initMenu();
			initTable();
			initStaff();
			initOrders();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//
		//
		//
		//initInvoices();
		//initReservations();
	}
	
	private static void initMenu() throws FileNotFoundException {
		
		menu = new Menu();
		
		File tempFile = new File("Data/menuItems.txt");
		
		try {
			if (tempFile.createNewFile()) {
				PrintWriter writer = new PrintWriter("Data/menuItems.txt", "UTF-8");
				writer.println("1_Fries_Cripsy golden-brown french fries_1.0_APPETISER");
				writer.println("2_Chicken Burger_Burger with two patties of chicken, a slice of cheese and mayonnaise_5.0_MAINCOURSE");
				writer.println("3_Beef Burger_Burger with a juicy beef patty and barbeque sauce_7.5_MAINCOURSE");
				writer.println("4_Iced Lemon Tea_Iced tea with lemon juice_2.5_DRINK");
				writer.println("5_Coke_Iced Coca Cola_1.5_DRINK");
				writer.println("6_Brownie and Ice Cream_Hot brownie paired with ice cream_8.0_DESSERT");
				writer.close();
			}
			tempFile = new File("Data/menuItems.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner input = new Scanner(tempFile);
	    input.useDelimiter("_|\n");

	    while(input.hasNext()) {
	        
	    	int itemID = input.nextInt();
	        String name = input.next();
	        String desc = input.next();
	        double price = Double.valueOf(input.next());
	        String itemType = input.next();
	        MenuItemType type;
	        if(Objects.equals(itemType, "MAINCOURSE"))
	        	type = MenuItemType.MAIN_COURSE;
	        else if(Objects.equals(itemType, "DESSERT"))
	        	type = MenuItemType.DESSERT;
	        else if(Objects.equals(itemType, "APPETISER"))
	        	type = MenuItemType.APPETISER;
	        else
	        	type = MenuItemType.DRINK;
	        
	        MenuItem item = new MenuItem(itemID, name, desc, price, type);
	        menu.addMenuItem(item);
	    }
	    
	    input.close();
	
	    tempFile = new File("Data/promoItems.txt");
		
		try {
			if (tempFile.createNewFile()) {
				PrintWriter writer = new PrintWriter("Data/promoItems.txt", "UTF-8");
				writer.println("1_Chicken Burger Set_1_2_4_Chicken burger along with fries and iced lemon tea_7.00");
				writer.println("2_Beef Burger Set_1_3_5_Beef burger along with fries and coke_9.00");
				writer.close();
			}
			tempFile = new File("Data/promoItems.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	     
	    input = new Scanner(tempFile);
	    input.useDelimiter("_|\n");
	    
		while(input.hasNext()) {
	        
	    	int promoID = input.nextInt();
	        String name = input.next();
	        ArrayList<MenuItem> promoItems = new ArrayList<MenuItem>();
	     
	        while(input.hasNextInt()) {
	        	int nextInt = input.nextInt() - 1;
	        	promoItems.add(menu.getMenuItems().get(nextInt));
	        }
	        
	        String desc = input.next();
	        double price = Double.valueOf(input.next());
	        
	        PromotionSet set = new PromotionSet(promoID, name, promoItems, desc, price);
	        menu.addPromotionSet(set);
	    }
		
		input.close();
		
	}
	
	private static void initTable() throws FileNotFoundException {
				
		tables = new ArrayList<Table>();
		
		File tempFile = new File("Data/tables.txt");
		
		try {
			if (tempFile.createNewFile()) {
				PrintWriter writer = new PrintWriter("Data/tables.txt", "UTF-8");
				int j = 1;
				for(int i = 0; i < 5; i++){
					writer.println(j+"_4");
					j++;
				}
				for(int i = 0; i < 5; i++){
					writer.println(j+"_8");
					j++;
				}
				for(int i = 0; i < 5; i++){
					writer.println(j+"_10");
					j++;
				}
				writer.close();
			}
			tempFile = new File("Data/tables.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner input = new Scanner(tempFile);
	    input.useDelimiter("_|\n");

	    while(input.hasNext()) {
	        
	    	int tableID = input.nextInt();
	        int tableSize = input.nextInt();
	        
	        tables.add(new Table(tableID, tableSize));
	    }
	 
	    input.close();

	}
	
	private static void initStaff() throws FileNotFoundException {
		
		staffs = new ArrayList<Staff>();
		
		File tempFile = new File("Data/staffs.txt");
		
		try {
			if (tempFile.createNewFile()) {
				PrintWriter writer = new PrintWriter("Data/staffs.txt", "UTF-8");
				writer.println("1_Jake_MALE_Co-owner");
				writer.println("2_Amy_FEMALE_Co-owner");
				writer.println("3_Olivia_FEMALE_Cashier");
				writer.println("4_Louis_MALE_Waiter");
				writer.println("5_Emma_FEMALE_Waitress");
				
				writer.close();
			}
			tempFile = new File("Data/staffs.txt");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner input = new Scanner(tempFile);
	    input.useDelimiter("_|\n");

	    while(input.hasNext()) {
	        
	    	int empID = input.nextInt();
	        String name = input.next();
	        
	        String genderString = input.next();
	        Gender gender;
	        if(Objects.equals(genderString, "MALE"))
	        	gender = Gender.MALE;
	        else
	        	gender = Gender.FEMALE;
	        
	        String jobTitle = input.next();
	        
	        staffs.add(new Staff(empID, name, gender, jobTitle));
	    }
	 
	    input.close();
	}
	
	private static void initOrders() throws FileNotFoundException, ParseException {
		
		orders = new ArrayList<Order>();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		File tempFile = new File("Data/orders.txt");
		
		try {
			if (tempFile.createNewFile()) {
				PrintWriter writer = new PrintWriter("Data/orders.txt", "UTF-8");
				writer.println("1_1_4_1_1_2_1_3_1_true_1_1_01/01/2021 13:00:00");
				writer.println("2_2_5_0_true_1_2_2_2_02/02/2021 15:00:00");
				writer.println("3_14_4_1_2_5_1_true_0_03/03/2021 20:00:00");
				writer.close();
			}
			tempFile = new File("Data/orders.txt");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner input = new Scanner(tempFile);
	    input.useDelimiter("_|\n");

	    while(input.hasNext()) {
	        
	    	int orderID = input.nextInt();
	        int tableID = input.nextInt();
	        Table table = tables.get(tableID-1);
	        int staffID = input.nextInt();
	        Staff staff = staffs.get(staffID-1);
	        
	        ArrayList<OrderedItem> orderedItems = new ArrayList<OrderedItem>();
		     
	        while(input.hasNextInt()) {
	        	int nextInt = input.nextInt() - 1;
	        	if(nextInt==-1)
	        		break;
	        	int qty = input.nextInt();
	        	orderedItems.add(new OrderedItem(qty, menu.getMenuItems().get(nextInt)));
	        }
	        
	        boolean completed = input.nextBoolean();
	        
	        ArrayList<OrderedSet> orderedSets = new ArrayList<OrderedSet>();
		     
	        while(input.hasNextInt()) {
	        	int nextInt = input.nextInt() - 1;
	        	if(nextInt==-1)
	        		continue;
	        	int qty = input.nextInt();
	        	orderedSets.add(new OrderedSet(qty, menu.getPromotionSets().get(nextInt)));
	        }
	        
	        Date timestamp = format.parse(input.next());
	        
	        orders.add(new Order(orderID, table, staff, orderedItems, orderedSets, completed, timestamp));
	    }
	 
	    input.close();
		
	}
	
	private static void initInvoices() {
		OrderInvoiceUI orderInvoiceUI_1 = new OrderInvoiceUI(new Date(), false, orders.get(0));
		OrderInvoiceUI orderInvoiceUI_2 = new OrderInvoiceUI(new Date(), false, orders.get(1));
		OrderInvoiceUI orderInvoiceUI_3 = new OrderInvoiceUI(new Date(), false, orders.get(2));
		
		invoices.add(orderInvoiceUI_1);
		invoices.add(orderInvoiceUI_2);
		invoices.add(orderInvoiceUI_3);
	}
	
	private static void initReservations() {
		// note that these reservations have not been assigned to table yet
		Reservation reservation_1 = new Reservation(1, new Date(), 4, "John", "93748245", "A0840382");
		Reservation reservation_2 = new Reservation(2, new Date(), 2, "Wendy", "92844720", "A2635271");
		Reservation reservation_3 = new Reservation(3, new Date(), 8, "Felix", "99504832", "A7402738");
		
		reservations.add(reservation_1);
		reservations.add(reservation_2);
		reservations.add(reservation_3);
	}
}