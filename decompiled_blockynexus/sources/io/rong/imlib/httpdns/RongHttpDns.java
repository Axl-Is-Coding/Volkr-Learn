package io.rong.imlib.httpdns;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import io.rong.imlib.httpdns.HostCacheManager;
import io.rong.imlib.httpdns.HttpDnsClient;
import io.rong.imlib.httpdns.RongHttpDnsResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class RongHttpDns {
    private static final int ACCOUNT_ID_MAX_LEN = 64;
    private static final int SECRET_MAX_LEN = 64;
    private static final int SECRET_MIN_LEN = 8;
    private static volatile RongHttpDns httpDns;
    private final Context context;
    private long lastReqTimeForExpiredHosts;
    private RongNetworkStateChangeReceiver networkStateChangeReceiver;
    private int preResolveNum;
    private long preResolveStartTime;
    private String[] hostWhiteList = {"nav.cn.ronghub.com", "rtc-info.ronghub.com"};
    private final HttpDnsClient httpDnsClient = HttpDnsClient.getInstance();
    private final HostCacheManager httpDnsCache = new HostCacheManager("HTTPDNS", false);
    private CachePolicy cachePolicy = CachePolicy.POLICY_TOLERANT;

    public enum CachePolicy {
        POLICY_AGGRESSIVE,
        POLICY_TOLERANT,
        POLICY_STRICT
    }

    public interface CompletionHandler {
        void completionHandler(RongHttpDnsResult rongHttpDnsResult);
    }

    private RongHttpDns(Context context) {
        this.context = context;
        registerNetworkChangeReceiver();
        this.networkStateChangeReceiver.refreshIpReachable();
        this.lastReqTimeForExpiredHosts = System.currentTimeMillis();
    }

    private boolean allowSendRequest(long j) {
        return this.httpDnsClient.getPreResolveFinish() || (j - this.preResolveStartTime > 1000 && !this.networkStateChangeReceiver.isIPv6Only());
    }

    private boolean filterHostRequest(String str) {
        return (TextUtils.isEmpty(str) || Arrays.asList(this.hostWhiteList).contains(str)) ? false : true;
    }

    public static RongHttpDns getService(Context context) {
        if (httpDns == null) {
            synchronized (RongHttpDns.class) {
                if (httpDns == null) {
                    httpDns = new RongHttpDns(context);
                }
            }
        }
        return httpDns;
    }

    private void registerNetworkChangeReceiver() {
        this.networkStateChangeReceiver = new RongNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.context.registerReceiver(this.networkStateChangeReceiver, intentFilter);
    }

    public void asyncResolve(String str, final CompletionHandler completionHandler, HttpDnsCompletion httpDnsCompletion) {
        if (RongHttpDnsUtil.validateIpv4(str)) {
            final ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            ThreadPool.getInstance().getExecutor().execute(new Runnable() { // from class: io.rong.imlib.httpdns.RongHttpDns.1
                @Override // java.lang.Runnable
                public void run() {
                    completionHandler.completionHandler(new RongHttpDnsResult(RongHttpDnsResult.ResolveType.RESOLVE_NONEED, RongHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, null));
                }
            });
            return;
        }
        if (RongHttpDnsUtil.validateIpv6(str)) {
            final ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            ThreadPool.getInstance().getExecutor().execute(new Runnable() { // from class: io.rong.imlib.httpdns.RongHttpDns.2
                @Override // java.lang.Runnable
                public void run() {
                    completionHandler.completionHandler(new RongHttpDnsResult(RongHttpDnsResult.ResolveType.RESOLVE_NONEED, RongHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, arrayList2));
                }
            });
            return;
        }
        final HostCacheManager.HostEntry hostCacheEntry = this.httpDnsCache.getHostCacheEntry(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<String> arrayList3 = new ArrayList<>();
        if (allowSendRequest(jCurrentTimeMillis)) {
            if (hostCacheEntry == null || hostCacheEntry.isExpired()) {
                arrayList3.add(str);
            }
            if (httpDnsCompletion == null) {
                httpDnsCompletion = new HttpDnsCompletion(this.context);
            }
            this.httpDnsClient.splitHostsAndSendRequest(arrayList3, httpDnsCompletion);
        } else {
            Logger.printLog("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
        }
        if (hostCacheEntry == null) {
            Logger.printLog("Async resolve failed, host(%s), find no httpdns cache entry ", str);
            ThreadPool.getInstance().getExecutor().execute(new Runnable() { // from class: io.rong.imlib.httpdns.RongHttpDns.4
                @Override // java.lang.Runnable
                public void run() {
                    completionHandler.completionHandler(new RongHttpDnsResult(RongHttpDnsResult.ResolveType.RESOLVE_NONE, RongHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null));
                }
            });
        } else {
            final RongHttpDnsResult.ResolveType resolveType = hostCacheEntry.isExpired() ? RongHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : RongHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
            Logger.printLog("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, hostCacheEntry.getIpv4List().toString(), resolveType.toString());
            ThreadPool.getInstance().getExecutor().execute(new Runnable() { // from class: io.rong.imlib.httpdns.RongHttpDns.3
                @Override // java.lang.Runnable
                public void run() {
                    completionHandler.completionHandler(new RongHttpDnsResult(resolveType, RongHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, hostCacheEntry.getIpv4List(), null));
                }
            });
        }
    }

    CachePolicy getCachePolicy() {
        return this.cachePolicy;
    }

    HostCacheManager getHttpDnsCache() {
        return this.httpDnsCache;
    }

    HttpDnsClient getHttpDnsClient() {
        return this.httpDnsClient;
    }

    RongNetworkStateChangeReceiver getNetworkStateChangeReceiver() {
        return this.networkStateChangeReceiver;
    }

    int getPreResolveNum() {
        return this.preResolveNum;
    }

    public void setAccountID(String str) {
        if (str.length() <= 64) {
            this.httpDnsClient.setAccountID(str);
            return;
        }
        throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
    }

    public void setCachePolicy(CachePolicy cachePolicy) {
        this.cachePolicy = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.httpDnsCache.setStrictCachePolicy(true);
        } else {
            this.httpDnsCache.setStrictCachePolicy(false);
        }
        Logger.printLog("Set cache policy to %s", cachePolicy.name());
    }

    public void setHttpsRequestEnable(boolean z) {
        this.httpDnsClient.setHttps(z);
        Logger.printLog("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void setLogEnable(boolean z) {
        Logger.setLogEnable(z);
        Logger.printLog("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void setNetworkSwitchPolicy(boolean z, boolean z2) {
        this.networkStateChangeReceiver.setClearCache(z);
        this.networkStateChangeReceiver.setHttpDnsPrefetch(z2);
        Logger.printLog("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void setPreResolveHosts(ArrayList<String> arrayList, HttpDnsCompletion httpDnsCompletion) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (filterHostRequest(it.next())) {
                it.remove();
            }
        }
        if (arrayList.size() <= 0) {
            Logger.printLog("Set pre resolve hosts error, get empty hosts", new Object[0]);
            return;
        }
        ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
        int maxHostNum = this.httpDnsClient.getMaxHostNum();
        if (arrayList2.size() > maxHostNum) {
            Logger.printLog("The current number of hosts is %d, and the max supported size is %s.Please reduce it to %s or less.", Integer.valueOf(arrayList2.size()), Integer.valueOf(maxHostNum), Integer.valueOf(maxHostNum));
            return;
        }
        this.preResolveNum++;
        if (this.preResolveNum > 1) {
            Logger.printLog("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
        }
        this.preResolveStartTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList2.size(); i++) {
            sb.append((String) arrayList2.get(i));
            sb.append(",");
        }
        if (sb.length() > 0) {
            String strSubstring = sb.substring(0, sb.length() - 1);
            Logger.printLog("Set pre resolve hosts: %s", strSubstring);
            if (httpDnsCompletion == null) {
                httpDnsCompletion = new HttpDnsCompletion(this.context);
            }
            this.httpDnsClient.asyncSendRequest(strSubstring, HttpDnsClient.RequestParamType.DNLIST_HOSTS, httpDnsCompletion);
        }
    }

    public void setPreResolveTag(String str) {
        if (str == null || str.isEmpty()) {
            Logger.printLog("Set pre resolve hosts error, get empty tag", new Object[0]);
            return;
        }
        this.preResolveNum++;
        if (this.preResolveNum > 1) {
            Logger.printLog("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
        }
        Logger.printLog(" Set preResolve tag : %s", str);
        HttpDnsCompletion httpDnsCompletion = new HttpDnsCompletion(this.context);
        this.preResolveStartTime = System.currentTimeMillis();
        this.httpDnsClient.asyncSendRequest(str, HttpDnsClient.RequestParamType.TAG_OF_HOSTS, httpDnsCompletion);
    }

    public void setSecret(String str) {
        int length = str.length();
        if (length <= 64 && length >= 8) {
            this.httpDnsClient.setSecret(str);
            return;
        }
        throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
    }

    public void setServerIp(String str) {
        this.httpDnsClient.setDefaultServerIp(str);
    }

    public RongHttpDnsResult syncResolve(String str) {
        if (RongHttpDnsUtil.validateIpv4(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            return new RongHttpDnsResult(RongHttpDnsResult.ResolveType.RESOLVE_NONEED, RongHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, null);
        }
        if (RongHttpDnsUtil.validateIpv6(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            return new RongHttpDnsResult(RongHttpDnsResult.ResolveType.RESOLVE_NONEED, RongHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, arrayList2);
        }
        RongHttpDnsResult.ResolveType resolveType = RongHttpDnsResult.ResolveType.RESOLVE_NONE;
        HostCacheManager.HostEntry hostCacheEntry = this.httpDnsCache.getHostCacheEntry(str);
        if (hostCacheEntry == null) {
            Logger.printLog("Sync resolve failed, host(%s), find no httpdns cache entry", str);
            return new RongHttpDnsResult(resolveType, RongHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
        }
        RongHttpDnsResult.ResolveType resolveType2 = hostCacheEntry.isExpired() ? RongHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : RongHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
        Logger.printLog("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, hostCacheEntry.getIpv4List().toString(), resolveType2.toString());
        return new RongHttpDnsResult(resolveType2, RongHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, hostCacheEntry.getIpv4List(), hostCacheEntry.getIpv6List(), hostCacheEntry.getClientIp());
    }
}
