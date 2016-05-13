package com.sanguo;

/**
 * Created by jinrong on 2016/4/11.
 */
public class Contact
{

    int KEY_ID = 0;
    String KEY_MOBLIE = null;
    String KEY_PASSWORD = null;

    public Contact() {

    }

    public Contact(int KEY_ID, String KEY_MOBLIE, String KEY_PASSWORD) {
        this.KEY_ID = KEY_ID;
        this.KEY_MOBLIE = KEY_MOBLIE;
        this.KEY_PASSWORD = KEY_PASSWORD;
    }

    public Contact(String KEY_MOBLIE, String KEY_PASSWORD) {
        this.KEY_MOBLIE = KEY_MOBLIE;
        this.KEY_PASSWORD = KEY_PASSWORD;
    }

    public int getID() {
        return this.KEY_ID;
    }

    public void setID(int KEY_ID) {
        this.KEY_ID = KEY_ID;
    }

    public String getKEY_MOBLIE() {
        return this.KEY_MOBLIE;
    }

    public void setKEY_MOBLIE(String KEY_MOBLIE) {
        this.KEY_MOBLIE = KEY_MOBLIE;
    }

    public String getKEY_PASSWORD() {
        return this.KEY_PASSWORD;
    }

    public void setKEY_PASSWORD(String KEY_PASSWORD) {
        this.KEY_PASSWORD = KEY_PASSWORD;
    }
}
