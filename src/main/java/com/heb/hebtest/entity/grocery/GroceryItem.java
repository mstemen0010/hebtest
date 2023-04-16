
package com.heb.hebtest.entity.grocery;

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
    "itemName",
    "sku",
    "isTaxable",
    "ownBrand",
    "price"
})
@Generated("jsonschema2pojo")
public class GroceryItem {

    @JsonProperty("itemName")
    private String itemName;
    @JsonProperty("sku")
    private Integer sku;
    @JsonProperty("isTaxable")
    private Boolean isTaxable;
    @JsonProperty("ownBrand")
    private Boolean ownBrand;
    @JsonProperty("price")
    private Double price;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("itemName")
    public String getItemName() {
        return itemName;
    }

    @JsonProperty("itemName")
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public GroceryItem withItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    @JsonProperty("sku")
    public Integer getSku() {
        return sku;
    }

    @JsonProperty("sku")
    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public GroceryItem withSku(Integer sku) {
        this.sku = sku;
        return this;
    }

    @JsonProperty("isTaxable")
    public Boolean getIsTaxable() {
        return isTaxable;
    }

    @JsonProperty("isTaxable")
    public void setIsTaxable(Boolean isTaxable) {
        this.isTaxable = isTaxable;
    }

    public GroceryItem withIsTaxable(Boolean isTaxable) {
        this.isTaxable = isTaxable;
        return this;
    }

    @JsonProperty("ownBrand")
    public Boolean getOwnBrand() {
        return ownBrand;
    }

    @JsonProperty("ownBrand")
    public void setOwnBrand(Boolean ownBrand) {
        this.ownBrand = ownBrand;
    }

    public GroceryItem withOwnBrand(Boolean ownBrand) {
        this.ownBrand = ownBrand;
        return this;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    public GroceryItem withPrice(Double price) {
        this.price = price;
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

    public GroceryItem withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GroceryItem.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("itemName");
        sb.append('=');
        sb.append(((this.itemName == null)?"<null>":this.itemName));
        sb.append(',');
        sb.append("sku");
        sb.append('=');
        sb.append(((this.sku == null)?"<null>":this.sku));
        sb.append(',');
        sb.append("isTaxable");
        sb.append('=');
        sb.append(((this.isTaxable == null)?"<null>":this.isTaxable));
        sb.append(',');
        sb.append("ownBrand");
        sb.append('=');
        sb.append(((this.ownBrand == null)?"<null>":this.ownBrand));
        sb.append(',');
        sb.append("price");
        sb.append('=');
        sb.append(((this.price == null)?"<null>":this.price));
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
        result = ((result* 31)+((this.isTaxable == null)? 0 :this.isTaxable.hashCode()));
        result = ((result* 31)+((this.itemName == null)? 0 :this.itemName.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.sku == null)? 0 :this.sku.hashCode()));
        result = ((result* 31)+((this.ownBrand == null)? 0 :this.ownBrand.hashCode()));
        result = ((result* 31)+((this.price == null)? 0 :this.price.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GroceryItem) == false) {
            return false;
        }
        GroceryItem rhs = ((GroceryItem) other);
        return (((((((this.isTaxable == rhs.isTaxable)||((this.isTaxable!= null)&&this.isTaxable.equals(rhs.isTaxable)))&&((this.itemName == rhs.itemName)||((this.itemName!= null)&&this.itemName.equals(rhs.itemName))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.sku == rhs.sku)||((this.sku!= null)&&this.sku.equals(rhs.sku))))&&((this.ownBrand == rhs.ownBrand)||((this.ownBrand!= null)&&this.ownBrand.equals(rhs.ownBrand))))&&((this.price == rhs.price)||((this.price!= null)&&this.price.equals(rhs.price))));
    }

}
