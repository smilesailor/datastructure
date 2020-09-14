package main.graph;

public class ListNDG {
    class Vertex {
        char ch;
        Vertex next;

        Vertex(char ch) {
            this.ch = ch;
        }

        void add(char ch) {
            Vertex node = this;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Vertex(ch);
        }
    }

    int size;
    Vertex[] vertexLists;

    public ListNDG(char[] vertexs, char[][] edges) {
        this.size = vertexs.length;
        this.vertexLists = new Vertex[size];

        for (int i = 0; i < size; i++) {
            this.vertexLists[i] = new Vertex(vertexs[i]);
        }

        for (char[] ch : edges) {
            int p1 = getPosition(ch[0]);
            this.vertexLists[p1].add(ch[1]);
            int p2 = getPosition(ch[1]);
            this.vertexLists[p2].add(ch[0]);
        }
    }

    public int getPosition(char c) {
        for (int i = 0; i < size; i++) {
            if (c == vertexLists[i].ch) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            Vertex head = vertexLists[i];
            while (head != null) {
                System.out.print(head.ch + " ");
                head = head.next;
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
        ListNDG G = new ListNDG(vexs, edges);
        G.print();
    }
}
