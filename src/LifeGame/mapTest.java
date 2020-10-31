package LifeGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class mapTest {
	private static map test=new map();
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testIni() {
		int flag=0;
		test.ini();
		for(int i=1;i<51;i++) {
			for(int j=1;j<51;j++) {
				if(test.getCell(i,j)==1) {
					flag=1;
					break;
				}
			}
		}
		Assert.assertEquals(1, flag);
	}
	
	@Test
	public void testClear() {
		int flag=0;
		test.clear();
		for(int i=1;i<51;i++) {
			for(int j=1;j<51;j++) {
				if(test.getCell(i,j)==1) {
					flag=1;
					break;
				}
			}
		}
		Assert.assertEquals(0, flag);
	}
	
	@Test
	public void testCount() {
		test.clear();
		test.setCell(1,1,1);
		test.setCell(1,2,1);
		test.count(2, 2);
		Assert.assertEquals(2, test.getK(2,2));
	}

	@Test
	public void testNext() {
		int flag=0;
		test.clear();
		for(int i=1;i<4;i++) {
			for(int j=1;j<4;j++) test.setCell(i, j, 1);
		}
		test.printMap();
		test.next();
		test.printMap();
		int[][] testMap_1=new int[][] {
			{0,0,0,0,0},
			{0,1,0,1,0},
			{0,0,0,0,1},
			{0,1,0,1,0},
			{0,0,1,0,0}
		};
		for(int i=1;i<5;i++) {
			for(int j=1;j<5;j++) {
				if(test.getCell(i, j)!=testMap_1[i][j]) flag=1;
			}
		}
		Assert.assertEquals(0,flag);
		test.next();
		test.printMap();
		int[][] testMap_2=new int[][] {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,1,1},
			{0,0,1,1,0},
			{0,1,0,0,0}
		};
		for(int i=1;i<4;i++) {
			for(int j=1;j<4;j++) {
				if(test.getCell(i, j)!=0) flag=1;
			}
		}
		Assert.assertEquals(0,flag);
	}

}
