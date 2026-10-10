package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.b.a.g;
import com.ta.utdid2.b.a.i;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: DeviceInfo.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f19373a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Object f19374e = new Object();
    static String k = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";

    static long a(a aVar) {
        if (aVar == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", aVar.f(), aVar.getDeviceId(), Long.valueOf(aVar.a()), aVar.e(), aVar.d());
        if (i.m95a(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    public static synchronized a b(Context context) {
        if (f19373a != null) {
            return f19373a;
        }
        if (context == null) {
            return null;
        }
        a aVarA = a(context);
        f19373a = aVarA;
        return aVarA;
    }

    private static a a(Context context) {
        if (context == null) {
            return null;
        }
        new a();
        synchronized (f19374e) {
            String value = c.a(context).getValue();
            if (i.m95a(value)) {
                return null;
            }
            if (value.endsWith(UMCustomLogInfoBuilder.LINE_SEP)) {
                value = value.substring(0, value.length() - 1);
            }
            a aVar = new a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA = g.a(context);
            String strB = g.b(context);
            aVar.d(strA);
            aVar.b(strA);
            aVar.b(jCurrentTimeMillis);
            aVar.c(strB);
            aVar.e(value);
            aVar.a(a(aVar));
            return aVar;
        }
    }
}
