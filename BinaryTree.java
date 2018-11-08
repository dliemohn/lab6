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
      int headCount = 0;
      if (this.isLeaf()) {
	  headCount++;
	  data = null;
      }
      if (left != null)
	  headCount+= left.prune();
      if (right != null)
	  headCount += right.prune();
      return headCount;
  }

  public boolean isFull(){
      // TODO:  write the ifFull method
      return false;
  }

  public boolean isComplete(){
      // TODO:  write the isComplete method
      return false;
  }

  public int leafCount(){
      int count = 0;
      if (right != null)
	  count += right.leafCount();
      if (left!=null)
	 count += left.leafCount();
      if (this.isLeaf()) 
	  count++; 
      return count;
  }

  public BinaryTree mirrorImage(){
      BinaryTree result = new BinaryTree(data);
      if (right == null)
	  result.left = null;
      else 
	  result.left = right.mirrorImage();
      if (left == null)
	  result.right = null;
      else 
	  result.right = left.mirrorImage();
      return result;
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
	  if(data == null)
		  return 0;
      if (level == 0)
    	  return 1;
      int levelBelow = 0;
      if(!left.isEmpty())
    	  levelBelow += left.levelCount(level--);
      if(right.isEmpty())
    	  levelBelow += right.levelCount(level--);
      return levelBelow;
  }

  public int weightBalanceFactor(){
      // TODO:  write the weightBalanceFactor method
      return -1;
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
      // TODO:  write the preOrder method
      return "";
  }

  public String inOrder(){
      // TODO:  write the inOrder method
      return "";
  }

  public String postOrder(){
      // TODO:  write the postOrder method
      return "";
  }

  public String levelOrder(){
      // TODO:  write the levelOrder method
      return "";
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
