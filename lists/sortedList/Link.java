package Algorithms.lists.sortedList;

/**
 * Created by Ruslan Zhdan on 29.05.2016.
 */
public class Link
{
    public long dData;
    public Link next;

    public Link(long dData)
    {
        this.dData = dData;
    }

    public void displayLink(){
        System.out.print(dData + " ");
    }
}

class SortedList{
    private Link first;

    public SortedList(){
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(long key){
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;

        while (current != null && key > current.dData){
            previous = current;
            current = current.next;
        }

        if (previous == null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }

    public Link remove(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class SortedListApp{
    public static void main(String[] args)
    {
        SortedList theSortedlist = new SortedList();
        theSortedlist.insert(20);
        theSortedlist.insert(40);

        theSortedlist.displayList();

        theSortedlist.insert(10);
        theSortedlist.insert(30);
        theSortedlist.insert(50);

        theSortedlist.displayList();

        theSortedlist.remove();

        theSortedlist.displayList();
    }
}
