import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases

    @Test
    public void testReachableArea_noStartPoint() {
        int[][] island = {
            {1, 1, 1},
            {2, 3, 1},
            {1, 1, 1}
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.reachableArea(island);
        });
        assertEquals("No starting location found", exception.getMessage()); 
    }

    @Test
    public void testReachableArea_startSurrounding() {
        int[][] island = {
            {2, 2, 2},
            {2, 0, 3},
            {3, 2, 2}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual); 
    }

    @Test
    public void testReachableArea_notAccessible() {
        int[][] island = {
            {3, 3, 3},
            {3, 3, 3},
            {3, 0, 3}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual); 
    }

    @Test
    public void testReachableArea_allAccessible() {
        int[][] island = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 0, 1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(9, actual); 
    }

    @Test
    public void testReachableArea_multipleStarts()  {
        int[][] island = {
            {0, 1, 0},
            {1, 1, 1},
            {3, 1, 2}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(7, actual); 
    }

    @Test
    public void testReachableArea_emptyIsland() {
        int[][] island = {};
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(0, actual); 
    }

    @Test
    public void testReachableArea_SurroundedByLand() {
        int[][] island = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(9, actual); 
    }

    // @Test
    // public void testReachableArea_bigIsland() {
    //     int[][] island = {
    //         {1, 1, 1, 3, 1, 1},
    //         {3, 2, 3, 1, 3, 1},
    //         {1, 1, 1, 1, 3, 3},
    //         {3, 1, 2, 1, 0, 1},
    //         {1, 1, 1, 2, 1, 1},
    //     };
    //     int actual = ExplorerSearch.reachableArea(island);
    //     assertEquals(14, actual); 
    // }

    @Test
    public void testStartingLocationNotFound() {
        int[][] island = {
            {1, 1, 1},
            {2, 3, 1},
            {1, 1, 1}
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.startingLocation(island);
        });
        assertEquals("No starting location found", exception.getMessage());
    }
}
