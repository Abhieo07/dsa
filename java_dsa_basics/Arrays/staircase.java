public class Main
{
  public static String find (int[][]matrix, int key)
  {
    int row = matrix.length - 1, col = 0;
    while (row >= 0 && col < matrix[0].length)
      {
	if (matrix[row][col] == key)
	  {
	    return "Found at " + row + "," + col;
	  }
	else if (key > matrix[row][col])
	  {
	    col++;
	  }
	else if (key < matrix[row][col])
	  {
	    row--;
	  }
      }
    return key + " NOt found";
  }

  public static void main (String[]args)
  {
    int matrix[][] = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    int key = 14;
    System.out.println (find (matrix, key));
  }
}
