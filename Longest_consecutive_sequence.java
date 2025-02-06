import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;

public class Longest_consecutive_sequence {
    
    public void using_sorting()
    {

    }

    public int using_hashset(int[] n)
    {
        HashSet<Integer> set = new HashSet<>(); // O(1)
        for(int i=0;i<n.length;i++)
        {
            set.add(n[i]);
        }
        int compare=0;
        for(int i=0;i<n.length;i++)
        {
            if(!set.contains(n[i]-1))
            {
                int currentNum = n[i];
                int pointer = 1;

                while(set.contains(currentNum + 1))
                {
                    currentNum++;
                    pointer++;
                }
                compare = Math.max(compare, pointer);
            }
        }
        return compare;
    }


    public int using_HashMap(int[] n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n.length;i++)
        {
            map.put(n[i], 0);
        }
        int compare=0;
        for(int i=0;i<n.length;i++)
        {
            if(!map.containsKey(n[i]-1))
            {
                int pointer = 1;
                int current = n[i];
                while(map.containsKey(current+1))
                {
                    current++;
                    pointer++;
                }
                compare = Math.max(compare, pointer);
            }
        }
        return compare;

    }

public static void main(String[] args)
{
    Scanner s = new Scanner(System.in);
    Longest_consecutive_sequence obj = new Longest_consecutive_sequence();
    int length = s.nextInt();
    int[] arr = new int[length];
    for(int i=0;i<length;i++)
    {
        arr[i] = s.nextInt();
    }
    int result_set = obj.using_hashset(arr);
    int result_map = obj.using_HashMap(arr);
    System.out.println(result_set);
    System.out.println(result_map);

}

}
