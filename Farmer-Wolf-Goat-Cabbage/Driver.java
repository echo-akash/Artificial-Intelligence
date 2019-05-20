
public class Driver {
    
    public static void main (String args[]){
        State s1=new State();
        System.out.println(s1.toString());
        /*State next[] = s1.generateNextSTate();
        for (State s:next) {
            System.out.println(s.toString());
            
        }*/
        BFS solver = new BFS();
        solver.start(s1);
        solver.printPath();
    }
    
}
