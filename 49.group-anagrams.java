import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map =  new HashMap();
        for(String str: strs){
            String s = encode(str);
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }   
            map.get(s).add(str);
        }
        List<List<String>> result =  new ArrayList<>();
        for(List<String> l:map.values()){
            result.add(l);
        }
        return result;
    }

    private String encode(String str) {
        int c[] = new int[127];
        for(char chr:str.toCharArray()){
            int index = chr-'a';
            c[index]++;
        }
        return Arrays.toString(c);
    }
}
// @lc code=end

