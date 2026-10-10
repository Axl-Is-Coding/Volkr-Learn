package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: IronSourceLoggerManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends IronSourceLogger implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f14865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<IronSourceLogger> f14866d;

    private c(String str) {
        super(str);
        this.f14866d = new ArrayList<>();
        d();
    }

    public static synchronized c b(int i) {
        if (f14865c == null) {
            f14865c = new c(c.class.getSimpleName());
        } else {
            f14865c.f14861a = i;
        }
        return f14865c;
    }

    public static synchronized c c() {
        if (f14865c == null) {
            f14865c = new c(c.class.getSimpleName());
        }
        return f14865c;
    }

    private void d() {
        this.f14866d.add(new a(0));
    }

    public void a(IronSourceLogger ironSourceLogger) {
        this.f14866d.add(ironSourceLogger);
    }

    @Override // com.ironsource.mediationsdk.logger.d
    public synchronized void a(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        b(ironSourceTag, str, i);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public synchronized void a(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th == null) {
            Iterator<IronSourceLogger> it = this.f14866d.iterator();
            while (it.hasNext()) {
                it.next().b(ironSourceTag, str, 3);
            }
        } else {
            Iterator<IronSourceLogger> it2 = this.f14866d.iterator();
            while (it2.hasNext()) {
                it2.next().a(ironSourceTag, str, th);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public synchronized void b(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        if (i < this.f14861a) {
            return;
        }
        for (IronSourceLogger ironSourceLogger : this.f14866d) {
            if (ironSourceLogger.a() <= i) {
                ironSourceLogger.b(ironSourceTag, str, i);
            }
        }
    }

    private IronSourceLogger a(String str) {
        for (IronSourceLogger ironSourceLogger : this.f14866d) {
            if (ironSourceLogger.b().equals(str)) {
                return ironSourceLogger;
            }
        }
        return null;
    }

    public void a(String str, int i) {
        if (str == null) {
            return;
        }
        IronSourceLogger ironSourceLoggerA = a(str);
        if (ironSourceLoggerA == null) {
            b(IronSourceLogger.IronSourceTag.NATIVE, "Failed to find logger:setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i + ")", 0);
            return;
        }
        if (i >= 0 && i <= 3) {
            b(IronSourceLogger.IronSourceTag.NATIVE, "setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i + ")", 0);
            ironSourceLoggerA.a(i);
            return;
        }
        this.f14866d.remove(ironSourceLoggerA);
    }
}
