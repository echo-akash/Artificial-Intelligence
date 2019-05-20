package eightpuzzle;

public class State {

    static int goal[][];
    int board[][];

    int g;
    int f;
    State parent;

    State() {

        parent = null;
        board = new int[3][3];

    }

    public State(State b) {

        parent = null;
        g = b.g;
        board = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = b.board[i][j];
            }
        }
    }

    public State(int[][] blocks) {

        parent = null;
        board = new int[3][3];
        g = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = blocks[i][j];
            }
        }

    }

    public int h_score() {                   // hamming distance: number of blocks out of place
        int distance = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != goal[i][j]) {
                    distance++;
                }
            }
        }
        return distance;
    }

    public int h_score_manhattan() {
        int distance = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != goal[i][j]) {
                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            if (goal[m][n] == board[i][j]) {
                                distance += Math.abs(m - i) + Math.abs(n - j);
                            }
                        }
                    }
                }
            }
        }

        return distance;
    }

    public boolean isGoal() {                // is this board the goal board?
        if (h_score() > 0) {
            return false;
        } else {
            return true;
        }
    }

   

    public State[] generateNextState() {
        State[] neighbors = new State[4];

        for (int i = 0; i < 4; i++) {
            neighbors[i] = new State(this);
            neighbors[i].parent = this;
            neighbors[i].g = this.g + 1;
        }

        int a;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == 0) {
                    //moving blank tiles to left
                    if (j > 0) {
                        a = neighbors[0].board[i][j - 1];
                        neighbors[0].board[i][j - 1] = neighbors[0].board[i][j];
                        neighbors[0].board[i][j] = a;
                    }

                    //moving blank tiles to right
                    if (j < 2) {
                        a = neighbors[1].board[i][j + 1];
                        neighbors[1].board[i][j + 1] = neighbors[1].board[i][j];
                        neighbors[1].board[i][j] = a;
                    }

                    //moving blank tiles to top
                    if (i > 0) {
                        a = neighbors[2].board[i - 1][j];
                        neighbors[2].board[i - 1][j] = neighbors[2].board[i][j];
                        neighbors[2].board[i][j] = a;
                    }

                    //moving blank tiles to bottom
                    if (i < 2) {
                        a = neighbors[3].board[i + 1][j];
                        neighbors[3].board[i + 1][j] = neighbors[3].board[i][j];
                        neighbors[3].board[i][j] = a;
                    }

                }

            }

        }

        return neighbors;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s += board[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }

}
