package io.rong.imlib.httpdns;

import io.rong.common.rlog.RLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
final class HttpDnsClient {
    static final int HTTPDNS_RESOLVE_ERR = -1;
    static final int HTTPDNS_RESOLVE_OK = 0;
    private static final int RESOLVE_DNS_ERR = 103;
    private static final int RSP_DATA_NULL = 101;
    private static final int SIGN_EXPIRED = 102;
    private static final String TAG = "HttpDnsClient";
    private static volatile HttpDnsClient httpDnsClient = null;
    private static HttpDnsHostnameVerifier httpDnsHostnameVerifier = null;
    private static boolean isSecretEncrypted = true;
    private static final int kDftSignatureTime = 300;
    private static final String osType = "android";
    private static final String sdkVersion = "1.3";
    private static final String serverDomain = "httpdns.baidubce.com";
    private static final int timeOut = 3000;
    private String defaultServerIp = "180.76.76.200";
    private boolean isHttps = true;
    private long repairLocalClock = 0;
    private final Object hostsExpiredLock = new Object();
    private ArrayList<String> hostsExpired = new ArrayList<>();
    private String accountID = "";
    private String secret = "";
    private boolean preResolveFinish = false;
    private int maxHostNum = 10;
    private final Object hostToResolveLock = new Object();
    private final HashSet<String> hostsToResolve = new HashSet<>();

    interface AsyncHttpDnsCompletion {
        void callback(int i, RequestParamType requestParamType, Map<String, Result> map, String str);
    }

    private class AsyncHttpTask implements Runnable {
        private String hostsOrTag;
        private AsyncHttpDnsCompletion httpDnsCompletion;
        private boolean needRetryBySignExpired = false;
        private RequestParamType requestParamType;

        AsyncHttpTask(String str, RequestParamType requestParamType, AsyncHttpDnsCompletion asyncHttpDnsCompletion) {
            this.hostsOrTag = str;
            this.requestParamType = requestParamType;
            this.httpDnsCompletion = asyncHttpDnsCompletion;
        }

        private String getHttpDnsUrl(String str, RequestParamType requestParamType) {
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + 300 + HttpDnsClient.this.repairLocalClock;
            String strCalcSign = HttpDnsClient.this.calcSign(str, jCurrentTimeMillis);
            if (strCalcSign == null) {
                return null;
            }
            String str2 = HttpDnsClient.this.defaultServerIp;
            Logger.printLog("Using BGPServerIp(%s)", HttpDnsClient.this.defaultServerIp);
            String str3 = requestParamType.equals(RequestParamType.TAG_OF_HOSTS) ? String.format("%s/v4/resolve?account_id=%s&tag=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, HttpDnsClient.this.accountID, str, strCalcSign, Long.valueOf(jCurrentTimeMillis), HttpDnsClient.sdkVersion, "android") : String.format("%s/v4/resolve?account_id=%s&dn=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, HttpDnsClient.this.accountID, str, strCalcSign, Long.valueOf(jCurrentTimeMillis), HttpDnsClient.sdkVersion, "android");
            return HttpDnsClient.this.isHttps ? String.format("https://%s", str3) : String.format("http://%s", str3);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0152 A[PHI: r4 r11 r13
          0x0152: PHI (r4v4 java.util.Map<java.lang.String, io.rong.imlib.httpdns.HttpDnsClient$Result>) = 
          (r4v0 java.util.Map<java.lang.String, io.rong.imlib.httpdns.HttpDnsClient$Result>)
          (r4v0 java.util.Map<java.lang.String, io.rong.imlib.httpdns.HttpDnsClient$Result>)
          (r4v0 java.util.Map<java.lang.String, io.rong.imlib.httpdns.HttpDnsClient$Result>)
          (r4v5 java.util.Map<java.lang.String, io.rong.imlib.httpdns.HttpDnsClient$Result>)
         binds: [B:54:0x017b, B:60:0x0191, B:65:0x01a5, B:33:0x0150] A[DONT_GENERATE, DONT_INLINE]
          0x0152: PHI (r11v7 long) = (r11v3 long), (r11v4 long), (r11v5 long), (r11v9 long) binds: [B:54:0x017b, B:60:0x0191, B:65:0x01a5, B:33:0x0150] A[DONT_GENERATE, DONT_INLINE]
          0x0152: PHI (r13v13 java.net.HttpURLConnection) = 
          (r13v8 java.net.HttpURLConnection)
          (r13v9 java.net.HttpURLConnection)
          (r13v10 java.net.HttpURLConnection)
          (r13v17 java.net.HttpURLConnection)
         binds: [B:54:0x017b, B:60:0x0191, B:65:0x01a5, B:33:0x0150] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01b1  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0244  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void httpGet(java.lang.String r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 586
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.httpdns.HttpDnsClient.AsyncHttpTask.httpGet(java.lang.String):void");
        }

        private void startResolveRequest() throws Throwable {
            String httpDnsUrl = getHttpDnsUrl(this.hostsOrTag, this.requestParamType);
            if (httpDnsUrl != null) {
                httpGet(httpDnsUrl);
            } else {
                this.httpDnsCompletion.callback(-1, this.requestParamType, null, this.hostsOrTag);
                Logger.printLog("Httpdns request failed for  %s(%s), get url error", this.requestParamType.toString(), this.hostsOrTag);
            }
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            startResolveRequest();
            if (this.needRetryBySignExpired) {
                Logger.printLog("Retry for %s(%s).", this.requestParamType.toString(), this.hostsOrTag);
                startResolveRequest();
            }
            synchronized (HttpDnsClient.this.hostToResolveLock) {
                if (!this.requestParamType.equals(RequestParamType.TAG_OF_HOSTS)) {
                    for (String str : this.hostsOrTag.split(",")) {
                        HttpDnsClient.this.hostsToResolve.remove(str);
                    }
                }
            }
            synchronized (HttpDnsClient.this.hostsExpiredLock) {
                if (this.requestParamType.equals(RequestParamType.DNLIST_HOSTS)) {
                    for (String str2 : this.hostsOrTag.split(",")) {
                        HttpDnsClient.this.hostsExpired.remove(str2);
                    }
                }
            }
        }
    }

    private class HttpDnsHostnameVerifier implements HostnameVerifier {
        private HttpDnsHostnameVerifier() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(HttpDnsClient.serverDomain, sSLSession);
        }
    }

