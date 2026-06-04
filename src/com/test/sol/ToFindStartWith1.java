package com.test.sol;


import java.util.List;
import java.util.stream.Collectors;

public class ToFindStartWith1 {

	
	public List<Integer> findNumber(){
		
		List<Integer> list = List.of(10, 15, 8, 49, 25, 98, 3);
		
		List<List<Integer>> lists = List.of(List.of(1,2),List.of(3,4));
		
	    List<Integer> result = list.stream().filter(s->s.toString().startsWith("1")).toList();
	    
	    List<Integer> result1 = list.stream().filter(s->s.toString().startsWith("1")).map(s->s*2).toList();
	    
	    List<Integer> result2 = list.stream().filter(s->s.toString().startsWith("1")).collect(Collectors.toList());
	    
	    List<Integer> result3 = lists.stream().flatMap(s->s.stream()).filter(s->s.toString().startsWith("1")).collect(Collectors.toList());
	    
	    
	    
	    return result;
	}
}
