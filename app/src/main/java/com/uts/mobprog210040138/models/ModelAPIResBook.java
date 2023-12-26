package com.uts.mobprog210040138.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAPIResBook {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<ModelBook> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ModelBook> getData() {
        return data;
    }

    public void setData(List<ModelBook> data) {
        this.data = data;
    }
}
