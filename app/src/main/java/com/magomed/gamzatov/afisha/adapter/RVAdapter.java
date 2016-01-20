package com.magomed.gamzatov.afisha.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.magomed.gamzatov.afisha.R;
import com.magomed.gamzatov.afisha.network.VolleySingleton;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    private ImageLoader imageLoader;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;
        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

    List<Cinema> cinemas;

    public RVAdapter(List<Cinema> cinemas){
        this.cinemas = cinemas;
        VolleySingleton volleySingleton = VolleySingleton.getsInstance();
        imageLoader = volleySingleton.getImageLoader();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder holder, int position) {
        holder.personName.setText(cinemas.get(position).name);
        holder.personAge.setText(cinemas.get(position).age);
        String url = cinemas.get(position).photoUrl;

        imageLoader.get(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                holder.personPhoto.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return cinemas.size();
    }
}

