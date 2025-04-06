import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too

        int[] start = startingLocation(island);
        if (start == null) {
            return 0;
        }
        
        boolean[][] visited = new boolean[island.length][island[0].length];
        return reachableAreaHelper(island, start, visited);
    }

    public static int reachableAreaHelper(int[][] island, int[] current, boolean[][] visited) {

        int row = current[0];
        int col = current[1];

        if (row < 0 || row >= island.length || col < 0 || col >= island[0].length) {
            return 0;
        }

        if (visited[row][col]) {
            return 0;
        }

        if (island[row][col] == 2 || island[row][col] == 3) {
            return 0;
        }

        visited[row][col] = true;
        int count = 1; 

        List<int[]> direction = possibleDirection(island, current);
        for (int[] dir : direction) {
            count += reachableAreaHelper(island, dir, visited);
        }

        return count;

    }
}
