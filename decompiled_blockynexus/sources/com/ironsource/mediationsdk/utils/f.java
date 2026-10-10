package com.ironsource.mediationsdk.utils;

import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.Timer;

/* JADX INFO: compiled from: DailyCappingManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15028d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d f15030f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Timer f15029e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f15025a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Integer> f15026b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f15027c = new HashMap();
    private com.ironsource.mediationsdk.logger.c g = com.ironsource.mediationsdk.logger.c.c();

    public f(String str, d dVar) {
        this.f15028d = str;
        this.f15030f = dVar;
        d();
    }

    private int e(String str) {
        if (!a().equalsIgnoreCase(b(str))) {
            f(str);
        }
        return a(str);
    }

    private void f(String str) {
        this.f15026b.put(str, 0);
        this.f15027c.put(str, a());
        j.b(c.c().a(), c(str), 0);
        j.f(c.c().a(), d(str), a());
    }

    public void b(AbstractSmash abstractSmash) {
        synchronized (this) {
            try {
                String strE = e(abstractSmash);
                if (!this.f15025a.containsKey(strE)) {
                } else {
                    a(strE, e(strE) + 1);
                }
            } catch (Exception e2) {
                this.g.a(IronSourceLogger.IronSourceTag.INTERNAL, "increaseShowCounter", e2);
            }
        }
    }

    public boolean c(AbstractSmash abstractSmash) {
        synchronized (this) {
            try {
                try {
                    String strE = e(abstractSmash);
                    if (this.f15025a.containsKey(strE)) {
                        return this.f15025a.get(strE).intValue() <= e(strE);
                    }
                    return false;
                } catch (Exception e2) {
                    this.g.a(IronSourceLogger.IronSourceTag.INTERNAL, "isCapped", e2);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(AbstractSmash abstractSmash) {
        synchronized (this) {
            try {
                try {
                    String strE = e(abstractSmash);
                    if (!this.f15025a.containsKey(strE)) {
                        return false;
                    }
                    if (a().equalsIgnoreCase(b(strE))) {
                        return false;
                    }
                    return this.f15025a.get(strE).intValue() <= a(strE);
                } catch (Exception e2) {
                    this.g.a(IronSourceLogger.IronSourceTag.INTERNAL, "shouldSendCapReleasedEvent", e2);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(AbstractSmash abstractSmash) {
        synchronized (this) {
            try {
            } catch (Exception e2) {
                this.g.a(IronSourceLogger.IronSourceTag.INTERNAL, "addSmash", e2);
            }
            if (abstractSmash.s() != 99) {
                this.f15025a.put(e(abstractSmash), Integer.valueOf(abstractSmash.s()));
            }
        }
    }

    private String e(AbstractSmash abstractSmash) {
        return this.f15028d + "_" + abstractSmash.y() + "_" + abstractSmash.w();
    }

    private int a(String str) {
        if (this.f15026b.containsKey(str)) {
            return this.f15026b.get(str).intValue();
        }
        int iA = j.a(c.c().a(), c(str), 0);
        this.f15026b.put(str, Integer.valueOf(iA));
        return iA;
    }

    private Date b() {
        Random random = new Random();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"), Locale.US);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, random.nextInt(10));
        gregorianCalendar.set(13, random.nextInt(60));
        gregorianCalendar.set(14, random.nextInt(1000));
        gregorianCalendar.add(5, 1);
        return gregorianCalendar.getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this) {
            try {
                Iterator<String> it = this.f15025a.keySet().iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                this.f15030f.b();
                d();
            } catch (Exception e2) {
                this.g.a(IronSourceLogger.IronSourceTag.INTERNAL, "onTimerTick", e2);
            }
        }
    }

    private void a(String str, int i) {
        this.f15026b.put(str, Integer.valueOf(i));
        this.f15027c.put(str, a());
        j.b(c.c().a(), c(str), i);
        j.f(c.c().a(), d(str), a());
    }

    private void d() {
        Timer timer = this.f15029e;
        if (timer != null) {
            timer.cancel();
        }
        this.f15029e = new Timer();
        this.f15029e.schedule(new e(this), b());
    }

    private String a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    private String c(String str) {
        return str + "_counter";
    }

    private String b(String str) {
        if (this.f15027c.containsKey(str)) {
            return this.f15027c.get(str);
        }
        String strC = j.c(c.c().a(), d(str), a());
        this.f15027c.put(str, strC);
        return strC;
    }

    private String d(String str) {
        return str + "_day";
    }
}
