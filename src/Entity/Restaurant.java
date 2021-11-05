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

/**
 * Represents the restaurant and contains its entities.
 */
public class Restaurant {

	/**
	 * Tables present in the restaurant.
	 */
	public static ArrayList<Table> tables;
	
	/**
	 * Menu of the restaurant.
	 */
	public static Menu menu;
	
	/**
	 * Orders handled by the restaurant.
	 */
	public static ArrayList<Order> orders;
	
	/**
	 * Invoices for orders completed at the restaurant.
	 */
	public static ArrayList<OrderInvoiceUI> invoices;
	
	/**
	 * Staffs employed by the restaurant.
	 */
	public static ArrayList<Staff> staffs;
	
	/**
	 * Reservations made at the restaurant.
	 */
	public static ArrayList<Reservation> reservations;

	/**
	 * Initializes the entities present in the restaurant.
	 */
	public static void initializeRestaurant() {
		
		try {
			initMenu();
			initTable();
			initStaff();
			initOrders();
			initReservations();
			initInvoices();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Initializes the menu using a datafile.
	 * @throws FileNotFoundException	If the datafile fails to get generated or isn't present.
	 */
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
	
	/**
	 * Initializes the tables using a datafile.
	 * @throws FileNotFoundException	If the datafile fails to get generated or isn't present.
	 */
	private static void initTable() throws FileNotFoundException {
				
		tables = new ArrayList<Table>();
		
		File tempFile = new File("Data/tables.txt");
		
		try {
			if (tempFile.createNewFile()) {
				PrintWriter writer = new PrintWriter("Data/tables.txt", "UTF-8");
				int j = 1;
				for(int i = 0; i < 5; i++){
					writer.println(j+"_2");
					j++;
				}
				for(int i = 0; i < 5; i++){
					writer.println(j+"_5");
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
	
	/**
	 * Initializes the staffs employed, using a datafile.
	 * @throws FileNotFoundException	If the datafile fails to get generated or isn't present.
	 */
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
	
	/**
	 * Initializes the orders handled, using a datafile.
	 * @throws FileNotFoundException	If the datafile fails to get generated or isn't present.
	 * @throws ParseException			If the date in the datafile isn't in the right format.
	 */
	private static void initOrders() throws FileNotFoundException, ParseException {
		
		orders = new ArrayList<Order>();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		File tempFile = new File("Data/orders.txt");
		
		try {
			if (tempFile.createNewFile()) {
				PrintWriter writer = new PrintWriter("Data/orders.txt", "UTF-8");
				writer.println("1_1_4_1_1_2_1_3_1_true_1_1_01/01/2021 13:00:00_A987654567");
				writer.println("2_2_5_0_true_1_2_2_2_02/02/2021 15:00:00_A765434565");
				writer.println("3_14_4_1_2_5_1_true_0_03/03/2021 20:00:00_0");
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
	        
	        String memberID = input.next();
	        
	        if(Objects.equals(memberID,"0")) {
	        	orders.add(new Order(orderID, table, staff, orderedItems, orderedSets, completed, timestamp));
	        }
	        else {
	        	orders.add(new Order(orderID, table, staff, orderedItems, orderedSets, completed, timestamp, memberID));
	        }
	        
	    }
	 
	    input.close();
		
	}
	
	/**
	 * Initializes the invoices generated, using a datafile
	 * @throws FileNotFoundException	If the datafile fails to get generated or isn't present.
	 * @throws ParseException			If the date in the datafile isn't in the right format.
	 */
	private static void initInvoices() throws FileNotFoundException, ParseException {
		
		invoices = new ArrayList<OrderInvoiceUI>();
		
		File tempFile = new File("Data/invoices.txt");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		try {
			if (tempFile.createNewFile()) {
				PrintWriter writer = new PrintWriter("Data/invoices.txt", "UTF-8");
				writer.println("1_01/01/2021 14:80:00");
				writer.println("2_02/02/2021 16:90:00");
				writer.println("3_03/03/2021 21:10:00");
				writer.close();
			}
			tempFile = new File("Data/invoices.txt");
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
	        

	        int nextInt = input.nextInt() - 1;
	        Order thisOrder = (orders.get(nextInt));
	        
	        Date timestamp = format.parse(input.next());
	        
	        OrderInvoiceUI invoice = new OrderInvoiceUI(timestamp, thisOrder);
	        invoices.add(invoice);
	    }
		
		input.close();
	}
	
	/***
	 * Initializes the reservations made, using a datafile.
	 * @throws FileNotFoundException	If the datafile fails to get generated or isn't present.
	 * @throws ParseException			If the data in the datafile isn't in the right format.
	 */
	private static void initReservations() throws FileNotFoundException, ParseException {
		
		reservations = new ArrayList<Reservation>();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		File tempFile = new File("Data/reservations.txt");
		
		try {
			if (tempFile.createNewFile()) {
				PrintWriter writer = new PrintWriter("Data/reservations.txt", "UTF-8");
				writer.println("1_01/01/2021 13:00:00_4_Ryan_88889999_A098765456");
				writer.println("2_12/11/2021 20:00:00_2_Kim_65789876_A876545678");
				writer.println("3_13/11/2021 19:00:00_10_Kanye_97674432_A098764321");
				writer.close();
			}
			tempFile = new File("Data/reservations.txt");
			
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
	        
	    	int resID = input.nextInt();
	    	Date timestamp;
			
			timestamp = format.parse(input.next());
			
	    	int paxSize = input.nextInt();
	        String name = input.next();
	        String contactNo = input.next();
	        String memberID = input.next();
	        
	        reservations.add(new Reservation(resID, timestamp, paxSize, name, contactNo, memberID));
	    }
	 
	    input.close();
		
	}
}