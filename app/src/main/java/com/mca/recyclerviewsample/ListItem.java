package com.mca.recyclerviewsample;

public class ListItem {

    private String ownerid,name,m1,m2,m3,m4,booking,encodedimage;

    public ListItem(String ownerid,String name,String m1,String m2,String m3,String m4,String booking,String image) {
        this.ownerid=ownerid;
        this.name=name;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
        this.m4=m4;
        this.booking=booking;
        this.encodedimage=image;
    }
    public ListItem() {

    }

    // create a contet value pack and return it to Adapter class
    public String getid() {
        return ownerid;
    }
    public  String getScreenName(){return name;}
    public  String getScreenM1(){return m1;}
    public  String getScreenM2(){return m2;}
    public  String getScreenM3(){return m3;}
    public  String getScreenM4(){return m4;}
    public  String getScreenBooking(){return booking;}
    public String getImage(){return encodedimage;}
}