package com.haiso.hr.entity.commons;

import com.google.common.base.Objects;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

/**
 * Created by ff on 6/5/14.
 */
@Embeddable
public class Address {

    @Basic
    private String country;
    @Basic
    private String province;
    @Basic
    private String city;
    @Basic
    private String district;
    @Basic
    private String street;
    @Basic
    private String details;
    @Basic
    private String zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(country, province, city, district, street, details, zip);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        return Objects.equal(this.country, other.country) && Objects.equal(this.province, other.province) && Objects.equal(this.city, other.city) && Objects.equal(this.district, other.district) && Objects.equal(this.street, other.street) && Objects.equal(this.details, other.details) && Objects.equal(this.zip, other.zip);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("country", country)
                .add("province", province)
                .add("city", city)
                .add("district", district)
                .add("street", street)
                .add("details", details)
                .add("zip", zip)
                .toString();
    }
}
