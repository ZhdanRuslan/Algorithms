package Algorithms.arrays.arroop;

public class OrdArrayWithMerge
{
    private long[] a;
    private int nElems;

    public OrdArrayWithMerge(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public int size(){
        return nElems;
    }

    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true){
            curIn = (lowerBound + upperBound)/2;
            if (a[curIn]==searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else{
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void insert(long value){
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] > value)
                break;
        for (int k = nElems; k > j; k--)
            a[k] = a[k-1];
        a[j] = value;
        nElems++;
    }

    public int[] merge (int[] first, int[] second){
        int resultLength = first.length + second.length;
        int[] result = new int[resultLength];

        if (first[0] < second[0]){
            for (int i = 0; i < first.length; i++)
                result[i] = first[i];
            int tmp = 0;
            for (int j = first.length; j < resultLength; j++){
                result[j] = second[tmp];
                tmp++;
            }
        }
        else {
            for (int i = 0; i < second.length; i++)
                result[i] = second[i];
            int tmp = 0;
            for (int j = second.length;  j < resultLength; j++){
                result[j] = first[tmp];
                tmp++;
            }
        }
        return result;
    }

    public boolean delete (long value){
        int j = find(value);
        if (j == nElems)
            return false;
        else {
            for(int k = j; k < nElems; k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }

    public void display(){
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + "\t");
        System.out.println("");
    }
}

class OrderedAppl{
    public static void main(String[] args)
    {
        int maxSize = 100;
        OrdArrayWithMerge arr;
        arr = new OrdArrayWithMerge(maxSize);

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

        int searchKey = 55;
        if (arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.display();

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();

        int[] first = {1, 5, 9, 17, 25, 32, 35, 36, 37};
        int[] second = {44, 55, 999, 117, 2525, 3535, 5555, 6782};
        int[] res = arr.merge(second, first);


        for (int i :res)
        {
            System.out.print(i+ " ");
        }
    }
}

