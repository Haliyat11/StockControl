


/**
 * Write a description of class ModestWear here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ModestWear
{
    private String name;
    private int price;
    private int stock;
    private String material;
    private String design;
    private String style;
    private String color;

    public ModestWear(String name,int price,int stock, String material,  String design, String style, String color)
    {

        this.name = name;
        this.price = price;
        this.stock = stock;
        this.material = material;
        this.design = design;
        this.style = style;
        this.color = color;
    }

    //get//
    public String getname()
    {
        return this.name;

    }

      public int getprice()
    {
        return this.price;

    }

    public int getstock()
    {
        return this.stock;

    }
    
    public String getmaterial()
    {
        return this.material;

    }

    public String getdesign()
    {
        return this.design;

    }

    public String getstyle()
    {
        return this.style;

    }

    public String getcolor()
    {
        return this.color;

    }

    //set//

    public void setname(String name)
    {
        this.name = name;

    }

   

    public void setprice(int price)
    {
        this.price = price;

    }

    public void setstock(int stock)
    {
        this.stock = stock;

    }
    
    public void setmaterial(String name)
    {
        this.material = material;

    }

    public void setdesign(String design )
    {
        this.design= design;

    }

    public void setstyle(String style)
    {
        this.style = style;

    }

    public void setcolor(String color)
    {
        this.color = color;

    }


    public String toString()
    {

        return " product name" + this.name +"\nprice" + this.price + "\nstock" + this.stock;

    }

}
