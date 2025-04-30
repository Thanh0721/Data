public class Main {
    public static void main(String[] args) 
    {
        testRepopulate();
        testCountIncreasingCols();
    }

    public static void testRepopulate() 
    {
        System.out.println("=== Testing repopulate() ===");
        Data data = new Data(3, 4);
        System.out.println("Empty grid:");
        System.out.println(data);
        
        data.repopulate();
        System.out.println("After repopulate():");
        System.out.println(data);
        
        verifyRepopulateValues(data);
    }

    public static void testCountIncreasingCols() 
    {
        System.out.println("\n=== Testing countIncreasingCols() ===");
        
        int[][] grid1 = 
        {
            {10, 50, 40},
            {20, 40, 20},
            {30, 50, 30}
        };
        testGrid("Test Case 1", grid1, 1);
        
        int[][] grid2 = 
        {
            {10, 540, 440, 440},
            {220, 450, 440, 190}
        };
        testGrid("Test Case 2", grid2, 2);
        
        int[][] grid3 = {{10, 30, 20, 50}};
        testGrid("Single Row", grid3, grid3[0].length);
        
        int[][] grid4 = 
        {
            {10},
            {20},
            {10}
        };
        testGrid("Single Column Not Increasing", grid4, 0);
    }

    private static void testGrid(String testName, int[][] grid, int expected) 
    {
        Data data = new Data(grid);
        System.out.println(testName + ":");
        System.out.println(data);
        int result = data.countIncreasingCols();
        System.out.println("Increasing columns: " + result + " (Expected: " + expected + ")\n");
    }

    private static void verifyRepopulateValues(Data data) 
    {
        boolean allValid = true;
        int[][] grid = data.getGrid();
        for (int row = 0; row < grid.length; row++) 
        {
            for (int col = 0; col < grid[row].length; col++) 
            {
                int val = grid[row][col];
                if (val < 1 || val > Data.MAX || val % 10 != 0 || val % 100 == 0) 
                {
                    allValid = false;
                    System.out.println("Invalid value at [" + row + "][" + col + "]: " + val);
                }
            }
        }

        if (allValid) 
        {
            System.out.println("All values meet the criteria");
        }
    }
}