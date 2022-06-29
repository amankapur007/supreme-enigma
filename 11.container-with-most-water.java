/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max = -1;
        int start=0;
        int end = height.length-1;
        while(start<end){
            int diff = end-start;
            int area = diff*Math.min(height[start], height[end]);
            max=Math.max(max, area);
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return max;   
    }
}
// @lc code=end

