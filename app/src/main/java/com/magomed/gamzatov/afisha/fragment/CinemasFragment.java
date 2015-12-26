package com.magomed.gamzatov.afisha.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.magomed.gamzatov.afisha.R;
import com.magomed.gamzatov.afisha.adapter.CVAdapter;
import com.magomed.gamzatov.afisha.adapter.Person;
import com.magomed.gamzatov.afisha.network.VolleySingleton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class CinemasFragment extends AbstractTabFragment{

    private static final int LAYOUT = R.layout.fragment_cinemas;

    private List<Person> persons = new ArrayList<>();
    
    public static CinemasFragment getInstance(Context context) {
        Bundle args = new Bundle();
        CinemasFragment fragment = new CinemasFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_cinemas));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        String url = "http://www.interdag.ru/afisha/movies";

        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);

        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQueue();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document doc = Jsoup.parse(response);
                Elements elements = doc.getElementsByClass("div100");
                persons.clear();
                for (Element element: elements) {
                    String imageUrl = element.getElementsByTag("a").get(0).getElementsByTag("img").get(0).attr("src");
                    String cinemaName = element.getElementsByTag("h2").get(0).getElementsByTag("a").get(0).text();
                    Log.d("taggggggsdgsgasgsggggg", cinemaName + " " + imageUrl);
                    persons.add(new Person(cinemaName, imageUrl, "http://www.interdag.ru"+imageUrl));
                }
                CVAdapter adapter = new CVAdapter(persons);
                rv.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error " + error, Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);


        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
