import java.util.Scanner;
import java.util.Stack;

public class Reverse_string {
    

    //Time complexity = O(n)
    //Space complexity = O(n)
    public char[] check_rev(char[] arr)
    {
        Stack<Character> stack = new Stack<>();
        char[] res = new char[arr.length];

        for(int i=0;i<arr.length;i++)
        {
           stack.push(arr[i]);
        }
        for(int i=0;i<arr.length;i++)
        {
           if(!stack.empty())
           {
                res[i] = stack.pop();
           }
           else{
            System.out.println("errr");
           }
        }
        return res;
    }

    //Time complexity = O(n)
    //Space complexity = O(1)
    public void two_pointer_technique(char[] arr)
    {
        int left=0, right = arr.length-1;
        while(left < right)
        {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Reverse_string obj = new Reverse_string();
        int length = s.nextInt();
        char[] arr = new char[length];
        for(int i=0;i<length;i++)
        {
            arr[i] = s.next().charAt(0);
        }
        char[] result = obj.check_rev(arr);
        obj.two_pointer_technique(arr);
        System.out.println("method 1" + new String (result));
        System.out.println("method 2" + new String (arr));

        s.close();

        
    }
}
