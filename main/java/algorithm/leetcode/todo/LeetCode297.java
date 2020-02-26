package algorithm.leetcode.todo;

import algorithm.JianZhiOffer.TreeNode;

import java.util.LinkedList;

/**
 * 【二叉树的序列化与反序列化】
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/2/5 13:13
 */
public class LeetCode297 {

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            StringBuilder stringBuilder = new StringBuilder();
            TreeNode node = root;
            linkedList.push(node);
            while (!linkedList.isEmpty()) {
                node = linkedList.pop();
                if (node == null) {
                    stringBuilder.append(",").append("null");
                } else {
                    stringBuilder.append(",").append(node.val);
                    linkedList.add(node.left);
                    linkedList.add(node.right);
                }
            }
            return stringBuilder.substring(1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strings = data.split(",");
            int length = strings.length;
            if (length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
            TreeNode node = root;

            int index = 1;
            while (index < length) {
                if (!"null".equals(strings[index])) {
                    node.left = new TreeNode(Integer.valueOf(strings[index]));
                }
                index++;
                if (!"null".equals(strings[index])) {
                    node.right = new TreeNode(Integer.valueOf(strings[index]));
                }
                index++;
            }
            return root;
        }


    }

    public Codec getCodec() {
        return new Codec();
    }

    public static void main(String[] args) {
        LeetCode297 solution = new LeetCode297();
        Codec codec = solution.getCodec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(codec.serialize(root));

        System.out.println(codec.deserialize("1,2,null,3,4"));
    }
}
