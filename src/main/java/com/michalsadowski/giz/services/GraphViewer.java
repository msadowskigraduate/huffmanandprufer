package com.michalsadowski.giz.services;

import org.graphstream.graph.Graph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

/**
 * Created by sadowsm3 on 23.05.2018
 */
public class GraphViewer {
    private GraphViewer() {
    }

    public static void viewGraph(Graph graph) {
        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        HierarchicalLayout h1 = new HierarchicalLayout();
        viewer.enableAutoLayout(h1);
        viewer.addDefaultView(true);
    }
}
