package com.asm.spring.ex.database.domain;

import java.time.LocalDateTime;

// usedGoods의 한 행의 정보를 모두 저장을 할 수 있는 객체를 위한 클래스
// 테이블의 컬럼이름과 함께 정확히 일치하는 이름의 멤버변수 정의
// Domain, Entity
public class UsedGoods 
{
	//db의 각각의 항목을 변수로 만든다
	private int id;
	private int sellerId;
	private String title;
	private int price;
	private String description;
	private String image;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
}
