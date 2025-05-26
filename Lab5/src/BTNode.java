import java.util.ArrayList;

public interface BTNode {
    
    public boolean search(BTNode node, int value);
    
    public void setRight(BTNode node);
    
    public void setLeft(BTNode node);
    
    public void addNode(BTNode node, int value);
    
    public int getValue();
    
    public BTNode getLeft();
    
    public BTNode getRight();
    
  // given a root node, add values from lowest to highest to result ArrayList
    public void toList(BTNode node, ArrayList<Integer> result);
    
}