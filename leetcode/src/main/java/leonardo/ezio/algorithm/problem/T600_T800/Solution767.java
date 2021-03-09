package leonardo.ezio.algorithm.problem.T600_T800;

import java.util.PriorityQueue;

/**
 * @ClassName : Solution767
 * @Author : LeonardoEzio
 * @Date : 2021-01-07 23:04
 * @Description : Leet code 767题 题解
 *
 *
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 */
public class Solution767 {

    public String reorganizeString(String S) {
        int len = S.length();
        if (len < 2){
            return S;
        }
        int maxCount = 0 ;
        int[] counts = new int[26];
        for (int i = 0 ; i < len ; i++){
            char c = S.charAt(i);
            counts[c-'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (len+1)/2){
            return "";
        }
        PriorityQueue<Character> chars = new PriorityQueue<>(((o1, o2) -> {
            return counts[o2 - 'a'] - counts[o1 - 'a'];
        }));
        for (char c = 'a' ; c<= 'z' ; c++){
            if (counts[c-'a']>0){
                chars.offer(c);
            }
        }
        StringBuffer resultBuf = new StringBuffer();
        while (chars.size() > 1){
            char first = chars.poll();
            char second = chars.poll();
            resultBuf.append(first).append(second);
            //减数量
            counts[first-'a']--;
            counts[second-'a']--;
            //重新将字符放回队列
            if (counts[first-'a']>0){
                chars.offer(first);
            }
            if (counts[second-'a']>0){
                chars.offer(second);
            }
        }
        if (chars.size()>0){
            resultBuf.append(chars.poll());
        }
        return resultBuf.toString();
    }

    public static void main(String[] args) {
        Solution767 solution767 = new Solution767();
        String result = solution767.reorganizeString("aaab");
        System.out.println(result);
    }
}
