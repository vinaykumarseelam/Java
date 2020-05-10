import java.util.*;
import java.io.*;
import java.lang.Math; 




class Datatypes{
    public static void main(String []argh)
    {

        double i1 = -((Math.pow(2,31)));
        double i2 = Math.pow(2,31) - 1;
        double l1 = -(Math.pow(2,63));
        double l2 = Math.pow(2,63) - 1;
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=-32768 && x<=32767)System.out.println("* short");
                if(x>=i1 && x<=i2)System.out.println("* int");
                if(x>=l1 && x<=l2)System.out.println("* long");
                
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
                sc.close();
    }
}
