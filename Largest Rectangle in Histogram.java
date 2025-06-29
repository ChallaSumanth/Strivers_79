class Solution {
    public int largestRectangleArea(int[] heights) {
        int largestArea = 0;
        int len = heights.length;
        for(int i = 0; i < len; i++)
        {
            int minHeight = (int)1e9;
            for(int j = i; j < len; j++)
            {
                minHeight = Math.min(minHeight, heights[j]);
                largestArea = Math.max(largestArea, minHeight *(j - i + 1));
            }
        }
        return largestArea;
    }
}
----------------------
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftSmall = new int[len];
        int[] rightSmall = new int[len];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < len; i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();

            if(st.isEmpty())
                leftSmall[i] = 0;
            else
                leftSmall[i] = st.peek() + 1;
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        for(int i = len - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            
            if(st.isEmpty())
                rightSmall[i] = len - 1;
            else
                rightSmall[i] = st.peek() - 1;

            st.push(i);
        }
        int maxArea = 0;
        for(int i = 0; i < len; i++)
        {
            maxArea = Math.max(maxArea, (rightSmall[i] - leftSmall[i] + 1) *  heights[i]);
        }

        return maxArea;
    }
}