import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map =  new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                int n = map.get(i);
                map.put(i, n+1);
            }else{
                map.put(i, 1);
            }
        }
        List<Integer>[] buckets = new List[nums.length+1];


        for(Integer key : map.keySet()){
            int freq =  map.get(key);
            if(buckets[freq]==null){
                buckets[freq]=new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=buckets.length-1;i>=0&&result.size()!=k;i--){
            if(buckets[i]!=null){
                result.addAll(buckets[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

