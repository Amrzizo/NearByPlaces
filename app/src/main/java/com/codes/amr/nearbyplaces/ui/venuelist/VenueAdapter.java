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
import com.codes.amr.nearbyplaces.data.model.ItemsItem;
import com.codes.amr.nearbyplaces.data.model.Venue;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.venueViewHolder> {
    private static String IMAGE_SIZE="64";
    private List<ItemsItem> venueList;
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
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.venue_item_row, parent, false);
        return new venueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(venueViewHolder holder, int position) {

        holder.bind(venueList.get(position).getVenue());

    }

    @Override
    public int getItemCount() {
        return venueList.size();
    }



    public class venueViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.venue_img)
        ImageView venueImage;
        @BindView(R.id.venue_name)
        TextView venueName;
        @BindView(R.id.venue_address)
        TextView venueAddress;
        private Venue venue;

        public venueViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        void bind( Venue venue) {
            this.venue = venue;

            venueName.setText(venue.getName());
            if (venue.getLocation().getAddress() != null)
                venueAddress.setText(venue.getLocation().getFormattedAddressString());
            else
                venueAddress.setText("no address");


                Picasso.with(context).load(venue.getCategories().get(0).getIcon().getPrefix().concat(IMAGE_SIZE).concat(venue.getCategories().get(0).getIcon().getSuffix())).into(venueImage);
        }
    }
}
