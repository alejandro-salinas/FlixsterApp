package com.codepath.flixster.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel // annotation indicates class is Parcelable
public class Video {
    public String key;


    // no-arg, empty constructor required for Parceler
    public Video() {

    }

    // initialize from JSON data, the object is the movie
    public Video(JSONObject object) throws JSONException {
        key = object.getString("key");
    }

    public String getKey() {
        return key;
    }
}
