1class Solution {
2    public String smallestSubsequence(String s) {
3        Stack<Character> st = new Stack<>();
4        int[] freq = new int[26];
5        boolean[] v = new boolean[26];
6        char[] ca = s.toCharArray();
7        for(int i=0;i<s.length();i++){
8            char c = s.charAt(i);
9            freq[c-'a']++;
10        }
11        st.push(ca[0]);
12        v[ca[0]-'a'] = true;
13        freq[ca[0]-'a']--;
14        for(int i=1;i<s.length();i++){
15            char curr = s.charAt(i);
16            freq[curr-'a']--;
17            if(v[curr-'a']) continue;
18            while(!st.isEmpty()&&curr < st.peek() && freq[st.peek()-'a'] > 0){
19                v[st.peek()-'a'] = false;
20                st.pop();
21            }
22            v[curr-'a'] = true;
23            st.add(curr);
24        }
25        StringBuilder sb = new StringBuilder();
26        while(!st.isEmpty()){
27            sb.append(st.pop());
28        }
29        sb.reverse();
30        return sb.toString();
31    }
32}