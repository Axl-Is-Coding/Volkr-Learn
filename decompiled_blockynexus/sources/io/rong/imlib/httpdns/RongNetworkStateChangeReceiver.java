package io.rong.imlib.httpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.rong.common.rlog.RLog;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class RongNetworkStateChangeReceiver extends BroadcastReceiver {
    private static final long ALLOW_CLEAR_CACHE_TIMEOUT = 600000;
    private static final String TAG = "RongNetworkStateChangeReceiver";
    private long clearCacheStartTime;
    private boolean isFirstNotify = false;
    private boolean clearCache = true;
    private boolean httpDnsPrefetch = true;
    private String beforeNetInfo = "";
    private boolean isIPv6Reachable = true;
    private boolean isIPv4Reachable = true;

    class RefreshIpReachableTask implements Callable<Object> {
        RefreshIpReachableTask() {
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object call() throws java.lang.Throwable {
            /*
                r5 = this;
                java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
                java.lang.String r1 = "2001:4860:4860::8888"
                r2 = 443(0x1bb, float:6.21E-43)
                r0.<init>(r1, r2)
                java.net.InetSocketAddress r1 = new java.net.InetSocketAddress
                java.lang.String r2 = "180.76.76.76"
                r3 = 80
                r1.<init>(r2, r3)
                r2 = 0
                r3 = 0
                java.net.DatagramSocket r4 = new java.net.DatagramSocket     // Catch: java.lang.Throwable -> L20 java.net.SocketException -> L23
                r4.<init>()     // Catch: java.lang.Throwable -> L20 java.net.SocketException -> L23
                r4.connect(r1)     // Catch: java.net.SocketException -> L24 java.lang.Throwable -> L71
            L1c:
                r4.close()
                goto L2c
            L20:
                r0 = move-exception
                r4 = r2
                goto L72
            L23:
                r4 = r2
            L24:
                io.rong.imlib.httpdns.RongNetworkStateChangeReceiver r1 = io.rong.imlib.httpdns.RongNetworkStateChangeReceiver.this     // Catch: java.lang.Throwable -> L71
                io.rong.imlib.httpdns.RongNetworkStateChangeReceiver.access$002(r1, r3)     // Catch: java.lang.Throwable -> L71
                if (r4 == 0) goto L2c
                goto L1c
            L2c:
                java.net.DatagramSocket r1 = new java.net.DatagramSocket     // Catch: java.lang.Throwable -> L3d java.net.SocketException -> L3f
                r1.<init>()     // Catch: java.lang.Throwable -> L3d java.net.SocketException -> L3f
                r1.connect(r0)     // Catch: java.lang.Throwable -> L38 java.net.SocketException -> L3b
                r1.close()
                goto L49
            L38:
                r0 = move-exception
                r4 = r1
                goto L6b
            L3b:
                r4 = r1
                goto L3f
            L3d:
                r0 = move-exception
                goto L6b
            L3f:
                io.rong.imlib.httpdns.RongNetworkStateChangeReceiver r0 = io.rong.imlib.httpdns.RongNetworkStateChangeReceiver.this     // Catch: java.lang.Throwable -> L3d
                io.rong.imlib.httpdns.RongNetworkStateChangeReceiver.access$102(r0, r3)     // Catch: java.lang.Throwable -> L3d
                if (r4 == 0) goto L49
                r4.close()
            L49:
                r0 = 2
                java.lang.Object[] r0 = new java.lang.Object[r0]
                io.rong.imlib.httpdns.RongNetworkStateChangeReceiver r1 = io.rong.imlib.httpdns.RongNetworkStateChangeReceiver.this
                boolean r1 = io.rong.imlib.httpdns.RongNetworkStateChangeReceiver.access$000(r1)
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                r0[r3] = r1
                r1 = 1
                io.rong.imlib.httpdns.RongNetworkStateChangeReceiver r3 = io.rong.imlib.httpdns.RongNetworkStateChangeReceiver.this
                boolean r3 = io.rong.imlib.httpdns.RongNetworkStateChangeReceiver.access$100(r3)
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                r0[r1] = r3
                java.lang.String r1 = "isIPv4Reachable(%s), isIPv6Reachable(%s)"
                io.rong.imlib.httpdns.Logger.printLog(r1, r0)
                return r2
            L6b:
                if (r4 == 0) goto L70
                r4.close()
            L70:
                throw r0
            L71:
                r0 = move-exception
            L72:
                if (r4 == 0) goto L77
                r4.close()
            L77:
                goto L79
            L78:
                throw r0
            L79:
                goto L78
            */
            throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.httpdns.RongNetworkStateChangeReceiver.RefreshIpReachableTask.call():java.lang.Object");
        }
    }

    private boolean allowClearCache(long j) {
        return j - this.clearCacheStartTime > ALLOW_CLEAR_CACHE_TIMEOUT;
    }

    private void processCacheOnNetworkChange(Context context) {
        Logger.printLog("Network change, clearCache(%b) httpDnsPrefetch(%b)", Boolean.valueOf(this.clearCache), Boolean.valueOf(this.httpDnsPrefetch));
        HttpDnsClient httpDnsClient = HttpDnsClient.getInstance();
        RongHttpDns service = RongHttpDns.getService(context);
        refreshIpReachable();
        ArrayList<String> allHosts = service.getHttpDnsCache().getAllHosts();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.clearCache && allowClearCache(jCurrentTimeMillis)) {
            this.clearCacheStartTime = System.currentTimeMillis();
            service.getHttpDnsCache().clearHostCacheMemory();
        }
        if (this.httpDnsPrefetch) {
            if (isIPv6Only()) {
                Logger.printLog("Now the network is Ipv6 Only, Will not send prefetch request. ", new Object[0]);
            } else {
                if (allHosts == null || allHosts.isEmpty()) {
                    return;
                }
                httpDnsClient.splitHostsAndSendRequest(allHosts, new HttpDnsCompletion(context));
            }
        }
    }

    public boolean isIPv6Only() {
        return !this.isIPv4Reachable && this.isIPv6Reachable;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager;
        String str = "";
        if (!this.isFirstNotify) {
            this.isFirstNotify = true;
            return;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (RuntimeException e2) {
            e = e2;
        }
        if (connectivityManager == null) {
            processCacheOnNetworkChange(context);
            return;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        String extraInfo = (networkInfo == null || networkInfo.getExtraInfo() == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) ? (networkInfo2 == null || networkInfo2.getExtraInfo() == null || networkInfo2.getState() != NetworkInfo.State.CONNECTED) ? "" : networkInfo2.getExtraInfo() : networkInfo.getExtraInfo();
        try {
            if (!this.beforeNetInfo.equals(extraInfo) && !extraInfo.equals("")) {
                Logger.printLog("Current net type: %s.", extraInfo);
                processCacheOnNetworkChange(context);
            }
            str = extraInfo;
        } catch (RuntimeException e3) {
            String str2 = extraInfo;
            e = e3;
            str = str2;
            RLog.e(TAG, "onReceive RuntimeException", e);
            try {
                processCacheOnNetworkChange(context);
            } catch (Exception e4) {
                RLog.e(TAG, "processCacheOnNetworkChange Exception", e4);
            }
        }
        this.beforeNetInfo = str;
    }

    public void refreshIpReachable() {
        Executors.newFixedThreadPool(1).submit(new RefreshIpReachableTask());
    }

    void setClearCache(boolean z) {
        this.clearCache = z;
    }

    void setHttpDnsPrefetch(boolean z) {
        this.httpDnsPrefetch = z;
    }
}
