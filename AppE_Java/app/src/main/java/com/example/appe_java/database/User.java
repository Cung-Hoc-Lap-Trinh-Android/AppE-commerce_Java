package com.example.appe_java.database;

public class User {
    private String Key, Username, Address, Gmail, Sex, Date_Of_Birth, Password, PhoneNumber, Level;

    public User() {
    }

    public User(String username, String password, String phoneNumber, String Level) {
        Username = username;
        Password = password;
        PhoneNumber = phoneNumber;
        Level = Level;
    }

    public User(String username, String address, String gmail, String sex, String date_Of_Birth, String password, String phoneNumber, String Level) {
        Username = username;
        Address = address;
        Gmail = gmail;
        Sex = sex;
        Date_Of_Birth = date_Of_Birth;
        Password = password;
        PhoneNumber = phoneNumber;
        Level = Level;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(String date_Of_Birth) {
        Date_Of_Birth = date_Of_Birth;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
