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

public class RVSessionsAdapter extends RecyclerView.Adapter<RVSessionsAdapter.PersonViewHolder>{

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView time;
        TextView cinema;
        TextView theatre;
        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            time = (TextView)itemView.findViewById(R.id.textTime);
            cinema = (TextView)itemView.findViewById(R.id.textCinema);
            theatre = (TextView)itemView.findViewById(R.id.textTheatre);
        }
    }

    List<Sessions> sessions;

    public RVSessionsAdapter(List<Sessions> sessions){
        this.sessions = sessions;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sessions, parent, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder holder, int position) {
        holder.time.setText(sessions.get(position).time);
        holder.cinema.setText(sessions.get(position).cinema);
        holder.theatre.setText(sessions.get(position).theatre);
    }

    @Override
    public int getItemCount() {
        return sessions.size();
    }
}

