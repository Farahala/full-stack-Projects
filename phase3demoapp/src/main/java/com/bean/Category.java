package com.bean;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int cid;
private String categoryname;
@OneToMany
@JoinColumn(name="categoryid")			//FK
private List<Product> listOfProducts;

@Column(name = "purchase_date")
private LocalDate purchaseDate;
@DateTimeFormat(pattern = "YYYY-mm-dd") 
LocalDate startDate;
@DateTimeFormat(pattern = "YYYY-mm-dd") 
LocalDate endDate;
public LocalDate getPurchaseDate() {
    return purchaseDate;
}

public void setPurchaseDate(LocalDate purchaseDate) {
    this.purchaseDate = purchaseDate;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public List<Product> getListOfProducts() {
	return listOfProducts;
}
public void setListOfProducts(List<Product> listOfProducts) {
	this.listOfProducts = listOfProducts;
}


public LocalDate getStartDate() {
   
	return startDate;
}
public LocalDate getEndDate() {
   
	return endDate;
}

public void setStartDate(LocalDate now) {
this.startDate=startDate;
	
}

public void setEndDate(LocalDate now) {
	// TODO Auto-generated method stub
	this .endDate=endDate;
	
}

}
