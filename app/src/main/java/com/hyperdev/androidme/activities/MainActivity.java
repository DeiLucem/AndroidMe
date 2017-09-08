package com.hyperdev.androidme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hyperdev.androidme.R;
import com.hyperdev.androidme.data.AndroidImageAssets;
import com.hyperdev.androidme.frags.FragBody;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            int positionBody = getIntent().getIntExtra("positionBody", 0);
            FragBody fragBody= new FragBody();
            fragBody.setnParts(AndroidImageAssets.getBodies());
            fragBody.setLocationlist(positionBody);
            getSupportFragmentManager() .beginTransaction()
                    .add(R.id.bodyy, fragBody)
                    .commit();
           int positionLeg = getIntent().getIntExtra("positionLeg", 0);
           FragBody fragleg = new FragBody();
            fragleg.setnParts(AndroidImageAssets.getLegs());
            fragleg.setLocationlist(positionLeg);
            getSupportFragmentManager() .beginTransaction()
                    .add(R.id.leggs, fragleg)
                    .commit();

            int positionHead = getIntent().getIntExtra("positionHead", 0);
            FragBody fraghead = new FragBody();
            fraghead.setnParts(AndroidImageAssets.getHeads());
            fraghead.setLocationlist(positionHead);
            getSupportFragmentManager() .beginTransaction()
                    .add(R.id.headd, fraghead)
                    .commit();
        }
    }
}
