package com.example.android.quakereport;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes)
    {
        super(context,0,earthquakes);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item,parent,false);
        }

        String primaryLocation;
        String locationOffset;
        String LOCATION_SEPARATOR = " of ";
        Earthquake currentEarthquake = getItem(position);

        String originalLocation = currentEarthquake.getLocation();

        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts=originalLocation.split(LOCATION_SEPARATOR);
            locationOffset=parts[0]+LOCATION_SEPARATOR;
            primaryLocation=parts[1];
        }
        else{
            locationOffset=getContext().getString(R.string.near_the);
            primaryLocation=originalLocation;
        }

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
                magnitudeView.setText(formattedMagnitude);

        TextView locationview =(TextView) listItemView.findViewById(R.id.location_offset);
        locationview.setText(locationOffset);

        TextView primary_locationview =(TextView) listItemView.findViewById(R.id.primary_location);
        primary_locationview.setText(primaryLocation);

        Date dateObject =new Date(currentEarthquake.gettimemili());

        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);

        TextView dateview =(TextView) listItemView.findViewById(R.id.date);
        TextView Timeview =(TextView) listItemView.findViewById(R.id.time);


        dateview.setText(formattedDate);
        Timeview.setText(formattedTime);

        return listItemView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }



}
