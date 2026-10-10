package com.ironsource.sdk.utils;

import android.os.AsyncTask;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: IronSourceAsyncHttpRequestTask.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends AsyncTask<String, Integer, Integer> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(String... strArr) throws Throwable {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            httpURLConnection.getInputStream();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e3) {
            httpURLConnection2 = httpURLConnection;
            e = e3;
            e.printStackTrace();
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        return 1;
    }
}
