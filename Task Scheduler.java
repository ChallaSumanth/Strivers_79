class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] char_freq = new int[26];
        for(char c : tasks)
            char_freq[c - 'A']++;
        Arrays.sort(char_freq);
        int max_value = char_freq[25] - 1;
        int chunks = max_value * n;

        for(int i = 24; i >= 0; i--)
        {
            chunks -= Math.min(max_value, char_freq[i]);
        }
        return chunks < 0 ? tasks.length : chunks + tasks.length;
    }
}