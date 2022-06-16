/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
                 int product = 1;
                int countZero = 0;
                for (int n : nums) {
                    if (n != 0) {
                        product *= n;
                    } else {
                        countZero++;
                    }
                    ;
                }
                int res[] = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    if(countZero>1){
                        res[i] = 0;
                    }
                    else{
                        if (nums[i] != 0) {
                            res[i] = countZero!=0 ? 0 : product / nums[i];
                        } else {
                            res[i] = product;
                        }
                    }
                    
                }
                return res;
    }
}
// @lc code=end

