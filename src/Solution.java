import java.util.ArrayList;

public class Solution  {

    public static void main(String[] args){
        String[] elements = {"power","ram","motherboard", "display", "cpu", "os","monitor","computer" };
        String[][] dependencies = {
                {"power", "ram"}, {"ram", "motherboard"}, {"ram", "cpu"}, {"motherboard", "cpu"}, {"cpu", "os"} ,
                {"os", "display"}, {"os", "monitor"}, {"monitor", "computer"} , {"display", "computer"}
        };
        Elements[] result = findBuildOrder(elements,dependencies);
        for(Elements e : result){
           String f =  e.getName();
           System.out.println(f);
        }


    }

    //find the correct order
    public static Elements[]  findBuildOrder(String[] Elements,String[][] dependencies){
        Graph g = buildGraph(Elements,dependencies);
        return orderElements(g.getNodes());
    }

    //build graph
    public static Graph buildGraph(String[] Elements, String[][] dependencies){
        Graph g = new Graph();

        //creating all graph nodes
        for(String Element: Elements){
            g.createNode(Element);
        }

        //adding all edges
        for(String[] dependency: dependencies){
            String first = dependency[0];
            String second = dependency[1];
            g.addEdge(first,second);
        }
        return g;
    }

    //order elements
    public static Elements[] orderElements(ArrayList<Elements> elements){

        Elements[] order = new Elements[elements.size()];

        //add non dependent to order
        int EOL = addNonDependent(order,elements,0);

        int toBeProcessed = 0;
        //now process order elements
        while(toBeProcessed < order.length){
            Elements current = order[toBeProcessed];

            if(current == null){
                return null;
            }

            //remove myself as dependency and add to eol

            ArrayList<Elements> children = current.getChildren();
            for(Elements child : children){
                child.decrementDependencies();
            }

            EOL = addNonDependent(order,children,EOL);
            toBeProcessed++;
        }

        return order;
    }

    public static int addNonDependent(Elements[] order, ArrayList<Elements> elements,int index){
        for(Elements e: elements){
            if(e.getDependencies()==0){
                order[index] = e;
                index++;
            }
        }
        return index;
    }
}
