package com.smallwei.day2demo;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit.Converter;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements retrofit.Callback<List<ListItem>> {

    ListView listView;
    MyAdapter adapter;
    List<ListItem> listItems;
    private retrofit.Call<List<ListItem>> call;
    //private Call call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listView);
        listItems=new ArrayList<>();
        adapter=new MyAdapter(this,listItems);
        listView.setAdapter(adapter);

        /*OkHttpClient client=new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url("http://m2.qiushibaike.com/article/list/suggest?page=").get().build();
        call = client.newCall(request);
        call.enqueue(this);*/

        Retrofit build = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(new Converter.Factory() {
                    @Override
                    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
                        return new Converter<ResponseBody, List<ListItem>>() {
                            @Override
                            public List<ListItem> convert(ResponseBody value) throws IOException {
                                String s = value.string();
                                JSONObject object = null;
                                try {
                                    object = new JSONObject(s);
                                    JSONArray items = object.getJSONArray("items");
                                    for (int i = 0; i < items.length(); i++) {
                                        listItems.add(new ListItem(items.getJSONObject(i)));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                return listItems;
                            }
                        };
                    }
                })
                .build();
        QsbkInterface service = build.create(QsbkInterface.class);
        call = service.getList("image", 1);
        call.enqueue(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        call.cancel();
    }

    @Override
    public void onResponse(retrofit.Response<List<ListItem>> response, Retrofit retrofit) {
        adapter.addAll(listItems);
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
    }


  /*  @Override
    public void onFailure(Request request, IOException e) {
        e.printStackTrace();
    }

    @Override
    public void onResponse(Response response) throws IOException {
        String jsonStr = response.body().string();
        JSONObject jsonObject= null;
        try {
            jsonObject = new JSONObject(jsonStr);
            JSONArray array=jsonObject.getJSONArray("items");
            for (int i=0;i<array.length();i++) {
                JSONObject object = array.getJSONObject(i);
                listItems.add(new ListItem(object));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //adapter.notifyDataSetChanged();
                adapter.addAll(listItems);
            }
        });
    }*/
}
