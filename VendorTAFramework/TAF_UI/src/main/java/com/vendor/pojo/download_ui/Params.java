package com.vendor.pojo.download_ui;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params {

    @SerializedName("behavior")
    @Expose
    public String behavior;
    @SerializedName("downloadPath")
    @Expose
    public String downloadPath;

}
