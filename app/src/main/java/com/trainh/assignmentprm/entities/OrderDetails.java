package com.trainh.assignmentprm.entities;

public class OrderDetails {
    String oderDetailId;
    String oderId;
    String productId;
    int quantity;
    float totalUnit;

    public OrderDetails(String oderId, String productId, int quantity, float totalUnit) {
        this.oderId = oderId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalUnit = totalUnit;
    }

    public OrderDetails(String oderDetailId, String oderId, String productId, int quantity, float totalUnit) {
        this.oderDetailId = oderDetailId;
        this.oderId = oderId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalUnit = totalUnit;
    }

    public String getOderDetailId() {
        return oderDetailId;
    }

    public void setOderDetailId(String oderDetailId) {
        this.oderDetailId = oderDetailId;
    }

    public String getOderId() {
        return oderId;
    }

    public void setOderId(String oderId) {
        this.oderId = oderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalUnit() {
        return totalUnit;
    }

    public void setTotalUnit(float totalUnit) {
        this.totalUnit = totalUnit;
    }
}
