package com.test.sol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
		
		List<Integer> l1 = new ArrayList<>(List.of(1,3,5));
		List<Integer> l2 = new ArrayList<>(List.of(2,4,6));
		
		List<Integer> result = new ArrayList<>();
		
		for(int i=0;i<Math.min(l1.size(), l2.size());i++) {
			result.add(l1.get(i));
			result.add(l2.get(i));
		}
		
		int[] result1 = result.stream().mapToInt(Integer::valueOf).toArray();
		
		result = IntStream.range(0, l1.size())
				.boxed()
				.flatMap(i-> Stream.of(l1.get(i),l2.get(i)))
				.toList();
		
		
		
		return 0;
		
	}

}
