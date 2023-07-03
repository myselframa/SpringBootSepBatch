package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity //Mandatory
public class Product {
@Id //Mandatory
@GeneratedValue
private Integer prodId;
private String prodName;
private double prodCost;
private String prodColor;
//super constructor
public Product() {
super();
}
//Id (PK) based constructor
public Product(Integer prodId) {
super();
this.prodId = prodId;
}
//Parameterized constructor without Id(PK)
public Product(String prodName, double prodCost, String prodColor) {
super();
this.prodName = prodName;
this.prodCost = prodCost;
this.prodColor = prodColor;
}
//Parameterized Constructor with Id (PK)
public Product(Integer prodId, String prodName, double prodCost, String prodColor)
{
super();
this.prodId = prodId;
this.prodName = prodName;
this.prodCost = prodCost;
this.prodColor = prodColor;
}
//setters & getters method
public Integer getProdId() {
return prodId;
}
public void setProdId(Integer prodId) {
this.prodId = prodId;
}
public String getProdName() {
return prodName;
}
public void setProdName(String prodName) {
this.prodName = prodName;
}
public double getProdCost() {
return prodCost;
}
public void setProdCost(double prodCost) {
this.prodCost = prodCost;
}
public String getProdColor() {
return prodColor;
}
public void setProdColor(String prodColor) {
this.prodColor = prodColor;
}
//toString method
@Override
public String toString() {
return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodCost=" + prodCost + ", prodColor="+ prodColor + "]";
}
}