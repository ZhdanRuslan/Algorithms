package Algorithms.lists;

class LinkX
{
    public int iData;
    public double dData;
    public LinkX next;

    public LinkX(int id, double dd)
    {
        this.iData = id;
        this.dData = dd;
    }

    public void displayLink()
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}

class LinkListX
{
    private LinkX first;

    public LinkListX()
    {
        first = null;
    }

    public void insertFirst(int id, double dd)
    {
        LinkX newLink = new LinkX(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public LinkX find(int key)
    {
        LinkX current = first;
        while (current.iData != key)
        {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public LinkX delete(int key)
    {
        LinkX current = first;
        LinkX previous = first;
        while (current.iData != key)
        {
            if (current.next == null)
                return null;
            else
            {
                previous = current;
                current = current.next;
            }
        }
        if (current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public LinkX deleteFirst()
    {
        LinkX temp = first;
        first = first.next;
        return temp;
    }

    public void displayList()
    {
        System.out.print("List-->last: ");
        LinkX current = first;
        while (current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

public class LinkListAppl
{
    public static void main(String[] args)
    {
        LinkListX theList = new LinkListX();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(33, 3.99);
        theList.insertFirst(99, 9.99);
        theList.insertFirst(77, 4.99);
        theList.insertFirst(32, 12.99);

        theList.displayList();

        LinkX f = theList.find(397);
        if (f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can't find a link");

        LinkX d = theList.delete(66);
        if (d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can't delete link");

        theList.displayList();
    }
}
