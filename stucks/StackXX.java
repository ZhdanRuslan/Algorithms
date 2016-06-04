package Algorithms.stucks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ruslan Zhdan on 23.05.2016.
 */
public class StackXX
{
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackXX(int maxSize)
    {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long j)
    {
        stackArray[++top] = j;
    }

    public long pop()
    {
        return stackArray[top--];
    }

    public long peek()
    {
        return stackArray[top];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public boolean isFull()
    {
        return (top == maxSize - 1);
    }
}

class Reverser
{
    private String input;
    private String output;

    public Reverser(String input)
    {
        this.input = input;
    }

    public String doRev()
    {
        int stackSize = input.length();
        StackXX theStack = new StackXX(stackSize);

        for (int j = 0; j < input.length(); j++)
        {
            char ch = input.charAt(j);
            theStack.push(ch);
        }
        output = "";
        while (!theStack.isEmpty())
        {
            char ch = (char) theStack.pop();
            output = output + ch;
        }
        return output;
    }
}

class ReverseApp{
    public static void main(String[] args) throws IOException
    {
        String input, output;

        while (true){
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;

            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("Reversed :" + output);

        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
