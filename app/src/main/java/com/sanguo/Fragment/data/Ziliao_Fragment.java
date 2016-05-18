package com.sanguo.Fragment.data;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sanguo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jinrong on 2016/4/18.
 */
public class Ziliao_Fragment extends Fragment {

    private TextView mZiliao_mv;
    private ImageView mZilaio_image;
    private static String s = "";
    private static String image = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ziliao_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mZiliao_mv = (TextView) view.findViewById(R.id.ziliao_wv);
        mZilaio_image = (ImageView) view.findViewById(R.id.ziliao_image);

        vollyGet();
    }

    private void vollyGet() {

        String url = "http://api.budejie.com/api/api_open.php";
        String a = "&a=list";
        String c = "&c=data";
        String order = "&order=order";
        String type = "&type=1";
        String Url = url + "?" + a + c + order + type;

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        final StringRequest stringRequest = new StringRequest(Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  mZiliao_mv.setText(response);
                        Jsonjiexi(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    private void Jsonjiexi(String response) {
        try {
            JSONArray jsonObjs = new JSONObject(response).getJSONArray("list");
            for (int i = 0; i < jsonObjs.length(); i++) {
                JSONObject jsonObj = (JSONObject) jsonObjs.get(i);
                int id = jsonObj.getInt("id");
                String text = jsonObj.getString("text");
                image = jsonObj.getString("profile_image");
                s += "id号" + id + "\n" + text + "\n";
            }
            mZiliao_mv.setText(s);
        } catch (JSONException e) {
            mZiliao_mv.setText("Jsons parse error !");
            e.printStackTrace();
        }
    }
}
