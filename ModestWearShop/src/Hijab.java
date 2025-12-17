


/**
 * Write a description of class hijab here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hijab extends ModestWear
{

    private String lenght;
    

    public Hijab(String name,int price,int stock,String material,  String design, String style, String color,String lenght )
    {
        super(name, price,stock,material,design,style,color); 
        this.lenght = lenght;
       

    }
    
    //get//
    public String getlenght()
    {
        return this.lenght;

    }

    
    //set//

    public void setlenght(String lenght)
    {
        this.lenght = lenght;

    }

   
    
    public String toString()
    {

        return super.toString() + "lenght" + this.lenght ;

    }
}
