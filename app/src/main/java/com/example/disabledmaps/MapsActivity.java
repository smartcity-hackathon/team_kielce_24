package com.example.disabledmaps;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.disabledmaps.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double longit;
    double latit;
    LatLng kielce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;
        kielce = new LatLng(50.898672, 20.588808);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kielce));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kielce,13));

        addMarker(googleMap, 50.8527512, 20.6429483, "Wietrznia",
                "Zły grunt", "wheelchair");
        addMarker(googleMap, 50.859395,20.619514, "Kadzielnia", "Stromo",
                "pushchair");
        addMarker(googleMap, 50.870827,20.727123, "Zalew", "Woda",
                "wheelchair");
        addMarker(googleMap, 50.847172, 20.622729, "Rajtarska",
                "Zły przejazd", "wheelchair");
        addMarker(googleMap, 50.856712, 20.72787, "", "", "pushchair");
        addMarker(googleMap, 50.8492, 20.65, " ","", "pushchair");
        addMarker(googleMap, 50.8501, 20.73, "","", "pushchair");
        addMarker(googleMap, 50.881763, 20.642738, "Street", "Koleiny",
                "wheelchair");
        addMarker(googleMap, 50.868672, 20.623740, "woda", "woda",
                "pushchair");
    }
    private void addMarker(GoogleMap googleMap, double latitude, double longitude, String place,
                           String info, String icon){
        mMap = googleMap;
        LatLng point = new LatLng(latitude, longitude);

        switch(icon){
            case "wheelchair":
                mMap.addMarker(new MarkerOptions().position(point).title(place).snippet(info)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wheelchair)));
                break;
            case "pushchair":
                mMap.addMarker(new MarkerOptions().position(point).title(place).snippet(info)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pushchair)));
                break;

        }
    }
    public void onMapSearch(View view) {
        EditText locationSearch = (EditText) findViewById(R.id.editText);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

}
