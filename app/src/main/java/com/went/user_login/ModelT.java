package com.went.user_login;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelT implements Parcelable {
    private String fname;
    private String username;
    private String mail;
    private String password;
    private String phone;
    private String sex;
    public ModelT(){

    }

    public ModelT(String fname, String username, String mail, String password, String phone, String sex) {
        this.fname = fname;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
    }

    protected ModelT(Parcel in) {
        fname = in.readString();
        username = in.readString();
        mail = in.readString();
        password = in.readString();
        phone = in.readString();
        sex = in.readString();
    }

    public static final Creator<ModelT> CREATOR = new Creator<ModelT>() {
        @Override
        public ModelT createFromParcel(Parcel in) {
            return new ModelT(in);
        }

        @Override
        public ModelT[] newArray(int size) {
            return new ModelT[size];
        }
    };

    public String getFname() {

        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fname);
        parcel.writeString(username);
        parcel.writeString(mail);
        parcel.writeString(password);
        parcel.writeString(phone);
        parcel.writeString(sex);
    }
}
