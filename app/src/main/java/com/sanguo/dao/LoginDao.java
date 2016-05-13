package com.sanguo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sanguo.Contact;
import com.sanguo.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinrong on 2016/4/18.
 */
public class LoginDao {
    private static final String TABLE_CONTACTS = "user";
    private static final String KEY_ID = "id";
    private static final String KEY_MOBLIE = "moblie";
    private static final String KEY_PASSWORD = "password";
    private Contact contact;

    public void addContact(Contact contact, Context context) {
        SQLiteDatabase db = DatabaseHelper.getmInstance(context).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MOBLIE, contact.getKEY_MOBLIE());
        values.put(KEY_PASSWORD, contact.getKEY_PASSWORD());

        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    public Contact getContact(String moblie, Context context) {
        SQLiteDatabase db = DatabaseHelper.getmInstance(context).getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{
                        KEY_MOBLIE, KEY_PASSWORD}, KEY_MOBLIE + "=?",
                new String[]{String.valueOf(moblie)}, null, null, null, null);
        if (cursor.moveToFirst()) {
            contact = new Contact(cursor.getString(0), cursor.getString(1));
            cursor.close();
            db.close();
            return contact;
        }
        return null;
    }

    public List<Contact> getAllContacts(Context context) {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = DatabaseHelper.getmInstance(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setKEY_MOBLIE(cursor.getString(1));
                contact.setKEY_PASSWORD(cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
            cursor.close();
            db.close();
        }

        return contactList;
    }

    public int updateContact(Contact contact, Context context) {
        SQLiteDatabase db = DatabaseHelper.getmInstance(context).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MOBLIE, contact.getKEY_MOBLIE());
        values.put(KEY_PASSWORD, contact.getKEY_PASSWORD());

        //更新行
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getID())});
    }

    public void deleteContact(Contact contact, Context context) {
        SQLiteDatabase db = DatabaseHelper.getmInstance(context).getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getID())});
        db.close();
    }

    public int getContactsCount(Context context) {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = DatabaseHelper.getmInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}
