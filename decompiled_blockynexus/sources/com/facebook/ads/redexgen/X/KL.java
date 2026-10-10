package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KL {
    public static final Set<Object> A00 = Collections.newSetFromMap(new WeakHashMap());
    public static final AtomicBoolean A01 = new AtomicBoolean(true);
    public static final AtomicReference<KJ> A02 = new AtomicReference<>();

    @SuppressLint({"RethrownThrowableArgument"})
    public static void A00(Throwable th, Object obj) throws Throwable {
        if (A01.get()) {
            A00.add(obj);
            C1719Ka.A00().A87(3306, th);
            KJ kj = A02.get();
            if (kj != null) {
                kj.ACk(th, obj);
                return;
            }
            return;
        }
        throw th;
    }

    public static void A01(boolean z, KJ kj) {
        A01.set(z);
        A02.set(kj);
    }

    public static boolean A02(Object obj) {
        return A00.contains(obj);
    }
}
