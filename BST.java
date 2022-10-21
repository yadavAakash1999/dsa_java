import java.util.ArrayList;

import javax.sql.rowset.spi.SyncResolver;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

     Node(int data){
        this.data = data;
     }
    }

public static Node insertNode(Node root, int val) {
    if(root == null){
         root = new Node(val);
        return root;
    }
    if(root.data>val){
        root.left = insertNode(root.left, val);
        
    }
    else{
        root.right = insertNode(root.right, val);
    }
    return root;
}

public static void inorder(Node root) {
    if(root==null) return;
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
}

public static boolean search(Node root , int key) {
    if(root == null) return false;
    if(root.data>key) return search(root.left, key);
    else if(root.data==key) return true;
    else return search(root.right, key);
}

public static Node delete(Node root , int key) {
    if(root.data> key){
        root.left = delete(root.left, key);
       
    }
    else if(root.data<key){
        root.right = delete(root.right, key);
    }
    else{
        if(root.left==null && root.right==null){
            return null;
        }
        if(root.left== null){
            return root.right;
        }
        else if(root.right== null){
            return root.left;
        }

        Node IS = inorderSuccessor(root.right);
        root.data = IS.data;
        root.right =delete(root.right, IS.data);
    }
    return root;
}

public static Node inorderSuccessor(Node root) {
    while(root.left!= null){
        root = root.left;
    }
    return root;
}

public static void printInRange(Node root, int x, int y) {
    if(root==null) return ;
    if(root.data>=x && root.data<=y){
        printInRange(root.left, x, y);
        System.out.print(root.data +" ");
        printInRange(root.right, x, y);
    }
    else if(root.data<=x){
        printInRange(root.right, x, y);
    }
    else{
        printInRange(root.left, x, y);
    }
}
public static void printpath(ArrayList<Integer> path) {
    for(int i=0; i<path.size(); i++){
        System.out.print(path.get(i)+"-->");
    }
    System.out.println();
}
public static void root2leaf(Node root, ArrayList<Integer> path) {
    if(root==null) return;
    path.add(root.data);
    if(root.left==null && root.right==null){
        printpath(path);
    }
    else{
        root2leaf(root.left, path);
        root2leaf(root.right, path);
    }
    path.remove(path.size()-1);
}

    public static void main(String[] args) {
        int value[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i : value){
           root= insertNode(root, i);
        }
        inorder(root);
        System.out.println();
        // System.out.print(search(root, 44));
        // delete(root, 5);
        // inorder(root);
        // printInRange(root, 3, 7);
        root2leaf(root, new ArrayList<>());
    }
}
