package Algorithms.stucks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ruslan Zhdan on 23.05.2016.
 */
public class StackInPos
{
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackInPos(int maxSize)
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

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
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

class InToPos{
    private StackInPos theStack;
    private String input;
    private String output = "";

    public InToPos(String in)
    {
        input = in;
        int stackSize = input.length();
        theStack = new StackInPos(stackSize);
    }

    public String doTrans(){
        for (int j = 0; j< input.length(); j++){
            char ch = input.charAt(j);
            theStack.displayStack("For " + ch + " ");
            switch (ch){
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParent(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty()){
            theStack.displayStack("While ");
            output = output + theStack.pop();
        }
        theStack.displayStack("End ");
        return output;
    }

    public void gotOper(char opThis, int prec1)
    {
        while (!theStack.isEmpty()){
            char opTop = (char) theStack.pop();
            if (opTop == '('){
                theStack.push(opTop);
                break;
            }
            else {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1){
                    theStack.push(opTop);
                    break;
                }
                else
                    output = output + opTop;
            }
        }
        theStack.push(opThis);
    }

    public void gotParent(char ch)
    {
        while (!theStack.isEmpty()){
            char chx = (char) theStack.pop();
            if (chx == '(')
                break;
            else
                output = output + chx;
        }
    }
}

class InfixApp{
    public static void main(String[] args) throws IOException
    {
        String input, output;
        while (true){
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;

            InToPos theTrans = new InToPos(input);
            output = theTrans.doTrans();
            System.out.println("Postfix is: " + output + '\n');
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

