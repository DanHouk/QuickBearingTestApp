package loves.com.bearingcheck;

import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class BearingAdapter extends RecyclerView.Adapter<BearingAdapter.ViewHolder> {
    private List<Location> locations;

    public BearingAdapter(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public BearingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bearing_layout_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BearingAdapter.ViewHolder holder, int position) {
        Location location = locations.get(position);
        holder.bearingTv.setText(Float.toString(location.getBearing()));
        holder.speedTv.setText(Float.toString(location.getSpeed()));
        holder.latTv.setText(Double.toString(location.getLatitude()));
        holder.lonTv.setText(Double.toString(location.getLongitude()));
        holder.accuracyTv.setText(Float.toString(location.getAccuracy()));
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView bearingTv;
        public TextView latTv;
        public TextView lonTv;
        public TextView speedTv;
        public TextView accuracyTv;

        public ViewHolder(View view) {
            super(view);

            bearingTv = view.findViewById(R.id.bearing_tv);
            latTv = view.findViewById(R.id.lat_tv);
            lonTv = view.findViewById(R.id.lon_tv);
            speedTv = view.findViewById(R.id.speed_tv);
            accuracyTv = view.findViewById(R.id.accuracy_tv);
        }
    }

    public void addLocation(Location location) {
        locations.add(location);
    }
}