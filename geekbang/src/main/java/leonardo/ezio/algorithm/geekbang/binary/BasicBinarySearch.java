package leonardo.ezio.algorithm.geekbang.binary;

/**
 * @ClassName : BasicBinarySearch
 * @Author : LeonardoEzio
 * @Date : 2020-09-08 22:25
 * @Description : 基础的二分查找
 */
public class BasicBinarySearch {


    /**
    * description : <二分查找>
    *
    * @methodName : binarySearch
    * @param arr 数组
    * @param beginIndex 开始位置
    * @param endIndex 结束位置
    * @param num  要查找的数
    * @return {@link int } 结果下标
    * @date : 2020/9/8 22:27
    *
    *
    **/
    public static int binarySearch(int [] arr, int beginIndex, int endIndex, int num){
        //不能采用>=要不然数据会不准确
        if (beginIndex>endIndex){
            return -1;
        }
        int midIndex = ((endIndex-beginIndex)>>1)+beginIndex;
        if (arr[midIndex] == num){
            return midIndex;
        }else if (arr[midIndex]>num){
            return binarySearch(arr, beginIndex, midIndex-1,num);
        }else {
            return binarySearch(arr, midIndex+1, endIndex, num);
        }
    }


    /**
    * description : <二分查找,优化了mid的计算防止下标越界>
    *
    * @methodName : binarySearchOptimize
    * @param a 数组元素
    * @param low 起始下标
    * @param high 结束下标
    * @param value 要查找的值
    * @return {@link int } 结果下标
    * @date : 2020/9/8 22:35
    **/
    private static int binarySearchOptimize(int[] a, int low, int high, int value) {
        if (low > high){
            return -1;
        }
        int mid =  low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] > value) {
            return binarySearchOptimize(a, low, mid-1, value);
        } else {
            return binarySearchOptimize(a, mid+1, high, value);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 5, 6, 8, 9, 12, 13, 15, 19, 20,21};
        int result1 = binarySearch(arr, 0, arr.length - 1, 13);
        int result2 = binarySearchOptimize(arr, 0, arr.length - 1, 13);
        System.out.println(result1);
        System.out.println(result2);
    }
}
