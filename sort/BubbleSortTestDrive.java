package Algorithms.sort;

/**
 * Created by Ruslan Zhdan on 22.05.2016.
 */
public class BubbleSortTestDrive
{
    private long[] a;
    private int nElems;

    public BubbleSortTestDrive(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public void insert (long value){
        a[nElems] = value;
        nElems++;
    }

    public void display(){
        for (int j=0; j<nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    public void bubbleSort(){
        int out, in;
        for (out = nElems-1; out>1; out--){

            for (in=0; in<a.length/2; in++)
                if(a[in] > a[in+1])
                    swap(in, in+1);
            for (int q = out-1; q>in; q--)
                if(a[q] > a[q+1])
                    swap(q, q+1);
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

class BubbleSortAppl{
    public static void main(String[] args)
    {
        int maxSize = 10000;
        BubbleSort arr;
        arr = new BubbleSort(maxSize);

        for (int i=0; i<maxSize; i++)
        {
            long n = (long) (Math.random()*(maxSize-1));
            arr.insert(n);
        }

        System.out.println("Array was fill!");
        long before = System.currentTimeMillis();
        arr.bubbleSort();
        long after = System.currentTimeMillis();

        long delta = after-before;
        System.out.println("time: " + delta);
        arr.display();
    }
}


