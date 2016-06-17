import java.util.ArrayList;

public class Node {

    private int balance;
    private String key;
    private Node father;
    private Node left;
    private Node right;

    private ArrayList<String> values;

    public Node(String key, ArrayList<String> values){
        setInitialValues(key);
        setValues(values);
    }

    public int getBalance(){
        return this.balance;
    }

    public String getKey(){
        return this.key;
    }

    public Node getFather(){
        return this.father;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void setKey(String key){
        this.key = key;
    }

    public void setFather(Node father){
        this.father = father;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public void setValues(ArrayList<String> values) {
        this.values = values;
    }

    private void setInitialValues(String key){
        setValues( new ArrayList<String>() );
        setBalance(0);
        setKey(key);
        setFather(null);
        setLeft(null);
        setRight(null);
    }

}
