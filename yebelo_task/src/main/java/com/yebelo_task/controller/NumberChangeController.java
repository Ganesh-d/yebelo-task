package com.yebelo_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yebelo_task.model.NumberChange;
import com.yebelo_task.repository.NumberChangeRepository;

@RestController
public class NumberChangeController {
	@Autowired
	private NumberChangeRepository num;
	
@GetMapping("/FetchNextNumber/{categoryCode}")
public NumberChange fetchNextNumber(@PathVariable("categoryCode")Long categoryCode) {
	return num.findBycategoryCode(categoryCode);

}
@PostMapping("/{categoryCode}")
public NumberChange updateNumber(@PathVariable("categoryCode")Long categoryCode) {
	NumberChange fetchNextNumber = this.fetchNextNumber(categoryCode);
	int fetchValue = fetchNextNumber.getFetchValue();
	int sumFetchValue=sumIs(fetchValue);
	int nextValue=0;
	for(int i=fetchValue+1;;i++) {
		boolean match=false;
		int sumIs = sumIs(i);
		if(sumIs==sumFetchValue) {
			nextValue=i;
			
			match=true;
		}
		if(match) break;
		
	}
	NumberChange n=new NumberChange();
	n.setCategoryCode(fetchNextNumber.getCategoryCode());
	n.setFetchValue(fetchNextNumber.getFetchValue());
	n.setStoredValue(nextValue);
	NumberChange save = num.save(n);
	
	return save;
}
public static int sumIs(int n) {
	int sum=0;
	while(n>0|| sum>9) {
		if(n==0) {
			n=sum;
			sum=0;
		}
		sum+=n%10;
		n/=10;
	}
	return sum;
}
}
