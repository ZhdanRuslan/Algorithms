package Algorithms.partition;

/**
 * Created by Ruslan Zhdan on 06.06.2016.
 */
public class PartitionApp
{
    public static void main(String[] args)
    {
        int maxSize = 16;
        ArrayApp arr;
        arr = new ArrayApp(maxSize);

        for (int j = 0; j < maxSize; j++){
            long n = (int) (Math.random()*199);
            arr.insert(n);
        }

        arr.display();

        long pivot = 99;

        System.out.println("Pivot is " + pivot);
        int size = arr.size();
        int partDex = arr.partitionIt(0, size-1, pivot);

        System.out.println(". Partition is at index " + partDex);
        arr.display();
    }
}

class ArrayApp{
    private long[] theArray;
    private int nElems;

    public ArrayApp(int max)
    {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems] = value;
        nElems++;
    }

    public int size(){
        return nElems;
    }

    public void display(){
        System.out.print("A= ");
        for (int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }

    public int partitionIt(int left, int right, long pivot){
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true){
            while (leftPtr < right && theArray[++leftPtr] < pivot)
                ;/*NOP*/
            while (rightPtr > left && theArray[--rightPtr] > pivot)
                ;/*NOP*/
            if (leftPtr >= rightPtr)
                break;
            else swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    public void swap (int dex1, int dex2){
        long temp;
        temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
