package leetcode;

/**
 * Created by amit.bhengra on 18/10/18.
 */
public class PopulateNextPointersPartTwo {
    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        connectRoot(root);
    }

    public void connectRoot(TreeLinkNode root){
        if(root.left!=null && root.right!=null){
            root.left.next = root.right;
            connectRoot(root.left);
            connectRoot(root.right);
            connectTwoNodes(root.left,root.right);
        }else{
            if(root.left!=null)
                connect(root.left);
            else
                connect(root.right);
        }
    }

    public void connectTwoNodes(TreeLinkNode node1, TreeLinkNode node2){
        if(node1.right!=null){
            if(node2.left!=null){
                node1.right.next = node2.left;
                connectTwoNodes(node1.right,node2.left);
            }
            else if(node2.right!=null){
                node1.right.next = node2.right;
                connectTwoNodes(node1.right,node2.right);
            }

        }else{
            if(node1.left!=null){
                if(node2.left!=null){
                    node1.left.next = node2.left;
                    connectTwoNodes(node1.left,node2.left);
                }
                else if(node2.right!=null){
                    node1.left.next = node2.right;
                    connectTwoNodes(node1.left,node2.right);
                }
            }
        }
    }
}
