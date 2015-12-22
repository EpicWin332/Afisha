package com.magomed.gamzatov.afisha.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magomed.gamzatov.afisha.R;

public class CinemasFragment extends AbstractTabFragment{

    private static final int LAYOUT = R.layout.fragment_cinemas;

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

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
