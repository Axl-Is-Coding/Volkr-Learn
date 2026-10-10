package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6L, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C6L {
    public static String[] A02;
    public final Context A00;
    public final C13815p A01;

    static {
        A01();
    }

    public static void A01() {
        A02 = new String[]{"HSkcF60AiAyYJizD2I8vIjqhfibhLk4F", "vdkNajAjw36u5RvY9xFki59AuKhwr3og", "", "sseZ8EdYk7i", "1PxOfa9BsFlCUZKt15VhEMgvVyvUPrjN", "QpqokUuVk7nKJb7TmK", "vU9iDbhGXBQk4voVJMEMlbxkWIFvNann", "KoP5O6PQnxDmDbSqeBv0xhaZ"};
    }

    public C6L(Context context, C13815p c13815p) {
        this.A00 = context;
        this.A01 = c13815p;
    }

    private int A00(C13815p c13815p, C6V c6v) {
        if (c13815p.A0e(c6v.A00()) != null) {
            return c13815p.A0e(c6v.A00()).intValue();
        }
        if (c6v.A03().contains(EnumC13936c.A0B)) {
            return c13815p.A0S();
        }
        if (c6v.A03().contains(EnumC13936c.A08)) {
            return c13815p.A0R();
        }
        return c13815p.A0V();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.5u != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    @SuppressLint({"CatchGeneralException"})
    public final synchronized void A02(C6Z c6z, List<C6V> list) {
        AbstractC14046n abstractC14046nA04;
        AbstractC14046n abstractC14046nA03;
        Map<Integer, C13865u<AbstractC14046n>> mapA03 = C13916a.A01().A03();
        for (C6V c6v : list) {
            C6Y signalExecutor = c6v.A02(c6z);
            if (signalExecutor != null) {
                try {
                    abstractC14046nA04 = signalExecutor.A58();
                } catch (Throwable th) {
                    abstractC14046nA04 = C14136w.A04(this.A00.getPackageName(), th);
                }
                if (abstractC14046nA04 != null && abstractC14046nA04.A08() != null) {
                    if (c6v.A03().contains(EnumC13936c.A0B) && mapA03.containsKey(Integer.valueOf(c6v.A00()))) {
                        C13865u<AbstractC14046n> c13865u = mapA03.get(Integer.valueOf(c6v.A00()));
                        if (c13865u != null) {
                            abstractC14046nA03 = c13865u.A03();
                        } else {
                            abstractC14046nA03 = null;
                        }
                        if (c13865u == null) {
                            c13865u = new C13865u<>(A00(this.A01, c6v));
                        }
                        if (abstractC14046nA03 == null || !abstractC14046nA04.A0C(abstractC14046nA03, c6v.A03())) {
                            c13865u.A05(abstractC14046nA04);
                            C13916a.A01().A04(c6v.A00(), c13865u, abstractC14046nA04.A06());
                        }
                    } else {
                        C13865u<AbstractC14046n> c13865u2 = new C13865u<>(A00(this.A01, c6v));
                        c13865u2.A05(abstractC14046nA04);
                        C13916a.A01().A04(c6v.A00(), c13865u2, abstractC14046nA04.A06());
                    }
                }
            }
        }
        String[] strArr = A02;
        if (strArr[0].charAt(9) == strArr[1].charAt(9)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[5] = "mCdjiAVU6tB7YULC7P";
        strArr2[2] = "";
    }
}
