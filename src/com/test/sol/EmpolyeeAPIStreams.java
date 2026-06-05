package com.test.sol;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.test.dao.Empolyee;

import sun.util.logging.resources.logging;

public class EmpolyeeAPIStreams {

	
   public Empolyee findHighestSalary(List<Empolyee> empolyees) {
		
		Empolyee emp = empolyees.stream().max(Comparator.comparing(Empolyee::getSalary)).orElse(null);
		
		Empolyee emp1 = empolyees.stream().sorted(Comparator.comparing(Empolyee::getSalary).reversed()).skip(1).findFirst().orElse(null);
		
		double salary = empolyees.stream()
				        .map(Empolyee :: getSalary)
				        .sorted(Comparator.reverseOrder())
				        .skip(1)
				        .findFirst()
				        .orElse(null);
		
		
		return emp;
	}
   
   public Map<String, List<Empolyee>> groupEmpolyesByDept(List<Empolyee> emps){
	   
	   Map<String, List<Empolyee>> empolyees = emps.stream().collect(Collectors.groupingBy(Empolyee::getDept));
	   
	   return empolyees;
	   
   }
   
   public Map<String, Long> countEmpolyeeByDept(List<Empolyee> emps){
	   
	   Map<String, Long> empsls = emps.stream().collect(Collectors.groupingBy(
			   Empolyee::getDept,Collectors.counting()));
	   
	   return empsls;
   }
   
   
   public Map<String, Long> findHighestSalaryInEachDept(List<Empolyee> emps){
	   
	   Map<String, Long> mps2 = emps.stream().collect(Collectors.groupingBy(
			                      Empolyee :: getDept, Collectors.maxBy(Comparator.comparing(Empolyee::getSalary))));
   }
   
	
}
