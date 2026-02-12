
import java.util.LinkedList;
import java.util.Queue;

public class build {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class preorder_Build {

        static int indx = -1;

        public static Node buildTree(int[] nodes) {
            indx++;
            if (nodes[indx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[indx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
//time complexity = o(n)

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
//time complexity = o(n)

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");

            inorder(root.right);
        }
//time complexity = o(n)

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        //time complexity = o(n)
        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }

                }
            }

        }

        public static int sumatKnode(Node root, int k) {
            Queue<Node> q = new LinkedList<>();
            if (root == null) {
                return 0;
            }
            q.add(root);
            int level = 0;
            int sum = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node currNode = q.remove();
                    if (level == k) {
                        sum += currNode.data;
                    }
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }

                }
                level++;
                if (level > k) {
                    break;
                }

            }
            return sum;
        }

//searching a node time complexity = O(n)

public static boolean searchNode(Node root,int key){
    if(root == null){
        return false;
    }

    if(root.data == key){
        return true;
    }

    boolean foundLeft = searchNode(root.left, key);
    boolean foundRight = searchNode(root.right, key);

    return foundLeft || foundRight;

}

        //time complexity = o(n)
        public static int countNodes(Node root) {
            if (root == null) {
                return 0;
            }

            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return leftCount + rightCount + 1;

        }

        //time complexity = o(n)
        public static int sumNodes(Node root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sumNodes(root.left);
            int rightSum = sumNodes(root.right);
            return leftSum + rightSum + root.data;
        }

//time complexity = o(n)
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int myHeight = Math.max(leftHeight, rightHeight) + 1;
            return myHeight;
        }

//time complexity = o(n^2)
        public static int diameter(Node root) {
            if (root == null) {
                return 0;
            }

            int leftd = diameter(root.left);
            int rightd = diameter(root.right);
            int height = height(root.left) + height(root.right) + 1;

            return Math.max(height, Math.max(leftd, rightd));

        }

        //time-complexity = o(n)
        static class TreeInfo {

            public int ht;
            public int diam;

            public TreeInfo(int ht, int diam) {
                this.ht = ht;
                this.diam = diam;
            }
        }

        public static TreeInfo diameter2(Node root) {
            if (root == null) {
                return new TreeInfo(0, 0);
            }

            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);
            int myHeight = Math.max(left.ht, right.ht) + 1;

            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.ht + right.ht + 1;

            int myDiam = Math.max(Math.max(diam1, diam2), diam3);
            TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
            return myInfo;

        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        preorder_Build pBuild = new preorder_Build();
        Node root = pBuild.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("PREORDER TRAVERSAL");
        preorder_Build.preorder(root);
        System.out.println();
        System.out.println("INORDER TRAVERSAL");
        preorder_Build.inorder(root);
        System.out.println();
        System.out.println("POSTORDER TRAVERSAL");
        preorder_Build.postorder(root);
        System.out.println();
        System.out.println("LEVELORDER TRAVERSAL");
        preorder_Build.levelorder(root);
        System.out.println("Finding Sum of Nodes at K level = " + preorder_Build.sumatKnode(root, 2));
        int key = 3;
        System.out.println(key+" Node found = " + preorder_Build.searchNode(root, key));
        System.out.println("Count of Nodes = " + preorder_Build.countNodes(root));
        System.out.println("Sum of Nodes = " + preorder_Build.sumNodes(root));
        System.out.println("Height of Tree = " + preorder_Build.height(root));
        System.out.println("Diameter of Tree = " + preorder_Build.diameter(root));
        System.out.println("Diameter of Tree in Linear Time complexity = " + preorder_Build.diameter2(root).diam);

    }

}
