package com.hackerrank.examQuestions;

import java.util.Scanner;

class Point2D {
	int x;
	int y;
	Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	double dist2D(Point2D p) {
		int dx = p.x - x;
		int dy = p.y - y;
		double dis = Math.sqrt((dx) * (dx) + (dy) * (dy));
		return dis;
	}
	void printDistance(double d) {
		System.out.println("2D distance = "+Math.round(Math.ceil(d)));
	}
} //Point2D Class

class Point3D extends Point2D {
	int z;
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
		// TODO Auto-generated constructor stub
	}
	double dist3D(Point3D p) {
		int dx = p.x - x;
		int dy = p.y - y;
		int dz = p.z - z;
		// We should avoid Math.pow or Math.hypot due to perfomance reasons
		double dis = Math.sqrt(dx * dx + dy * dy + dz * dz);
		return dis;
	}
	void printDistance(double d) {
		System.out.println("3D distance = "+Math.round(Math.ceil(d)));
	}
} //Point3D Class



public class DistanceBetween2DAnd3D {
	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		   int x1 = scanner.nextInt();
		   int y1 = scanner.nextInt();
		   int z1 = scanner.nextInt();
		   int x2 = scanner.nextInt();
		   int y2 = scanner.nextInt();
		   int z2 = scanner.nextInt();
		         scanner.close();
		         
		         Point3D p1 = new Point3D(x1, y1, z1);
		         Point3D p2 = new Point3D(x2, y2, z2);
		         
		         double d2 = p1.dist2D(p2);
		         double d3 = p1.dist3D(p2);
		         
		         Point2D  p = new Point2D(0,0);
		         p.printDistance(d2);
		         p = p1;
		         p.printDistance(d3);
	}
}
