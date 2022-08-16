import org.junit.Test;

import java.util.TreeSet;

public class AkunaOA_1 {
    class Solution {

        class NumArray {
            int[] treeArray;

            private int lowBit(int x) {
                return x & -x;
            }

            private void add(int x, int val) {
                for (int i = x; i <= n; i += lowBit(i)) {
                    treeArray[i] += val;
                }
            }

            private int query(int x) {
                int res = 0;
                for (int i = x; i > 0; i -= lowBit(i)) {
                    res += treeArray[i];
                }
                return res;
            }

            int n;
            int[] datas;

            public NumArray(int[] nums) {
                n = nums.length;
                datas = nums;
                treeArray = new int[n + 10];
                for (int i = 0; i < n; i++) {
                    add(i + 1, nums[i]);
                }
            }

            public void update(int index, int val) {
                add(index + 1, val);
                datas[index] = val;
            }

            public int sumRange(int left, int right) {
                return query(right + 1) - query(left);
            }
        }


        int get(int[] arr, int l, int r) {
            int n = arr.length;
            int[] nums = new int[100001];
            NumArray numArray = new NumArray(nums);
            int res = 0;
            for (int i : arr) {
                int left = l - i;
                int right = r - i;
                res += numArray.sumRange(left, right);
                numArray.update(i, 1);
            }
            return res;
        }


    }
    @Test
    public void test() {
        Solution s = new Solution();
        System.out.println(s.get(new int[]{2, 3, 4, 5}, 5, 7));
    }
    @Test
    public void test2(){
        int a = 9;
        System.out.println(a&-a);
    }

}
