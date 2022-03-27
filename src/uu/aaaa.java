package uu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class aaaa {
	public static void main(String[] args) {
		String[]aStrings = {"x","z","y","s","t"};
		int[][] yaya = {{8,0,1},{9,0,2},{4,1,3},{7,2,1},{9,3,0},{5,3,2},{7,3,4},{8,4,3},{1,4,0},{2,4,2}};
		ArrayList<Node> yeyeArrayList = new ArrayList<Node>();
		ArrayList<String> S= new ArrayList<String>();
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
		int i=0;
		for(String qString : aStrings)
		{
			int a = (qString=="s") ? 0 : 10000;
			yeyeArrayList.add(new Node(i,a,qString));
			tempArrayList.add(i);
			i++;
		}
		for (int[] a : yaya)
		{
			yeyeArrayList.get(a[1]).addNei(a[2], a[0]);
		}
		for (int j = tempArrayList.size()-1; j >0; j--) {
			if(yeyeArrayList.get(tempArrayList.get(j)).weight<yeyeArrayList.get(tempArrayList.get(j-1)).weight)
			{
				int a = tempArrayList.get(j);
				tempArrayList.set(j, tempArrayList.get(j-1));
				tempArrayList.set(j-1, a);
			}
		}
		while(!tempArrayList.isEmpty())
		{
			int aNode = tempArrayList.get(0);
			tempArrayList.remove(0);
			for(int nei : yeyeArrayList.get(aNode).edge.keySet())
			{
				if(yeyeArrayList.get(nei).weight>yeyeArrayList.get(aNode).weight+yeyeArrayList.get(aNode).edge.get(nei))
				{
					yeyeArrayList.get(nei).weight = yeyeArrayList.get(aNode).weight+yeyeArrayList.get(aNode).edge.get(nei);
					yeyeArrayList.get(nei).parent = aStrings[aNode];
				}
			}
			for (int j = tempArrayList.size()-1; j >0; j--) {
				if(yeyeArrayList.get(tempArrayList.get(j)).weight<yeyeArrayList.get(tempArrayList.get(j-1)).weight)
				{
					int a = tempArrayList.get(j);
					tempArrayList.set(j, tempArrayList.get(j-1));
					tempArrayList.set(j-1, a);
				}
			}
			S.add(aStrings[aNode]);
			for(Node aNode2 : yeyeArrayList)
			{
				System.out.print(aNode2.Al+":("+aNode2.weight+","+aNode2.parent+") ");
			}
			System.out.print(S +" [");
			for(int a : tempArrayList)
			{
				System.out.print(aStrings[a]+",");
			}
			System.out.println("]");
		}
	}
}
class Node  
{
	int weight,root;
	String parent;
	String Al;
	HashMap<Integer,Integer> edge =new HashMap<Integer, Integer>();
	public Node(int root,int weight,String a)
	{
		this.weight = weight;
		this.root = root;
		parent = null;
		Al = a;
	}
	public void addNei(int nei,int weight)
	{
		edge.put(nei, weight);
	}

	@Override
	public String toString() {
		return Al;
	}

}
