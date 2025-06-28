class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[] color = new int[v];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        constructGraph(map, v, m, edges);
        return canColor(v, edges, m, 0, color, map);
    }
    private boolean canColor(int v, int[][] edges, int m, int start, int[] color,  Map<Integer, ArrayList<Integer>> map)
    {
        if(start == v)
            return true;
            
        for(int i = 1; i <= m; i++)
        {
            if(isPossible(start, edges, i, color, map))
            {
                color[start] = i;
                if(canColor(v, edges, m, start+1, color, map))
                    return true;
                color[start] = 0;
            }
        }
        return false;
    }
    private boolean isPossible(int node, int[][] edges, int color, int[] colors,  Map<Integer, ArrayList<Integer>> map)
    {
        ArrayList<Integer> neighbours = map.get(node);
        
        for(int nei : neighbours)
        {
            if(colors[nei] == color)
                return false;
        }
        return true;
    }
    
    private void constructGraph(Map<Integer, ArrayList<Integer>> map, int v, int m, int[][] edges)
    {
        for(int i = 0; i < v; i++)
        {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
    }
}