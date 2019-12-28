package com.codes.amr.nearbyplaces.ui.venuelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.codes.amr.nearbyplaces.R;
import com.codes.amr.nearbyplaces.data.model.VenueModel.Venue;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.venueViewHolder> {
    private List<Venue> venueList;
    private Context context;

    public VenueAdapter(VenueListViewModel viewModel, LifecycleOwner lifecycleOwner) {
        venueList = new ArrayList<>();

        viewModel.getVenuesData().observe(lifecycleOwner, data -> {

            if (data != null) {
                this.venueList = data;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public venueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.venue_item_row, parent, false);
        return new venueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(venueViewHolder holder, int position) {
        Venue venue = venueList.get(position);
        holder.venueName.setText(venue.getName());
        if (venue.getLocation().getAddress() != null)
            holder.venueAddress.setText(venue.getLocation().getAddress());
        else
//            holder.description.setText(R.string.no_des);

            Picasso.with(context).load(venue.getImgUrl()).into(holder.venueImage);


    }

    @Override
    public int getItemCount() {
        return venueList.size();
    }

    public void updateList(List<Venue> venues) {
        venueList.clear();
        venueList.addAll(venues);
        notifyDataSetChanged();
    }

    public class venueViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.venue_img)
        ImageView venueImage;
        @BindView(R.id.venue_name)
        TextView venueName;
        @BindView(R.id.venue_address)
        TextView venueAddress;

        public venueViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
