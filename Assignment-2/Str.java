/**
 * Created by zemoso on 28/6/17.
 */
public class Str {
    public Str(String s)
    {
        System.out.println(s);
    }
    public static void main(String args[])
    {
        Str a[] = new Str[5];
     for (int i=0;i<5;i++)
         a[i]= new Str("1");
    }
}
