package util;

public class MyArrayListEx <E> extends MyArrayList<E>{
	public int indexOf(Object o){
		if(o==null){
			System.out.println("������ȷ");
		}else{
			System.out.println("����ʧ��");
		}
		return -1;
	}

}
