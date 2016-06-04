package Algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ruslan Zhdan on 30.05.2016.
 */
public class TriangleAppl
{
    static int theNumber;

    public static void main(String[] args) throws IOException
    {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        int theAnswer = triangle(theNumber);
        System.out.println("Triangle: " + theAnswer);
    }

    public static int triangle(int n)
    {
        System.out.println("Entering: " + n);
        if (n == 1){
            System.out.println("Returning 1");
            return 1;
        }
        else
        {
            int tmp = (n + triangle(n - 1));
            System.out.println("Returning: " + tmp);
            return tmp;
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}
