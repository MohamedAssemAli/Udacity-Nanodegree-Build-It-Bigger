package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import app.builditbigger.assem.com.javajokes.JavaJokes;
import app.builditbigger.assem.com.jokebuilder.JokeBuilderActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnDataFetched {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button jokeBtn = root.findViewById(R.id.jokes_button);
        jokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EndpointAsyncTask(MainActivityFragment.this).execute();
            }
        });
        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    @Override
    public void onJokeFetched(String joke) {
        Intent intent = new Intent(getContext(), JokeBuilderActivity.class);
        intent.putExtra("key", joke);
        startActivity(intent);
    }

    public void tellJoke(View view) {
        JavaJokes joker = new JavaJokes();
        // Create Intent to launch JokeFactory Activity
        Intent intent = new Intent(getActivity(), JokeBuilderActivity.class);
        // Put the string in the envelope
        intent.putExtra("key", joker.tellJoke());
        startActivity(intent);
    }
}
