package uu;

import java.util.ArrayList;
import java.util.Arrays;

public class uuu {

	public static void main(String[] args) {
		String[]aStrings = {"a","b","c","d","e"};
		String[] parent = {null,null,null,null,null};
		int[] W = {0,10000,10000,10000,10000};

		ArrayList<edge> edgelist = new ArrayList<edge>();
		int[][] E  = {{6,0,1},{2,0,4},{3,1,3},{-2,1,4},{-1,2,1},{-1,3,2},{2,4,3}};
		for (int i = 0; i < 7; i++) {
			edgelist.add(new edge(E[i][0], E[i][1], E[i][2]));
		}
		for (int i = 0; i < aStrings.length-1; i++) {
			for(edge edge: edgelist)
			{
				if(W[edge.root]+edge.weight<W[edge.child])
				{
					W[edge.child] = W[edge.root]+edge.weight;
					parent[edge.child] = aStrings[edge.root];
				}
			}
			System.out.print(i+". ");
			for (int j = 0; j < aStrings.length; j++) {
				System.out.print("("+W[j]+","+parent[j]+")");
			}
			System.out.print("\n");
		}
	}
}
class edge{
	public int weight;
	public int root,child;
	public edge(int weight,int root,int child)
	{
		this.weight = weight;
		this.root = root;
		this.child = child;
	}
}
