package Week_04;

import Week_03.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 102. 二叉树的层序遍历
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> qNodes = new LinkedList<>();
        qNodes.add(root);

        while (!qNodes.isEmpty()) {
            int size = qNodes.size();
            List<Integer> tempRes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node=qNodes.poll();
                tempRes.add(node.val);

                if(node.left!=null){
                    qNodes.add(node.left);
                }

                if(node.right!=null){
                    qNodes.add(node.right);
                }
            }
            res.add(tempRes);
        }

        return res;
    }
}
