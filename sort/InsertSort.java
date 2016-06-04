package Algorithms.sort;

/**
 * Created by Ruslan Zhdan on 22.05.2016.
 */
public class InsertSort
{
    private long[] a;
    private int nElems;

    public InsertSort(int max)
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

    public void insertionSort()
    {
        int out, in;

        for (out = 1; out < nElems; out++){
            long temp = a[out];
            in = out;
            while (in > 0 && a[in-1] >= temp){
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

class InsertSortApp{
    public static void main(String[] args)
    {
        int maxSize = 10000;
        InsertSort arr;
        arr = new InsertSort(maxSize);

//        arr.insert(77);
//        arr.insert(99);
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);

//        arr.display();


        for (int i=0; i<maxSize; i++)
        {
            long n = (long) (Math.random()*(maxSize-1));
            arr.insert(n);
        }

        arr.display();
        System.out.println("Array was fill!");
        long before = System.currentTimeMillis();
        arr.insertionSort();
        long after = System.currentTimeMillis();

        long delta = after-before;
        System.out.println("time: " + delta);

//        arr.insertionSort);
        arr.display();
    }
}


