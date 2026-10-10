package io.rong.push.core;

import android.content.Context;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import io.rong.common.utils.SSLUtils;
import io.rong.push.common.PushCacheHelper;
import io.rong.push.common.RLog;
import io.rong.push.pushconfig.PushNaviObserver;
import io.rong.push.rongpush.RongPushCacheHelper;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes5.dex */
public class PushNaviClient {
    private static final String TAG = "PushNaviClient";
    private boolean isPushProcess;
    private PushNaviObserver pushNaviObserver;
    private final String NAVI_SPLIT = ";";
    private final String IP_SPLIT = ",";
    private final String NAVI_PATH = "navipush.json";
    private Set<String> naviList = new LinkedHashSet();

    /* JADX WARN: Removed duplicated region for block: B:66:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean connect(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.push.core.PushNaviClient.connect(android.content.Context, java.lang.String, java.lang.String, boolean):boolean");
    }

    private void connectToNavi(Context context, String str) {
        ArrayList arrayList = new ArrayList(naviStrToList(PushCacheHelper.getInstance().getPushServerInfoInIMToken(context)));
        for (String str2 : this.naviList) {
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && !connect(context, (String) it.next(), str, !it.hasNext())) {
        }
    }

    private HttpURLConnection createConnection(String str) throws Exception {
        if (!str.toLowerCase().startsWith("https")) {
            return (HttpURLConnection) new URL(str).openConnection();
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        SSLContext sSLContext = SSLUtils.getSSLContext();
        if (sSLContext != null) {
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        }
        HostnameVerifier hostVerifier = SSLUtils.getHostVerifier();
        if (hostVerifier == null) {
            return httpsURLConnection;
        }
        httpsURLConnection.setHostnameVerifier(hostVerifier);
        return httpsURLConnection;
    }

    private String formatServerAddress(String str, String str2) {
        return String.format(str.toLowerCase().startsWith("http") ? "%s/%s" : (Build.VERSION.SDK_INT < 28 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) ? "http://%s/%s" : "https://%s/%s", str, str2);
    }

    private List<String> naviStrToList(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        String[] strArrSplit = str.split(";");
        ArrayList arrayList = new ArrayList();
        if (strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (!TextUtils.isEmpty(str2)) {
                    String serverAddress = formatServerAddress(str2, "navipush.json");
                    if (!arrayList.contains(serverAddress)) {
                        arrayList.add(serverAddress);
                    }
                }
            }
        }
        return arrayList;
    }

    public void getPushServerIPs(Context context, String str, boolean z, PushNaviObserver pushNaviObserver) {
        this.pushNaviObserver = pushNaviObserver;
        this.isPushProcess = z;
        if (z && RongPushCacheHelper.getInstance().isCacheValid(context, str)) {
            pushNaviObserver.onSuccess(RongPushCacheHelper.getInstance().getCachedAddressList(context));
        } else if (z || !PushCacheHelper.getInstance().isCacheValid(context, str)) {
            connectToNavi(context, str);
        } else {
            pushNaviObserver.onSuccess(PushCacheHelper.getInstance().getCachedAddressList(context));
        }
    }

    public void setPushNaviUrl(String str) {
        RLog.i(TAG, "setPushNaviUrl " + str);
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "navi address is empty! Use default navi address!");
            str = PushUtils.getDefaultNavi();
        }
        this.naviList.addAll(naviStrToList(str));
    }
}
