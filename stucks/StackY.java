package Algorithms.stucks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ruslan Zhdan on 23.05.2016.
 */
public class StackY
{
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackY(int maxSize)
    {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push (long j){
        stackArray[++top] = j;
    }

    public long pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }

    public int size(){
        return top+1;
    }

    public char peekN(int n){
        return (char) stackArray[n];
    }

    public void displayStack(String s){
        System.out.print(s);
        System.out.print("Stack (bottom --> top): ");
        for (int j = 0; j < size(); j++){
            System.out.print( peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
}

class ParsePost
{
    private StackY theStack;
    private String input;

    public ParsePost(String s)
    {
        input = s;
    }

    public int doParse(){
        theStack = new StackY(20);
        char ch;
        int j;
        int num1, num2, interAns;

        for (j = 0; j < input.length(); j++){
            ch = input.charAt(j);
            theStack.displayStack(""+ch+" ");
            if (ch >= '0' && ch <= '9')
                theStack.push((int) (ch-'0'));
            else{
                num2 = (int) theStack.pop();
                num1 = (int) theStack.pop();
                switch (ch){
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 + num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = (int) theStack.pop();
        return interAns;
    }
}

class PostfixApp{
    public static void main(String[] args) throws IOException
    {
        String input;
        int output;

        while (true){
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;
            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse();
            System.out.println("Evaluates to " + output);
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

