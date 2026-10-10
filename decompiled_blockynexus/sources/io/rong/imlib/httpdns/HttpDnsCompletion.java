package io.rong.imlib.httpdns;

import android.content.Context;
import android.util.Log;
import io.rong.imlib.httpdns.HostCacheManager;
import io.rong.imlib.httpdns.HttpDnsClient;
import io.rong.imlib.httpdns.RongHttpDns;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class HttpDnsCompletion implements HttpDnsClient.AsyncHttpDnsCompletion {
    private static final String TAG = "HttpDnsCompletion";
    private final RongHttpDns.CachePolicy cachePolicy;
    private final RongHttpDns httpDns;
    private final HostCacheManager httpDnsCache;
    private final HttpDnsClient httpDnsClient;

    public HttpDnsCompletion(Context context) {
        this.httpDns = RongHttpDns.getService(context);
        this.httpDnsCache = this.httpDns.getHttpDnsCache();
        this.cachePolicy = this.httpDns.getCachePolicy();
        this.httpDnsClient = this.httpDns.getHttpDnsClient();
    }

    @Override // io.rong.imlib.httpdns.HttpDnsClient.AsyncHttpDnsCompletion
    public void callback(int i, HttpDnsClient.RequestParamType requestParamType, Map<String, HttpDnsClient.Result> map, String str) {
        if (i == -1) {
            if (requestParamType.equals(HttpDnsClient.RequestParamType.DNLIST_HOSTS) && this.cachePolicy == RongHttpDns.CachePolicy.POLICY_TOLERANT) {
                for (String str2 : str.split(",")) {
                    this.httpDnsCache.removeExpiredEntry(str2);
                }
            }
            onFailed(-1);
        } else if (i != 0) {
            onFailed(-1);
            Logger.printLog("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
        } else {
            for (Map.Entry<String, HttpDnsClient.Result> entry : map.entrySet()) {
                String key = entry.getKey();
                HttpDnsClient.Result value = entry.getValue();
                if (value != null) {
                    HostCacheManager.HostEntry hostEntry = new HostCacheManager.HostEntry();
                    hostEntry.setTtl(value.getTtl());
                    hostEntry.setQueryTime(System.currentTimeMillis() / 1000);
                    hostEntry.setIpv4List(value.getIpv4List());
                    hostEntry.setClientIp(value.getClientIp());
                    this.httpDnsCache.setHostCacheEntry(key, hostEntry);
                    onSuccess(value.getIpv4List());
                } else {
                    if (this.cachePolicy == RongHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.httpDnsCache.removeExpiredEntry(key);
                    }
                    onFailed(-1);
                }
            }
        }
        if (this.httpDns.getPreResolveNum() <= 0 || this.httpDnsClient.getPreResolveFinish()) {
            return;
        }
        this.httpDnsClient.setPreResolveFinish(true);
        Logger.printLog("preResolve has finished", new Object[0]);
    }

    protected void onFailed(int i) {
        Log.i(TAG, "onFailed()");
    }

    protected void onSuccess(ArrayList<String> arrayList) {
        Log.i(TAG, "onSuccess()");
    }
}
