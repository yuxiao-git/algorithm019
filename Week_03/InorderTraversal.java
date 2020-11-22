package Week_03;

import java.util.ArrayList;
import java.util.List;


public class InorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        // left
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        // root val
        res.add(root.val);
        // right
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return res;
    }

}
