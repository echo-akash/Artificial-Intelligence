package eightpuzzle;

public class EightPuzzle {

    public static void main(String[] args) {

        int start[][] = {{1, 2, 3}, {4, 0, 6}, {7, 5, 8}};
        int goal[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
       
        State.goal = goal;
        State s1 = new State(start);

        Solver s = new Solver();
        s.A_star(s1);

    }

}
