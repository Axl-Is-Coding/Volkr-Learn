package com.google.common.base;

import com.umeng.analytics.pro.au;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Stopwatch.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f13767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13770d;

    t() {
        this.f13767a = x.b();
    }

    public static t a() {
        return new t();
    }

    private long d() {
        return this.f13768b ? (this.f13767a.a() - this.f13770d) + this.f13769c : this.f13769c;
    }

    public t b() {
        this.f13769c = 0L;
        this.f13768b = false;
        return this;
    }

    public t c() {
        m.b(!this.f13768b, "This stopwatch is already running.");
        this.f13768b = true;
        this.f13770d = this.f13767a.a();
        return this;
    }

    public String toString() {
        long jD = d();
        TimeUnit timeUnitA = a(jD);
        double d2 = jD;
        double dConvert = TimeUnit.NANOSECONDS.convert(1L, timeUnitA);
        Double.isNaN(d2);
        Double.isNaN(dConvert);
        return String.format(Locale.ROOT, "%.4g %s", Double.valueOf(d2 / dConvert), b(timeUnitA));
    }

    public static t a(x xVar) {
        t tVar = new t(xVar);
        tVar.c();
        return tVar;
    }

    t(x xVar) {
        m.a(xVar, "ticker");
        this.f13767a = xVar;
    }

    private static String b(TimeUnit timeUnit) {
        switch (s.f13766a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return au.ax;
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return au.au;
            default:
                throw new AssertionError();
        }
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(d(), TimeUnit.NANOSECONDS);
    }

    private static TimeUnit a(long j) {
        if (TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }
}
