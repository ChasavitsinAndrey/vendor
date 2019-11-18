package com.vendor.pojo.download_ui;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DownloadProps {

    @SerializedName("cmd")
    @Expose
    public String cmd;
    @SerializedName("params")
    @Expose
    public Params params;

}