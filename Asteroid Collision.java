class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids)
        {
            if(asteroid > 0)
                st.push(asteroid);
            else
            {
               while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroid))
                    st.pop();
                if(!st.isEmpty() && st.peek() == Math.abs(asteroid))
                    st.pop();
                else if(st.isEmpty() || st.peek() < 0)
                    st.push(asteroid);

            }
        }
        int[] res = new int[st.size()];
        int idx = st.size() - 1;
        while(!st.isEmpty())
        {
            res[idx--] = st.pop();
        }
        return res;
    }
}