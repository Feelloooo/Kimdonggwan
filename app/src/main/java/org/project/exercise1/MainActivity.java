package org.project.exercise1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.tensorflow.lite.examples.classification.tflite.Classifier;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            //카카오맵 hashkey 발급
            //getHashKey();

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button button = findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), Menu1_Activity.class);
                    startActivity(intent);
                }
            });
            Button button4 = findViewById(R.id.button4);
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, ClassifierActivity.class);
                    startActivity(intent);
                }
            });


        }
        public void onButton2Clicked(View v){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("kakaomap://place?id=11312845"));
            startActivity(intent);
        }
        public void onButton3Clicked(View v){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8957-5311"));
            startActivity(intent);
        }

//        hashkey발급
//        private void getHashKey(){
//            PackageInfo packageInfo = null;
//            try {
//                packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
//            } catch (PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }
//            if (packageInfo == null)
//                Log.e("KeyHash", "KeyHash:null");
//
//            for (Signature signature : packageInfo.signatures) {
//                try {
//                    MessageDigest md = MessageDigest.getInstance("SHA");
//                    md.update(signature.toByteArray());
//                    Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//                } catch (NoSuchAlgorithmException e) {
//                    Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
//                }
//            }
//        }


    }
