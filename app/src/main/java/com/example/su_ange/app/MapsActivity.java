package com.example.su_ange.app;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private Button booknowbutton;
    private FloatingActionButton pe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        booknowbutton = (Button) findViewById(R.id.button2);
        booknowbutton.setOnClickListener(this);
        pe = (FloatingActionButton) findViewById(R.id.pinkeye);
        pe.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent;
        switch(view.getId()) {
            case R.id.button2:
                intent = new Intent(this, BookNowActivity.class);
                startActivity(intent);
            case R.id.pinkeye:
                intent = new Intent(this, VRE360.class);
                startActivity(intent);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Boston and move the camera
        LatLng loc = new LatLng(42.33141,-71.099396);
        mMap.addMarker(new MarkerOptions().position(loc).title("Boston, MA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 14));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
