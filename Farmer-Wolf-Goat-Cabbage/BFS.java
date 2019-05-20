
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class BFS {
    Queue<State> Q;
    HashSet<String> visitted;
    LinkedList<ArrayList<String>> paths;
    ArrayList<String> shortest_path;
    
    
    
    public BFS(){
        Q=new LinkedList<State>();
        visitted = new HashSet<>();
        paths= new LinkedList<>();
        
    }
    
    public void printPath(){
        for (String s: shortest_path){
            System.out.println(s);
        }
        
    }
    
    public void start(State start){
        Q.add(start);
        visitted.add(start.toString());
        
        ArrayList<String> r = new ArrayList<>();
        r.add(start.toString());
        paths.add(r);
        
        
        while(Q.size()!=0){
            State u=Q.poll();
            shortest_path = paths.poll();
            
            if(u.toString().equals("1111")){
                System.out.println("Found the End");
                return;
            }
            
            State v_list[]=u.generateNextSTate();
            for (State v:v_list) {
                if(v.isIllegal()){
                    continue;
                }
                if(visitted.contains(v)){
                    continue;
                }
                
                ArrayList<String> r1 = new ArrayList<>(shortest_path);
                r1.add(v.toString());
                paths.add(r1);
                
                Q.add(v);
                visitted.add(v.toString());
            }
        }
    }
    
}
