package Algorithms;

/**
 * Created by Ruslan Zhdan on 20.05.2016.
 */
public class ListApplication
{
    public static void main(String[] args)
    {
        LinkList ll = new LinkList();
        ll.insert(22);
        ll.insert(33);
        ll.insert(44);
        ll.insert(55);

        ll.printAll();


    }
}

class LinkList
{
    public List first;

    public void insert(int value)
    {
        List list = new List(value);
        list.next = first;
        first = list;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void printAll()
    {
        List current = first;
        while (current != null)
        {
            current.printElem();
            current = current.next;
        }
        System.out.println("");
    }
}

class List
{
    public int data;
    public List next;

    public List(int data)
    {
        this.data = data;
    }

    public void printElem()
    {
        System.out.print("value: " + data + " ");
    }
}
