package pkg8queens;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int column = 0; column < _8Queens.SIZE; column++) {
            _8Queens q = new _8Queens();
            placeQueen(q, 0, column);
        }
    }

    private static void placeQueen(_8Queens q, int r, int c) {
        q.board[r][c] = true;
        if (!q.isLegal()) {
           // System.out.println("BACKTRACK");
            return;
        } else if (r == _8Queens.SIZE - 1) {
            System.out.println(q);
            return;
        }
       // System.out.println(q);
        for (int column = 0; column < _8Queens.SIZE; column++) {
            _8Queens q2 = new _8Queens(q);
            placeQueen(q2, r + 1, column);
        }

    }

}
