class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeFromString {
    public static TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }

        // Find the index of the first '(' character
        int firstParenthesisIndex = s.indexOf('(');

        if (firstParenthesisIndex == -1) {
            // The string contains only an integer, create a new node and return it
            return new TreeNode(Integer.parseInt(s));
        }

        // Extract the value of the root node from the substring before the first '('
        int rootValue = Integer.parseInt(s.substring(0, firstParenthesisIndex));
        TreeNode root = new TreeNode(rootValue);

        // Count the number of parentheses pairs
        int count = 0;
        int i = firstParenthesisIndex;

        // Find the substring that represents the left child node
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }

            if (count == 0) {
                break;
            }

            i++;
        }

        // Extract the substring representing the left child node
        String leftSubtree = s.substring(firstParenthesisIndex + 1, i);
        root.left = str2tree(leftSubtree);

        // Find the substring that represents the right child node (if it exists)
        if (i + 1 < s.length()) {
            String rightSubtree = s.substring(i + 2, s.length() - 1);
            root.right = str2tree(rightSubtree);
        }

        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = str2tree(s);
        System.out.print("Inorder traversal of the constructed tree: ");
        inorderTraversal(root);
    }
}
