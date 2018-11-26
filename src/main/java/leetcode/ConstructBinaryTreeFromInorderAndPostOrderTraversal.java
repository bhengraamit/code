package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 01/11/18.
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */
public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inOrderMap = getInorderMap(inorder);
        return buildTree(postorder,inorder,postorder.length-1,0,inorder.length-1,inOrderMap);
    }

    public TreeNode buildTree(int[] postorder, int[] inorder, int postPos, int inStart, int inEnd, Map<Integer,Integer> inOrderMap){
        if(postPos < 0 || inStart > inEnd)
            return null;
        int postNode = postorder[postPos];
        int inorderRootPos = inOrderMap.get(postNode);
        TreeNode node = new TreeNode(postNode);
        TreeNode rightNode = buildTree(postorder,inorder,postPos-1, inorderRootPos+1,inEnd,inOrderMap);
        TreeNode leftNode = buildTree(postorder,inorder,postPos-(inEnd-inorderRootPos+1),inStart,inorderRootPos-1,inOrderMap);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    public Map<Integer,Integer> getInorderMap(int[] inorder){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i],i);
        }
        return map;
    }
}
