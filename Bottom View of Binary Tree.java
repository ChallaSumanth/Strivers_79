

//User function Template for Java
class Pair{
    Node node;
    int level;
    Pair(Node node,int level)
    {
        this.node = node;
        this.level = level;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList <Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair> qu = new LinkedList<>();
        Map<Integer,Node> map = new TreeMap<>();
        qu.offer(new Pair(root,0));
        while(!qu.isEmpty())
        {
            Pair p = qu.poll();
            Node head = p.node;
            int level = p.level;
            map.put(level,head);
            if(head.left != null)
                qu.offer(new Pair(head.left,level-1));
            if(head.right != null)
                qu.offer(new Pair(head.right,level+1));
        }
        for(Map.Entry<Integer,Node> mp : map.entrySet())
            ans.add(mp.getValue().data);
        return ans;
    }
}