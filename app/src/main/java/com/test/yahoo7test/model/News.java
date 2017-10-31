package com.test.yahoo7test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by amitsingh on 10/31/17.
 */

public class News implements Serializable {
    @SerializedName("abstract")
    @Expose
    private String mAbstracts;

    @SerializedName("body")
    @Expose
    private String mBody;

    @SerializedName("headline")
    @Expose
    private String mHeadline;

    @SerializedName("id")
    @Expose
    private String mId;

    @SerializedName("image")
    @Expose
    private String mImageUrl;

    public String getAbstract() {
        return mAbstracts;
    }

    public String getBody() {
        return mBody;
    }

    public String getHeadline() {
        return mHeadline;
    }

    public String getId() {
        return mId;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    @Override
    public String toString() {
        return "News{" +
                "mHeadline='" + mHeadline + '\'' +
                ", mId='" + mId + '\'' +
                ", mImageUrl='" + mImageUrl + '\'' +
                '}';
    }
}
