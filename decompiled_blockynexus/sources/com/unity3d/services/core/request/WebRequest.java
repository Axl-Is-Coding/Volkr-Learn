package com.unity3d.services.core.request;

import com.just.agentweb.DefaultWebClient;
import com.unity3d.services.core.log.DeviceLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes5.dex */
public class WebRequest {
    private String _body;
    private boolean _canceled;
    private int _connectTimeout;
    private long _contentLength;
    private Map<String, List<String>> _headers;
    private IWebRequestProgressListener _progressListener;
    private int _readTimeout;
    private String _requestType;
    private int _responseCode;
    private Map<String, List<String>> _responseHeaders;
    private URL _url;

    public enum RequestType {
        POST,
        GET,
        HEAD
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map) throws MalformedURLException {
        this(str, str2, map, 30000, 30000);
    }

    private HttpURLConnection getHttpUrlConnectionWithHeaders() throws NetworkIOException, IllegalArgumentException {
        HttpURLConnection httpURLConnection;
        if (getUrl().toString().startsWith(DefaultWebClient.HTTPS_SCHEME)) {
            try {
                httpURLConnection = (HttpsURLConnection) getUrl().openConnection();
            } catch (IOException e2) {
                throw new NetworkIOException("Open HTTPS connection: " + e2.getMessage());
            }
        } else {
            if (!getUrl().toString().startsWith(DefaultWebClient.HTTP_SCHEME)) {
                throw new IllegalArgumentException("Invalid url-protocol in url: " + getUrl().toString());
            }
            try {
                httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            } catch (IOException e3) {
                throw new NetworkIOException("Open HTTP connection: " + e3.getMessage());
            }
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(getConnectTimeout());
        httpURLConnection.setReadTimeout(getReadTimeout());
        try {
            httpURLConnection.setRequestMethod(getRequestType());
            if (getHeaders() != null && getHeaders().size() > 0) {
                for (String str : getHeaders().keySet()) {
                    for (String str2 : getHeaders().get(str)) {
                        DeviceLog.debug("Setting header: " + str + "=" + str2);
                        httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
            return httpURLConnection;
        } catch (ProtocolException e4) {
            throw new NetworkIOException("Set Request Method: " + getRequestType() + ", " + e4.getMessage());
        }
    }

    public void cancel() {
        this._canceled = true;
    }

    public String getBody() {
        return this._body;
    }

    public int getConnectTimeout() {
        return this._connectTimeout;
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public Map<String, List<String>> getHeaders() {
        return this._headers;
    }

    public String getQuery() {
        URL url = this._url;
        if (url != null) {
            return url.getQuery();
        }
        return null;
    }

    public int getReadTimeout() {
        return this._readTimeout;
    }

    public String getRequestType() {
        return this._requestType;
    }

    public int getResponseCode() {
        return this._responseCode;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this._responseHeaders;
    }

    public URL getUrl() {
        return this._url;
    }

    public boolean isCanceled() {
        return this._canceled;
    }

    public String makeRequest() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        makeStreamRequest(byteArrayOutputStream);
        return byteArrayOutputStream.toString("UTF-8");
    }

    public long makeStreamRequest(OutputStream outputStream) throws Exception {
        InputStream errorStream;
        PrintWriter printWriter;
        HttpURLConnection httpUrlConnectionWithHeaders = getHttpUrlConnectionWithHeaders();
        httpUrlConnectionWithHeaders.setDoInput(true);
        if (getRequestType().equals(RequestType.POST.name())) {
            httpUrlConnectionWithHeaders.setDoOutput(true);
            PrintWriter printWriter2 = null;
            try {
                try {
                    printWriter = new PrintWriter((Writer) new OutputStreamWriter(httpUrlConnectionWithHeaders.getOutputStream(), "UTF-8"), true);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (getBody() == null) {
                    printWriter.print(getQuery());
                } else {
                    printWriter.print(getBody());
                }
                printWriter.flush();
                try {
                    printWriter.close();
                } catch (Exception e3) {
                    DeviceLog.exception("Error closing writer", e3);
                    throw e3;
                }
            } catch (IOException e4) {
                e = e4;
                printWriter2 = printWriter;
                DeviceLog.exception("Error while writing POST params", e);
                throw new NetworkIOException("Error writing POST params: " + e.getMessage());
            } catch (Throwable th2) {
                th = th2;
                printWriter2 = printWriter;
                if (printWriter2 != null) {
                    try {
                        printWriter2.close();
                    } catch (Exception e5) {
                        DeviceLog.exception("Error closing writer", e5);
                        throw e5;
                    }
                }
                throw th;
            }
        }
        try {
            this._responseCode = httpUrlConnectionWithHeaders.getResponseCode();
            this._contentLength = httpUrlConnectionWithHeaders.getContentLength();
            if (httpUrlConnectionWithHeaders.getHeaderFields() != null) {
                this._responseHeaders = httpUrlConnectionWithHeaders.getHeaderFields();
            }
            try {
                errorStream = httpUrlConnectionWithHeaders.getInputStream();
            } catch (IOException e6) {
                errorStream = httpUrlConnectionWithHeaders.getErrorStream();
                if (errorStream == null) {
                    throw new NetworkIOException("Can't open error stream: " + e6.getMessage());
                }
            }
            IWebRequestProgressListener iWebRequestProgressListener = this._progressListener;
            if (iWebRequestProgressListener != null) {
                iWebRequestProgressListener.onRequestStart(getUrl().toString(), this._contentLength, this._responseCode, this._responseHeaders);
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
            byte[] bArr = new byte[4096];
            long j = 0;
            int i = 0;
            while (!isCanceled() && i != -1) {
                try {
                    i = bufferedInputStream.read(bArr);
                    if (i > 0) {
                        outputStream.write(bArr, 0, i);
                        j += (long) i;
                        IWebRequestProgressListener iWebRequestProgressListener2 = this._progressListener;
                        if (iWebRequestProgressListener2 != null) {
                            iWebRequestProgressListener2.onRequestProgress(getUrl().toString(), j, this._contentLength);
                        }
                    }
                } catch (IOException e7) {
                    throw new NetworkIOException("Network exception: " + e7.getMessage());
                } catch (Exception e8) {
                    throw new Exception("Unknown Exception: " + e8.getMessage());
                }
            }
            httpUrlConnectionWithHeaders.disconnect();
            outputStream.flush();
            return j;
        } catch (IOException | RuntimeException e9) {
            throw new NetworkIOException("Response code: " + e9.getMessage());
        }
    }

    public void setBody(String str) {
        this._body = str;
    }

    public void setConnectTimeout(int i) {
        this._connectTimeout = i;
    }

    public void setProgressListener(IWebRequestProgressListener iWebRequestProgressListener) {
        this._progressListener = iWebRequestProgressListener;
    }

    public void setReadTimeout(int i) {
        this._readTimeout = i;
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map, int i, int i2) throws MalformedURLException {
        this._requestType = RequestType.GET.name();
        this._responseCode = -1;
        this._contentLength = -1L;
        this._canceled = false;
        this._url = new URL(str);
        this._requestType = str2;
        this._headers = map;
        this._connectTimeout = i;
        this._readTimeout = i2;
    }
}
