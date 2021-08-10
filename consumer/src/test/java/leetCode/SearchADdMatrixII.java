package leetCode;


import cn.hutool.core.lang.Console;

/**
 * 搜索二维矩阵 II
 * 描述：编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 *
 示例 1：
 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 输出：true

 示例 2：
 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 输出：false

 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 */
public class SearchADdMatrixII {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Console.log(searchMatrix(matrix, 20));
    }

    /**
     * 二分法搜索
     * 矩阵已经排过序，就需要使用二分法搜索以加快我们的算法。
     * 首先，我们确保矩阵不为空。
     * 那么，如果我们迭代矩阵对角线，从当前元素对列和行搜索，我们可以保持从当前 (row,col)(row,col) 对开始的行和列为已排序。
     * 因此，我们总是可以二分搜索这些行和列切片。
     * 我们以如下逻辑的方式进行 :
     * 在对角线上迭代，二分搜索行和列，直到对角线的迭代元素用完为止（意味着我们可以返回 false ）
     * 或者找到目标（意味着我们可以返回 true ）。
     * binary search 函数的工作原理和普通的二分搜索一样,但需要同时搜索二维数组的行和列。
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // iterate over matrix diagonals
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }

        return false;
    }

    private static boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;

        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
