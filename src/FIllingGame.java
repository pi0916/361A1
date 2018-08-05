public class FIllingGame {






















    private class Board{

        private  int [] designation= new int[2];
        private  int size;
        private int[][] board;

        public Board(int[] designation, int size)
        {
            this.designation = designation;
            this.size = size;
            board = new  int[size][size];
        }
    }
}
