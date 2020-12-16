import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class graph {

	static String x;
	static int n,m;
	static int edges[][];
	static int G[][];
	static LinkedHashMap<Integer,Set<Integer>> order = new LinkedHashMap<Integer,Set<Integer>>();
	
	public static void main(String[] args) throws FileNotFoundException {
		String filename = null;
		String method = null;
		int no_of_color;
		long startTime,endTime,duration;
		/**********************************************200-1534**********************************************************/
		System.out.println("File 1 : 200 nodes 1534 edges");
		System.out.println("***********************************************");
		System.out.println("* Method : Duplicating");
		filename = "inputfiles/200-1534.txt";
		G = readGraph(filename);	//Function : 1
		if(!isBipartite(G)) {
			method = "duplicating";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used :");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
		System.out.println("* Method : Random Balanced Partition");
		if(!isBipartite(G)) {
			method = "random";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used :");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
		/**********************************************410-2765**********************************************************/
		System.out.println("File 2 : 410 nodes 2765 edges");
		System.out.println("***********************************************");
		System.out.println("* Method : Duplicating");
		filename = "inputfiles/410-2765.txt";
		G = readGraph(filename);	//Function : 1
		if(!isBipartite(G)) {
			method = "duplicating";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used :");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
		System.out.println("* Method : Random Balanced Partition");
		if(!isBipartite(G)) {
			method = "random";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used :");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
		/**********************************************643-2280**********************************************************/
		System.out.println("File 3 : 643 nodes 2280 edges");
		System.out.println("***********************************************");
		System.out.println("* Method : Duplicating");
		filename = "inputfiles/643-2280.txt";
		G = readGraph(filename);	//Function : 1
		if(!isBipartite(G)) {
			method = "duplicating";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used :");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
		System.out.println("* Method : Random Balanced Partition");
		if(!isBipartite(G)) {
			method = "random";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used :");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
		/**********************************************889-2914**********************************************************/
		System.out.println("File 4 : 889 nodes 2914 edges");
		System.out.println("***********************************************");
		System.out.println("* Method : Duplicating");
		filename = "inputfiles/889-2914.txt";
		G = readGraph(filename);	//Function : 1
		if(!isBipartite(G)) {
			method = "duplicating";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used :");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
		System.out.println("* Method : Random Balanced Partition");
		if(!isBipartite(G)) {
			method = "random";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used :");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
		/**********************************************962-18812**********************************************************/
		System.out.println("File 5 : 962 nodes 18812 edges");
		System.out.println("***********************************************");
		System.out.println("* Method : Duplicating");
		filename = "inputfiles/962-18812.txt";
		G = readGraph(filename);	//Function : 1
		if(!isBipartite(G)) {
			method = "duplicating";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used for");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
		System.out.println("* Method : Random Balanced Partition");
		if(!isBipartite(G)) {
			method = "random";
			G = makeBipartite(G,method);
		}
		order = generateOrder(G);	
		System.out.println("* No. of Colors Used for");
		startTime = System.nanoTime();
		no_of_color = firstFit(G, order);	//Function : 3
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; 
		System.out.println("*     FirstFit Algorithm : "+no_of_color+" ("+duration+" milli seconds)");		
		startTime = System.nanoTime();
		no_of_color = CBIP(G, order);	//Function : 4
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     CBIP Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo(G, order);	//Function : 5
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		startTime = System.nanoTime();
		no_of_color = myAlgo2(G, order);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("*     myAlgo2 Algorithm : "+no_of_color+" ("+duration+" milli seconds)");
		System.out.println("***********************************************");
	}
	
	public static int[][] readGraph(String filename) throws FileNotFoundException{
		Scanner scanner1 = new Scanner(new File(filename));
		
		x = scanner1.nextLine();
		while(x.startsWith("%")) {
			x = scanner1.nextLine();
		}
		//System.out.println(x);
		
		String convert[] = x.split(" ");
		n = Integer.parseInt(convert[0]);
		m = Integer.parseInt(convert[2]);
		
		//System.out.println(n);
		//System.out.println(m);
		
		edges = new int[m][2];
		
		for(int i=0;i<m;i++) {
			edges[i][0] = scanner1.nextInt();
			edges[i][1] = scanner1.nextInt();
		}
		/*for(int i=0;i<m;i++) {
			System.out.println(edges[i][0]+" "+edges[i][1]);
		}*/
		
		int[][] graph = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				graph[i][j] = 0;
			}
		}
		for(int i=0;i<m;i++) {
			graph[edges[i][0]-1][edges[i][1]-1] = 1;
			graph[edges[i][1]-1][edges[i][0]-1] = 1;
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(graph[i][j]+" ");
//			}
//			
//		}
		return graph;
	}
	public static int[][] makeBipartite(int G[][], String method){
		int[][] graph = null;
		if(method == "duplicating") {
			int x = 2*n;
			graph = new int[x][x];
			for(int i=0;i<x;i++) {
				for(int j=0;j<x;j++) {
					graph[i][j] = 0;
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=n;j<x;j++) {
					//System.out.println(i);
					//System.out.println(j);
					if(G[i][j-n] == 1) {
						graph[i][j] = 1;
						graph[j][i] = 1;
					}else {
						graph[i][j] = 0;
						graph[j][i] = 0;
					}
				}
			}
		}else if(method == "random") {
			graph = new int[n][n];
			List<Integer> L = new ArrayList<Integer>();
			List<Integer> R = new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				if(L.size() >= n/2) {
					R.add(i);
				}else if(R.size() >= n/2) {
					L.add(i);
				}else {
					int x = random_int(0,1);
					if(x == 0) {
						L.add(i);
					}else{
						R.add(i);
					}
				}
			}
			//System.out.println(L);
			//System.out.println(R);
			for(int i=0;i<L.size();i++) {
				int x = L.get(i);
				for(int j=0;j<R.size();j++) {
					int y = R.get(j);
					if(G[x][y] == 1) {
						graph[x][y] = 1;
						graph[y][x] = 1;
					}
				}
			}
		}
		return graph;
	}
	public static int firstFit(int G[][], LinkedHashMap<Integer,Set<Integer>> order) {
		int no_of_color = 0;
		int cc = 1;
		LinkedHashMap<Integer,Integer> colorMap = new LinkedHashMap<Integer,Integer>();
		Iterator orderitr = order.entrySet().iterator();
		while(orderitr.hasNext()) {
			Map.Entry orderelement = (Map.Entry)orderitr.next();
			int x = (int)orderelement.getKey();	//current input node
			Set<Integer> neighbours = (Set<Integer>)orderelement.getValue();	//neighbours
			Object[] neg = neighbours.toArray();	//neighbours
			while(true) {
				int flag = 0;
				for(int i=0;i<neg.length;i++) {
					if(colorMap.get(neg[i])==cc) {
						flag++;
					}
				}
				if(flag==0) {
					if(cc > no_of_color) {
						no_of_color = cc;
					}
					colorMap.put(x, cc);
					cc=1;
					break;
				}else {
					cc++;
				}
			}
		}
		//System.out.println(colorMap);
		return no_of_color;
	}
	
	public static int CBIP(int G[][], LinkedHashMap<Integer,Set<Integer>> order) {
		int no_of_color = 0;
		int cc = 1;
		LinkedHashMap<Integer,Integer> colorMap = new LinkedHashMap<Integer,Integer>();
		Iterator orderitr = order.entrySet().iterator();
		Set<Integer> U = new HashSet<Integer>();
		Set<Integer> V = new HashSet<Integer>();
		while(orderitr.hasNext()) {
			Map.Entry orderelement = (Map.Entry)orderitr.next();
			int x = (int)orderelement.getKey();	//current input node
			//System.out.println("x : "+x);
			Set<Integer> neighbours = (Set<Integer>)orderelement.getValue();	//neighbours
			Object[] neg = neighbours.toArray();	//neighbours
			if(neighbours.isEmpty()) {
				U.add(x);
				colorMap.put(x, cc);
			}else {
				int u=0,v=0;
				for(int j=0;j<neg.length;j++) {
					if(U.contains(neg[j])) {
						u++;
					}else if(V.contains(neg[j])){
						v++;
					}
				}
				if(u != neg.length && v != neg.length) {
					for(int j=0;j<neg.length;j++) {
						if(order.get(neg[j]).isEmpty()) {
							if(U.contains(neg[j])) {
								U.remove(neg[j]);
								V.add((Integer) neg[j]);
							}else {
								V.remove(neg[j]);
								U.add((Integer) neg[j]);
							}
						}
					}
				}
				if(U.contains(neg[0])) {
					V.add(x);
					Object[] U_neg = U.toArray();
					while(true) {
						int flag = 0;
						for(int i=0;i<U_neg.length;i++) {
							if(neighbours.contains(U_neg[i]) && colorMap.get(U_neg[i])==cc) {//neighbours.contains(U_neg[i]) && 
								flag++;
							}
						}
						if(flag==0) {
							if(cc > no_of_color) {
								no_of_color = cc;
							}
							colorMap.put(x, cc);
							cc=1;
							break;
						}else {
							cc++;
						}
					}
				}else {
					U.add(x);
					Object[] V_neg = V.toArray();
					while(true) {
						int flag = 0;
						for(int i=0;i<V_neg.length;i++) {
							if(neighbours.contains(V_neg[i]) && colorMap.get(V_neg[i])==cc) {//neighbours.contains(V_neg[i]) && 
								flag++;
							}
						}
						if(flag==0) {
							if(cc > no_of_color) {
								no_of_color = cc;
							}
							colorMap.put(x, cc);
							cc=1;
							break;
						}else {
							cc++;
						}
					}
				}
			}
		}
//		System.out.println(U);
//		System.out.println(V);
//		System.out.println(colorMap);
		return no_of_color;
	}
	public static int myAlgo2(int G[][], LinkedHashMap<Integer,Set<Integer>> order) {
		int no_of_color = 0;
		int cc = 1;
		LinkedHashMap<Integer,Integer> colorMap = new LinkedHashMap<Integer,Integer>();
		Iterator orderitr = order.entrySet().iterator();
		Set<Integer> U = new HashSet<Integer>();
		Set<Integer> V = new HashSet<Integer>();
		while(orderitr.hasNext()) {
			Map.Entry orderelement = (Map.Entry)orderitr.next();
			int x = (int)orderelement.getKey();	//current input node
			//System.out.println("x : "+x);
			Set<Integer> neighbours = (Set<Integer>)orderelement.getValue();	//neighbours
			Object[] neg = neighbours.toArray();	//neighbours
			if(neighbours.isEmpty()) {
				U.add(x);
				colorMap.put(x, cc);
			}else {
				int u=0,v=0;
				for(int j=0;j<neg.length;j++) {
					if(U.contains(neg[j])) {
						u++;
					}else if(V.contains(neg[j])){
						v++;
					}
				}
				if(u != neg.length && v != neg.length) {
					for(int j=0;j<neg.length;j++) {
						if(order.get(neg[j]).isEmpty()) {
							if(U.contains(neg[j])) {
								U.remove(neg[j]);
								V.add((Integer) neg[j]);
							}else {
								V.remove(neg[j]);
								U.add((Integer) neg[j]);
							}
						}
					}
				}
				if(U.contains(neg[0])) {
					V.add(x);
					Object[] U_neg = U.toArray();
					while(true) {
						int flag = 0;
						for(int i=0;i<U_neg.length;i++) {
							if(colorMap.get(U_neg[i])==cc) {
								flag++;
							}
						}
						if(flag==0) {
							if(cc > no_of_color) {
								no_of_color = cc;
							}
							colorMap.put(x, cc);
							cc=1;
							break;
						}else {
							cc++;
						}
					}
				}else {
					U.add(x);
					Object[] V_neg = V.toArray();
					while(true) {
						int flag = 0;
						for(int i=0;i<V_neg.length;i++) {
							if(colorMap.get(V_neg[i])==cc) {
								flag++;
							}
						}
						if(flag==0) {
							if(cc > no_of_color) {
								no_of_color = cc;
							}
							colorMap.put(x, cc);
							cc=1;
							break;
						}else {
							cc++;
						}
					}
				}
			}
		}
//		System.out.println(U);
//		System.out.println(V);
//		System.out.println(colorMap);
		return no_of_color;
	}
	
	public static int myAlgo(int G[][], LinkedHashMap<Integer,Set<Integer>> order) {
		int no_of_color = 0;
		int cc = 0;
		LinkedHashMap<Integer,Integer> colorMap = new LinkedHashMap<Integer,Integer>();
		Iterator orderitr = order.entrySet().iterator();
		while(orderitr.hasNext()) {
			Map.Entry orderelement = (Map.Entry)orderitr.next();
			int x = (int)orderelement.getKey();	//current input node
			Set<Integer> neighbours = (Set<Integer>)orderelement.getValue();	//neighbours
			Object[] neg = neighbours.toArray();	//neighbours
			for(int i=0;i<neg.length;i++) {
				if(colorMap.get(neg[i])>cc) {
					cc = colorMap.get(neg[i]);
				}
			}
			cc++;
			colorMap.put(x, cc);	
			if(cc > no_of_color) {
				no_of_color = cc;
			}		
			cc=0;
		}
		//System.out.println(colorMap);
		return no_of_color;
	}
	
	public static LinkedHashMap<Integer,Set<Integer>> generateOrder(int G[][]){
		LinkedHashMap<Integer,Set<Integer>> order = new LinkedHashMap<Integer,Set<Integer>>();
		List<Integer> nodes = new ArrayList<Integer>();
		for(int i=0;i<G.length;i++) {
			nodes.add(i);
		}
		while(!nodes.isEmpty()) {
			//System.out.println(nodes);
			int x = random_int(0,nodes.size()-1);
			int y = nodes.get(x);
			Set<Integer> neighbours = new HashSet<Integer>();
			Iterator orderitr = order.entrySet().iterator();
			while(orderitr.hasNext()) {
				Map.Entry orderelement = (Map.Entry)orderitr.next();
				int a = (int)orderelement.getKey();
				if(G[a][y] == 1) {
					neighbours.add(a);
				}
			}
			order.put(y, neighbours);
			nodes.remove(x);
		}
		return order;
	}
	
	public static int random_int(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}
	
	public static boolean isBipartite(int G[][]) { 
        int color[] = new int[n]; 
        for (int i = 0; i < n; ++i) {
            color[i] = -1; 
        }
        for (int i = 0; i < n; i++) { 
        	if (color[i] == -1) {
        		if (checkBipartite(G, i, color) == false) { 
        			return false; 
        		}
        	}
        }
        return true; 
    } 
	
    public static boolean checkBipartite(int G[][], int src, int color[]) { 
    	color[src] = 1; 
    	LinkedList<Integer> q = new LinkedList<Integer>(); 
    	q.add(src);
    	while (!q.isEmpty()) { 
    		int u = q.getFirst(); 
    		q.pop(); 
    		if (G[u][u] == 1) { 
            	return false;   
            }
        
    		for (int v = 0; v < n; ++v) { 
    			if (G[u][v] ==1 && color[v] == -1) { 
    				color[v] = 1 - color[u]; 
    				q.push(v); 
                } else if (G[u][v] == 1 && color[v] == color[u]) { 
                	return false; 
                }
            } 
        }
    	return true; 
	}
}
