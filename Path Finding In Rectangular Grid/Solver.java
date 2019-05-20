package eightpuzzle;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solver {

    PriorityQueue<State> open_list;
    HashSet<String> closed_list;

    Solver() {
        open_list = new PriorityQueue<>(new StateComparator());
        closed_list = new HashSet<String>();
    }

    private class StateComparator implements Comparator<State> {

        @Override
        public int compare(State t, State t1) {
            // sorting f value in ascending order 
            if (t.f > t1.f) {
                return 1;
            } else if (t.f < t1.f) {
                return -1;
            } else {
                return 0;
            }

        }
    }

    private void printPath(State s) {
        if (s == null) {
            return;
        }
        printPath(s.parent);
        System.out.println(s.toString());
        return;
    }

    public boolean A_star(State start) {
        start.g = 0;
        start.f = start.g + start.h_score();

        open_list.add(start);
        while (!open_list.isEmpty()) {
            State current = open_list.poll();

            if (current.isGoal()) {

                System.out.println("Total Steps taken: " + current.g + "\n");
                printPath(current);

                return true;
            }

            closed_list.add(current.toString());

            for (State neighbor : current.generateNextState()) {
                if (closed_list.contains(neighbor.toString())) {
                    continue;
                }

                neighbor.f = neighbor.g + neighbor.h_score();

                if (open_list.contains(neighbor) == false) {
                    open_list.add(neighbor);
                }// else { If path cost is considered different then implement this part }

            }
        }

        return false;
    }
}
