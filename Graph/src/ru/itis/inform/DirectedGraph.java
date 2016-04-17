package ru.itis.inform;

/**
 * Created by Иван on 19.02.2016.
 */
public interface DirectedGraph {
    . * Добавление вершины в граф
    void addVertex();

    /**
     * Добавление ребра
     * @param vertexA первая вершина
     * @param vertexB вторая вершина
     */
    void addDirectedEdge(int vertexA, int vertexB);

    /**
     * Вывод графа на экран
     */

    void runFloyd();

}
