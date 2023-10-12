package com.citi.training.gc;

public class TestMain {

	// from cmd run as java -Xms50m -Xmx100m com.citi.training.gc.TestMain
	public static void main(String[] args) {
		GraphUtility utility = new GraphUtility();
		for(int i = 1; i <= 500; i++) {
			Point[] points = new Point[i*100];
			for(int j = 0; j < points.length; j++) {
				points[j] = new Point(i*2, j);
			}
			Graph graph = new Graph(points);
			utility.processGraph(graph);
		}
	}
}
