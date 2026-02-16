
public class Hijab extends ModestWear
{

    private String lenght;
    

    public Hijab(String name,int price,int stock,String material,  String design, String style, String color,String lenght )
    {
        super(name, price,stock,material,design,style,color); 
        this.lenght = lenght;
       

    }
    
    public String getlenght()
    {
        return this.lenght;

    }


    public void setlenght(String lenght)
    {
        this.lenght = lenght;

    }

   
    
    public String toString()
    {

        return super.toString() + "lenght" + this.lenght ;

    }
}

