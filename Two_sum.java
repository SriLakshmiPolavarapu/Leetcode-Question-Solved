import java.util.HashMap;
import java.util.Scanner;

public class Two_sum {
    public int[] check(int[] arr, int target)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
                if(arr[i] + arr[j] == target)
                {
                // return index of arr[i] and arr[i+1]
                return new int[] {i, j};
                }
        }
        return new int[] {-1,-1};
    }

    public int[] optimized_check(int[] arr, int target)
    {
        HashMap<Integer, Integer> store = new HashMap<>();
        {
            for(int i=0;i<arr.length;i++)
            {
                int j = target - arr[i];
                if(store.containsKey(j))
                {
                    return new int[] {store.get(j), i};
                }
            }
            return new int[] {-1,-1};
        }

    }

    //two sum - when array is sorted
    //using two-pointer approach
    //time = O(n), space = O(1)
    public int[] two_pointer(int[] arr, int target)
    {
        int left=0;
        int right = arr.length-1;
        while(left < right)
        {
            int sum = arr[left] + arr[right];
            if(sum == target)
            {
                return new int[] {left+1, right+1};
            }
            else if(sum > target)
            {
                right --;
            }
            else{
                left ++;
            }
        }
        return new int[]{-1,-1};
    }

public static void main(String args[])
{
    Scanner s = new Scanner(System.in);
    Two_sum obj = new Two_sum();
    int length = s.nextInt();
    int[] arr = new int[length];
    for(int i=0;i<length;i++)
    {
        arr[i] = s.nextInt();
    }
    int target = s.nextInt();
    int[] result = obj.check(arr, target);
    int[] result1 = obj.check(arr, target);
    int[] result2 = obj.check(arr,target);
    System.out.println(result[0] + "," + result[1]);
    System.out.println(result1[0] + "," + result1[1]);
    System.out.println(result2[0] + "," + result2[1]);


    s.close();
}
}
