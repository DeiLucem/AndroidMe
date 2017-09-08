package com.hyperdev.androidme.frags;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;

import java.util.ArrayList;
import java.util.List;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;


public class FragBody extends Fragment {

    private List<Integer> nParts;
    private static final String NUMBER_PART = "num_parts";
    private static final String LIST_PART ="list_part";
    private int nLocation;

    public FragBody(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container , Bundle savedInstanceState)
    {
        if(savedInstanceState != null) {
            nParts = savedInstanceState.getIntegerArrayList(LIST_PART);
            nLocation = savedInstanceState.getInt(NUMBER_PART);}

        View rootView = inflater.inflate(R.layout.frags, container , false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.FragmentImg);

        if(nParts != null){
            imageView.setImageResource(nParts.get(nLocation));
            imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if(nLocation < nParts.size()-1) {
                        nLocation++;
                    }else{
                        nLocation = 0;
                    }
                    imageView.setImageResource(nParts.get(nLocation));
                }
                        });
    }
    return rootView;
    }
 public void setLocationlist(int nLocation){

     this.nLocation = nLocation;

 }
 public void setnParts(List<Integer> nPartss){
     this.nParts = nPartss;
 }
@Override
    public void onSaveInstanceState(Bundle outState){
    super.onSaveInstanceState(outState);

    outState.putIntegerArrayList(LIST_PART,(ArrayList<Integer>)nParts);
    outState.putInt(NUMBER_PART,nLocation);
}

}

