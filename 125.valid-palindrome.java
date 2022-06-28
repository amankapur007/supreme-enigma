/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }

        s =  s.toLowerCase().trim();
        int start = 0;
        int end = s.length()-1;
        while(start<=end){
            if(isNotCharacter(s.charAt(start)) && isNotCharacter(s.charAt(end))){
                start++;
                end--;
                continue;
            }
            if(isNotCharacter(s.charAt(start))){
                start++;
                continue;
            }else if(isNotCharacter(s.charAt(end))){
                end--;
                continue;
            }
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isNotCharacter(char character) {
        return !(Character.isAlphabetic(character) || Character.isDigit(character));
    }
}
// @lc code=end

