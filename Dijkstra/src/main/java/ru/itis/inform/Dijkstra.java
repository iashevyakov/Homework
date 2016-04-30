package ru.itis.inform;

import static java.lang.Integer.min;
public class Dijkstra {
    int INF = Integer.MAX_VALUE / 2; // "Бесконечность"
     public int vNum; // количество вершин
       public int[][] graph; // матрица смежности
        public Dijkstra(int a, int[][] g)
        {
            this.vNum=a;
            this.graph=g;
        }


           public int[] dijkstra(int start) {
                boolean[] used = new boolean [vNum]; // массив пометок
                int[] dist = new int [vNum]; // массив расстояния. dist[v] = минимальное_расстояние(start, v)

                fill(dist, INF); // устанаавливаем расстояние до всех вершин INF
                dist[start] = 0; // для начальной вершины положим 0

                while(true) {
                        int v = -1;
                       for (int nv = 0; nv < vNum; nv++) // перебираем вершины
                                 if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv])) // выбираем самую близкую непомеченную вершину
                                    v = nv;
                        if (v == -1) break; // ближайшая вершина не найдена
                        used[v] = true; // помечаем ее
                      for (int nv = 0; nv < vNum; nv++)
                              if (!used[nv] && graph[v][nv] < INF) // для всех непомеченных смежных
                                   dist[nv] = Math.min(dist[nv], dist[v] + graph[v][nv]); // улучшаем оценку расстояния (релаксация)
                }
                return dist;


             }


            public void fill (int[] a, int b)
            {for (int i=0; i<a.length;i++)
                {a[i]=b;}
            }


}
