
package com.heb.hebtest.entity.coupon;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "couponName",
    "appliedSku",
    "discountPrice"
})
@Generated("jsonschema2pojo")
public class Coupon__1 {

    @JsonProperty("couponName")
    private String couponName;
    @JsonProperty("appliedSku")
    private Integer appliedSku;
    @JsonProperty("discountPrice")
    private Double discountPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("couponName")
    public String getCouponName() {
        return couponName;
    }

    @JsonProperty("couponName")
    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Coupon__1 withCouponName(String couponName) {
        this.couponName = couponName;
        return this;
    }

    @JsonProperty("appliedSku")
    public Integer getAppliedSku() {
        return appliedSku;
    }

    @JsonProperty("appliedSku")
    public void setAppliedSku(Integer appliedSku) {
        this.appliedSku = appliedSku;
    }

    public Coupon__1 withAppliedSku(Integer appliedSku) {
        this.appliedSku = appliedSku;
        return this;
    }

    @JsonProperty("discountPrice")
    public Double getDiscountPrice() {
        return discountPrice;
    }

    @JsonProperty("discountPrice")
    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Coupon__1 withDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Coupon__1 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Coupon__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("couponName");
        sb.append('=');
        sb.append(((this.couponName == null)?"<null>":this.couponName));
        sb.append(',');
        sb.append("appliedSku");
        sb.append('=');
        sb.append(((this.appliedSku == null)?"<null>":this.appliedSku));
        sb.append(',');
        sb.append("discountPrice");
        sb.append('=');
        sb.append(((this.discountPrice == null)?"<null>":this.discountPrice));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.discountPrice == null)? 0 :this.discountPrice.hashCode()));
        result = ((result* 31)+((this.couponName == null)? 0 :this.couponName.hashCode()));
        result = ((result* 31)+((this.appliedSku == null)? 0 :this.appliedSku.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Coupon__1) == false) {
            return false;
        }
        Coupon__1 rhs = ((Coupon__1) other);
        return (((((this.discountPrice == rhs.discountPrice)||((this.discountPrice!= null)&&this.discountPrice.equals(rhs.discountPrice)))&&((this.couponName == rhs.couponName)||((this.couponName!= null)&&this.couponName.equals(rhs.couponName))))&&((this.appliedSku == rhs.appliedSku)||((this.appliedSku!= null)&&this.appliedSku.equals(rhs.appliedSku))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
