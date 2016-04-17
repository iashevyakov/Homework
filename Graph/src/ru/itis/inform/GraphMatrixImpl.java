import ru.itis.inform.DirectedGraph;

public class GraphMatrixImpl implements Graph,DirectedGraph {

    private static final int DEFAULT_SIZE = 50;
    /**
     * Тут храним вершины и ребра
     */
    private int matrix[][];
    private int dmatrix[][];

    /**
     * Сколько вершин сейчас в графе. Вершины нумеруются от 0.
     */
    private int verticesCount;

    private int maxSize;

    public GraphMatrixImpl() {
        initGraph(DEFAULT_SIZE);
    }

    public GraphMatrixImpl(int maxSize) {
        initGraph(maxSize);
    }

    private void initGraph(int maxSize) {
        this.maxSize = maxSize;
        this.verticesCount = 0;
        this.matrix = new int[maxSize][maxSize];
        this.dmatrix = new int[maxSize][maxSize];
    }

    @Override
    public void addVertex() {
        if (this.verticesCount < this.maxSize) {
            this.verticesCount++;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void addEdge(int vertexA, int vertexB) {
        if (vertexA < verticesCount && vertexB < verticesCount) {
            this.matrix[vertexA][vertexB] = vertexA+vertexB ;
            this.matrix[vertexB][vertexA] = vertexA+vertexB;

        } else throw new IllegalArgumentException();

    }
    //0 - пути между вершинами вообще нет
    public void runFloyd()
    {
            for (int k=0; k<verticesCount; k++)
        {
            for (int i=0; i<verticesCount; i++)
            {
            
                for (int j=0; j<verticesCount; j++)
                    {
                        if (matrix[i][j]>matrix[i][k]+matrix[k][j])
                           {dmatrix[i][j]=matrix[i][k]+matrix[k][j];}
                        else
                        {dmatrix[i][j]=matrix[i][j];} 
                    }
             }
        }
    }
    @Override
    public void addDirectedEdge(int vertexA, int vertexB) {
        if (vertexA < verticesCount && vertexB < verticesCount) {
            this.matrix[vertexA][vertexB] = vertexA+vertexB;

        } else throw new IllegalArgumentException();

    }


}