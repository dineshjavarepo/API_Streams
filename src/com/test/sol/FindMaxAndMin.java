package com.test.sol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMaxAndMin {
	
	public int findMaxAndMin(int[] arrys) {
		
		int max = Arrays.stream(arrys).max().getAsInt();
		
		int min = Arrays.stream(arrys).min().getAsInt();
		
		Set<Integer> set = new HashSet<Integer>();
		
		Optional<Integer> firstDuplicate = Arrays.stream(arrys).boxed().filter(s->!set.add(s)).findFirst();
		
		List<Integer> duplicates = Arrays.stream(arrys).boxed().filter(s->!set.add(s)).toList();
		
		List<Integer> uniqueList = Arrays.stream(arrys).boxed().filter(s->set.add(s)).collect(Collectors.toList());
		
		Integer firstNonRepeating = Arrays.stream(arrys).boxed().collect(Collectors.groupingBy(
                                       Function.identity(), LinkedHashMap:: new,Collectors.counting()))
				                      .entrySet().stream().filter(s->s.getValue()==1)
				                      .map(Map.Entry :: getKey).findFirst().orElse(null);
		
		
		
		return 0;
		
	}

}
