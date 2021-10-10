package upo.graph20018562;

import upo.additionalstructures.PriorityQueue;

public class PriorityQueueArr implements PriorityQueue {

	int[] queue;
	
	public PriorityQueueArr(int size) {
		queue = new int[size];
		for(int i=0; i < queue.length; i++ )
			queue[i]=-1;
	}
		
	@Override
	public void enqueue(int el, int priority) {
		// TODO Auto-generated method stub
		queue[el] = priority;
	}

	@Override
	public int dequeue() {
	    double minValue = -1;
	    int minIndex = -1;
		for(int i=0; i < queue.length; i++ ) {
			if(minValue == -1) {
				minValue = queue[i];
				minIndex = i;
			}else{
				if(minValue>queue[i] && queue[i]!=-1) {
					minValue = queue[i];
					minIndex = i;
				}
			}
		}
		queue[minIndex] = -1;
		if(minValue == -1)
			return -1;
		else
			return minIndex;
	}

	@Override
	public void modify_priority(int el, int newPriority) {
		// TODO Auto-generated method stub
		queue[el] = newPriority;		
	}
	
	public void ViewQueue() {
		for(int i=0; i < queue.length; i++ ) {
			System.out.println("I:" + i + " P:" + queue[i] );
		}
	}

}
