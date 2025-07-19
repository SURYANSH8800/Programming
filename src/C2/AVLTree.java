package C2;
public class AVLTree {
    public static class node {
        int data, height;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        public int height(node n) {
            if (n == null)
                return 0;
            return n.height;
        }

        public int balancefactor(node n) {
            if (n == null) return 0;
            return height(n.left) - height(n.right);
        }

        public node rightrotate(node y) {
            node x = y.left;
            node t2 = x.right;

            x.right = y;
            y.left = t2;

            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return x;
        }

        public node leftrotate(node x) {
            node y = x.right;
            node t2 = y.left;

            y.left = x;
            x.right = t2;

            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

        public node insert(node root, int data) {
            if (root == null)
                return new node(data);

            if (data < root.data)
                root.left = insert(root.left, data);
            else if (data > root.data)
                root.right = insert(root.right, data);
            else
                return root; // no duplicates

            root.height = 1 + Math.max(height(root.left), height(root.right));

            int balance = balancefactor(root);

            // Left Left
            if (balance > 1 && data < root.left.data)
                return rightrotate(root);

            // Right Right
            if (balance < -1 && data > root.right.data)
                return leftrotate(root);

            // Left Right
            if (balance > 1 && data > root.left.data) {
                root.left = leftrotate(root.left);
                return rightrotate(root);
            }

            // Right Left
            if (balance < -1 && data < root.right.data) {
                root.right = rightrotate(root.right);
                return leftrotate(root);
            }

            return root;
        }

        public void inorder(node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
            }
        }
    }

    public static node root;

    public static void main(String args[]) {
        node treeNode = new node(50);
        root = treeNode.insert(root, 50);
        root = treeNode.insert(root, 100);
        root = treeNode.insert(root, 0);
        root = treeNode.insert(root, 25);
        root = treeNode.insert(root, 12);

        treeNode.inorder(root);
        System.out.println("\nHeight: " + root.height);
        System.out.println("Balance Factor: " + treeNode.balancefactor(root));
    }
}
