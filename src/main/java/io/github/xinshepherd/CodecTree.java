package io.github.xinshepherd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * @author Fuxin
 * @since 2020/6/16
 */
public class CodecTree {

    public String _serialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = _serialize(root.left, str);
            str = _serialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root) {
        return _serialize(root, "");
    }

    public TreeNode _deserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        root.left = _deserialize(l);
        root.right = _deserialize(l);

        return root;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return _deserialize(data_list);
    }

    public static void main(String[] args) {
        CodecTree codecTree = new CodecTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode();
        TreeNode node = codecTree.deserialize(codecTree.serialize(TreeNode.demo2()));
        assertThat(node).isNotNull();
    }

}