    public enum RequestParamType {
        DNLIST_HOSTS,
        TAG_OF_HOSTS
    }

    public class Result {
        private final String clientIp;
        private final ArrayList<String> ipv4List;
        private final long ttl;

        Result(ArrayList<String> arrayList, long j, String str) {
            this.ipv4List = arrayList;
            this.ttl = j;
            this.clientIp = str;
        }

        String getClientIp() {
            return this.clientIp;
        }

        ArrayList<String> getIpv4List() {
            return this.ipv4List;
        }

        long getTtl() {
            return this.ttl;
        }
    }

    private HttpDnsClient() {
        httpDnsHostnameVerifier = new HttpDnsHostnameVerifier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calcSign(String str, long j) {
        return RongHttpDnsUtil.md5(String.format("%s-%s-%d", str, getSecret(), Long.valueOf(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map checkRspMsg(String str, String str2, RequestParamType requestParamType) {
        HashMap map = new HashMap();
        map.put("isMsgOK", false);
        map.put("isSignExpired", false);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("msg");
            if (strOptString == null || strOptString.isEmpty()) {
                Logger.printLog("Httpdns request failed for %s(%s), response lack of msg", requestParamType.toString(), str2);
                return map;
            }
            if (!"SignatureExpired".equals(strOptString)) {
                if ("ok".equals(strOptString)) {
                    map.put("isMsgOK", true);
                    return map;
                }
                Logger.printLog("Httpdns request failed for %s(%s), response msg(%s) is not ok", requestParamType.toString(), str2, strOptString);
                return map;
            }
            int iOptInt = jSONObject.optInt("timestamp");
            if (iOptInt == 0) {
                Logger.printLog("Httpdns request failed for %s(%s), response get invalid timestamp", requestParamType.toString(), str2);
            } else {
                this.repairLocalClock = ((long) iOptInt) - (System.currentTimeMillis() / 1000);
                map.put("isSignExpired", true);
            }
            return map;
        } catch (JSONException e2) {
            e2.printStackTrace();
            Logger.printLog("Httpdns request failed for %s(%s), response parse json error", requestParamType.toString(), str2);
            return map;
        }
    }

    static HttpDnsClient getInstance() {
        if (httpDnsClient == null) {
            synchronized (HttpDnsClient.class) {
                if (httpDnsClient == null) {
                    httpDnsClient = new HttpDnsClient();
                }
            }
        }
        return httpDnsClient;
    }

    private String getSecret() {
        return !isSecretEncrypted ? this.secret : RongHttpDnsUtil.decode(this.secret);
    }

    private String getStringFromGzip(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
            do {
                int i2 = gZIPInputStream.read(bArr2, 0, i);
                byteArrayOutputStream.write(bArr2, 0, i2);
                if (i2 == -1) {
                    break;
                }
            } while (!isJson(byteArrayOutputStream.toString()));
            gZIPInputStream.close();
            return byteArrayOutputStream.toString();
        } catch (IOException e2) {
            RLog.e(TAG, "getStringFromGzip IOException", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStringFromInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (contentEncoding != null) {
            try {
                if (contentEncoding.contains("gzip")) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int contentLength = httpURLConnection.getContentLength();
                    if (contentLength <= 0) {
                        contentLength = 1024;
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (-1 == i) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } else {
                        byte[] bArr2 = new byte[contentLength];
                        int i2 = inputStream.read(bArr2);
                        if (i2 != -1) {
                            byteArrayOutputStream.write(bArr2, 0, i2);
                        }
                    }
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return getStringFromGzip(byteArrayOutputStream.toByteArray(), contentLength);
                }
            } catch (UnsupportedEncodingException e2) {
                RLog.e(TAG, "getStringFromInputStream UnsupportedEncodingException", e2);
                return null;
            } catch (IOException e3) {
                RLog.e(TAG, "getStringFromInputStream IOException", e3);
                return null;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(line);
        }
    }

    private static boolean isJson(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map parseRspData(String str, String str2) {
        String string;
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("clientip")) {
                try {
                    string = jSONObject.getString("clientip");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    string = null;
                }
            } else {
                string = null;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                Logger.printLog("Httpdns request failed, hostsOrTag(%s), response has empty data", str2);
                return null;
            }
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            int i = 0;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next).optJSONObject("ipv4");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("ip");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    Logger.printLog("Httpdns request failed, host(%s), response has no ip field", next);
                    map.put(next, null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i2);
                        if (strOptString == null || strOptString.isEmpty()) {
                            Logger.printLog("Httpdns request warning, host(%s), response get ip error", next);
                        } else if (RongHttpDnsUtil.validateIpv4(strOptString)) {
                            arrayList.add(strOptString);
                        } else {
                            Logger.printLog("Httpdns request warning, host(%s), response get invalid ip(%s)", next, strOptString);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Logger.printLog("Httpdns request failed, host(%s), response has no valid ip", next);
                        map.put(next, null);
                    } else {
                        try {
                            long j = jSONObjectOptJSONObject2.getLong("ttl");
                            if (j < 0) {
                                Logger.printLog("Httpdns request failed, host(%s), response has invalid ttl(%s)", next, Long.valueOf(j));
                                map.put(next, null);
                            } else {
                                map.put(next, new Result(arrayList, j, string));
                                i++;
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                            Logger.printLog("Httpdns request failed, host(%s), response has no ttl", next);
                            return null;
                        }
                    }
                }
            }
            if (i == 0) {
                return null;
            }
            return map;
        } catch (JSONException e4) {
            e4.printStackTrace();
            Logger.printLog("Httpdns request failed, hostsOrTag(%s), response parse data json error", str2);
            return null;
        }
    }

    void asyncSendRequest(String str, RequestParamType requestParamType, AsyncHttpDnsCompletion asyncHttpDnsCompletion) {
        if (str == null || str.isEmpty()) {
            return;
        }
        synchronized (this.hostToResolveLock) {
            if (requestParamType.equals(RequestParamType.DNLIST_HOSTS)) {
                ArrayList arrayList = new ArrayList(Arrays.asList(str.split(",")));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (this.hostsToResolve.contains(str2)) {
                        Logger.printLog("Httpdns request request for host(%s) is in processing，will exclude it.", str2);
                        it.remove();
                    } else {
                        this.hostsToResolve.add(str2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append((String) arrayList.get(i));
                    sb.append(",");
                }
                str = sb.toString().replaceAll("^,*|,*$", "");
            }
            if (!str.isEmpty()) {
                try {
                    ThreadPool.getInstance().getExecutor().execute(new AsyncHttpTask(str, requestParamType, asyncHttpDnsCompletion));
                } catch (RejectedExecutionException e2) {
                    RLog.e(TAG, "asyncSendRequest RejectedExecutionException", e2);
                    Logger.printLog("Httpdns request failed, host(%s), async tasks has exceed the maximum thread limit.", str);
                }
            }
        }
    }

    String getAccountID() {
        return this.accountID;
    }

    int getMaxHostNum() {
        return this.maxHostNum;
    }

    boolean getPreResolveFinish() {
        return this.preResolveFinish;
    }

    long getRepairLocalClock() {
        return this.repairLocalClock;
    }

    boolean isHttps() {
        return this.isHttps;
    }

    void setAccountID(String str) {
        this.accountID = str;
    }

    void setDefaultServerIp(String str) {
        this.defaultServerIp = str;
    }

    void setHttps(boolean z) {
        this.isHttps = z;
    }

    void setPreResolveFinish(boolean z) {
        this.preResolveFinish = z;
    }

    void setSecret(String str) {
        this.secret = RongHttpDnsUtil.encode(str);
        if (this.secret == null) {
            this.secret = str;
            isSecretEncrypted = false;
        }
    }

    void splitHostsAndSendRequest(ArrayList<String> arrayList, AsyncHttpDnsCompletion asyncHttpDnsCompletion) {
        ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
        int i = 0;
        int i2 = 0;
        while (i < arrayList2.size()) {
            StringBuilder sb = new StringBuilder();
            int i3 = i;
            int i4 = 0;
            while (true) {
                int i5 = this.maxHostNum;
                if (i4 >= i5 || (i3 = i4 + (i5 * i2)) >= arrayList2.size()) {
                    break;
                }
                sb.append((String) arrayList2.get(i3));
                sb.append(",");
                i4++;
            }
            i = i3;
            String string = sb.toString();
            i2++;
            if (string.length() > 0) {
                String strSubstring = string.substring(0, string.length() - 1);
                Logger.printLog("Hosts for httpdns request is (%s) ", strSubstring);
                asyncSendRequest(strSubstring, RequestParamType.DNLIST_HOSTS, asyncHttpDnsCompletion);
            }
        }
    }
}
