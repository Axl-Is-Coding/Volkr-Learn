package io.rong.imlib.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import io.grpc.internal.GrpcUtil;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.common.fwlog.FwLog;
import io.rong.imlib.CMPStrategy;
import io.rong.imlib.HttpDnsManager;
import io.rong.imlib.common.NetUtils;
import io.rong.imlib.filetransfer.upload.FilePlatformInfo;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public class NavigationClient {
    private static final String NAVIGATION_2_HTTPS_URL = "https://nav2-cn.ronghub.com/navi.json";
    private static final String NAVIGATION_2_HTTP_URL = "http://nav2-cn.ronghub.com/navi.json";
    private static final String NAVIGATION_HTTPS_URL = "https://nav.cn.ronghub.com/navi.json";
    private static final String NAVIGATION_HTTP_IP_URL = "http://%s/navi.json";
    private static final String NAVIGATION_HTTP_URL = "http://nav.cn.ronghub.com/navi.json";
    private static final String NAVI_IN_TOKEN_SPLIT_SYMBOL = "@";
    private static final String NAVI_SPLIT_SYMBOL = ";";
    private static final String SEP1 = ";";
    private static final String TAG = "NavigationClient";
    private final String NAVI_SUFFIX;
    private Context context;
    private ExecutorService executor;
    private AtomicBoolean fetching;
    private String latestTokenNaviEncodeStr;
    private List<String> latestTokenNaviList;
    private String naviString;
    private NaviUpdateListener naviUpdateListener;
    private List<String> naviUrlList;
    private volatile NavigationObserver navigationObserver;

    public interface NaviUpdateListener {
        void onNaviUpdate();
    }

    private static class SingletonHolder {

        @SuppressLint({"StaticFieldLeak"})
        private static final NavigationClient sIns = new NavigationClient();

        private SingletonHolder() {
        }
    }

    private HttpURLConnection createConnection(String str, final String str2, String str3, String str4, String str5) throws IOException {
        HttpURLConnection httpURLConnectionCreateURLConnection = NetUtils.createURLConnection(str2);
        httpURLConnectionCreateURLConnection.setConnectTimeout(5000);
        httpURLConnectionCreateURLConnection.setReadTimeout(10000);
        httpURLConnectionCreateURLConnection.setUseCaches(false);
        httpURLConnectionCreateURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
        httpURLConnectionCreateURLConnection.setRequestProperty("Connection", "Close");
        httpURLConnectionCreateURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, LibStorageUtils.DIR);
        if (TextUtils.isEmpty(str)) {
            str = getNavHost(str2);
        }
        if (!TextUtils.isEmpty(str5)) {
            httpURLConnectionCreateURLConnection.setRequestProperty("clientIp", str5);
            NavigationCacheHelper.updateClientIp(this.context, str5);
        }
        if (!TextUtils.isEmpty(str)) {
            httpURLConnectionCreateURLConnection.setRequestProperty("Host", str);
            if (httpURLConnectionCreateURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnectionCreateURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: io.rong.imlib.navigation.NavigationClient.3
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str6, SSLSession sSLSession) {
                        return !TextUtils.isEmpty(str2) && str2.contains(str6);
                    }
                });
            }
        }
        String str6 = (("token=" + URLEncoder.encode(str4, "UTF-8")) + "&v=4.0.4.2") + "&p=Android";
        httpURLConnectionCreateURLConnection.setRequestProperty("Content-Length", String.valueOf(str6.length()));
        httpURLConnectionCreateURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        httpURLConnectionCreateURLConnection.setRequestProperty("appId", str3);
        httpURLConnectionCreateURLConnection.setDoOutput(true);
        httpURLConnectionCreateURLConnection.setDoInput(true);
        OutputStream outputStream = httpURLConnectionCreateURLConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        bufferedWriter.write(str6);
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();
        return httpURLConnectionCreateURLConnection;
    }

    public static NavigationClient getInstance() {
        return SingletonHolder.sIns;
    }

    private static String getNavHost(String str) {
        try {
            URL url = new URL(str);
            String host = url.getHost();
            int port = url.getPort();
            if (port == -1 || url.getDefaultPort() == url.getPort()) {
                return host;
            }
            return host + ":" + port;
        } catch (MalformedURLException e2) {
            RLog.e(TAG, "MalformedURLException ", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> getNaviFromToken(String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split(NAVI_IN_TOKEN_SPLIT_SYMBOL);
        if (strArrSplit.length > 1) {
            String str2 = strArrSplit[1];
            if (!TextUtils.isEmpty(str2)) {
                if (str2.equals(this.latestTokenNaviEncodeStr)) {
                    arrayList.addAll(this.latestTokenNaviList);
                } else {
                    arrayList.addAll(naviStrToList(str2, ";"));
                    this.latestTokenNaviList.clear();
                    this.latestTokenNaviList.addAll(arrayList);
                    this.latestTokenNaviEncodeStr = str2;
                }
            }
        }
        return arrayList;
    }

    private URL getUrlStr(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            RLog.e(TAG, "getUrlStr ", e2);
            return null;
        }
    }

    private String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && list.get(i) != "") {
                    sb.append(list.get(i));
                    sb.append(";");
                }
            }
        }
        return sb.toString();
    }

    private List<String> naviStrToList(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str3 : str.split(str2)) {
            if (!TextUtils.isEmpty(str3)) {
                String serverAddress = formatServerAddress(str3.trim(), "navi.json");
                if (!arrayList.contains(serverAddress)) {
                    arrayList.add(serverAddress);
                }
            }
        }
        return arrayList;
    }

    private void notifyNaviUpdate() {
        NaviUpdateListener naviUpdateListener = this.naviUpdateListener;
        if (naviUpdateListener != null) {
            naviUpdateListener.onNaviUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|(1:4)(1:5)|6|(11:148|7|8|(3:144|10|11)(2:16|17)|139|18|19|(2:142|21)(2:146|29)|30|125|31)|(12:32|33|(3:131|35|151)(1:150)|84|133|97|(1:101)|102|103|(2:135|105)|(1:110)|111)|39|40|141|41|(2:43|(6:(1:46)|47|137|48|(1:53)|54)(3:55|(1:57)|58))(3:59|(1:63)|64)|65|127|66|(1:71)|111|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0258, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0259, code lost:
    
        io.rong.common.RLog.e(io.rong.imlib.navigation.NavigationClient.TAG, "IOException ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0264, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0267, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x032f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0302 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02d2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean request(java.lang.String r25, java.lang.String r26, java.lang.String r27, boolean r28, boolean r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.navigation.NavigationClient.request(java.lang.String, java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    public void addObserver(NavigationObserver navigationObserver) {
        this.navigationObserver = navigationObserver;
    }

    public void clearCacheTime(Context context) {
        NavigationCacheHelper.updateTime(context, 0L);
    }

    public String formatServerAddress(String str, String str2) {
        return String.format(str.toLowerCase().startsWith("http") ? "%s/%s" : (Build.VERSION.SDK_INT < 28 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) ? "http://%s/%s" : "https://%s/%s", str, str2);
    }

    public void getCMPServerString(Context context, String str, String str2) {
        RLog.d(TAG, "[connect] getCMPServerString.");
        this.context = context.getApplicationContext();
        if (isNaviCacheValid(context, str, str2)) {
            RLog.d(TAG, "[connect] cache is valid.");
            this.navigationObserver.onSuccess(NavigationCacheHelper.getUserId(context));
            return;
        }
        String userId = NavigationCacheHelper.getUserId(context);
        if (!str2.equals(NavigationCacheHelper.getToken(context))) {
            NavigationCacheHelper.clearUserId(context);
            RLog.d(TAG, "[connect] clear userId.");
            userId = "";
        }
        if (CMPStrategy.getInstance().getCmpList().size() <= 0) {
            requestNavi(str, str2, true);
        } else {
            RLog.d(TAG, "[connect] cache cmp length > 0.");
            this.navigationObserver.onSuccess(userId);
        }
    }

    public int getGroupMessageLimit(Context context) {
        return NavigationCacheHelper.getGroupMessageLimit(context);
    }

    public String getMediaServer(Context context) {
        return NavigationCacheHelper.getMediaServer(context);
    }

    public List<FilePlatformInfo> getMediaServerConfigs(Context context) {
        return NavigationCacheHelper.getMediaServerCache(context);
    }

    public String getNaviString() {
        return this.naviString;
    }

    public String getTokenExceptNavi(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(NAVI_IN_TOKEN_SPLIT_SYMBOL)) ? str : str.substring(0, str.indexOf(NAVI_IN_TOKEN_SPLIT_SYMBOL) + 1);
    }

    public String getUploadLogConfigInfo(Context context) {
        return NavigationCacheHelper.getRealTimeLogConfig(context);
    }

    public String getUserId(Context context) {
        return NavigationCacheHelper.getUserId(context);
    }

    public String getVoIPCallInfo(Context context) {
        return NavigationCacheHelper.getVoIPCallInfo(context);
    }

    public boolean isChatroomHistoryEnabled(Context context) {
        return NavigationCacheHelper.isChatroomHistoryEnabled(context);
    }

    public boolean isFetching() {
        return this.fetching.get();
    }

    public boolean isGROpened(Context context) {
        return NavigationCacheHelper.isGetRemoteEnabled(context);
    }

    public boolean isGetRemoteHistoryEnabled(Context context) {
        return NavigationCacheHelper.isGetRemoteEnabled(context);
    }

    public boolean isMPOpened(Context context) {
        return NavigationCacheHelper.isMPOpened(context);
    }

    public boolean isNaviCacheValid(Context context, String str, String str2) {
        return NavigationCacheHelper.isCacheValid(context, str, str2, this.naviString);
    }

    public boolean isUSOpened(Context context) {
        return NavigationCacheHelper.isUSOpened(context);
    }

    public void requestCmpIfNeed(Context context, final String str, final String str2) {
        if (NavigationCacheHelper.isCacheTimeout(context)) {
            this.executor.submit(new Runnable() { // from class: io.rong.imlib.navigation.NavigationClient.2
                @Override // java.lang.Runnable
                public void run() {
                    NavigationClient.this.requestNavi(str, str2, true);
                }
            });
        }
    }

    public void requestNavi(final String str, final String str2, final boolean z) {
        this.executor.submit(new Runnable() { // from class: io.rong.imlib.navigation.NavigationClient.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ArrayList<String> arrayList = new ArrayList();
                    List naviFromToken = NavigationClient.this.getNaviFromToken(str2);
                    if (naviFromToken.size() > 0) {
                        arrayList.addAll(naviFromToken);
                    }
                    for (String str3 : NavigationClient.this.naviUrlList) {
                        if (!arrayList.contains(str3)) {
                            arrayList.add(str3);
                        }
                    }
                    if (arrayList.size() > 0) {
                        NavigationClient.this.fetching.set(true);
                        for (String str4 : arrayList) {
                            if (NavigationClient.this.request(str4, str, str2, z, arrayList.indexOf(str4) == arrayList.size() - 1)) {
                                break;
                            }
                        }
                        NavigationClient.this.fetching.set(false);
                    }
                } catch (Exception e2) {
                    FwLog.write(1, 1, FwLog.LogTag.L_CRASH_IPC_EPT_F.getTag(), "stacks", FwLog.stackToString(e2));
                    if (z) {
                        NavigationClient.this.navigationObserver.onError(NavigationCacheHelper.getUserId(NavigationClient.this.context), 30004);
                    }
                }
            }
        });
    }

    public void setNaviDomainList(String str) {
        this.naviString = str;
        List<String> list = this.naviUrlList;
        if (list == null) {
            return;
        }
        list.clear();
        if (str == null) {
            return;
        }
        this.naviUrlList.addAll(naviStrToList(str, ";"));
        HttpDnsManager.getInstance().shouldEnableHttpDns(this.naviUrlList);
    }

    public void setNaviUpdateListener(NaviUpdateListener naviUpdateListener) {
        this.naviUpdateListener = naviUpdateListener;
    }

    private NavigationClient() {
        this.NAVI_SUFFIX = "navi.json";
        this.naviUrlList = new ArrayList();
        this.naviUpdateListener = null;
        this.latestTokenNaviList = new ArrayList();
        this.fetching = new AtomicBoolean(false);
        this.executor = Executors.newSingleThreadExecutor();
        if (Build.VERSION.SDK_INT < 28 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
            this.naviUrlList.add(NAVIGATION_HTTP_URL);
            this.naviUrlList.add(NAVIGATION_2_HTTP_URL);
        } else {
            this.naviUrlList.add(NAVIGATION_HTTPS_URL);
            this.naviUrlList.add(NAVIGATION_2_HTTPS_URL);
        }
        this.naviString = listToString(this.naviUrlList);
    }
}
