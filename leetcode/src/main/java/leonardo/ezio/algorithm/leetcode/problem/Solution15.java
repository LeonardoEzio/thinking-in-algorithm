package leonardo.ezio.algorithm.leetcode.problem;

/**
 * @ClassName : Solution15
 * @Author : LeonardoEzio
 * @Date : 2020-09-09 20:15
 * @Description : leetcode 15题
 */
public class Solution15 {

    public static int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        int i = hammingWeight(8);
        System.out.println(i);
    }
}
