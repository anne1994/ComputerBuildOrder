import java.util.ArrayList;
import java.util.HashMap;

public class Elements {

    private ArrayList<Elements> children = new ArrayList<>();
    private HashMap<String,Elements> map = new HashMap<String, Elements>();
    private String name;
    private int dependencies = 0;

    public Elements(String n){
        name = n ;
    }



    public void addNeighbor(Elements node)
    {

        if(!map.containsKey(node.getName())){
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();

        }
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies(){
        dependencies--;
    }


    public String getName(){
        return name;
    }

    public ArrayList<Elements> getChildren(){
        return children;
    }

    public int getDependencies(){
        return dependencies;
    }
}
