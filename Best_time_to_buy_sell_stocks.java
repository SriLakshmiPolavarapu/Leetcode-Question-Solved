import java.util.Scanner;
import java.util.Stack;

public class Best_time_to_buy_sell_stocks {
    
    //bruteforce method
    public int diff_stock(int[] prices)
    {
        int profit = 0;
        int res = 0;
        for(int i=0;i<prices.length-1;i++)
        {
           for(int j=i+1;j<prices.length;j++)
           {
                profit = prices[j] - prices[i];
                res = Math.max(res, profit);
           }
        }
        return res;
    }

    //optimized code
    public int diff_stocks_1(int[] prices)
    {
        int minValue = Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<prices.length-1;i++)
        {
            if(minValue > prices[i])
            {
                minValue = prices[i];
            }
            else
            {
                profit = Math.max(profit, prices[i] - minValue);
            }
        }
        return profit;
        
    }

    //stack method
    public int diff_stock_stack(int[] prices)
    {
        Stack<Integer> stack = new Stack<>();
        int maxProfit=0;
        for(int i=0;i<prices.length;i++)
        {
        
        while(!stack.isEmpty() && prices[i] > prices[stack.peek()])
        {
            int buy = stack.pop();
            int profit = prices[i] - prices[buy];
            maxProfit = Math.max(maxProfit, profit);
        }
        stack.push(i);
    }
        return maxProfit;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Best_time_to_buy_sell_stocks obj = new Best_time_to_buy_sell_stocks();
        int length = s.nextInt();
        int[] prices = new int[length];
        for(int i=0;i<prices.length;i++)
        {
            prices[i] = s.nextInt();
        }
        int result = obj.diff_stock(prices);
        int result1 = obj.diff_stocks_1(prices);
        int result2 = obj.diff_stock_stack(prices);


        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);


        s.close();
    }
}
