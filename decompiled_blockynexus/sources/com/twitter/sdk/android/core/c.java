package com.twitter.sdk.android.core;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: Callback.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c<T> implements Callback<T> {
    public abstract void a(TwitterException twitterException);

    public abstract void a(k<T> kVar);

    @Override // retrofit2.Callback
    public final void onFailure(Call<T> call, Throwable th) {
        a(new TwitterException("Request Failure", th));
    }

    @Override // retrofit2.Callback
    public final void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            a(new k<>(response.body(), response));
        } else {
            a(new TwitterApiException(response));
        }
    }
}
