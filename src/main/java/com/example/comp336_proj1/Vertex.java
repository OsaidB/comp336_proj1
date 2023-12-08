package com.example.comp336_3;

import java.util.Comparator;
import java.util.LinkedList;

public class Vertex {
	College college;
	Vertex previous;
	int num;
	double distance=Integer.MAX_VALUE;
	boolean visited;
	LinkedList<edges> e = new LinkedList<edges>();

	public Vertex(College college, int number) {
		super();
		this.college = college;
		this.num = number;
	}

	public College getCollege() {
		return college;
	}


	public void setCollege(College college) {
		this.college = college;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public LinkedList<edges> getE() {
		return e;
	}

	public void setE(LinkedList<edges> e) {
		this.e = e;
	}

	public boolean FindEdge(String ss) {

		for (int i = 0; i < e.size(); i++) {
			if (e.get(i).getD().getCollege().getName().compareToIgnoreCase(ss) == 0)
				return true;
		}
		return false;
	}

	public String ttoString() {
		String r = college.getName()+":";
		for (int i = 0; i < e.size(); i++) {
			r = r + e.get(i).desination.college.getName() + "\n";
		}
		return r;
	}

	// Usage of comparator
	public Comparator<Vertex> coNameComparator = new Comparator<Vertex>() {

		@Override
		public int compare(Vertex o1, Vertex o2) {
			return 0;
		}

		// Comparing attributes of
		public int compare(College c1, College c2) {

			String coName1 = c1.getName().toUpperCase();
			String coName2 = c2.getName().toUpperCase();

			// Returning in ascending order
			return coName1.compareTo(coName2);

			// descending order
			// return
			// StudentName2.compareTo(StudentName1);
		}
	};

}
