package ex1_Introduction.t8_Java_Datatypes;

import java.util.*;
import java.io.*;
import static java.lang.Math.pow;



class Solution{
    public static void main(String []argh)
    {



        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                //Complete the code
                if(x>=pow(-2, 15) && x<=(pow(2, 15)-1))System.out.println("* short");
                if(x>=pow(-2, 31) && x<=(pow(2, 31)-1))System.out.println("* int");
                if(x>=pow(-2, 63) && x<=(pow(2, 63)-1))System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}
