package LifeGame;

import java.util.Random;

public class map {
	private int[][] map=new int[52][52];
	private int[][] k=new int[52][52];
	public int getCell(int i,int j) { return map[i][j]; }
	public int getK(int i,int j) {return k[i][j];}
	public void setCell(int i,int j,int a) { map[i][j]=a;  }  
	public void setK(int i,int j,int a) {  k[i][j]=a;  }
	public void printMap() {
		for(int i=1;i<51;i++) {
			for(int j=1;j<51;j++) System.out.print(map[i][j]);
			System.out.println();
		}
	}
	public void ini() {
		for(int i=0;i<52;i++) {
			map[0][i]=0;
			map[i][0]=0;
			map[51][i]=0;
			map[i][51]=0;
		}
		
		Random r=new Random();
		for(int i=1;i<51;i++) {
			for(int j=1;j<51;j++) {
				int number=r.nextInt();
				if(number<0.5) map[i][j]=0;
				if(number>=0.5) map[i][j]=1;
			}
		}
	}
	public void clear() {
		for(int i=0;i<52;i++) {
			for(int j=0;j<52;j++) {
				map[i][j]=0;
			}
		}
	}
	public void count(int row,int col) {
		for(int i=-1;i<2;i++) {
			for(int j=-1;j<2;j++) {
				if(i==0&&j==0) continue;
				if(map[row+i][col+j]==1) k[row][col]++;
			}
		}
	}
	public void next() {
		for(int i=0;i<52;i++) {
			for(int j=0;j<52;j++ ) {
				k[i][j]=0;
			}
		}
		for(int i=1;i<51;i++) {
			for(int j=1;j<51;j++) {
				count(i,j);
			}
		}
		for(int i=1;i<51;i++) {
			for(int j=1;j<51;j++) {
				if(k[i][j]==3) map[i][j]=1;
				else if(k[i][j]!=2) map[i][j]=0;
			}
		}
	}
	public int[][] getMap() {
		return map;
	}
}

