
import java.util.ArrayList;


public class Bst {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    //time complexity = O(H) where H is the Height of the TREE
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;

    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

//time complexity = O(n)

    public static boolean searchNode(Node root, int key) {
        if(root == null){
            return false;
        }
        if(root.data > key){
            return searchNode(root.left, key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return searchNode(root.right, key);
        }
    }

    public static Node delete(Node root,int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{ // root.data == val

            //case 1 
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2 
            if(root.left == null){
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            //case 3

            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public static Node inOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root,int X,int Y){
        if(root == null){
            return;
        }
        if(root.data >= X && root.data<=Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }
        else if(root.data>=Y){
            printInRange(root.left, X, Y);
        }else{
            printInRange(root.right, X, Y);
        }
    }


    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+ " -> ");
        }
        System.out.println("Null");
    }
    public static void printRoot_Leaf(Node root,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }else{
            printRoot_Leaf(root.left, path);
            printRoot_Leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }



    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        System.out.println("Inorder Traversal ");
        inorder(root);
        System.out.println();

        int key = 4;
        System.out.print("Searching for " + key);
        boolean result = searchNode(root, key);
        if(result){
            System.out.println(" Found");
        }else{
            System.out.println(" Not Found");
        }

        System.out.println("Deletion of Node ");
        int del = 4;
        root = delete(root, del);

        inorder(root);
        System.out.println();

        System.out.println("Printing in Range");
        printInRange(root, 3, 7);
        System.out.println();
        inorder(root);
        System.out.println();

        System.out.println("Printing all the Paths from Root to Leaf");
        printRoot_Leaf(root, new ArrayList<>());

    }

}
