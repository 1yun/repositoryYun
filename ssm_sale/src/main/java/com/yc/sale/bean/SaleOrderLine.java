package com.yc.sale.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"handler"})
//在所有相关的类前加上@JsonIgnoreProperties, 作用是json序列化时忽略bean中的一些属性序列化和反序列化时抛出的异常.
public class SaleOrderLine implements Serializable{
   
	
	@Override
	public String toString() {
		return "SaleOrderLine [odlId=" + odlId + ", odlOrderId=" + odlOrderId + ", odlProductName=" + odlProductName
				+ ", odlProductPrice=" + odlProductPrice + ", odlProductCount=" + odlProductCount + "]";
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order_line.odl_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private Integer odlId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order_line.odl_order_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private Integer odlOrderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order_line.odl_product_name
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private String odlProductName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order_line.odl_product_price
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private Double odlProductPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order_line.odl_product_count
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private Integer odlProductCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order_line.odl_id
     *
     * @return the value of sale_order_line.odl_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public Integer getOdlId() {
        return odlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order_line.odl_id
     *
     * @param odlId the value for sale_order_line.odl_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdlId(Integer odlId) {
        this.odlId = odlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order_line.odl_order_id
     *
     * @return the value of sale_order_line.odl_order_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public Integer getOdlOrderId() {
        return odlOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order_line.odl_order_id
     *
     * @param odlOrderId the value for sale_order_line.odl_order_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdlOrderId(Integer odlOrderId) {
        this.odlOrderId = odlOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order_line.odl_product_name
     *
     * @return the value of sale_order_line.odl_product_name
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public String getOdlProductName() {
        return odlProductName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order_line.odl_product_name
     *
     * @param odlProductName the value for sale_order_line.odl_product_name
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdlProductName(String odlProductName) {
        this.odlProductName = odlProductName == null ? null : odlProductName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order_line.odl_product_price
     *
     * @return the value of sale_order_line.odl_product_price
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public Double getOdlProductPrice() {
        return odlProductPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order_line.odl_product_price
     *
     * @param odlProductPrice the value for sale_order_line.odl_product_price
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdlProductPrice(Double odlProductPrice) {
        this.odlProductPrice = odlProductPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order_line.odl_product_count
     *
     * @return the value of sale_order_line.odl_product_count
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public Integer getOdlProductCount() {
        return odlProductCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order_line.odl_product_count
     *
     * @param odlProductCount the value for sale_order_line.odl_product_count
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdlProductCount(Integer odlProductCount) {
        this.odlProductCount = odlProductCount;
    }
}