package com.test.sol;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.test.dao.Empolyee;

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
   
   
	
}
