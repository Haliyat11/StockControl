
/**
 * Write a description of class abaya here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Abaya extends ModestWear
{
    private String sleeve;

    public Abaya(String name,int price,int stock, String material,  String design, String style, String color,  String sleeve )
    {
        super(name, price,stock,material,design,style, color); 
        this.sleeve = sleeve;
       
    }

    //get//
    public String getsleeve()
    {
        return this.sleeve;

    }

    //set//
    public void setsleeve(String sleeve)
    {
        this.sleeve = sleeve;

    }


    public String toString()
    {

        return super.toString() + "sleeve" + this.sleeve;

    }
}

