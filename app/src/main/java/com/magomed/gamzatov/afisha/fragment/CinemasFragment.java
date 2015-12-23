package com.magomed.gamzatov.afisha.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magomed.gamzatov.afisha.R;
import com.magomed.gamzatov.afisha.adapter.CVAdapter;
import com.magomed.gamzatov.afisha.adapter.Person;

import java.util.ArrayList;
import java.util.List;

public class CinemasFragment extends AbstractTabFragment{

    private static final int LAYOUT = R.layout.fragment_cinemas;

    private List<Person> persons;
    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
    }

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

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);
        initializeData();

        CVAdapter adapter = new CVAdapter(persons);

        rv.setAdapter(adapter);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
