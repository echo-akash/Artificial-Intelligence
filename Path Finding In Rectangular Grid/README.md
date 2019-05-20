Artifical Intelligence - A* Search Problem

The Environment:
-A two dimensional rectangular grid
-A typical grid cell connected to its eight surrounding cells
-The grid represented by a M X N matrix 
-Usually, a grid cell is accessible and represented by 0 
-Some grid cell may not be accessible (have walls) and can be represented by 1

Problem Specification:
• For the pathfinding problem, we need to specify a starting location (x1, y1) and a goal location (x2, y2) 
• Also, the M X N matrix needs to be specified 
• The problem difficulty can vary depending on the location of start position, goal position, and the position of wall cells

Distance Heuristics
• Euclidean Distance • Manhattan Distance • Chebyshev Distance • Octile Distance  

Euclidean Distance 
• The Euclidean distance or Euclidean metric is the "ordinary" (i.e.straight-line) distance between two points in Euclidean space
• The Euclidean distance between points p and q is the length of the line segment connecting them (pq)

Manhattan Distance 
• Taxicab geometry is a form of geometry in which the usual metric of Euclidean geometry is replaced by a new metric in which the distance between two points is the sum of the (absolute) differences of their coordinates
• The Manhattan distance, also known as rectilinear distance, city block distance, taxicab metric is defined as the sum of the lengths of the projections of the line segment between the points onto the coordinate axes
• In chess, the distance between squares on the chessboard for rooks is measured in Manhattan distance

Chebyshev Distance 
• The Chebyshev distance between two vectors or points p and q, with     standard coordinates and respectively, is :
• It is also known as chessboard distance, since in the game of chess the minimum number of moves needed by a king to go from one square on a chessboard to another equals the Chebyshev distance between the centers of the squares

Octile Distance 
• For Octile distance, it is assumed , one can travel in  only 45° and 90° angles.
• If the x-distance and y-distance to the goal are x and y, the octile heuristic is max(x, y) + (sqrt(2)-1)*min(x, y)

Heuristic Selection
• As for heuristic selection, consider pathfinding on a grid, with 8directional movement
• Three possible heuristics are straight-line (Euclidean) distance, octile distance, which assumes that only 45° and 90° angles are allowed, and Manhattan (city-block) distance
• Manhattan distance is a poor heuristic, because it will overestimate distances, not taking diagonal movement into account
• A straight-line heuristic is also poor, because it will underestimate distances, assuming that paths can take any angle
• The octile heuristic , which corresponds exactly to movement in the world, is the most accurate and best heuristic to use on a grid
• The octile heuristic between two points can be computed as max(Δx, Δy) + 0.41 · min(Δx, Δy), assuming that diagonal movement has cost 1.41
