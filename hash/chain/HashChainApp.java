package Algorithms.hash.chain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ruslan Zhdan on 05.07.2016.
 */
public class HashChainApp
{
    public static void main(String[] args) throws IOException
    {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;
        System.out.print("Enter size of hash table: ");
        size = (int) getInt();
        System.out.print("Enter initial number of items: ");
        n = (int) getInt();

        HashTable theHashTable = new HashTable(size);

        for (int j = 0; j < n; j++)
        {
            aKey = (int) (java.lang.Math.random() * keysPerCell * size);
            aDataItem = new Link(aKey);
            theHashTable.insert(aDataItem);
        }

        while (true)
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete or find: ");
            char choice = getChar();
            switch (choice)
            {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter a key value to insert: ");
                    aKey = (int) getInt();
                    aDataItem = new Link(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter a key value to delete: ");
                    aKey = (int) getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.println("Enter a key value to find: ");
                    aKey = (int) getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null)
                    {
                        System.out.println("Found: " + aKey);
                    } else
                        System.out.println("Could not to find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }


    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }

    public static long getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}

class Link
{
    private int iData;
    public Link next;

    public Link(int iData)
    {
        this.iData = iData;
    }

    public int getKey()
    {
        return iData;
    }

    public void displayLink()
    {
        System.out.print(iData + " ");
    }
}

class SortedList
{
    private Link first;

    SortedList()
    {
        first = null;
    }

    public void insert(Link theLink)
    {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getKey())
        {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = theLink;
        else
            previous.next = theLink;
        theLink.next = current;
    }

    public void delete(int key)
    {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey())
        {
            previous = current;
            current = current.next;
        }

        if (previous == null)
            first = first.next;
        else
            previous.next = current.next;
    }

    public Link find(int key)
    {
        Link current = first;

        while (current != null && current.getKey() <= key)
        {
            if (current.getKey() == key)
                return current;
            current = current.next;
        }
        return null;
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class HashTable
{
    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int arraySize)
    {
        this.arraySize = arraySize;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++)
            hashArray[j] = new SortedList();
    }

    public void displayTable()
    {
        for (int j = 0; j < arraySize; j++)
        {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(int key)
    {
        return key % arraySize;
    }

    public void insert(Link theLink)
    {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key)
    {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key)
    {
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }
}
