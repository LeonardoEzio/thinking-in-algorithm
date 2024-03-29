package leonardo.ezio.personal.leetcode.algorithm.problem.T1_T200;

/**
 * @ClassName : Solution122
 * @Author : LeonardoEzio
 * @Date : 2020-12-17 21:46
 * @Description : Leet code 122题 题解
 *
 *
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 */
public class Solution122 {

    public static int maxProfit(int[] prices) {

        int n = prices.length;

        //存储当天持有或不持有股票时最大的利润
        int[][] profits = new int[n][2];
        //初始化数据
        //第一天不持有
        profits[0][0] = 0;
        //第一天持有
        profits[0][1] = -prices[0];

        for (int i = 1; i<n ; i++){
            //状态转移
            //1.今天持有   昨天持有 今天啥也不做； 昨天未持有 今天买入
            profits[i][1] = Math.max(profits[i-1][1],profits[i-1][0] - prices[i]);
            //2.今天未持有 昨天未持有 今天啥也不做 ；昨天持有 今天卖出
            profits[i][0] = Math.max(profits[i-1][0],profits[i - 1][1] + prices[i]);
        }
        //最后一天未持有收益才是最多
        return profits[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
}
