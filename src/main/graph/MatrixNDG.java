package main.graph;

import java.util.LinkedList;

public class MatrixNDG {
    int size;
    char[] vertexs;
    int[][] matrix;

    public MatrixNDG(char[] vertexs, char[][] edges) {
        this.size = vertexs.length;
        this.vertexs = vertexs;
        this.matrix = new int[size][size];

        for (char[] c : edges) {
            int p1 = getPosition(c[0]);
            int p2 = getPosition(c[1]);
            this.matrix[p1][p2] = 1;
            this.matrix[p2][p1] = 1;
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

    public void DFS() {
        boolean[] beTraversed = new boolean[size];
        System.out.print(vertexs[0] + " ");
        beTraversed[0] = true;
        DFS(0, 0, beTraversed);
    }

    private void DFS(int x, int y, boolean[] beTraversed) {
        while (y <= size - 1) {
            if (matrix[x][y] != 0 && beTraversed[y] == false) {
                System.out.print(vertexs[y] + " ");
                beTraversed[y] = true;
                DFS(y, 0, beTraversed);
            }
            y++;
        }
    }

    public void BFS() {
        boolean[] beTraversed = new boolean[size];
        System.out.print(vertexs[0] + " ");
        beTraversed[0] = true;
        BFS(0, beTraversed);
    }

    private void BFS(int x, boolean[] beTraversed) {
        LinkedList<Character> list = new LinkedList<>();
        int y = 0;
        while (y <= size - 1) {
            if (matrix[x][y] != 0 && beTraversed[y] == false) {
                System.out.print(vertexs[y] + " ");
                beTraversed[y] = true;
                list.add(vertexs[y]);
            }
            y++;
        }
        while (!list.isEmpty()) {
            char ch = list.pop();
            int p = getPosition(ch);
            BFS(p, beTraversed);
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
        MatrixNDG G = new MatrixNDG(vexs, edges);
        G.print();
        G.DFS();
        G.BFS();
    }
}
