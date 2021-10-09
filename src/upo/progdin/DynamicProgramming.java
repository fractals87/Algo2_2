package upo.progdin;

public class DynamicProgramming {
	

	/** Calcola la LCS tra <code>s1</code> e <code>s2</code> utilizzando l'algoritmo visto a lezione.
	 * </br>CONSIGLIO: potete usare i metodi di String per accedere alle posizioni di s1 ed s2.
	 * </br>CONSIGLIO2: potete costruire l'output come un array di caratteri, e poi trasformarlo in stringa,
	 * oppure usare le concatenazioni di stringhe nelle chiamate ricorsive (vedi slide).
	 * 
	 * @param s1 una sequenza di caratteri
	 * @param s2 una sequenza di caratteri
	 * @return una LCS di <code>s1</code> e <code>s2</code>
	 */
	public static String LongestCommonSubsequence(String s1, String s2) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/** Risolve il problema dello zaino 0-1 con l'algoritmo di programmazione dinamica visto a lezione.
	 * 
	 * @param weights un vettore contenente in posizione i-esima, per ogni oggetto oi, il suo peso. 
	 * @param values un vettore contenente in posizione i-esima, per ogni oggetto oi, il suo valore. 
	 * @param maxWeight la capienza dello zaino.
	 * @return un vettore di boolean che contiene, in posizione i-esima, true se l'oggetto i-esimo è
	 * incluso nella soluzione, false altrimenti.
	 */
	public static boolean[] getKnapsack01(int[] weights, int[] values, int maxWeight) {
			
	    int[] p = weights;
	    int[] v = values;
	    int n = p.length;
	    int P = maxWeight;
	
		boolean[] res = new boolean[n];
	    
	    int[][] V = new int[n+1][1+P];
	    boolean[][] K = new boolean[n+1][1+P];
		
        int i,j;
   	
    	for(i=1;i<n;i++) { 
    		for(j=1;j<=P;j++) {
        		//System.out.print(j+"<" + p[i] + "\n");
    			if(j<p[i]) {
    				//System.out.print("V[i][j] = V[i-1][j] ==>" + V[i-1][j] + "\n" );
    				V[i][j] = V[i-1][j];
    			}else {
    				//System.out.print("V[i-1][j], V[i-1][j-p[i]]+v[i] ==>MAX:" + V[i-1][j] + "-" + (V[i-1][j-p[i]]+v[i]) + "\n" );
    				//V[i][j] = Math.max(V[i-1][j], V[i-1][j-p[i]]+v[i]);
    				if(V[i-1][j] > V[i-1][j-p[i]]+v[i]) {
    					V[i][j] =V[i-1][j];
    				}else {
    					V[i][j] =V[i-1][j-p[i]]+v[i];
    					K[i][j] = true;
    				}
    			}
    		}
    	}

    	//stampaV( n,  P, V);
    	//stampaK( n,  P, K);

    	//Prepare soluzions "RES"
    	i=n-1;
        j=P;
        //System.out.print("Verifica Soluzione: \n" + n);
        while( i>=0 ) {
            if ( K[i][j] ) {
                //System.out.print("Oggetto "+i+" di peso "+p[i]+" e valore "+v[i] + "\n");
                j-=p[i];
                res[i] = true;
            }
            i=i-1;
        }
        //System.out.print("Valore totale "+V[n-1][P] + "\n");
        //System.out.print("Peso totale "+(P-j)+" su "+P + "\n");
        
        
        /*
        for(i=0;i<n;i++)
            System.out.print(res[i] + "-");        	
        System.out.print("\n");
    	*/
        return res;
	}
	/*
	private static void stampaV(int n, int P, int[][]V) {
    	for (int i=0; i<n; i++) {
    	    for (int j=0; j<=P; j++) {
    		System.out.print(V[i][j]+" ");
    	    }
    	    System.out.println();
    	}
	}
	
	private static void stampaK(int n, int P, boolean[][]K){
    	for (int i=0; i<n; ++i) {
    	    for (int j=0; j<=P; ++j) {
    		System.out.print(K[i][j]+" ");
    	    }
    	    System.out.println();
    	}
	}*/
	
}
