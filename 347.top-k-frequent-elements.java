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
        List<Map.Entry<Integer, Integer>> l =  new LinkedList<>(map.entrySet());
        l.sort((Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)->{
            if(o1.getValue()<o2.getValue()){
                return 1;
            }else if(o1.getValue()==o2.getValue()){
                return 0;
            }else{
                return -1;
            }
        });
        int result[] = new int[k];
        int i=0;
        for(Map.Entry<Integer, Integer> e:l){
            result[i]=e.getKey();
            i++;
            if(i==k){
                break;
            }
        }
        return result;
    }
}
// @lc code=end

