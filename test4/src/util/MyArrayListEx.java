package util;

public class MyArrayListEx <E> extends MyArrayList<E>{
	public int indexOf(Object o){
		if(o==null){
			System.out.println("²âÊÔÕıÈ·");
		}else{
			System.out.println("²âÊÔÊ§°Ü");
		}
		return -1;
	}

}
