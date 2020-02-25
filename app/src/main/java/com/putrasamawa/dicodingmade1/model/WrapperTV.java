package com.putrasamawa.dicodingmade1.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//* Satria Junanda *//

@SuppressWarnings("unused")
public class WrapperTV {

    @SerializedName("results")
    private List<ItemTV> resultstv;

    public List<ItemTV> getResultsTV() {
        return resultstv;
    }

    public void setResultstv(List<ItemTV> resultstv) {
        this.resultstv = resultstv;
    }

}

//* Satria Junanda *//