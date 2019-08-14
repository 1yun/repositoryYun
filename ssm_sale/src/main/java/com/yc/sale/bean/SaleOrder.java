package com.yc.sale.bean;

import java.io.Serializable;
import java.util.List;

public class SaleOrder implements Serializable{
    
	//一个订单可能有多个订单详细信息  1对多
	private List<SaleOrderLine> ordeLines;
	
	@Override
	public String toString() {
		return "SaleOrder [ordeLines=" + ordeLines + ", odrId=" + odrId + ", odrCustomerId=" + odrCustomerId
				+ ", odrCustomerName=" + odrCustomerName + ", odrDeliverAddr=" + odrDeliverAddr + ", odrOrderDate="
				+ odrOrderDate + ", odrDeliverDate=" + odrDeliverDate + ", odrStatus=" + odrStatus + "]";
	}

	public List<SaleOrderLine> getOrdeLines() {
		return ordeLines;
	}

	public void setOrdeLines(List<SaleOrderLine> ordeLines) {
		this.ordeLines = ordeLines;
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order.odr_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private Integer odrId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order.odr_customer_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private Integer odrCustomerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order.odr_customer_name
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private String odrCustomerName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order.odr_deliver_addr
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private String odrDeliverAddr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order.odr_order_date
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private String odrOrderDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order.odr_deliver_date
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private String odrDeliverDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_order.odr_status
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private String odrStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order.odr_id
     *
     * @return the value of sale_order.odr_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public Integer getOdrId() {
        return odrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order.odr_id
     *
     * @param odrId the value for sale_order.odr_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdrId(Integer odrId) {
        this.odrId = odrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order.odr_customer_id
     *
     * @return the value of sale_order.odr_customer_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public Integer getOdrCustomerId() {
        return odrCustomerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order.odr_customer_id
     *
     * @param odrCustomerId the value for sale_order.odr_customer_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdrCustomerId(Integer odrCustomerId) {
        this.odrCustomerId = odrCustomerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order.odr_customer_name
     *
     * @return the value of sale_order.odr_customer_name
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public String getOdrCustomerName() {
        return odrCustomerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order.odr_customer_name
     *
     * @param odrCustomerName the value for sale_order.odr_customer_name
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdrCustomerName(String odrCustomerName) {
        this.odrCustomerName = odrCustomerName == null ? null : odrCustomerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order.odr_deliver_addr
     *
     * @return the value of sale_order.odr_deliver_addr
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public String getOdrDeliverAddr() {
        return odrDeliverAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order.odr_deliver_addr
     *
     * @param odrDeliverAddr the value for sale_order.odr_deliver_addr
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdrDeliverAddr(String odrDeliverAddr) {
        this.odrDeliverAddr = odrDeliverAddr == null ? null : odrDeliverAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order.odr_order_date
     *
     * @return the value of sale_order.odr_order_date
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
  
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order.odr_deliver_date
     *
     * @param odrDeliverDate the value for sale_order.odr_deliver_date
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_order.odr_status
     *
     * @return the value of sale_order.odr_status
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public String getOdrStatus() {
        return odrStatus;
    }

    public String getOdrOrderDate() {
		return odrOrderDate;
	}

	public void setOdrOrderDate(String odrOrderDate) {
		this.odrOrderDate = odrOrderDate;
	}

	public String getOdrDeliverDate() {
		return odrDeliverDate;
	}

	public void setOdrDeliverDate(String odrDeliverDate) {
		this.odrDeliverDate = odrDeliverDate;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_order.odr_status
     *
     * @param odrStatus the value for sale_order.odr_status
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setOdrStatus(String odrStatus) {
        this.odrStatus = odrStatus == null ? null : odrStatus.trim();
    }
}