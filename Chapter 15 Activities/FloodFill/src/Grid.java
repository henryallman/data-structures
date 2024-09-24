import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    private int fillCount = 1;

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(row, column));

        while (stack.isEmpty() == false) {
            Pair p = stack.pop();
            int r = p.getRow();
            int c = p.getColumn();

            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && pixels[r][c] == 0) {
                pixels[r][c] = fillCount;
                fillCount++; 

                stack.push(new Pair(r - 1, c)); // N
                stack.push(new Pair(r, c + 1)); // E
                stack.push(new Pair(r + 1, c)); // S
                stack.push(new Pair(r, c - 1)); // W
            }
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
