package upo;

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

}
