/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
     int[] alpha = new int[26];
     for(char c:s.toCharArray()){
         int index = c - 'a';
         alpha[index]++;
     } ;
     for(char c:t.toCharArray()){
        int index = c - 'a';
        alpha[index]--;
    } ;
    for(int n:alpha){
        if(n!=0){
            return false;
        }
    }
    return true;
    }
}
// @lc code=end

