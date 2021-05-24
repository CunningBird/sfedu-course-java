package com.cunningbird;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph();

        myGraph.addEdge(1, 3);
        myGraph.addEdge(1, 7);
        myGraph.addEdge(2, 4);
        myGraph.addEdge(3, 0);
        myGraph.addEdge(3, 5);
        myGraph.addEdge(5, 4);
        myGraph.addEdge(6, 2);
        myGraph.addEdge(6, 5);
        myGraph.addEdge(7, 0);
        myGraph.addEdge(7, 6);

        int[] startPoints = new int[]{2, 7};
        System.out.println(myGraph.pathsCount(startPoints));
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

    public void addEdge(Integer vertexName1, Integer vertexName2) {
        if (!hasVertex(vertexName1)) addVertex(vertexName1);
        if (!hasVertex(vertexName2)) addVertex(vertexName2);

        List<Integer> edges = vertexMap.get(vertexName1);
        edges.add(vertexName2);
        Collections.sort(edges);
    }

    // TODO FIX THIS
    public int pathsCount(int[] Y) {
        int[] M = new int[vertexMap.size()];
        int[] V = new int[vertexMap.size()];

        for (int i = 0; i < vertexMap.size(); ++i) {
            M[i] = 0;
            V[i] = 0;
        }

        for (int i : Y) {
            V[i] = 1;
        }

        int T;
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

                for (Integer str : value) {
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