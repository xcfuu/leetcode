package com.oomthread.lockoom.hashmap;

public class PhoneNumber {
    private int prefix; //区号
    private int phoneNumber; //电话号

    public PhoneNumber(int prefix, int phoneNumber) {
        this.prefix = prefix;
        this.phoneNumber = phoneNumber;

    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof PhoneNumber))
        {
            return false;
        }
        PhoneNumber pn = (PhoneNumber)o;
        return pn.prefix == prefix && pn.phoneNumber == phoneNumber;
    }

    @Override
    public int hashCode()
    {
        int result = 17;
        result = 31 * result + prefix;
        result = 31 * result + phoneNumber;
        return result;
    }
}
