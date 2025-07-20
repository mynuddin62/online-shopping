package com.faith.oneUmmah.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

public class ShippingAddressDTO {
    private Long id;

    @NotEmpty
    private String address;
    private String address2;

    @NotEmpty
    private String city;

    @NotEmpty
    private String thana;

    @NotEmpty
    private String postalCode;

    @NotEmpty
    @Pattern(regexp = "^(?:\\+88|0088)?01[3-9]\\d{8}$", message= "Must be a Bangladeshi phone number")
    private String mobileNumber;


    @Pattern(regexp = "^(?:\\+88|0088)?01[3-9]\\d{8}$", message= "Must be a Bangladeshi phone number")
    private String mobileNumber2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty String getAddress() {
        return address;
    }

    public void setAddress(@NotEmpty String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public @NotEmpty String getCity() {
        return city;
    }

    public void setCity(@NotEmpty String city) {
        this.city = city;
    }

    public @NotEmpty String getThana() {
        return thana;
    }

    public void setThana(@NotEmpty String thana) {
        this.thana = thana;
    }

    public @NotEmpty String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@NotEmpty String postalCode) {
        this.postalCode = postalCode;
    }

    public @NotEmpty @Pattern(regexp = "^(?:\\+88|0088)?01[3-9]\\d{8}$", message = "Must be a Bangladeshi phone number") String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotEmpty @Pattern(regexp = "^(?:\\+88|0088)?01[3-9]\\d{8}$", message = "Must be a Bangladeshi phone number") String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public @Pattern(regexp = "^(?:\\+88|0088)?01[3-9]\\d{8}$", message = "Must be a Bangladeshi phone number") String getMobileNumber2() {
        return mobileNumber2;
    }

    public void setMobileNumber2(@Pattern(regexp = "^(?:\\+88|0088)?01[3-9]\\d{8}$", message = "Must be a Bangladeshi phone number") String mobileNumber2) {
        this.mobileNumber2 = mobileNumber2;
    }
}
