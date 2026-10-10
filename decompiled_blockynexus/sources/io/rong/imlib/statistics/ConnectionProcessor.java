package io.rong.imlib.statistics;

import android.os.Build;
import android.util.Log;
import io.grpc.internal.GrpcUtil;
import io.rong.imlib.common.NetUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionProcessor implements Runnable {
    private static final int CONNECT_TIMEOUT_IN_MILLISECONDS = 30000;
    private static final int READ_TIMEOUT_IN_MILLISECONDS = 30000;
    private final DeviceId deviceId_;
    private final String serverURL_;
    private final SSLContext sslContext_;
    private final StatisticsStore store_;

    ConnectionProcessor(String str, StatisticsStore statisticsStore, DeviceId deviceId, SSLContext sSLContext) {
        this.serverURL_ = str;
        this.store_ = statisticsStore;
        this.deviceId_ = deviceId;
        this.sslContext_ = sSLContext;
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    StatisticsStore getCountlyStore() {
        return this.store_;
    }

    DeviceId getDeviceId() {
        return this.deviceId_;
    }

    String getServerURL() {
        return this.serverURL_;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        URLConnection uRLConnectionUrlConnectionForEventData;
        BufferedInputStream bufferedInputStream;
        while (true) {
            String[] strArrConnections = this.store_.connections();
            if (strArrConnections == null || strArrConnections.length == 0) {
                return;
            }
            if (this.deviceId_.getId() == null) {
                if (Statistics.sharedInstance().isLoggingEnabled()) {
                    Log.i("Statistics", "No Device ID available yet, skipping request " + strArrConnections[0]);
                    return;
                }
                return;
            }
            String str = strArrConnections[0];
            BufferedInputStream bufferedInputStream2 = null;
            try {
                uRLConnectionUrlConnectionForEventData = urlConnectionForEventData(str);
                try {
                    try {
                        uRLConnectionUrlConnectionForEventData.connect();
                        bufferedInputStream = new BufferedInputStream(uRLConnectionUrlConnectionForEventData.getInputStream());
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                }
            } catch (Exception e3) {
                e = e3;
                uRLConnectionUrlConnectionForEventData = null;
            } catch (Throwable th2) {
                th = th2;
                uRLConnectionUrlConnectionForEventData = null;
                bufferedInputStream = null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
                while (true) {
                    int i = bufferedInputStream.read();
                    if (i == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(i);
                    }
                }
                boolean z = true;
                if (uRLConnectionUrlConnectionForEventData instanceof HttpURLConnection) {
                    int responseCode = ((HttpURLConnection) uRLConnectionUrlConnectionForEventData).getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        z = false;
                    }
                    Log.d("Statistics", "code=" + responseCode);
                    if (!z && Statistics.sharedInstance().isLoggingEnabled()) {
                        Log.w("Statistics", "HTTP error response code was " + responseCode + " from submitting event data: " + str);
                    }
                }
                if (z) {
                    if (Statistics.sharedInstance().isLoggingEnabled()) {
                        Log.d("Statistics", "ok ->" + str);
                    }
                    this.store_.removeConnection(strArrConnections[0]);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    if (uRLConnectionUrlConnectionForEventData != null && (uRLConnectionUrlConnectionForEventData instanceof HttpURLConnection)) {
                        ((HttpURLConnection) uRLConnectionUrlConnectionForEventData).disconnect();
                    }
                } else {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                    if (uRLConnectionUrlConnectionForEventData == null || !(uRLConnectionUrlConnectionForEventData instanceof HttpURLConnection)) {
                        return;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                bufferedInputStream2 = bufferedInputStream;
                if (Statistics.sharedInstance().isLoggingEnabled()) {
                    Log.w("Statistics", "Got exception while trying to submit event data: " + str, e);
                }
                Log.d("Statistics", "exception :" + e.getMessage());
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                if (uRLConnectionUrlConnectionForEventData == null || !(uRLConnectionUrlConnectionForEventData instanceof HttpURLConnection)) {
                    return;
                }
                ((HttpURLConnection) uRLConnectionUrlConnectionForEventData).disconnect();
                return;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                if (uRLConnectionUrlConnectionForEventData == null || !(uRLConnectionUrlConnectionForEventData instanceof HttpURLConnection)) {
                    throw th;
                }
                ((HttpURLConnection) uRLConnectionUrlConnectionForEventData).disconnect();
                throw th;
            }
        }
    }

    URLConnection urlConnectionForEventData(String str) throws IOException {
        String str2 = this.serverURL_;
        URL url = new URL(str2);
        HttpURLConnection httpURLConnectionCreateURLConnection = NetUtils.createURLConnection(str2);
        httpURLConnectionCreateURLConnection.setConnectTimeout(30000);
        httpURLConnectionCreateURLConnection.setReadTimeout(30000);
        httpURLConnectionCreateURLConnection.setUseCaches(false);
        httpURLConnectionCreateURLConnection.setDoInput(true);
        String picturePathFromQuery = UserData.getPicturePathFromQuery(url);
        if (Statistics.sharedInstance().isLoggingEnabled()) {
            Log.d("Statistics", "Got picturePath: " + picturePathFromQuery);
        }
        if (!picturePathFromQuery.equals("")) {
            File file = new File(picturePathFromQuery);
            httpURLConnectionCreateURLConnection.setDoOutput(true);
            String hexString = Long.toHexString(System.currentTimeMillis());
            httpURLConnectionCreateURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + hexString);
            OutputStream outputStream = httpURLConnectionCreateURLConnection.getOutputStream();
            PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
            printWriter.append((CharSequence) ("--" + hexString)).append((CharSequence) "\r\n");
            printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"binaryFile\"; filename=\"" + file.getName() + "\"")).append((CharSequence) "\r\n");
            StringBuilder sb = new StringBuilder();
            sb.append("Content-Type: ");
            sb.append(URLConnection.guessContentTypeFromName(file.getName()));
            printWriter.append((CharSequence) sb.toString()).append((CharSequence) "\r\n");
            printWriter.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n");
            printWriter.append((CharSequence) "\r\n").flush();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                outputStream.write(bArr, 0, i);
            }
            outputStream.flush();
            printWriter.append((CharSequence) "\r\n").flush();
            fileInputStream.close();
            printWriter.append((CharSequence) ("--" + hexString + "--")).append((CharSequence) "\r\n").flush();
        } else if (str.contains("&crash=")) {
            if (Statistics.sharedInstance().isLoggingEnabled()) {
                Log.d("Statistics", "Using post because of crash");
            }
            httpURLConnectionCreateURLConnection.setDoOutput(true);
            httpURLConnectionCreateURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
            OutputStream outputStream2 = httpURLConnectionCreateURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream2, "UTF-8"));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream2.close();
        } else {
            httpURLConnectionCreateURLConnection.setDoOutput(true);
            httpURLConnectionCreateURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
            httpURLConnectionCreateURLConnection.setRequestProperty("Connection", "close");
            OutputStream outputStream3 = httpURLConnectionCreateURLConnection.getOutputStream();
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream3, "UTF-8"));
            bufferedWriter2.write(str);
            bufferedWriter2.flush();
            bufferedWriter2.close();
            outputStream3.close();
        }
        return httpURLConnectionCreateURLConnection;
    }
}
