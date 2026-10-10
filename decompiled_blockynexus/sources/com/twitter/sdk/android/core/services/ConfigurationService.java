package com.twitter.sdk.android.core.services;

import retrofit2.Call;
import retrofit2.http.GET;

/* JADX INFO: loaded from: classes5.dex */
public interface ConfigurationService {
    @GET("/1.1/help/configuration.json")
    Call<Object> configuration();
}
