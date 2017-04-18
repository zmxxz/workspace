package test4;

import util.MyArrayList;

public class TestMyArrayList {
	public static void main(String[] args){
		TestMyArrayList myTest = new TestMyArrayList();
		myTest.testAdd();
	}

	private void testAdd() {
		// TODO Auto-generated method stub
		MyArrayList al = new MyArrayList();
		Integer a1 = new Integer(1);
		Integer a2 = new Integer(2);
		al.add(a1);
		al.add(a2);
		if(al.size()==2&&al.contains(a2)&&al.contains(a1)){
			System.out.println("success!");
		}else{
			System.out.println("fail!");
		}
	}
}
