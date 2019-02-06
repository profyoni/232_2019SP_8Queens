package pkg8queens;

import java.util.HashSet;

class _8Queens {
    public final static int SIZE = 10;
    boolean board[][];

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(String.format("[%s]", this.board[i][j] ? "X" : " "));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    _8Queens(_8Queens q) {
        this();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = q.board[i][j];
            }
        }
    }

    _8Queens() {
        board = new boolean[SIZE][SIZE];
    }

    boolean isLegal() {
        HashSet<String> occupied = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j]) {
                    boolean legal = occupied.add("Row" + i)
                            && occupied.add("Col" + j)
                            && occupied.add("DiagA" + (i - j))
                            && occupied.add("DiagB" + (i + j));
                    if (!legal) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}

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
