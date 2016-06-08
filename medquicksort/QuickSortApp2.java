package Algorithms.medquicksort;

/**
 * Created by Ruslan Zhdan on 07.06.2016.
 */
class ArrayIns
{

    private long[] data;
    private int len;
    public ArrayIns(int max)
    {
        data = new long[max];
        len = 0;
    }

    public void insert(long value)
    {
        data[len] = value;
        len++;
    }

    public void display()
    {
        System.out.print("A=");
        for (int j = 0; j < len; j++)
            System.out.print(data[j] + " ");
        System.out.println("");
    }

    public void quickSort()
    {
        recQuickSort(0, len - 1);
    }

    public void recQuickSort(int left, int right)
    {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(left, right);
        else
        {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public long medianOf3(int left, int right)
    {
        int center = (left + right) / 2;
        if (data[left] > data[center])
            swap(left, center);
        if (data[left] > data[right])
            swap(left, right);
        if (data[center] > data[right])
            swap(center, right);

        swap(center, right - 1);
        return data[right - 1];
    }

    public void swap(int dex1, int dex2)
    {
        long temp = data[dex1];
        data[dex1] = data[dex2];
        data[dex2] = temp;
    }

    public int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true)
        {
            while (data[++leftPtr] < pivot)
                ;
            while (data[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    public void manualSort(int left, int right)
    {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2)
        {
            if (data[left] > data[right])
                swap(left, right);
            return;
        } else
        {
            if (data[left] > data[right - 1])
                swap(left, right - 1);
            if (data[left] > data[right])
                swap(left, right);
            if (data[right - 1] > data[right])
                swap(right - 1, right);
        }
    }

}

public class QuickSortApp2
{
    public static void main(String[] args)
    {
        int maxSize = 16;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);

        for (int j = 0; j < maxSize; j++)
        {
            long n = (int) (Math.random() * 99);
            arr.insert(n);
        }

        arr.display();
        arr.quickSort();
        arr.display();
    }
}
