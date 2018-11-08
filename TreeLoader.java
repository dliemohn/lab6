/**
 * Load a tree from a text file.  Format is line based, with each line
 * representing one node in the tree.  The first line represents the root
 * of the tree and contains the root data item.  Each additional line
 * consists of a String for data, a flag (L or R) indicating whether this
 * node is the left or right child of its parent, and an int
 * representing the (0-based) index of its parent.
 *
 * Ordering of nodes is level order.
 *
 * @author John Donaldson (Spring 2018)
 */

import java.io.*;
import java.util.*;

public class TreeLoader {

    BinaryTree loadTreeFromFile(String fname) throws IOException
    {
    //System.out.println("Successfully Loaded!");
    File file = new File(fname);
	Scanner sc = new Scanner(file);
	//System.out.println("Successfully Scannered!");
	
	if (!sc.hasNext()) {
		sc.close();
		//System.out.print("oops");
		return new BinaryTree();
	}
	//System.out.println("Not Empty!");
	
	String root = sc.nextLine();
	
	//System.out.println("Scanners Made!");
	ArrayList<BinaryTree> ref = new ArrayList<BinaryTree>();
	ref.add( new BinaryTree(root));
	//System.out.println("Root Added!");
	
	while (sc.hasNext()) {
		System.out.println("Theres more too see!");
		
		String data = sc.next();
		String side = sc.next();
		int daddy = sc.nextInt();
		
		BinaryTree current = new BinaryTree(data);
		if (side.equals("L"))
		ref.get(daddy).setLeft(current);
		else
			ref.get(daddy).setRight(current);
		ref.add(current);
		System.out.println("Looped!");
	}
	sc.close();
	return ref.get(0);
    }

    // So you can test your tree loader
    public static void main(String[] args) throws IOException {
        if(args.length!=1){
            System.out.println("Usage:  java TreeLoader filename");
        }
        else {
            TreeLoader tl = new TreeLoader();
            BinaryTree t = tl.loadTreeFromFile(args[0]);
            System.out.println(t);
        }
    }
}
