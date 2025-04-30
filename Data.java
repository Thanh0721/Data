public class Data {
    public static final int MAX = (int)(Math.random() * Integer.MAX_VALUE);
    private int[][] grid;

    public Data(int rows, int cols) 
    {
        grid = new int[rows][cols];
    }

    public Data(int[][] grid) 
    {
        this.grid = grid;
    }

    public int[][] getGrid() 
    {
        return grid;
    }

    public void repopulate() 
    {
        for (int row = 0; row < grid.length; row++) 
        {
            for (int col = 0; col < grid[row].length; col++) 
            {
                int val;
                do {
                    val = (int)(Math.random() * MAX) + 1;
                } while (val % 10 != 0 || val % 100 == 0);
                grid[row][col] = val;
            }
        }
    }

    public int countIncreasingCols() 
    {
        int count = 0;
        for (int col = 0; col < grid[0].length; col++) 
        {
            boolean isIncreasing = true;
            for (int row = 1; row < grid.length; row++) 
            {
                if (grid[row][col] < grid[row-1][col]) 
                {
                    isIncreasing = false;
                    break;
                }
            }

            if (isIncreasing) 
            {
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        for (int[] row : grid) 
        {
            for (int val : row) 
            {
                sb.append(val).append(" ");
            }

            sb.append("\n");
        }
        
        return sb.toString();
    }
}