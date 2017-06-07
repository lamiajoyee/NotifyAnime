package com.example.lamia.notifyanime.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lamia on 6/6/2017.
 */

public class AuthModel {

    @SerializedName("access_token")
    public String accessToken;
    @SerializedName("token_type")
    public String tokenType;
    @SerializedName("expires")
    public Integer expires;
    @SerializedName("expires_in")
    public Integer expiresIn;

    public AuthModel(String accessToken, String tokenType, Integer expires, Integer expiresIn) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expires = expires;
        this.expiresIn = expiresIn;
    }

}
