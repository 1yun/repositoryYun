package com.yc.sale.bean;

public class SaleProduct {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_product.prod_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private Integer prodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_product.prod_name
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private String prodName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_product.prod_price
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    private Double prodPrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_product.prod_id
     *
     * @return the value of sale_product.prod_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public Integer getProdId() {
        return prodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_product.prod_id
     *
     * @param prodId the value for sale_product.prod_id
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_product.prod_name
     *
     * @return the value of sale_product.prod_name
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_product.prod_name
     *
     * @param prodName the value for sale_product.prod_name
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_product.prod_price
     *
     * @return the value of sale_product.prod_price
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public Double getProdPrice() {
        return prodPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_product.prod_price
     *
     * @param prodPrice the value for sale_product.prod_price
     *
     * @mbg.generated Wed Aug 14 16:13:25 CST 2019
     */
    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }
}