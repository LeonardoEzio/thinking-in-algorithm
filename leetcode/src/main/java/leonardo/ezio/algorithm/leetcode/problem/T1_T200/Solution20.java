package leonardo.ezio.algorithm.leetcode.problem.T1_T200;

import java.util.Stack;

/**
 * @ClassName : Solution20
 * @Author : LeonardoEzio
 * @Date : 2020-11-28 12:35
 * @Description : Leet code 20题 题解
 *
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 采用栈协助，若栈顶元素不是相反括号则入栈，否则则出栈，最后栈为空则说明括号是有效括号
 */
public class Solution20 {


    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            char matchC = ' ';
            if (c == ')'){
                matchC = '(';
            }
            if (c == '}'){
                matchC = '{';
            }
            if (c == ']'){
                matchC = '[';
            }
            if (stack.isEmpty() || !stack.peek().equals(matchC)){
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("[]{()[]}");
        System.out.println(valid);
    }
}
