package Algorithms.lists;

/**
 * Created by Ruslan Zhdan on 28.05.2016.
 */

class Link{
    public int iData;
    public double dData;
    public Link next;

    public Link(int iData, double dData)
    {
        this.iData = iData;
        this.dData = dData;
    }

    public void displayLink(){
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}

class LinkList{
    private Link first;

    public LinkList()
    {
        first = null;
    }

    public LinkList(Link first)
    {
        this.first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int id, double dd){
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.print("List-->last: ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

public class LinkListApp
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(33, 3.99);
        theList.insertFirst(99, 9.99);
        theList.insertFirst(77, 4.99);
        theList.insertFirst(32, 12.99);

        theList.displayList();

        while (!theList.isEmpty()){
            Link aLink = theList.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayLink();
            System.out.println();
        }
        theList.displayList();
    }
}
