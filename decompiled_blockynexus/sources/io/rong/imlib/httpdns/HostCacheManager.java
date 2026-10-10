package io.rong.imlib.httpdns;

import android.util.LruCache;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
class HostCacheManager {
    private final String dnsPrefix;
    private final LruCache<String, HostEntry> hostCache = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);
    private boolean strictCachePolicy;

    static class HostEntry {
        private String clientIp;
        private ArrayList<String> ipv4List;
        private ArrayList<String> ipv6List;
        private long queryTime;
        private long ttl;

        HostEntry() {
        }

        public String getClientIp() {
            return this.clientIp;
        }

        ArrayList<String> getIpv4List() {
            return this.ipv4List;
        }

        ArrayList<String> getIpv6List() {
            return this.ipv6List;
        }

        long getQueryTime() {
            return this.queryTime;
        }

        long getTtl() {
            return this.ttl;
        }

        public boolean isExpired() {
            return getQueryTime() + this.ttl < System.currentTimeMillis() / 1000;
        }

        public void setClientIp(String str) {
            this.clientIp = str;
        }

        void setIpv4List(ArrayList<String> arrayList) {
            this.ipv4List = arrayList;
        }

        void setIpv6List(ArrayList<String> arrayList) {
            this.ipv6List = arrayList;
        }

        void setQueryTime(long j) {
            this.queryTime = j;
        }

        void setTtl(long j) {
            this.ttl = j;
        }
    }

    HostCacheManager(String str, boolean z) {
        this.dnsPrefix = str;
        this.strictCachePolicy = z;
    }

    void clearHostCacheMemory() {
        this.hostCache.evictAll();
        Logger.printLog("Clear %s cache", this.dnsPrefix);
    }

    ArrayList<String> getAllHosts() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(this.hostCache.snapshot().keySet());
        return arrayList;
    }

    HostEntry getHostCacheEntry(String str) {
        HostEntry hostEntry = this.hostCache.get(str);
        if (hostEntry == null || !hostEntry.isExpired() || !this.strictCachePolicy) {
            return hostEntry;
        }
        this.hostCache.remove(str);
        Logger.printLog("Remove expired entry from %s cache while reading, host(%s)", this.dnsPrefix, str);
        return null;
    }

    boolean isStrictCachePolicy() {
        return this.strictCachePolicy;
    }

    void removeExpiredEntry(String str) {
        HostEntry hostCacheEntry = getHostCacheEntry(str);
        if (hostCacheEntry == null || !hostCacheEntry.isExpired()) {
            return;
        }
        this.hostCache.remove(str);
        Logger.printLog("Remove expired entry from %s cache, host(%s)", this.dnsPrefix, str);
    }

    void setHostCacheEntry(String str, HostEntry hostEntry) {
        ArrayList<String> ipv4List = hostEntry.getIpv4List();
        ArrayList<String> ipv6List = hostEntry.getIpv6List();
        if ((ipv4List == null || ipv4List.isEmpty()) && (ipv6List == null || ipv6List.isEmpty())) {
            return;
        }
        this.hostCache.put(str, hostEntry);
        Object[] objArr = new Object[5];
        objArr[0] = this.dnsPrefix;
        objArr[1] = str;
        objArr[2] = ipv4List != null ? ipv4List.toString() : null;
        objArr[3] = ipv6List != null ? ipv6List.toString() : null;
        objArr[4] = Long.valueOf(hostEntry.getTtl());
        Logger.printLog("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    void setStrictCachePolicy(boolean z) {
        this.strictCachePolicy = z;
    }
}
