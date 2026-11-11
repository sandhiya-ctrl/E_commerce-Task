
class Node {
    String data;
    Node left, right;

    Node(String data) {
        this.data = data;
        left = right = null;
    }
}

public class BST{
    Node root;

    // Insert a category into the BST
    Node insert(Node root, String data) {
        if (root == null) {
            return new Node(data);
        }

        if (data.compareToIgnoreCase(root.data) < 0) {
            root.left = insert(root.left, data);
        } else if (data.compareToIgnoreCase(root.data) > 0) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Search for a category
    boolean search(Node root, String key) {
        if (root == null) {
            return false;
        }

        if (root.data.equalsIgnoreCase(key)) {
            return true;
        }

        if (key.compareToIgnoreCase(root.data) < 0) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Inorder: Left, Root, Right
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder: Root, Left, Right
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder: Left, Right, Root
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        String[] categories = {
            "Electronics", "Clothing", "Books", "Furniture",
            "Beauty", "Sports", "Toys", "Mobiles",
            "Laptops", "Shoes", "Watches", "Groceries",
            "Jewellery", "Kitchen", "Gaming"
        };

        for (String category : categories) {
            tree.root = tree.insert(tree.root, category);
        }

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\n\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\n\nPostorder Traversal:");
        tree.postorder(tree.root);

        System.out.println("\n\nSearch Electronics: "
                + tree.search(tree.root, "Electronics"));

        System.out.println("Search Pharmacy: "
                + tree.search(tree.root, "Pharmacy"));
    }

}
