import java.util.Iterator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        PriorityQueue<Integer> queue =  new PriorityQueue<>();
        int max = 0;
        for(int i:nums){
            queue.add(i);
        }

        int count=0;
        int prev = queue.peek();
        int k=1;
        Iterator<Integer> itr =  queue.iterator();
        while(itr.hasNext()){
            int curr =  itr.next();
           if(prev==curr){
               continue;
           }
           else if((prev+1)==curr){
               count++;
               max=  Math.max(max, count);
           }else{
               count=0;
           }
           prev=curr;
        }
        return max+1;
    }
}
// @lc code=end

