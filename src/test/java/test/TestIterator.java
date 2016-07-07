package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestIterator {
	@Test
	public void test(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> iterator  = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
