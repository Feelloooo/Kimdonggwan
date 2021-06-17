package org.project.exercise1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import net.daum.mf.map.api.*;

import java.io.IOException;
import java.util.List;

public class AnotherActivity extends AppCompatActivity implements MapView.POIItemEventListener{

    TextView mTitleTv, mDescTv;
    ImageView mImageIv;
    TextView mNumberTv;

    //주소를 위도, 경도로 바꿔주는
    final Geocoder geocoder = new Geocoder(this);
    private String location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        //mapview
        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        //AnctionBar
        ActionBar actionBar = getSupportActionBar();

        mTitleTv = findViewById(R.id.title);
        mDescTv = findViewById(R.id.description);
        mImageIv = findViewById(R.id.imageView);
        mNumberTv = findViewById(R.id.phonenumber);


        Intent intent = getIntent();

        String mTitle = intent.getStringExtra("iTitle");
        String mDescription = intent.getStringExtra("iDesc");
        final String mNumber = intent.getStringExtra("iNumber");

        byte[] mBytes = getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        actionBar.setTitle(mTitle);

        mTitleTv.setText(mTitle);
        mDescTv.setText("주소 : " + mDescription);
        mImageIv.setImageBitmap(bitmap);
        mNumberTv.setText("번호 : " + mNumber);


        //주소에서 위도, 경도로
        List<Address> list = null;
        try {
            list = geocoder.getFromLocationName(mDescription, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address addr = list.get(0);
        double lat = addr.getLatitude();
        double lon = addr.getLongitude();
        location = Double.toString(lat) + "," + Double.toString(lon);     //uri scheme에 전달할 변수

        //marker
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName(mTitle);
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(lat, lon));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker);

        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(lat, lon), 0, true);
        mapView.setPOIItemEventListener(this);


        Button button1 = findViewById(R.id.phone_icon);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+ mNumber));
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.car_icon);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "kakaomap://route?sp=&ep=" + location + "&by=CAR";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        Button button3 = findViewById(R.id.bus_icon);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "kakaomap://route?sp=&ep=" + location + "&by=PUBLICTRANSIT";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        Button button4 = findViewById(R.id.walk_icon);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "kakaomap://route?sp=&ep=" + location + "&by=FOOT";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }

    //implements MapView.POIItemEventListener Override
    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {
    }
    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

        String uri = "kakaomap://look?p=" + location;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {
    }
    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {
    }

}