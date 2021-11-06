package com.himansusahoo.FileAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="region")
	private String region;
	
	@Column(name="country")
	private String country;
	
	@Column(name="itemtype")
	private String itemType;
	
	@Column(name="saleschannel")
	private String salesChannel;
	
	@Column(name="orderpriority")
	private String orderPriority;
	
	@Column(name="orderdate")
	private String orderDate;
	
	@Column(name="orderid")
	private String orderId;
	
	@Column(name="shipdate")
	private String shipDate;
	
	@Column(name="unitssold")
	private int unitsSold;
	
	@Column(name="unitprice")
	private float unitPrice;
	
	@Column(name="unitcost")
	private float unitCost;
	
	@Column(name="totalrevenue")
	private float totalRevenue;
	
	@Column(name="totalcost")
	private float totalCost;
	
	@Column(name="totalprofit")
	private float totalProfit;
	
	//@Column(name="creationdate")
	//private Timestamp date;
	
	
	public Order() {
		
	}


	public Order(long id, String region, String country, String itemType, String salesChannel, String orderPriority,
			String orderDate, String orderId, String shipDate, int unitsSold, float unitPrice, float unitCost,
			float totalRevenue, float totalCost, float totalProfit) {
		super();
		this.id = id;
		this.region = region;
		this.country = country;
		this.itemType = itemType;
		this.salesChannel = salesChannel;
		this.orderPriority = orderPriority;
		this.orderDate = orderDate;
		this.orderId = orderId;
		this.shipDate = shipDate;
		this.unitsSold = unitsSold;
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.totalRevenue = totalRevenue;
		this.totalCost = totalCost;
		this.totalProfit = totalProfit;
		//this.date = new Timestamp(new Date().getTime());
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public String getSalesChannel() {
		return salesChannel;
	}


	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}


	public String getOrderPriority() {
		return orderPriority;
	}


	public void setOrderPriority(String orderPriority) {
		this.orderPriority = orderPriority;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getShipDate() {
		return shipDate;
	}


	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}


	public int getUnitsSold() {
		return unitsSold;
	}


	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}


	public float getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}


	public float getUnitCost() {
		return unitCost;
	}


	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}


	public float getTotalRevenue() {
		return totalRevenue;
	}


	public void setTotalRevenue(float totalRevenue) {
		this.totalRevenue = totalRevenue;
	}


	public float getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}


	public float getTotalProfit() {
		return totalProfit;
	}


	public void setTotalProfit(float totalProfit) {
		this.totalProfit = totalProfit;
	}

/*
	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp date) {
		this.date = date;
	}
*/

	@Override
	public String toString() {
		return "Order [id=" + id + ", region=" + region + ", country=" + country + ", itemType=" + itemType
				+ ", salesChannel=" + salesChannel + ", orderPriority=" + orderPriority + ", orderDate=" + orderDate
				+ ", orderId=" + orderId + ", shipDate=" + shipDate + ", unitsSold=" + unitsSold + ", unitPrice="
				+ unitPrice + ", unitCost=" + unitCost + ", totalRevenue=" + totalRevenue + ", totalCost=" + totalCost
				+ ", totalProfit=" + totalProfit + "]";
	}

	
}
