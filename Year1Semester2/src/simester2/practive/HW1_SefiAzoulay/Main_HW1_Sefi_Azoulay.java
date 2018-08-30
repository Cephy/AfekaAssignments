package simester2.practive.HW1_SefiAzoulay;

import java.util.*;

public class Main_HW1_Sefi_Azoulay {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int action = 0;
		boolean menu = true;

		Customer[] allCustomers = new Customer[11];
		fillArray(allCustomers);
		for (int i = 0; i < allCustomers.length; i++) {
			if (allCustomers[i].getId() < 0) {
				throw new IllegalArgumentException("Id can not be less the 1");
			}
		}

		do {
			System.out.println("Please choose one of the following options: ");
			System.out.println("Press 1 to present all the customers in the bank (with duplicates) ");
			System.out.println("Press 2 to present all the customers in the bank (without duplicates) ");
			System.out.println(
					"Press 3 to present all the customers in the bank (without duplicates) and each customer's payments");
			System.out.println("Press 4 to present the total revenues from all of the customers (without duplicates) ");
			System.out.println("Press 5 to present all of the lists 1-4 all together");
			System.out.println("Press 6 to find and print a specific customer ");
			System.out.println("Press 0 to exit the programme");
			action = s.nextInt();

			switch (action) {
			case 1: {
				printDuplicate(allCustomers);
				break;
			}
			case 2: {
				print(allCustomers);
				break;
			}
			case 3: {
				payments(allCustomers);
				break;
			}
			case 4: {
				totalRevenues(allCustomers);
				break;
			}
			case 5: {
				printDuplicate(allCustomers);
				print(allCustomers);
				payments(allCustomers);
				totalRevenues(allCustomers);
				break;
			}
			case 6: {
				int idSearch = 0;
				boolean flag = false;

				do {
					flag = false;
					try {
						System.out.println("Please enter the Id number you would like to find: ");
						idSearch = s.nextInt();
						if (idSearch < 1) {
							throw new Exception();
						}

					} catch (Exception ex) {
						System.out.println("Id can not be less the 1");
						flag = true;
					}
				} while (flag);
				search(allCustomers, idSearch);
				break;
			}

			case 0: {
				menu = false;
				break;
			}
			default: {
				System.out.println("We are sorry, we don't have that option, please try again.");
				break;
			}

			}
			System.out.println("\n\n");
		} while (menu);
		s.close();
	}

	public static void fillArray(Customer[] allCustomers) {
		allCustomers[0] = new GoldCustomer(1, "Rothchild", 500000, 30);
		allCustomers[1] = new GoldCustomer(2, "Bill Gates", 300000, 10);
		allCustomers[2] = new Customer(3, "Tali", 20);
		allCustomers[3] = new PreferredCustomer(4, "James Bond", 3000, 20);
		allCustomers[4] = new Customer(5, "Rothchild", 500000);
		allCustomers[5] = new PreferredCustomer(6, "Tali", 20, 20);
		allCustomers[6] = new GoldCustomer(7, "Tali", 20, 20);
		allCustomers[7] = new GoldCustomer(8, "Rothchild", 500000, 30);
		allCustomers[8] = new PreferredCustomer(9, "Rothchild", 500000, 30);
		allCustomers[9] = new Customer(10, "Rothchild", 500000);
		allCustomers[10] = new PreferredCustomer(11, "Tali", 20, 20);

	}

	public static void printDuplicate(Customer[] allCustomers) {
		System.out.println("\n\n------------------All Customers with duplicats------------------\n\n");

		for (int i = 0; i < allCustomers.length; i++) {
			System.out.println(allCustomers[i]);
		}
	}

	public static void print(Customer[] allCustomers) {
		System.out.println("\n\n------------------All Customers without duplicats------------------\n\n");
		boolean duplicateFlag = false;
		for (int compare = 0; compare < allCustomers.length; compare++) {
			duplicateFlag = false;
			for (int flag = (compare - 1); flag >= 0; flag--) {
				if (allCustomers[compare].equals(allCustomers[flag])) {
					duplicateFlag = true;
				}
			}
			if (!duplicateFlag) {
				System.out.println(allCustomers[compare]);
			}
		}
	}

	public static void payments(Customer[] allCustomers) {
		System.out.println("\n\n------------------All Customers Payments------------------\n\n");
		boolean duplicateFlag = false;
		for (int compare = 0; compare < allCustomers.length; compare++) {
			duplicateFlag = false;
			for (int flag = (compare - 1); flag >= 0; flag--) {
				if (allCustomers[compare].equals(allCustomers[flag])) {
					duplicateFlag = true;
				}
			}
			if (!duplicateFlag) {
				System.out.printf("%-65s%7s\n", allCustomers[compare], paymentToBank(allCustomers[compare]));
			}
		}
	}

	public static int paymentToBank(Customer customer) {
		int GOLD_CUSTOMER_BAR = 50000;
		int PREFERRED_CUSTOMER_BAR = 10000;

		if (customer.getClass().getSimpleName().equals("GoldCustomer")) {
			GoldCustomer tmp = (GoldCustomer) customer;
			int discount = (int) (tmp.getAmountPurchases() * (1 - (double) tmp.getDiscount() / 100));
			return discount > GOLD_CUSTOMER_BAR ? GOLD_CUSTOMER_BAR
					: discount > PREFERRED_CUSTOMER_BAR ? discount : tmp.getAmountPurchases();
		}

		if (customer.getClass().getSimpleName().equals("PreferredCustomer")) {
			PreferredCustomer tmp = (PreferredCustomer) customer;
			int discount = (int) (tmp.getAmountPurchases() * (1 - (double) tmp.getDiscount() / 100));
			return discount > PREFERRED_CUSTOMER_BAR ? discount : tmp.getAmountPurchases();
		}
		return customer.getAmountPurchases();
	}

	public static void totalRevenues(Customer[] allCustomers) {
		int sumOfRevenues = 0;
		for (int i = 0; i < allCustomers.length; i++) {
			sumOfRevenues += paymentToBank(allCustomers[i]);
		}
		System.out.println("Total revenues from all customers (without duplications): " + sumOfRevenues);
	}

	public static void search(Customer[] allCustomers, int idNumber) {
		Boolean flag = true;
		for (int locationTmp = 0; locationTmp < allCustomers.length; locationTmp++) {
			if (allCustomers[locationTmp].getId() == idNumber) {
				System.out.println(allCustomers[locationTmp]);
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("We can not find that ID number in our database Please try again");
		}

	}
}
