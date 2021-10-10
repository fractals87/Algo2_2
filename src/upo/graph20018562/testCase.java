package upo.graph20018562;

import static org.junit.Assert.*;

import org.junit.Test;

import upo.progdin.DynamicProgramming;

public class testCase {

	@Test
	public void testKnapsack01() {
		boolean[] res = new boolean[4];
		boolean[] resExpected = {false,true,true,false};
		
		int[] weights = {0,2,7,6};
		int[] values  = {0,13,7,2};
		int maxWeight = 10;
		res = DynamicProgramming.getKnapsack01(weights, values, maxWeight);
		for (int i = 0; i < resExpected.length; i++) {
	        assertEquals(resExpected[i], res[i]);
		}
	}
	
	@Test
	public void testPriorityQueue() {
		PriorityQueueArr q = new PriorityQueueArr(5);
		q.enqueue(0, 9);
		q.enqueue(1, 1);
		q.enqueue(2, 6);
		q.enqueue(3, -1);
		q.enqueue(4, 2);
		
		//q.ViewQueue();
		
		assertEquals(1,q.dequeue());
		assertEquals(4,q.dequeue());
		assertEquals(2,q.dequeue());
		assertEquals(0,q.dequeue());
		assertEquals(-1,q.dequeue());	
	}
	
	@Test
	public void testPrim() {
		AdjListUndirWeight adjListUndirWeight = new AdjListUndirWeight();
		adjListUndirWeight.addVertex();
		adjListUndirWeight.addVertex();
		adjListUndirWeight.addVertex();
		adjListUndirWeight.addVertex();
		adjListUndirWeight.addVertex();
		adjListUndirWeight.addEdge(0, 1);
		adjListUndirWeight.addEdge(1, 2);
		adjListUndirWeight.addEdge(2, 3);
		adjListUndirWeight.addEdge(3, 4);
		adjListUndirWeight.addEdge(4, 0);
		adjListUndirWeight.addEdge(0, 3);
		adjListUndirWeight.addEdge(4, 2);
		
		adjListUndirWeight.setEdgeWeight(0, 1, 2);
		adjListUndirWeight.setEdgeWeight(1, 2, 3);
		adjListUndirWeight.setEdgeWeight(2, 3, 2);
		adjListUndirWeight.setEdgeWeight(3, 4, 2);
		adjListUndirWeight.setEdgeWeight(4, 0, 4);
		adjListUndirWeight.setEdgeWeight(0, 3, 9);
		adjListUndirWeight.setEdgeWeight(4, 2, 9);		
		
		AdjListUndirWeight res = (AdjListUndirWeight)adjListUndirWeight.getPrimMST(0);
		adjListUndirWeight.viewGraph();
		System.out.print("\n");
		res.viewGraph();
		
		AdjListUndirWeight correctRes = new AdjListUndirWeight();
		correctRes.addVertex();
		correctRes.addVertex();
		correctRes.addVertex();
		correctRes.addVertex();
		correctRes.addVertex();
		correctRes.addEdge(0, 1);
		correctRes.addEdge(1, 2);
		correctRes.addEdge(2, 3);
		correctRes.addEdge(3, 4);
		
		correctRes.setEdgeWeight(0, 1, 2);
		correctRes.setEdgeWeight(1, 2, 3);
		correctRes.setEdgeWeight(2, 3, 2);
		correctRes.setEdgeWeight(3, 4, 2);
		
		assertEquals(true, res.equals(correctRes));
		
	}

}
