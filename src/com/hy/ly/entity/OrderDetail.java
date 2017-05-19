package com.hy.ly.entity;

public class OrderDetail {

	private Integer id;
	private Integer orderid;
	private Integer itemsid;
	private Integer items_num;
	private Items item;
	
	public Items getItem() {
		return item;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getItemsid() {
		return itemsid;
	}
	public void setItemsid(Integer itemsid) {
		this.itemsid = itemsid;
	}
	public Integer getItems_num() {
		return items_num;
	}
	public void setItems_num(Integer items_num) {
		this.items_num = items_num;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderid=" + orderid + ", itemsid=" + itemsid + ", items_num=" + items_num
				+ "]";
	}

	
}
