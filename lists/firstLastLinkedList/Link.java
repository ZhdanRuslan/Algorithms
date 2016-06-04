package Algorithms.lists.firstLastLinkedList;

/**
 * Created by Ruslan Zhdan on 28.05.2016.
 */

class Link
{
    public int iData;
    public Link next;

    public Link(int iData)
    {
        this.iData = iData;
    }

    public void displayLink()
    {
        System.out.print("{" + iData + "}");
    }
}

class FirstLastList
{
    private Link first;
    private Link last;

    public FirstLastList()
    {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void insertFirst(int dd)
    {
        Link newLink = new Link(dd);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int dd)
    {
        Link newLink = new Link(dd);
        if (isEmpty())
            first = newLink;
        else
        {
            last.next = newLink;
            last = newLink;
        }
    }

    public int deleteFirst()
    {
        int tmp = first.iData;
        if (first.next == null)
            last = null;
        first = first.next;
        return tmp;
    }

    public void displayList()
    {
        System.out.println("List (first-->last): ");
        Link current = first;
        while (current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class FirstLastApp
{
    public static void main(String[] args)
    {
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();
    }
}

