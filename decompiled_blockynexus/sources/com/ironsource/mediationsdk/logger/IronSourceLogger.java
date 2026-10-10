package com.ironsource.mediationsdk.logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IronSourceLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f14861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14862b;

    public enum IronSourceTag {
        API,
        ADAPTER_API,
        CALLBACK,
        ADAPTER_CALLBACK,
        NETWORK,
        INTERNAL,
        NATIVE,
        EVENT
    }

    IronSourceLogger(String str) {
        this.f14862b = str;
        this.f14861a = 0;
    }

    int a() {
        return this.f14861a;
    }

    public abstract void a(IronSourceTag ironSourceTag, String str, Throwable th);

    String b() {
        return this.f14862b;
    }

    public abstract void b(IronSourceTag ironSourceTag, String str, int i);

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IronSourceLogger)) {
            return false;
        }
        IronSourceLogger ironSourceLogger = (IronSourceLogger) obj;
        String str = this.f14862b;
        return str != null && str.equals(ironSourceLogger.f14862b);
    }

    public void a(int i) {
        this.f14861a = i;
    }

    IronSourceLogger(String str, int i) {
        this.f14862b = str;
        this.f14861a = i;
    }
}
