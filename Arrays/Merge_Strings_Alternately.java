class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer sf = new StringBuffer();
        int i = 0, j = 0;
        while(i < word1.length() || j < word2.length()) {
            if(i >= word1.length()) {
                sf.append(word2.charAt(j));
                j++;
            } else if(j >= word2.length()) {
                sf.append(word1.charAt(i));
                i++;
            } else {
                sf.append(word1.charAt(i));
                sf.append(word2.charAt(j));
                i++;
                j++;
            }
        }
        return sf.toString();
    }
}