
import java.util.Scanner;
import java.util.ArrayList;

public class Drivercls {

	ArrayList<ModestWear> objectList;
	ArrayList<Customer> customerList;
	String password = "123";

	public Drivercls() {
		objectList = new ArrayList<ModestWear>();
		customerList = new ArrayList<Customer>();

		stock();
		displayTopMenu();

	}

	public void stock() {

		objectList.add(new Abaya("Ruffled Arm Abaya", 75, 5, "Chiffon", "Ruffled Arms", "Elegant", "Black", "Long"));

		objectList.add(new Abaya("Linen Abaya", 65, 4, "Linen", "Plain", "Casual", "Beige", "Straight"));

		objectList.add(new Abaya("Plain Abaya", 55, 8, "Cotton", "Plain", "Classic", "Navy", "Regular"));

		objectList.add(new Hijab("Jersey Hijab", 18, 10, "Jersey", "Plain", "Everyday", "Black", "Long"));

		objectList.add(new Hijab("Chiffon Hijab", 22, 6, "Chiffon", "Soft", "Formal", "Nude", "Long"));

		objectList.add(new Hijab("Khimar", 30, 3, "Crepe", "Flowing", "Modest", "Grey", "Extra Long"));
	}

	public void displayTopMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\f");

		int option = 0;
		do {
			System.out.println("\n\n\nMain Menu\n==========");
			System.out.println("1.customer menu ");
			System.out.println("2.staff menu ");
			System.out.println("3.exit ");
			System.out.println("Enter option:  ");
			option = scan.nextInt();
			scan.nextLine();

			if (option == 1) {
				displayCustomerMenu();

			} else if (option == 2) {

				displaystaffMenu();
			} else if (option == 3) {
				System.out.println("Exiting program...");
			} else {
				System.out.println("Invalid option. Please enter 1, 2, or 3.");
			}

		} while (option != 3);
	}

	public void displayCustomerMenu() {
		Scanner scan = new Scanner(System.in);

		int quantityBought;
		int option = 0;
		boolean found = false;

		do {
			System.out.println("\n\n\nCustomer Menu\n==========");
			System.out.println("1.Display all abaya for sale ");
			System.out.println("2.Display all hijab for sale ");
			System.out.println("3.Buy abayas ");
			System.out.println("4.Buy hijabs ");
			System.out.println("5.Exit Customer menu ");

			option = scan.nextInt();
			scan.nextLine();

			if (option == 1) {
				if (objectList.isEmpty()) {
					System.out.println("We do not have any products in stock currently");
				} else {
					for (ModestWear a : objectList) {

						if (a instanceof Abaya) {
							System.out.println("Abaya" + a.toString());

						}
					}
				}
			} else if (option == 2) {
				if (objectList.isEmpty()) {
					System.out.println("We do not have any products in stock currently");
				} else {
					for (ModestWear a : objectList) {

						if (a instanceof Hijab) {
							System.out.println("hijab" + a.toString());

						}
					}
				}
			} else if (option == 3) {
				buyAbaya();
			} else if (option == 4) {
				buyHijab();
			}

		} while (option != 5);
	}

	public void buyProduct(String type) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your email: ");
		String email = scan.nextLine();

		Customer customer = null;

		for (Customer c : customerList) {
			if (c.getemail().equalsIgnoreCase(email)) {
				customer = c;
			}
		}

		if (customer == null) {
			customer = new Customer(email);
			customerList.add(customer);
		}

		System.out.print("Enter product name: ");
		String itemName = scan.nextLine();

		boolean found = false;

		for (ModestWear item : objectList) {
			if (item.getname().equalsIgnoreCase(itemName)) {
				if ((type.equals("Abaya") && item instanceof Abaya)
						|| (type.equals("Hijab") && item instanceof Hijab)) {
					found = true;

					System.out.print("Enter quantity to buy: ");
					int quantity = scan.nextInt();
					scan.nextLine();

					if (quantity <= 0) {
						System.out.println("Invalid quantity.");
					} else if (item.getstock() >= quantity) {
						item.setstock(item.getstock() - quantity);

						customer.setlastProductBought(item);
						customer.setquantityBought(quantity);

						System.out.println("Purchase successful!");
						System.out.println("Remaining stock: " + item.getstock());
					} else {
						System.out.println("Not enough stock.");
					}
				}
			}
		}

		if (!found) {
			System.out.println("Product not found.");
		}
	}

	public void displaystaffMenu() {
		Scanner scan = new Scanner(System.in);

		String type,name;
		String material, style, color, sleeve, lenght, design, pass;
		int price, stock, delivered;
		int option = 0;
		

		System.out.print("Please enter the staff password: ");
		pass = scan.nextLine();
		boolean access = false;

		if (pass.equalsIgnoreCase(password)) {
			System.out.println("Correct password.");
			access = true;
		} else {
			System.out.println("Wrong password. Access denied.");
		}

		if (access == true) {
			do {
				System.out.println("\n\n\nStaff Menu\n==========");
				System.out.println("1. Add a new type of Abaya or Hijab to the stock list");
				System.out.println("2. Display the list of customers and products they have bought");
				System.out.println("3. Update the stock level for an existing Abaya or Hijab with a new delivery");
				System.out.println("4. Exit Staff menu");

				System.out.print("Enter your choice (1-4): ");
				option = scan.nextInt();
				scan.nextLine();

				
				if (option == 1) {
					System.out.print("Enter type of modest wear (Abaya or Hijab): ");
					type = scan.nextLine();

					System.out.print("Enter item name: ");
					name = scan.nextLine();

					System.out.print("Enter item price: ");
					price = scan.nextInt();

					System.out.print("Enter starting stock quantity: ");
					stock = scan.nextInt();
					scan.nextLine(); // consume newline

					System.out.print("Enter material: ");
					material = scan.nextLine();

					System.out.print("Enter design: ");
					design = scan.nextLine();

					System.out.print("Enter style: ");
					style = scan.nextLine();

					System.out.print("Enter color: ");
					color = scan.nextLine();

					if (type.equalsIgnoreCase("Abaya")) {
						System.out.print("Enter sleeve type: ");
						sleeve = scan.nextLine();

						objectList.add(new Abaya(name, price, stock, material, design, style, color, sleeve));
						System.out.println("New Abaya added successfully.");
					} else if (type.equalsIgnoreCase("Hijab")) {
						System.out.print("Enter length: ");
						lenght = scan.nextLine();

						objectList.add(new Hijab(name, price, stock, material, design, style, color, lenght));
						System.out.println("New Hijab added successfully.");
					} else {
						System.out.println("Invalid type. Only Abaya or Hijab allowed.");
					}
				}

				else if (option == 2) {
					if (customerList.isEmpty()) {
						System.out.println("No customer purchases yet.");
					} else {
						for (Customer c : customerList) {
							System.out.println(c);
						}
					}
				}

				else if (option == 3) {
					System.out.print("Enter name of the product to update: ");
					name = scan.nextLine();
					boolean found = false;

					for (ModestWear a : objectList) {
						if (a.getname().equalsIgnoreCase(name)) {
							System.out.print("Enter quantity delivered: ");
							delivered = scan.nextInt();
							scan.nextLine();

							if (delivered > 0) {
								a.setstock(a.getstock() + delivered);
								System.out.println("Stock updated. New stock: " + a.getstock());
							} else {
								System.out.println("Invalid delivery quantity. Must be more than 0.");
							}

							found = true;
						}
					}

					if (!found) {
						System.out.println("Product not found.");
					}
				}

				else if (option == 4) {
					System.out.println("Exiting Staff Menu...");
				}

				else {
					System.out.println("Invalid option. Please enter 1, 2, 3 or 4.");
				}

			} while (option != 4);
		}
	}

	public void buyAbaya() {
		ArrayList<Abaya> abayas = new ArrayList<Abaya>();
		Scanner scan = new Scanner(System.in);

		for (ModestWear item : objectList) {
			if (item instanceof Abaya) {
				abayas.add((Abaya) item);
			}
		}

		if (abayas.isEmpty()) {
			System.out.println("No Abayas in stock.");
			return;
		}

		System.out.println("Abayas for sale:");
		for (int i = 0; i < abayas.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + abayas.get(i).getname());
			System.out.println(abayas.get(i));
			System.out.println("------------------------");
		}

		System.out.print("Enter the number of the Abaya you want to buy: ");
		int choice = scan.nextInt();
		scan.nextLine();

		if (choice >= 1 && choice <= abayas.size()) {
			Abaya selected = abayas.get(choice - 1);
			System.out.print("How many would you like to buy? ");
			int qty = scan.nextInt();
			scan.nextLine();

			if (qty > 0 && qty <= selected.getstock()) {
				selected.setstock(selected.getstock() - qty);
				System.out.println(
						"Purchased " + qty + " " + selected.getname() + "(s). Remaining stock: " + selected.getstock());
			} else {
				System.out.println("Invalid quantity or not enough stock.");
			}
		} else {
			System.out.println("Invalid selection.");
		}
	}

	public void buyHijab() {
		ArrayList<Hijab> hijabs = new ArrayList<Hijab>();
		Scanner scan = new Scanner(System.in);

		for (ModestWear item : objectList) {
			if (item instanceof Hijab) {
				hijabs.add((Hijab) item);
			}
		}

		if (hijabs.isEmpty()) {
			System.out.println("No Hijabs in stock.");
			return;
		}

		System.out.println("Hijabs for sale:");
		for (int i = 0; i < hijabs.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + hijabs.get(i).getname());
			System.out.println(hijabs.get(i));
			System.out.println("------------------------");
		}

		System.out.print("Enter the number of the Hijab you want to buy: ");
		int choice = scan.nextInt();
		scan.nextLine();

		if (choice >= 1 && choice <= hijabs.size()) {
			Hijab selected = hijabs.get(choice - 1);
			System.out.print("How many would you like to buy? ");
			int qty = scan.nextInt();
			scan.nextLine();

			if (qty > 0 && qty <= selected.getstock()) {
				selected.setstock(selected.getstock() - qty);
				System.out.println(
						"Purchased " + qty + " " + selected.getname() + "(s). Remaining stock: " + selected.getstock());
			} else {
				System.out.println("Invalid quantity or not enough stock.");
			}
		} else {
			System.out.println("Invalid selection.");
		}
	}

	public static void main(String[] args) {
		new Drivercls();
	}
}

