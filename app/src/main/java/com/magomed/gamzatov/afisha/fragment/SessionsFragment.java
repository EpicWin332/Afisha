package com.magomed.gamzatov.afisha.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.magomed.gamzatov.afisha.R;
import com.magomed.gamzatov.afisha.adapter.Cinema;
import com.magomed.gamzatov.afisha.adapter.RVAdapter;
import com.magomed.gamzatov.afisha.adapter.RVSessionsAdapter;
import com.magomed.gamzatov.afisha.adapter.Sessions;
import com.magomed.gamzatov.afisha.network.VolleySingleton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class SessionsFragment extends AbstractTabFragment{

    private static final int LAYOUT = R.layout.fragment_sessions;

    private List<Sessions> sessions = new ArrayList<>();

    public static SessionsFragment getInstance(Context context) {
        Bundle args = new Bundle();
        SessionsFragment fragment = new SessionsFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_sessions));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        String url = "http://www.interdag.ru/afisha/seans";

        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);

        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQueue();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                htmlParser(response);
                RVSessionsAdapter adapter = new RVSessionsAdapter(sessions);
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

    private void htmlParser(String response) {
        Document doc = Jsoup.parse(response);
        Elements elements = doc.getElementsByClass("even");
        sessions.clear();
        elements.remove(0);
        for (Element element: elements) {
            String time = element.getElementsByTag("td").get(0).text();
            String cinema = element.getElementsByTag("td").get(1).getElementsByTag("a").get(0).text();
            String theatre = element.getElementsByTag("td").get(2).getElementsByTag("a").get(0).text();
            Log.d("taggggggsdgsgasgsggggg", time + " " + cinema + " " + theatre);
            sessions.add(new Sessions(time, cinema, theatre));
        }
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
