package com.cunningbird;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph();
        myGraph.addEdge(0, 2);
        myGraph.addEdge(2, 4);
        myGraph.addEdge(2, 8);
        myGraph.addEdge(8, 1);
        myGraph.addEdge(8, 7);
        myGraph.addEdge(4, 1);
        myGraph.addEdge(4, 6);
        myGraph.addEdge(7, 6);
        myGraph.addEdge(7, 3);
        myGraph.addEdge(1, 3);
        myGraph.addEdge(6, 5);
        myGraph.addEdge(3, 5);

        int[] points = new int[]{1, 6};
        System.out.println(myGraph.pathCounts(points));
    }
}

class MyGraph {
    private final HashMap<Integer, List<Integer>> vertexMap = new HashMap<>();

    public void addVertex(Integer vertexName) {
        if (!hasVertex(vertexName)) {
            vertexMap.put(vertexName, new ArrayList<>());
        }
    }

    public boolean hasVertex(Integer vertexName) {
        return vertexMap.containsKey(vertexName);
    }

    public boolean hasEdge(Integer vertexName1, Integer vertexName2) {
        if (!hasVertex(vertexName1)) return false;

        List<Integer> edges = vertexMap.get(vertexName1);
        return Collections.binarySearch(edges, vertexName2) != -1;
    }

    public void addEdge(Integer vertexName1, Integer vertexName2) {
        if (!hasVertex(vertexName1)) addVertex(vertexName1);
        if (!hasVertex(vertexName2)) addVertex(vertexName2);

        List<Integer> edges = vertexMap.get(vertexName1);
        edges.add(vertexName2);
        Collections.sort(edges);
    }

    public Map<Integer, List<Integer>> getVertexMap() {
        return vertexMap;
    }

    /**
     * @param Y - Array of Vertexes
     * @return Count of ways to each Vertex
     */
    public int pathCounts(int[] Y) {
        int T;
        int[] M = new int[vertexMap.size()];
        int[] V = new int[vertexMap.size()];

        for (int i = 0; i < vertexMap.size(); ++i) {
            M[i] = 0;
            V[i] = 0;
        }

        for (int i : Y) {
            V[i] = 1;
        }

        int _T;
        int[] _M = new int[vertexMap.size()];
        int[] _V = new int[vertexMap.size()];

        do {
            T = 0;
            for (int i = 0; i < vertexMap.size(); ++i) {
                T += M[i];
            }
            for (int i = 0; i < vertexMap.size(); ++i) {
                _M[i] = M[i] + V[i];
                _V[i] = 0;
            }
            for (Map.Entry<Integer, List<Integer>> entry : vertexMap.entrySet()) {
                Integer key = entry.getKey();
                List<Integer> value = entry.getValue();

                for (Integer str: value) {
                    _V[key] += V[str];
                }
            }
            _T = 0;
            for (int i = 0; i < vertexMap.size(); ++i) {
                _T += _M[i];
            }
            for (int i = 0; i < vertexMap.size(); ++i) {
                M[i] = _M[i];
                V[i] = _V[i];
            }
        } while (T != _T);

        return _T;
    }
}