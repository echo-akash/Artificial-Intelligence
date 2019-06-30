import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;


public class Sudoku {
public static void main(String[] args) {


int i, j, k;
int p, q;

// 1. Create a Model
Model model = new Model("my first suguru problem");
// 2. Create variables



/* the board which is 6 X 6 */
/* (0, 0) is the top left position and (6, 6) is the bottom right position */
/*each cell is an integer variable taking their value in [1, 5] */
/* because no cage is bigger than size five*/
IntVar[][] bd = model.intVarMatrix("bd", 6, 6, 1, 5);

/* the cage variables are declared. There are eight cages */
IntVar[] c0 = model.intVarArray("c0", 5, 1, 5);
IntVar[] c1 = model.intVarArray("c1", 4, 1, 4);
IntVar[] c2 = model.intVarArray("c2", 5, 1, 5);
IntVar[] c3 = model.intVarArray("c3", 5, 1, 5);
IntVar[] c4 = model.intVarArray("c4", 5, 1, 5);
IntVar[] c5 = model.intVarArray("c5", 5, 1, 5);
IntVar[] c6 = model.intVarArray("c6", 5, 1, 5);
IntVar[] c7 = model.intVarArray("c7", 2, 1, 2);



// 3. Post constraints


/* post constraints for the given hints or clues */

model.arithm (bd[1][5], "=", 1).post();
model.arithm (bd[3][3], "=", 4).post(); 
model.arithm (bd[4][0], "=", 3).post(); 
model.arithm (bd[4][1], "=", 2).post(); 
model.arithm (bd[4][3], "=", 1).post();


/*within all cages,  no numbers can be repeated*/
model.allDifferent(c0).post();
model.allDifferent(c1).post();
model.allDifferent(c2).post();
model.allDifferent(c3).post();
model.allDifferent(c4).post();
model.allDifferent(c5).post();
model.allDifferent(c6).post();
model.allDifferent(c7).post();

/* specify the cage variables by linking them with board variables */
/* do the specification for all eight cages*/
model.arithm (bd[0][0], "=", c0[0]).post();
model.arithm (bd[1][0], "=", c0[1]).post();
model.arithm (bd[1][1], "=", c0[2]).post();
model.arithm (bd[2][0], "=", c0[3]).post();
model.arithm (bd[3][0], "=", c0[4]).post();

model.arithm (bd[0][1], "=", c1[0]).post();
model.arithm (bd[0][2], "=", c1[1]).post();
model.arithm (bd[0][3], "=", c1[2]).post();
model.arithm (bd[0][4], "=", c1[3]).post();

model.arithm (bd[1][2], "=", c2[0]).post();
model.arithm (bd[2][1], "=", c2[1]).post();
model.arithm (bd[2][2], "=", c2[2]).post();
model.arithm (bd[2][3], "=", c2[3]).post();
model.arithm (bd[3][2], "=", c2[4]).post();


model.arithm (bd[0][5], "=", c3[0]).post();
model.arithm (bd[1][3], "=", c3[1]).post();
model.arithm (bd[1][4], "=", c3[2]).post();
model.arithm (bd[1][5], "=", c3[3]).post();
model.arithm (bd[2][5], "=", c3[4]).post();

model.arithm (bd[3][1], "=", c4[0]).post();
model.arithm (bd[4][0], "=", c4[1]).post();
model.arithm (bd[4][1], "=", c4[2]).post();
model.arithm (bd[4][2], "=", c4[3]).post();
model.arithm (bd[5][0], "=", c4[4]).post();

model.arithm (bd[2][4], "=", c5[0]).post();
model.arithm (bd[3][3], "=", c5[1]).post();
model.arithm (bd[3][4], "=", c5[2]).post();
model.arithm (bd[3][5], "=", c5[3]).post();
model.arithm (bd[4][4], "=", c5[4]).post();

model.arithm (bd[4][3], "=", c6[0]).post();
model.arithm (bd[5][1], "=", c6[1]).post();
model.arithm (bd[5][2], "=", c6[2]).post();
model.arithm (bd[5][3], "=", c6[3]).post();
model.arithm (bd[5][4], "=", c6[4]).post();

model.arithm (bd[4][5], "=", c7[0]).post();
model.arithm (bd[5][5], "=", c7[1]).post();

/*specify the constraint that eight neighbors of a cell cannot hold */
/*the number which is contained by a cell */
for ( i = 0; i < 6; i++)
    for ( j = 0; j < 6; j++)
    {
     for ( p = i-1; p < i+2; p++)
       for ( q = j-1; q < j+2; q++)
         if (p > -1 && p < 6)
           if (q > -1 && q < 6)
           {
           if (p == i && q == j) continue;
           model.arithm (bd[i][j], "!=", bd[p][q]).post();
           }
    }       







// 4. Solve the problem


     Solver solver = model.getSolver();

    solver.showStatistics();
    solver.showSolutions();
    solver.findSolution();


// 5. Print the solution

for ( i = 0; i < 6; i++)
    {
for ( j = 0; j < 6; j++)
     { 
  
        System.out.print(" "); 
        /* get the value for the board position [i][j] for the solved board */
        k = bd [i][j].getValue();
        System.out.print(k );
     }
     System.out.println();
    }


}

}

