class Solution {
    private boolean checkPalindrome(String s, int start, int end) {
        while((start < end) && (s.charAt(start) == s.charAt(end))) {
            start++;
            end--;
        }
        return start >= end;
    }
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return checkPalindrome(s, start+1, end) || checkPalindrome(s, start, end-1);
            }
        }
        return true;
    }
}