package Algorithms.arrays.arroop;


class NoDups
{
    private int[] noDups(Integer[] arr)
    {
        int nullsCounter = 0;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] != null)
                for (int y = i + 1; y < arr.length; y++)
                    if (arr[y] != null && arr[i].equals(arr[y]))
                    {
                        arr[y] = null;
                        nullsCounter++;
                    }

        int[] noDups = new int[arr.length - nullsCounter];
        int i = 0;
        for (Integer e : arr)
            if (e != null)
                noDups[i++] = e;
        return noDups;
    }

    public static void main(String[] args)
    {
        Integer[] tmp = {1, 2, 3, 4, 2, 2, 2, 5};
        int[] result = new NoDups().noDups(tmp);
        for (int i : result)
            System.out.print(i + " ");

    }
}
