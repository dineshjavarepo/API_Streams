package com.test.sol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.test.dao.Empolyee;

public class FindDuplicateInArray {

	public List<Integer> findDuplicate(int[] nums) {
		
		List<Integer> result = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		result = Arrays.stream(nums).boxed().filter(i-> !set.add(i)).toList();
		
		List<Integer> result1 = new ArrayList<>();
		
		result1 = Arrays.stream(nums).boxed().filter(i-> Collections.frequency(Arrays.stream(nums).boxed().collect(Collectors.toList()), i) > 1).collect(Collectors.toList());
		
		return result;
	}
	
	
	public int findNonRepeatNumber(int[] nums) {
		
		int val = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(
				Function.identity(), LinkedHashMap :: new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e->e.getValue() == 1)
				.map(Map.Entry :: getValue)
				.findFirst()
				.orElse(null).intValue();
		
		return val;
		
	}
	
	public int findFirstDuplicate(int[] nums) {
		
		int val = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(
				Function.identity(), LinkedHashMap :: new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e->e.getValue()>1)
				.map(Map.Entry::getKey)
				.findFirst()
				.orElse(null).intValue();
		
		return val;
	}
	
	public int findSecondDuplicate(int[] nums) {
		
		int val = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(
				Function.identity(),LinkedHashMap :: new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(i->i.getValue()>1)
                .map(Map.Entry :: getKey)
                .skip(1)
                .findFirst()
                .orElse(null).intValue();
		
		return val;
				
	}
	
	public int findSecondLargestNumber(int[] nums) {
		
		int val = Arrays.stream(nums).boxed()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.orElse(0)
				.intValue();
		
		return val;
	}
	
	public Map<String, Long> findOccurances(List<String> list){
		
		Map<String, Long> result = new HashMap<>();
		
		result = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		return result;
							
	}
	
	
	public Map<Character, Long> findCharacterCount(String str){
		
		Map<Character, Long> result = str.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		return result;
	}
	
	public char findFirstDuplicateCharacter(String str) {
		
		return str.chars()
			      .mapToObj(c->(char)c)
			      .collect(Collectors.groupingBy(
                             Function.identity(), 
                             LinkedHashMap :: new, 
                             Collectors.counting()))
			      .entrySet()
			      .stream()
			      .filter(s->s.getValue()>1)
			      .map(Map.Entry::getKey)
			      .findFirst()
			      .orElse(null);
                
	}
	
	public char findFirstNonRepeatCharacter(String str) {
		
		return str.chars()
				  .mapToObj(c->(char)c)
				  .collect(Collectors.groupingBy(
						   Function.identity(),LinkedHashMap :: new, Collectors.counting()))
				  .entrySet()
				  .stream()
				  .filter(s->s.getValue()==1)
				  .map(Map.Entry::getKey)
				  .findFirst()
				  .orElse(null);
				  
	}
	
	public boolean isPrime(int num) {
		
		return IntStream.range(2, (int)Math.sqrt(num)).noneMatch(i-> num%i ==0);
	}
	
	
}
