package com.sanguo.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sanguo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinrong on 2016/3/25.
 */
public class Forum_Fragment extends Fragment {
    private ListView mF_view;
    private List<String> contatsList = new ArrayList<String>();
    private ArrayAdapter<String> adpter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mF_view = (ListView) view.findViewById(R.id.forum_view);
        adpter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, contatsList);
        mF_view.setAdapter(adpter);
        readcontacts();
    }

    private void readcontacts() {
        Cursor cursor = null;
        try {
            cursor = getActivity().getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null
            );
            while (cursor.moveToNext()) {
                String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contatsList.add(displayName + "\n" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
