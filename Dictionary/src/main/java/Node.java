import java.util.ArrayList;

public class Node {

    private int balance;
    private String key;
    private Node father;
    private Node left;
    private Node rigth;
    private ArrayList<String> values;

    public Node(String key, String value){
        this.values = new ArrayList<String>();

        addValue(value);
        setBalance(0);
        setKey(key);
        setFather(null);
        setLeft(null);
        setRight(null);
    }

    public void addValue(String value){
        this.values.add(value);
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
        return this.rigth;
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

    public void setRight(Node rigth){
        this.rigth = rigth;
    }
}
