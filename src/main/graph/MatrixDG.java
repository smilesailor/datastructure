package main.graph;

public class MatrixDG {
    int size;
    char[] vertexs;
    int[][] matrix;

    public MatrixDG(char[] vertexs, char[][] edges) {
        this.size = vertexs.length;
        this.vertexs = vertexs;
        this.matrix = new int[size][size];

        for (char[] c : edges) {
            int p1 = getPosition(c[0]);
            int p2 = getPosition(c[1]);
            this.matrix[p1][p2] = 1;// 有向图只能在一个方向存储
//            this.matrix[p2][p1] = 1;
        }
    }

    public int getPosition(char c) {
        for (int i = 0; i < vertexs.length; i++) {
            if (c == vertexs[i]) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        char[][] edges = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'D', 'G'},
                {'I', 'J'},
                {'J', 'G'},
                {'E', 'H'},
                {'H', 'K'},
        };
        MatrixDG G = new MatrixDG(vexs, edges);
        G.print();
    }
}
