package leonardo.ezio.algorithm.leetcode.problem;

/**
 * @ClassName : Solution121
 * @Author : LeonardoEzio
 * @Date : 2020-12-17 21:11
 * @Description : Leet code 121题 题解
 *
 *
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 */
public class Solution121 {

    public static int maxProfit(int[] prices) {
        if (prices.length <=0){
            return 0;
        }
        int minPrice = prices[0];
        int maxProfix = 0;
        for (int i = 0 ; i<prices.length ; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            if (prices[i]-minPrice > maxProfix){
                maxProfix = prices[i] -minPrice;
            }
        }
        return maxProfix;
    }

    public static int maxProfit2(int[] prices){
        int n = prices.length;
        int [][] profits = new int[n][2];
        //第一天 不持股
        profits[0][0] = 0;
        //第一天 持股
        profits[0][1] = -prices[0];
        for (int i =1; i<n ; i++){
            //状态转移
            //1.今天不持股  昨天不持股 ； 昨天持股，今天卖出
            profits[i][0] = Math.max(profits[i - 1][0], prices[i] + profits[i - 1][1]);
            //2.今天持股    昨天持股，今天啥都不做 ；昨天不持股 ， 今天买入
            profits[i][1] = Math.max(profits[i - 1][1], - prices[i]);
        }
        return profits[n - 1][0];
    }

    public static void main(String[] args) {
        int[] price = new int[]{7,6,4,3,1};
//        int i = maxProfit(price);
        int i = maxProfit2(price);
        System.out.println(i);
    }
}
