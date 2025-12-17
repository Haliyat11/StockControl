

import java.util.Scanner;
import java.util.ArrayList;

public class Drivercls
{

    ArrayList<ModestWear> objectList;
    ArrayList<Customer> customerList;
    String password = "123";

    public Drivercls()
    {
        objectList = new ArrayList<ModestWear>();
        customerList = new ArrayList<Customer>();

        displayTopMenu();

    }

    public void displayTopMenu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        int option = 0;
        do
        {
            System.out.println("\n\n\nMain Menu\n==========");
            System.out.println("1.customer menu ");
            System.out.println("2.staff menu ");
            System.out.println("3.exit ");
            System.out.println("Enter option:  ");
            option = scan.nextInt();
            scan.nextLine();

            if (option ==1)
            {
                displayCustomerMenu();

            }else if (option ==2)
            {

                displaystaffMenu();
            }
            else if (option == 3)
            {
                System.out.println("Exiting program...");
            }
            else
            {
                System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }

        }while(option != 3);
    }

    public void displayCustomerMenu()
    {
        Scanner scan = new Scanner(System.in);

        int quantityBought;
        int option = 0;
        boolean found= false;

        do{
            System.out.println("\n\n\nCustomer Menu\n==========");
            System.out.println("1.Display all abaya for sale ");
            System.out.println("2.Display all hijab for sale ");
            System.out.println("3.Buy one or more abaya ");
            System.out.println("4.Buy one or more hijab ");
            System.out.println("5.Exit Customer menu ");

            option = scan.nextInt();
            scan.nextLine();

            if (option ==1)
            {
                if (objectList.isEmpty())
                {
                    System.out.println("We do not have any products in stock currently");
                }
                else
                {
                    for (ModestWear a :objectList)
                    {

                        if(a instanceof Abaya)
                        {
                            System.out.println("Abaya" + a.toString() );

                        }
                    }
                }
            }
            else if (option == 2)
            {
                if (objectList.isEmpty())
                {
                    System.out.println("We do not have any products in stock currently");
                }
                else
                {
                    for (ModestWear a :objectList)
                    {

                        if(a instanceof Hijab)
                        {
                            System.out.println("hijab" + a.toString() );

                        }
                    }
                }
            }
            else if (option == 3)
            {
                System.out.println("Exiting program...");
            }
            else if(option == 4)
            {
                System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }

            //ask user detail about item//
        }while (option !=5);
    }

    public void buyAnAbaya()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");
        String itemName ;
        int quantityBought;

        boolean found= false;
        System.out.print("Enter the name of the item you want to buy: ");
        itemName = scan.nextLine();

        //see find item in list that match//
        for (ModestWear item : objectList)
        {
            if (item. getname().equalsIgnoreCase(itemName))
            {

                found = true;

                //found, ask user what they want purchase
                System.out.print("Enter how many you want to buy: ");
                quantityBought = scan.nextInt();
                scan.nextLine();

                // check item in stock stock call getter//
                if (item.getstock() >= quantityBought)
                {
                    item.setstock(item.getstock() - quantityBought);
                    System.out.println("Purchased");
                    System.out.println("Remaining stock " + item.getstock());
                }
                else
                {
                    System.out.println("Not enough stock available.");
                }

            }
        }

    }

    public void displaystaffMenu()
    {
        Scanner scan = new Scanner(System.in);

        String type;
        String name;
        int price;
        int stock;
        int option = 0;
        int delivered;
        String material;

        String style;
        String color;
        String item;
        String sleeve;
        String lenght;
        String design;
        String pass;

        System.out.print("Please enter the staff password: ");
        pass = scan.nextLine();
        boolean access = false;

        if (pass.equalsIgnoreCase(password))
        {

            System.out.print("correct password");
            access =true;

        }else
        {

            System.out.print("wrong password try again");

        } 

        if(access==true)
            {
                 do {
                System.out.println("\n\n\nStaff Menu\n==========");
                System.out.println("1.Add a new type of abaya or hijab to the stock list");
                System.out.println("2.Display the list of customers and products they have bought");
                System.out.println("3.update the stock level for an existing abaya or hijab with a new delivery");
                System.out.println("4.Exit Staff menu");

                System.out.print("Enter your choice");

                option = scan.nextInt();
                scan.nextLine();

                // If option 1 Add new Wear item
                if (option == 1)
                {
                    System.out.print("enter type modestwear you want");
                    type = scan.nextLine();

                    //  Ask for the name prices tock of the new item
                    System.out.println("Enter item name: ");
                    name = scan.nextLine();

                    System.out.println("Enter item price: ");
                    price = scan.nextInt();

                    System.out.println("Enter starting stock quantity: ");
                    stock = scan.nextInt();
                    scan.nextLine();

                    // Ask for subclass (Abaya) specific variables
                    System.out.println("Enter material: ");
                    material = scan.nextLine();

                    System.out.println("Enter style: ");
                    style = scan.nextLine();

                    System.out.println("Enter color: ");
                    color = scan.nextLine();

                    System.out.println("Enter sleeve: ");
                    sleeve = scan.nextLine();

                    System.out.println("Enter lenght: ");
                    lenght = scan.nextLine();

                    System.out.println("Enter design: ");
                    design = scan.nextLine();

                    // Add the new item to the list  on type wear
                    if (type.equalsIgnoreCase("Abaya"))
                    {
                        objectList.add(new Abaya( name, price,stock, material, design, style, color, sleeve)); 
                        System.out.println("New Abaya added");

                    }
                    else if (type.equalsIgnoreCase("Hijab"))

                    {
                        objectList.add(new Hijab(name, price, stock, material, design,  style,  color, lenght));
                        System.out.println("New Hijab added");

                    }
                    else
                    {
                        // invalid item
                        System.out.println("Only Abaya or Hijab allowed.");

                    }

                    // Option 2: Display customers and what they bought

                } else if (option == 2) 
                {
                    if (customerList.isEmpty()) 
                    {
                        System.out.println("No customer purchases yet.");
                    } else
                    {
                        for (Customer c : customerList) 
                            System.out.println(c);

                    }
                }

                // Update stock level for an existing product
                else if ( option==3)
                {

                    System.out.println("Enter name of the product to update: ");
                    name = scan.nextLine();
                    boolean found = false;

                    for (ModestWear a : objectList) 
                    {
                        if (a.getname().equalsIgnoreCase(name))

                        {
                            System.out.println("Enter quantity delivered: ");
                            delivered =scan.nextInt();
                            scan.nextLine();

                            a.setstock(a.getstock() + delivered);
                            System.out.println("Stock updated New stock  " + a.getstock());
                            found = true;

                        }

                        else
                        {
                            //invalid delivery number
                            System.out.println("Invalid delivery number. Must be more than 0");
                        }

                    } 

                }
            }while(option != 4);
        }
    }

    public static void main(String[] args)
    {
        new Drivercls();
    }
}

