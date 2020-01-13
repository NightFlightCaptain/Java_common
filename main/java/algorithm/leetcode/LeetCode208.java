package algorithm.leetcode;

/**
 * 【实现 Trie (前缀树)】
 * <p>
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/13 22:07
 */
public class LeetCode208 {

    public Trie getTrie(){
        return new Trie();
    }

    class Trie {
        TreeNode root = new TreeNode('-');

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TreeNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (cur.treeNodes[ch - 'a'] == null) {
                    cur.treeNodes[ch - 'a'] = new TreeNode(ch);
                }
                cur = cur.treeNodes[ch - 'a'];
            }
            cur.isEnd = true;

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.treeNodes[ch - 'a'] == null) {
                    return false;
                }
                node = node.treeNodes[ch - 'a'];
            }
            return node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TreeNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (node.treeNodes[ch - 'a'] == null) {
                    return false;
                }
                node = node.treeNodes[ch - 'a'];
            }
            return true;
        }
    }

    class TreeNode {
        TreeNode[] treeNodes = new TreeNode[27];
        char c;
        boolean isEnd = false;

        public TreeNode(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        LeetCode208 solution =new LeetCode208();
        Trie trie = solution.getTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}
