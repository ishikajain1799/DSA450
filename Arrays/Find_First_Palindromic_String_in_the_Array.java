class Solution {
    private boolean isPalindrome(String word) {
        int start = 0, end = word.length() - 1;
        while((start < end) && (word.charAt(start) == word.charAt(end))) {
            start++;
            end--;
        }
        return start >= end;
    }
    public String firstPalindrome(String[] words) {
        for(String word: words) {
            if(isPalindrome(word)) return word;
        }
        return "";
    }
}