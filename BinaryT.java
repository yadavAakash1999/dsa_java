public class BinaryT {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
    public static Node buildtree(int nodes[]){
        idx++;
        if(nodes[idx]==-1) return null;
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildtree(nodes);
        newNode.right = buildtree(nodes);
        return newNode;
    }
    }
    //Count of Nodes
    public static int countOfNodes(Node root){
        if(root== null) return 0;
        int sumLeft = countOfNodes(root.left);
        int sumRight = countOfNodes(root.right);
        return sumLeft+sumRight+1;
    }
    //Sum of Nodes
    public static int sumOfNodes(Node root){
        if(root== null) return 0;
        int sumLeft = sumOfNodes(root.left);
        int sumRight = sumOfNodes(root.right);
        return sumLeft+sumRight+root.data;
    }

    //Height of Tree
    public static int height(Node root) {
        if(root==null) return 0;
        int leftheight = height(root.left);
        int rightheight = height(root.right);

        return Math.max(leftheight, rightheight) + 1;
    }

    // Maximum Diameter   T.C = O(n^2)
    public static int maxDiamer(Node root) {
        if(root==null) return 0;
        int dia1 = maxDiamer(root.left);
        int dia2 = maxDiamer(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;
        return Math.max(dia1 ,Math.max(dia2, dia3));
    }   

    static class Treeinfo{
        int diam;
        int ht;
         Treeinfo(int diam , int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Treeinfo OptimisedDia(Node root) {
        if(root==null){
             return new Treeinfo(0, 0);
        }
        Treeinfo leftT = OptimisedDia(root.left);        
        Treeinfo rightT = OptimisedDia(root.right);        
        int myHeight = Math.max(leftT.ht , rightT.ht) +1;
        int diam1 = leftT.diam;
        int diam2 = rightT.diam;
        int diam3 = leftT.ht + rightT.ht + 1;

        int myDia = Math.max(diam1, Math.max(diam2, diam3));
        return new Treeinfo(myDia, myHeight);
    }
public static void main(String[] args) {
    int nodes[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1} ;
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildtree(nodes);
    // System.out.println(root.data);
    // System.out.println(countOfNodes(root));
    // System.out.println(sumOfNodes(root));
    // System.out.println(height(root));
    System.out.println(maxDiamer(root));
    System.out.println(OptimisedDia(root).diam);
}
}
