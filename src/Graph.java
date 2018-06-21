
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.String;

public class Graph
{

    private ArrayList<Elements> nodes = new ArrayList<Elements>();
    private HashMap<String, Elements> map = new HashMap<String, Elements>();




    public Elements createNode(String name){
        if(!map.containsKey((name))){
            Elements node = new Elements(name);
            nodes.add(node);
            map.put(name,node);
        }
        return map.get(name); //returns node with that name
    }

    public void addEdge(String startName, String endName){
        Elements start = createNode(startName);
        Elements end = createNode(endName);
        start.addNeighbor(end);
    }


    public ArrayList<Elements> getNodes(){
        return nodes;
    }
}


