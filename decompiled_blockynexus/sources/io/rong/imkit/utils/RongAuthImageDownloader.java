package io.rong.imkit.utils;

import android.content.Context;
import com.just.agentweb.AgentWebPermissions;
import io.rong.common.utils.SSLUtils;
import io.rong.imageloader.core.assist.ContentLengthInputStream;
import io.rong.imageloader.core.download.BaseImageDownloader;
import io.rong.imageloader.utils.IoUtils;
import io.rong.imlib.common.NetUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes5.dex */
public class RongAuthImageDownloader extends BaseImageDownloader {
    private static final String TAG = "RongAuthImageDownloader";

    public RongAuthImageDownloader(Context context) {
        super(context);
    }

    @Override // io.rong.imageloader.core.download.BaseImageDownloader
    protected InputStream getStreamFromNetwork(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnectionCreateURLConnection;
        InputStream errorStream;
        try {
            httpURLConnectionCreateURLConnection = NetUtils.createURLConnection(str);
            try {
                httpURLConnectionCreateURLConnection.setConnectTimeout(this.connectTimeout);
                httpURLConnectionCreateURLConnection.setReadTimeout(this.readTimeout);
                if (httpURLConnectionCreateURLConnection instanceof HttpsURLConnection) {
                    SSLContext sSLContext = SSLUtils.getSSLContext();
                    if (sSLContext != null) {
                        ((HttpsURLConnection) httpURLConnectionCreateURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
                    }
                    HostnameVerifier hostVerifier = SSLUtils.getHostVerifier();
                    if (hostVerifier != null) {
                        ((HttpsURLConnection) httpURLConnectionCreateURLConnection).setHostnameVerifier(hostVerifier);
                    }
                }
                httpURLConnectionCreateURLConnection.connect();
                if (httpURLConnectionCreateURLConnection.getResponseCode() >= 300 && httpURLConnectionCreateURLConnection.getResponseCode() < 400) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(httpURLConnectionCreateURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION)).openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(this.connectTimeout);
                        httpURLConnection.setReadTimeout(this.readTimeout);
                        if (httpURLConnection instanceof HttpsURLConnection) {
                            SSLContext sSLContext2 = SSLUtils.getSSLContext();
                            if (sSLContext2 != null) {
                                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext2.getSocketFactory());
                            }
                            HostnameVerifier hostVerifier2 = SSLUtils.getHostVerifier();
                            if (hostVerifier2 != null) {
                                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostVerifier2);
                            }
                        }
                        httpURLConnection.connect();
                        httpURLConnectionCreateURLConnection = httpURLConnection;
                    } catch (IOException e2) {
                        e = e2;
                        httpURLConnectionCreateURLConnection = httpURLConnection;
                        if (httpURLConnectionCreateURLConnection == null || httpURLConnectionCreateURLConnection.getContentLength() <= 0 || !httpURLConnectionCreateURLConnection.getContentType().contains("image/")) {
                            if (httpURLConnectionCreateURLConnection != null) {
                                IoUtils.readAndCloseStream(httpURLConnectionCreateURLConnection.getErrorStream());
                            }
                            throw e;
                        }
                        errorStream = httpURLConnectionCreateURLConnection.getErrorStream();
                    }
                }
                errorStream = httpURLConnectionCreateURLConnection.getInputStream();
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e = e4;
            httpURLConnectionCreateURLConnection = null;
        }
        if (shouldBeProcessed(httpURLConnectionCreateURLConnection)) {
            return new ContentLengthInputStream(new BufferedInputStream(errorStream, 32768), httpURLConnectionCreateURLConnection.getContentLength());
        }
        IoUtils.closeSilently(errorStream);
        throw new IOException("Image request failed with response code " + httpURLConnectionCreateURLConnection.getResponseCode());
    }

    public RongAuthImageDownloader(Context context, int i, int i2) {
        super(context, i, i2);
    }
}
