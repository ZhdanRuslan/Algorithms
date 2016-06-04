package Algorithms.recursion;

/**
 * Created by Ruslan Zhdan on 01.06.2016.
 */
public class TowerOfHanoi
{
    static int nDisks = 3;

    public static void main(String[] args)
    {
        doTowers(nDisks, 'A', 'B', 'C');
    }

    public static void doTowers(int topN, char from, char inter, char to){
        if (topN == 1)
            System.out.println("Disk 1 from " + from + " to " + to);
        else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}
