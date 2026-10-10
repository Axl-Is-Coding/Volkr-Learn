package io.rong.imlib.httpdns;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class RongHttpDnsResult {
    private String clientIp;
    private ArrayList<String> ipv4List;
    private ArrayList<String> ipv6List;
    private final ResolveStatus resolveStatus;
    private ResolveType resolveType;

    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss
    }

    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE
    }

    public RongHttpDnsResult(ResolveStatus resolveStatus) {
        this.resolveType = ResolveType.RESOLVE_NONE;
        this.resolveStatus = resolveStatus;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public ArrayList<String> getIpv4List() {
        return this.ipv4List;
    }

    public ArrayList<String> getIpv6List() {
        return this.ipv6List;
    }

    public ResolveStatus getResolveStatus() {
        return this.resolveStatus;
    }

    public ResolveType getResolveType() {
        return this.resolveType;
    }

    RongHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this(resolveType, resolveStatus, arrayList, arrayList2, "");
    }

    RongHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str) {
        this.resolveType = ResolveType.RESOLVE_NONE;
        this.resolveType = resolveType;
        this.resolveStatus = resolveStatus;
        this.ipv4List = arrayList;
        this.ipv6List = arrayList2;
        this.clientIp = str;
    }
}
