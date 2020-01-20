package com.example.loginapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class FakeServer implements Parcelable {
    private String userName;
    private String password;
    public boolean isValidate = false;

    public FakeServer() {
    }

    protected FakeServer(Parcel in) {
        userName = in.readString();
        password = in.readString();
        isValidate = in.readByte() != 0;
    }

    public static final Creator<FakeServer> CREATOR = new Creator<FakeServer>() {
        @Override
        public FakeServer createFromParcel(Parcel in) {
            return new FakeServer(in);
        }

        @Override
        public FakeServer[] newArray(int size) {
            return new FakeServer[size];
        }
    };

    public void registerUser(String uName, String uPassword) {

        this.userName = uName;
        this.password = uPassword;
    }

    public boolean validate(String uName, String upassword){
        if(uName.equals(this.userName) && upassword.equals(this.password)){
            isValidate = true;
            return isValidate;
        }
        else{
            isValidate = false;
            return isValidate;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeByte((byte) (isValidate ? 1 : 0));
    }
}
