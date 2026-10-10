package com.ut.mini.internal;

/* JADX INFO: loaded from: classes5.dex */
public class CustomDNS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IDnsResolver f21363a;

    public interface IDnsResolver {
        String[] resolveUrl(String str);
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final CustomDNS f21364a = new CustomDNS();
    }

    public static CustomDNS instance() {
        return a.f21364a;
    }

    public String[] resolveUrl(String str) {
        IDnsResolver iDnsResolver = this.f21363a;
        if (iDnsResolver != null) {
            return iDnsResolver.resolveUrl(str);
        }
        return null;
    }

    public void setDnsResolver(IDnsResolver iDnsResolver) {
        this.f21363a = iDnsResolver;
    }

    private CustomDNS() {
        this.f21363a = null;
    }
}
