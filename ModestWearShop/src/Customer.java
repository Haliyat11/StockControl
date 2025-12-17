


/**
 * Write a description of class customers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    private  String email;
    private ModestWear lastProductBought;
    private int quantityBought;

    public Customer(String email)
    {
        this.email = email; 
        this.lastProductBought = null;
        this.quantityBought = 0 ;
    }

    //get//
    public String getemail()
    {
        return this.email;

    }

    public ModestWear getlastProductBought()
    {
        return this.lastProductBought;

    }

    public int getquantityBought()
    {
        return this.quantityBought;

    }

    //set//

    public void setemail(String email)
    {
        this.email= email;

    }

    public void setlastProductBought(ModestWear lastProductBought)
    {
        this.lastProductBought = lastProductBought;

    }

    public void setquantityBought(int  quantityBought)
    {
        this.quantityBought =  quantityBought;

    }


    public String toString()
    {
        String sentence = "";
        sentence = "Customer email address: " + this.email;
        if (this.lastProductBought == null)
        {
            sentence = sentence + "\nThis customer has not bought a product yet";
        }
        else
        {
             sentence = sentence + "\nName of product bought: " + this.lastProductBought.getname() + 
             "\nNumber bought " + this.quantityBought + "\n";
        }
        
        return sentence;
    }
    
    public void testtoString()
    {
        System.out.print("\f");
        System.out.println(toString());
    }
}
