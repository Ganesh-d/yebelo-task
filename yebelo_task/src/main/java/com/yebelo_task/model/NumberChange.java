package com.yebelo_task.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NumberChange {
@Id
private Long categoryCode;
private int fetchValue;
private int storedValue;
public Long getCategoryCode() {
	return categoryCode;
}
public void setCategoryCode(Long categoryCode) {
	this.categoryCode = categoryCode;
}
public int getFetchValue() {
	return fetchValue;
}
public void setFetchValue(int fetchValue) {
	this.fetchValue = fetchValue;
}
public int getStoredValue() {
	return storedValue;
}
public void setStoredValue(int storedValue) {
	this.storedValue = storedValue;
}


}
