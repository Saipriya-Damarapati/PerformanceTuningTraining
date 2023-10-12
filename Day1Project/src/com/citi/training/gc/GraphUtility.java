package com.citi.training.gc;

import java.util.ArrayList;
import java.util.List;

public class GraphUtility {
    private List<Graph> graphs=new ArrayList<>();
    
    public void addGraph(Graph g)
    {
        graphs.add(g);
    }
    
    public void removeGraph(Graph g)
    {
        graphs.remove(g);
    }
    
    public void processGraph(Graph g)
    {
        graphs.add(g);
        System.out.println("processing "+g);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("completed processing "+g);
        graphs.remove(g); //intentional to trigger gc
    }

}

