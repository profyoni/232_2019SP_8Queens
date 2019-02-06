package pkg8queens;

import java.util.HashSet;

public class _8Queens {
    public final static int SIZE = 4;
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
