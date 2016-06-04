package Algorithms.sort;

/**
 * Created by Ruslan Zhdan on 22.05.2016.
 */
public class SelectionSort
{
    private long[] a;
    private int nElems;

    public SelectionSort(int max)
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

    public void selectionSort()
    {
        int out, in, min;

        for (out = 0; out < nElems; out++){
            min = out;
            for (in = out+1; in < nElems; in++)
                if (a[in] < a[min])
                    min = in;
            swap(out, min);
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

class SelectionSortApp{
    public static void main(String[] args)
    {
        int maxSize = 10_000;
        SelectionSort arr;
        arr = new SelectionSort(maxSize);

        arr.display();

        for (int i=0; i<maxSize; i++)
        {
            long n = (long) (Math.random()*(maxSize-1));
            arr.insert(n);
        }

        System.out.println("Array was fill!");
        long before = System.currentTimeMillis();
        arr.selectionSort();
        long after = System.currentTimeMillis();

        long delta = after-before;
        System.out.println("time: " + delta);
        arr.display();
    }
}


