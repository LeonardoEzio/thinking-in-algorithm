package leonardo.ezio.algorithm.offer;

/**
 * @ClassName : Offer29
 * @Author : LeonardoEzio
 * @Date : 2020-08-21 21:38
 * @Description : LeetCode剑指offer 29题解
 *
 *  剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 通过次数52,643提交次数117,390
 *
 *
 */
public class Offer29 {

    //[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    private int count = 0;

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Offer29 offer29 = new Offer29();
        int[] ints = offer29.spiralOrder(arr);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

    /**
    * @description <顺时针遍历矩阵>
    *
    * @name : spiralOrder
    * @param : matrix
    * @return : int[]
    * @date : 2020/8/21 22:02
    **/
    public int[] spiralOrder(int[][] matrix) {
        int indexX = matrix.length == 0 ? 0 : matrix.length;
        if (indexX ==0){
            return new int[0];
        }
        int indexY = matrix[0].length == 0 ? 0 : matrix[0].length;
        int[] result = new int[indexX * indexY];
        int topIndex = 0;
        int footIndex = matrix.length-1;

        int leftIndex = 0;
        int rightIndex = matrix[0].length-1;
        leftToRight(leftIndex,rightIndex,topIndex,footIndex,result,matrix);
        return result;
    }

    /**
    * @description <从左往右遍历>
    *
    * @name : leftToRight
    * @param : leftIndex
    * @param : rightIndex
    * @param : topIndex
    * @param : footIndex
    * @param : result
    * @param : matrix
    * @return : void
    * @date : 2020/8/21 22:02
    **/
    public void leftToRight (int leftIndex,int rightIndex,int topIndex,int footIndex,int [] result,int [][] matrix){
        System.out.println("before left to right :  leftIndex  = "+leftIndex+" ; rightIndex  = "+rightIndex+" ; topIndex = "+topIndex+" ; footIndex = "+footIndex);
        for (int i = leftIndex;i<= rightIndex; i++){
            System.out.println("["+topIndex+"]["+i+"]");
            result[count] = matrix[topIndex][i];
            count++;
        }
        topIndex++;
        System.out.println("after left to right :  leftIndex  = "+leftIndex+" ; rightIndex  = "+rightIndex+" ; topIndex = "+topIndex+" ; footIndex = "+footIndex);
        if (topIndex<=footIndex){
            topToFoot(leftIndex,rightIndex,topIndex,footIndex,result,matrix);
        }
    }

    /**
    * @description <从上往下遍历>
    *
    * @name : topToFoot
    * @param : leftIndex
    * @param : rightIndex
    * @param : topIndex
    * @param : footIndex
    * @param : result
    * @param : matrix
    * @return : void
    * @date : 2020/8/21 22:03
    **/
    public void topToFoot(int leftIndex,int rightIndex,int topIndex,int footIndex,int [] result,int [][] matrix){
        System.out.println("before top to foot :  leftIndex  = "+leftIndex+" ; rightIndex  = "+rightIndex+" ; topIndex = "+topIndex+" ; footIndex = "+footIndex);
        for (int i = topIndex; i<=footIndex;i++){
            System.out.println("["+i+"]["+rightIndex+"]");
            result[count] = matrix[i][rightIndex];
            count++;
        }
        rightIndex--;
        System.out.println("after top to foot :  leftIndex  = "+leftIndex+" ; rightIndex  = "+rightIndex+" ; topIndex = "+topIndex+" ; footIndex = "+footIndex);
        if (leftIndex<=rightIndex){
            rightToLeft(leftIndex,rightIndex,topIndex,footIndex,result,matrix);
        }
    }

    /**
    * @description <从右往左遍历>
    *
    * @name : rightToLeft
    * @param : leftIndex
    * @param : rightIndex
    * @param : topIndex
    * @param : footIndex
    * @param : result
    * @param : matrix
    * @return : void
    * @date : 2020/8/21 22:03
    **/
    public void rightToLeft(int leftIndex, int rightIndex, int topIndex, int footIndex, int [] result,int [][] matrix){
        System.out.println("before right to left :  leftIndex  = "+leftIndex+" ; rightIndex  = "+rightIndex+" ; topIndex = "+topIndex+" ; footIndex = "+footIndex);
        for (int i = rightIndex ; i>= leftIndex; i--){
            System.out.println("["+footIndex+"]["+i+"]");
            result[count] = matrix[footIndex][i];
            count++;
        }
        footIndex--;
        System.out.println("after right to left :  leftIndex  = "+leftIndex+" ; rightIndex  = "+rightIndex+" ; topIndex = "+topIndex+" ; footIndex = "+footIndex);
        if (topIndex<=footIndex){
            footToTop(leftIndex,rightIndex,topIndex,footIndex,result,matrix);
        }
    }

    /**
    * @description <从下往上遍历>
    *
    * @name : footToTop
    * @param : leftIndex
    * @param : rightIndex
    * @param : topIndex
    * @param : footIndex
    * @param : result
    * @param : matrix
    * @return : void
    * @date : 2020/8/21 22:03
    **/
    public void footToTop(int leftIndex,int rightIndex,int topIndex,int footIndex,int [] result,int [][] matrix){
        System.out.println("before foot to top :  leftIndex  = "+leftIndex+" ; rightIndex  = "+rightIndex+" ; topIndex = "+topIndex+" ; footIndex = "+footIndex);
        for (int i = footIndex; i>=topIndex ; i--){
            System.out.println("["+i+"]["+leftIndex+"]");
            result[count] = matrix[i][leftIndex];
            count++;
        }
        leftIndex++;
        System.out.println("after foot to top :  leftIndex  = "+leftIndex+" ; rightIndex  = "+rightIndex+" ; topIndex = "+topIndex+" ; footIndex = "+footIndex);
        if (leftIndex<=rightIndex){
            leftToRight(leftIndex,rightIndex,topIndex,footIndex,result,matrix);
        }
    }
}
