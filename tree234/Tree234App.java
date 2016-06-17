package Algorithms.tree234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ruslan Zhdan on 15.06.2016.
 */
public class Tree234App
{
    public static void main(String[] args) throws IOException
    {
        long value;
        Tree234 theTree = new Tree234();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

        while (true)
        {
            System.out.print("Enter the first letter of: ");
            System.out.print("show, insert or find: ");

            char choice = getChar();
            switch (choice)
            {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found != -1)
                        System.out.println("Found " + value);
                    else
                        System.out.println("Could not find " + value);
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

    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}

class DataItem
{
    public long dData;

    public DataItem(long dData)
    {
        this.dData = dData;
    }

    public void displayItem()
    {
        System.out.print("/" + dData);
    }
}

class Node
{
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER - 1];

    public void connectChild(int childNum, Node child)
    {
        childArray[childNum] = child;
        if (child != null)
        {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum)
    {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum)
    {
        return childArray[childNum];
    }

    public Node getParent()
    {
        return parent;
    }

    public boolean isLeaf()
    {
        return childArray[0] == null;
    }

    public int getNumItems()
    {
        return numItems;
    }

    public DataItem getItem(int index)
    {
        return itemArray[index];
    }

    public boolean isFull()
    {
        return numItems == ORDER - 1;
    }

    public int findItem(long key)
    {
        for (int j = 0; j < ORDER - 1; j++)
        {
            if (itemArray[j] == null)
                break;
            else if (itemArray[j].dData == key)
                return j;
        }
        return -1;
    }

    /*It assumed that the node is not empty*/
    public int insertItem(DataItem newItem)
    {
        numItems++;
        long newKey = newItem.dData;


        for (int j = ORDER - 2; j >= 0; j--)
        {
            if (itemArray[j] == null)
                continue;
            else
            {
                long itsKey = itemArray[j].dData;
                if (newKey < itsKey)
                    itemArray[j + 1] = itemArray[j];
                else
                {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    /*It assumed that the node is not empty*/
    public DataItem removeItem()
    {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void displayNode()
    {
        for (int j = 0; j < numItems; j++)
            itemArray[j].displayItem();
        System.out.println("/");
    }
}

class Tree234
{
    private Node root = new Node();

    public int find(long key)
    {
        Node curNode = root;
        int childNumber;
        while (true)
        {
            if ((childNumber = curNode.findItem(key)) != -1)
                return childNumber;
            else if (curNode.isLeaf())
                return -1;
            else
                curNode = getNextChild(curNode, key);
        }
    }

    public void insert(long dValue)
    {
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);

        while (true)
        {
            if (curNode.isFull())
            {
                split(curNode);
                curNode = curNode.getParent();

                curNode = getNextChild(curNode, dValue);
            } else if (curNode.isLeaf())
                break;
            else
                curNode = getNextChild(curNode, dValue);
        }
        curNode.insertItem(tempItem);
    }

    /*It assumed that the node is full*/
    public void split(Node thisNode)
    {
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();

        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node newRight = new Node();

        if (thisNode == root)
        {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else
            parent = thisNode.getParent();

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int j = n - 1; j > itemIndex; j--)
        {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }
        parent.connectChild(itemIndex + 1, newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    /*It assumed that the node is full, not empty and not leaf*/
    public Node getNextChild(Node theNode, long theValue)
    {
        int j;
        int numItems = theNode.getNumItems();
        for (j = 0; j < numItems; j++)
        {
            if (theValue < theNode.getItem(j).dData)
                return theNode.getChild(j);
        }
        return theNode.getChild(j);
    }

    public void displayTree()
    {
        recDisplayTree(root, 0, 0);
    }

    public void recDisplayTree(Node thisNode, int level, int childNumber)
    {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();

        for (int j = 0; j < numItems + 1; j++)
        {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
            else
                return;
        }
    }
}


