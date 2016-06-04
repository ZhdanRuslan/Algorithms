package Algorithms.arrays.arroop;

public class BinarySearch
{
    public static int[] insert(int arr[], int value)
    {
        int upperBound = arr.length - 1;
        int lowerBound = 0;

        while (true)
        {
            int mid = (upperBound + lowerBound) / 2;
            if (arr[mid] == value){
                int[] tmp = new int[arr.length+1];

                for (int i = 0; i < arr.length; i++)
                    tmp[i] = arr[i];

                for (int k = tmp.length-1; k > mid; k--)
                    tmp[k] = tmp[k-1];
                tmp[mid] = value;
                return tmp;
            }
            else if (lowerBound > upperBound){
                int[] tmp = new int[arr.length+1];

                for (int i = 0; i < arr.length; i++)
                    tmp[i] = arr[i];

                int j;
                for (j = 0; j < tmp.length-1; j++)
                    if (tmp[j] > value)
                        break;
                for (int k = tmp.length-1; k > j; k--)
                    tmp[k] = tmp[k-1];
                tmp[j] = value;
                return tmp;
            }

            else
            {
                if (arr[mid] > value)
                    upperBound = mid - 1;
                else
                    lowerBound = mid + 1;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] tmp = {1, 2, 5, 9, 12, 54, 78};

        int[] result = insert(tmp, 22);

        for (int i : result)
        {
            System.out.print(i + " ");
        }
    }
}
