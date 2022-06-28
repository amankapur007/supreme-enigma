import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(nums, 0, 3, 0, nums.length-1);
    }

    private static List<List<Integer>> kSum(int[] arr, int target, int n, int start, int end) {
        List<List<Integer>> l = new LinkedList<>();
        if(n<2){
            return l;
        }

        if(n==2){
            return twoSum(arr, target, start, end);
        }
        for(int i=start;i<arr.length-1;i++){
            List<List<Integer>> newL = kSum(arr, target-arr[i], n-1, i+1, end);
            if(newL.size()>0){
                for(List<Integer> l2 : newL){
                    l2.add(arr[i]);
                }
                l.addAll(newL);
            }
            
            while (i < arr.length-1 && arr[i] == arr[i+1]) {
                        i++;
            }
        }

        return l;
    }

    private static List<List<Integer>> twoSum(int[] arr, int target, int start, int end) {
        List<List<Integer>> l =  new LinkedList();
        while(start<end){
            if(arr[start]+arr[end]==target){
                List<Integer> pair =  new LinkedList<>();
                pair.add(arr[start]);
                pair.add(arr[end]);
                l.add(pair);
                while(start<end && arr[start]==arr[start+1]){
                    start++;
                }
                while(start<end && arr[end] == arr[end-1]){
                    end--;
                }
                start++;
                end--;

            }else if(arr[start]+arr[end]>target){
                end--;
            }else{
                start++;
            }
            
        }

        return l;
        
    }
}
// @lc code=end

