import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

  protected String data;
  protected BinaryTree left,right;

  BinaryTree(){
    data = null;
    left = right = null;
  }

  BinaryTree(String item){
    data = item;
    left = new BinaryTree();
    right = new BinaryTree();
  }

  BinaryTree(String item, BinaryTree left, BinaryTree right)
  {
    data = item;
    this.left = left;
    this.right = right;
  }

  public String getData(){
    return data;
  }

  public BinaryTree getLeft(){
    return left;
  }

  public BinaryTree getRight(){
    return right;
  }

  public void setData(String obj){
    data=obj;
  }

  public void setLeft(BinaryTree tree){
      left = tree;
  }

  public void setRight(BinaryTree tree){
      right = tree;
  }

  public boolean isEmpty(){
    return data == null;
  }

  public boolean isLeaf(){
    return !isEmpty() && left.isEmpty() && right.isEmpty();
  }

  public int nodeCount(){
      if(isEmpty())
    	  return 0;
      else
    	  return 1 + left.nodeCount()+right.nodeCount();
  }

  public int prune(){
	  if(isEmpty())
		  return 0;
      if (this.isLeaf()) {
    	  data = null;
    	  left = null;
    	  right = null;
    	  return 1;
      }
      return left.prune() + right.prune();
  }

  public boolean isFull(){
      if(left.isEmpty() && right.isEmpty())
    	  return true;
      if(!left.isEmpty() && !right.isEmpty())
    	  return left.isFull() && right.isFull();
      return false;
  }

  public boolean isComplete(){
      return isComplete(0, nodeCount());
  }
  
  boolean isComplete(int index, int nodeCount) 
  { 
      if (isEmpty())         
         return true; 
      if (index >= nodeCount) 
         return false; 
      return (left.isComplete( 2 * index + 1, nodeCount) && right.isComplete( 2 * index + 2, nodeCount));
  } 

  public int leafCount(){
	  if(isEmpty())
		  return 0;
	  if(isLeaf())
		  return 1;
	  return left.leafCount() + right.leafCount();
  }

  public BinaryTree mirrorImage(){
      if(isEmpty())
    	  return new BinaryTree();
      return new BinaryTree(data, right, left);
  }

  public int height(){
      if (isEmpty())
    	  return -1;
      int rh = right.height() + 1;
      int lh = left.height() + 1;
      if (rh > lh )
    	  return rh;
      else 
    	  return lh;
  }

  public int levelCount(int level){
	  if(this.isEmpty())
		  return 0;
      if (level == 0)
    	  return 1;
      return left.levelCount(level-1) + right.levelCount(level - 1);
  }

  public int weightBalanceFactor(){
	  if (isEmpty())
		  return 0;
	  if (!isLeaf()) {
	  int bal = left.height() - right.height();
	  int lb = left.weightBalanceFactor();
	  int rb = right.weightBalanceFactor();
	  if (Math.abs(bal) < Math.abs(lb))
		  bal = lb;
	  if (Math.abs(bal) < Math.abs(rb))
		  bal = rb;
	  return bal;
	  }
	return 0;
  }
  

  public int nodeSum(){
      int result = Integer.parseInt(data);
      if(!left.isEmpty())
    	  result += left.nodeSum();
      if(!right.isEmpty())
    	  result += right.nodeSum();
      return result;
  }

  public void doubles(){
      int newValue = Integer.parseInt(data) * 2;
      if(!left.isEmpty()) 
    	  left.doubles();
      if(!right.isEmpty())
    	  right.doubles();
      data = newValue + "";
  }

  public int maxPathSum(){
      int node = Integer.parseInt(data);
      int leftsum  = node;
      int rightsum = node;
      if(!left.isEmpty())
    	  leftsum += left.maxPathSum();  
      if(!right.isEmpty())
    	  rightsum += right.maxPathSum();
      if(rightsum > leftsum)
    	  return rightsum;
      else 
    	  return leftsum;
  }

  public String preOrder(){
	  if(!this.isEmpty())
		  return this.data + " "+ left.preOrder() + right.preOrder();
	  return "";
  }

  public String inOrder(){
	  if(!this.isEmpty())
		  return left.preOrder()  + this.data + " " + right.preOrder();
	  return "";
  }

  public String postOrder(){
	  if(!this.isEmpty())
		  return left.preOrder() +  right.preOrder() +  this.data  + " " ;
	  return "";
  }

  public String levelOrder(){
	  Queue<BinaryTree> q = new LinkedList<BinaryTree>();
	  String result = "";
	  if(!isEmpty())
		  q.add(this);
	  
	  while(!q.isEmpty()) {
		  BinaryTree cur = q.remove();
		  result += cur.data + " ";
		  System.out.println(cur.data);
		  if(!left.isEmpty())
			  q.add(cur.left);
		  if(!right.isEmpty())
			  q.add(cur.right);
	  }
      return result;
  }
  
  public String toString( String indent ) {
     if(isEmpty())
        return "";
     else
        return right.toString( indent + "   " ) + "\n" +
        indent + "/\n" +
        indent + data + "\n" +
        indent + "\\" +
        left.toString( indent + "   ");
  }

  public String toString() {
      return toString("");
  }
}
