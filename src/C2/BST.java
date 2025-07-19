package C2;

public class BST {
    public static class node {
        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void insert(int data) {
            if (data <= this.data) {
                if (this.left == null) {
                    this.left = new node(data);
                } else {
                    this.left.insert(data);
                }
            } else {
                if (this.right == null) {
                    this.right = new node(data);
                } else {
                    this.right.insert(data);
                }
            }
        }

        public void search(node node, int key) {
            if (node == null) {
                System.out.println("NOT FOUND");
                return;
            }

            if (key == node.data) {
                System.out.println("Found the entered key: " + key);
                return;
            }

            if (key < node.data) {
                System.out.println("Searching in the left subtree...");
                search(node.left, key);
            } else {
                System.out.println("Searching in the right subtree...");
                search(node.right, key);
            }
        }

        public void inorder(node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }

        public void preorder(node root) {
            if (root == null) {
                return;
            }
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }

        public void postorder(node root) {
            if (root == null) {
                return;
            }
            System.out.println(root.data);
            postorder(root.left);
            postorder(root.right);
        }

        public int getheight(node node) {
            if (node == null) {
                return -1;
            }
            int leftheight = getheight(node.left);
            int rightheight = getheight(node.right);
            return Math.max(leftheight, rightheight) + 1;
        }
    }

    public static node root;

    public static void main(String[] args) {

        BST.root = new node(50);
        root.insert(45);
        root.insert(55);
        root.insert(40);
        root.insert(47);
        root.insert(52);
        root.insert(57);

        System.out.println("Preorder Traversal:");
        root.preorder(root);
        System.out.println("Inorder Traversal:");
        root.inorder(root);
        System.out.println("Postorder Traversal:");
        root.postorder(root);
        System.out.println("\nSearch Output:");
        root.search(root, 45);

        int h = root.getheight(root);
        System.out.println("\nHeight of tree: " + h);
    }
}
