package Algorithms.arrays.arroop;

/**
 * Created by Ruslan Zhdan on 21.05.2016.
 */
public class HighArray
{
    private long[] a;
    private int nElems;

    public HighArray(int max)
    {
        a = new long[max];
        nElems = 0;
    }

//    Searching an element
    public boolean find(long searchKey){
        int j;
        for(j = 0; j < nElems; j++)
            if (a[j] == searchKey)
                break;
        if (j == nElems)
            return false;
        else
            return true;
    }

//    Inserting into structure
    public void insert (long value){
        a[nElems] = value;
        nElems++;
    }

//    Deleting
    public boolean delete(long value){
        int j;
        for(j = 0; j < nElems; j++)
            if (value == a[j])
                break;
        if (j == nElems)
            return false;
        else
        {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

//    Displaying
    public void display(){
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    public long removeMax(){
        long max = 0;
        for (int j = 0; j < nElems; j++){
            if(a[j] > max)
                max = a[j];
        }
        delete(max);
        return max;
    }

    public int size(){
        return nElems;
    }
}

class HighArrayApp{
    public static void main(String[] args)
    {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        int searchKey = 35;
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        System.out.println("MAX: " + arr.removeMax());
        arr.display();

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
        System.out.println("MAX: " + arr.removeMax());


        long[] result = new long[maxSize];

        for (int i = 0; i < maxSize; i++){
            long tmp = arr.removeMax();
            result[i] = tmp;
            maxSize--;
        }
        for (long l : result)
        {
            System.out.print(l + " ");
        }
    }
}