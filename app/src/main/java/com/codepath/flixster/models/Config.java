package com.codepath.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    // the base URL for loading images
    String imageBaseURL;
    // the poster size to use when fetching images, part of the URL
    String posterSize;
    // the backdrop size to use when fetching images
    String backdropSize;

    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        // get the image base URL
        imageBaseURL = images.getString("secure_base_url");
        // get the poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // use the option at index 3 or w42 as a fallback
        posterSize = posterSizeOptions.optString(3, "w342");
        // parse the backdrop sizes and use the option at index 1 or w780 as a default
        JSONArray backdropSizeOptions = images.getJSONArray(("backdrop_sizes"));
        backdropSize = backdropSizeOptions.optString(1, "w780");
    }

    // helper method for creating urls
    public String getImageURL(String size, String path) {
        return String.format("%s%s%s", imageBaseURL, size, path); //Concatenate all three
    }


    // Gets info from outside of the class
    public String getImageBaseURL() {
        return imageBaseURL;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() {
        return backdropSize;
    }
}

