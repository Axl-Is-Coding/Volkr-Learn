package com.ironsource.mediationsdk.f;

import android.text.TextUtils;
import com.ironsource.mediationsdk.U;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: HttpFunctions.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a(String str) throws Exception {
        return a(str, null);
    }

    public static String a(String str, U.a aVar) throws Exception {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 400) {
                    if (aVar != null) {
                        aVar.a("Bad Request - 400");
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    String string = sb.toString();
                    if (TextUtils.isEmpty(string)) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        bufferedReader.close();
                        return null;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    bufferedReader.close();
                    return string;
                } catch (Exception unused) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return null;
                } catch (Throwable th) {
                    bufferedReader2 = bufferedReader;
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            httpURLConnection = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }
}
