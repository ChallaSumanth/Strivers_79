// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class NodeValue{
    
    int minNode, maxNode, maxSize;
    
    NodeValue(int minNode, int maxNode, int maxSize)
    {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}
class Solution {

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        return largestBstHelper(root).maxSize;
    }
    
    private static NodeValue largestBstHelper(Node root)
    {
        if(root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            
        NodeValue left =largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);
        
        if(left.maxNode < root.data && root.data < right.minNode)
        {
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), left.maxSize + right.maxSize + 1);
        }
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    
}