package com.example.joseramirez.apipokemon.Model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Region {

    @SerializedName("count")
    private String count;
    @SerializedName("previous")
    private Boolean previous;
    @SerializedName("next")
    private String next;
    @SerializedName("results")
    List<Results> results;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Boolean getPrevious() {
        return previous;
    }

    public void setPrevious(Boolean previous) {
        this.previous = previous;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }






}
