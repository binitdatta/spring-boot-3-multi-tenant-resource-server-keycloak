package com.rollingstone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="ROLLINGSTONE_CUSTOMER_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ADDRESS_ID", nullable = false)
    private long addressId;

    @Column(name ="HOUSE_NUMBER", nullable = false)
    private String houseNumber;

    @Column(name ="STREET", nullable = false)
    private String street;

    @Column(name ="CITY", nullable = false)
    private String city;

    @Column(name ="STATE", nullable = false)
    private String state;

    @Column(name ="ZIP", nullable = false)
    private String zip;

    @Column(name ="HOME_PHONE", nullable = false)
    private String homePhoneNumber;

    @Column(name ="MOBILE_PHONE", nullable = false)
    private String mobilePhoneNumber;

    @Column(name ="EMAIL", nullable = false)
    private String emailAddress;

    @Column(name ="CUSTOMER_ID", nullable = false)
    private long customerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn(name = "wave_id", nullable = false)
    @JoinColumn(name="CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore // VIP
    Customer customer;



    @Column(name="CREATED_BY", nullable = false, updatable = false, insertable = true)
    private String createdBy;

    @CreationTimestamp
    @Column(name="CREATED_TIME", nullable = false, updatable = true, insertable = true)
    private LocalDateTime createdTime;

    @Column(name="UPDATED_BY", nullable = false, updatable = true, insertable = true)
    private String updatedBy;

    @CreationTimestamp
    @Column(name="UPDATED_TIME", nullable = false, updatable = true, insertable = true)
    private LocalDateTime updatedTime;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(homePhoneNumber, address.homePhoneNumber) && Objects.equals(mobilePhoneNumber, address.mobilePhoneNumber) && Objects.equals(emailAddress, address.emailAddress)  && Objects.equals(createdBy, address.createdBy) && Objects.equals(createdTime, address.createdTime) && Objects.equals(updatedBy, address.updatedBy) && Objects.equals(updatedTime, address.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, houseNumber, street, city, state, homePhoneNumber, mobilePhoneNumber, emailAddress, createdBy, createdTime, updatedBy, updatedTime);
    }

    public Address(long addressId, String houseNumber, String street, String city, String state, String zip, String homePhoneNumber, String mobilePhoneNumber, String emailAddress, Customer customer, String createdBy, LocalDateTime createdTime, String updatedBy, LocalDateTime updatedTime) {
        this.addressId = addressId;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.emailAddress = emailAddress;
        this.customer = customer;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", houseNumber='" + houseNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", customer=" + customer +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
