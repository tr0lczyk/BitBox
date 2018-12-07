package com.olczyk.android.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {

    public static final String TAG = "BeatBox";
    public static final String SOUNDS_FOLDER = "sample_sounds";
    private AssetManager assetManager;
    private List<Sound> sounds = new ArrayList<>();
    public BeatBox(Context context){
        assetManager = context.getAssets();
        loadSounds();
    }

    private void loadSounds(){
        String[] soundNames;
        try {
            soundNames = assetManager.list(SOUNDS_FOLDER);
            Log.i(TAG,"Found " + soundNames.length + " sounds.");
        } catch (IOException ioe) {
            Log.e(TAG, "Cannot display: " + ioe.getMessage());
            return;
        }

        for(String filename : soundNames){
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            sounds.add(sound);
            Log.i(TAG,"Sound name: "+ sound.getName());
        }
    }

    public List<Sound> getSounds(){
        return sounds;
    }
}
