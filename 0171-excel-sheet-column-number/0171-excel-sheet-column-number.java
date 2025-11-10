import java.util.HashMap;

class Solution {
    public int titleToNumber(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            int value = ch - 'A' + 1;
            map.put(ch, value);
        }

        // convert to char array
        char[] arr = s.toCharArray();

        // reverse the array
        reverseString(arr);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + map.get(arr[i]) * (int)Math.pow(26, i);
        }
        return sum;
    }
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
