/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    public static int minTime(Node root, int target) {
        // code here
        Map<Node, Node> parent_map = new HashMap<>();
        Node target_node = bfsToMapParent(root, target, parent_map);
        return calculateTime(target_node, parent_map);
    }
    
    private static int calculateTime(Node target,  Map<Node, Node> parent_map)
    {
        Map<Node, Integer> visited = new HashMap<>();
        Queue<Node> qu = new LinkedList<>();
        qu.offer(target);
        visited.put(target, 1);
        boolean spread = false;
        int time = 0;
        while(!qu.isEmpty())
        {
            int size = qu.size();
            spread = false;
            for(int i = 0; i < size; i++)
            {
                Node top = qu.poll();
                if(top.left != null && !visited.containsKey(top.left))
                {
                    qu.offer(top.left);
                    visited.put(top.left, 1);
                    spread = true;
                }
                
                if(top.right != null && !visited.containsKey(top.right))
                {
                    qu.offer(top.right);
                    visited.put(top.right, 1);
                    spread = true;
                }
                
                if(parent_map.containsKey(top) && !visited.containsKey(parent_map.get(top)))
                {
                    qu.offer(parent_map.get(top));
                    visited.put(parent_map.get(top), 1);
                    spread = true;
                }
                
            }
            
            if(spread)
                time++;
        }
        return time;
    }
    
    private static Node bfsToMapParent(Node root, int target, Map<Node, Node> parent_map)
    {
        Queue<Node> qu = new LinkedList<>();
        
        qu.offer(root);
        Node target_node = null;
        while(!qu.isEmpty())
        {
            Node top = qu.poll();
            if(top.data == target)
                target_node = top;
            if(top.left != null)
            {
                qu.offer(top.left);
                parent_map.put(top.left, top);
            }
            if(top.right != null)
            {
                qu.offer(top.right);
                parent_map.put(top.right, top);
            }
        }
        
        return target_node;
    }
}