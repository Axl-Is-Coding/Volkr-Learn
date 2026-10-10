package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12500l {
    public static byte[] A06;
    public static String[] A07;

    @Nullable
    public Application A01;

    @Nullable
    public C12490k A03;
    public final J5 A05;
    public long A00 = 0;

    @Nullable
    public String A04 = null;

    @Nullable
    public EnumC12420d A02 = null;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{44, 47, 45, 37, 17, 58, 39, 35, 43, 8, 1, 5, 18, 1, 59, ci.n, ci.k, 9, 1, 10, ci.n, 17, 6, 10, 8, 0};
    }

    public static void A04() {
        A07 = new String[]{"jY95Z4e8SjES", "FWAQk0vwFzOT3H3ejUps9E7fwyQUHgqv", "R9UUrzGy7cjs1hDg6byYlCYbXfp8nW0w", "dKAdSxu4tDkfYe86wdSSQ2n2Du5", "FgFVZj7d091u9rUO", "kSt0PMlvWs2DEAK3GKEU98UDJan6EgWc", "nGXCIrfUxBd8PJB10o2gs7oQf", "n"};
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.facebook.ads.redexgen.X.0k] */
    public C12500l(J5 j5, final Activity activity, int i) {
        this.A05 = j5;
        this.A01 = activity.getApplication();
        this.A03 = new Application.ActivityLifecycleCallbacks(activity, this) { // from class: com.facebook.ads.redexgen.X.0k

            @Nullable
            public C12500l A00;
            public final WeakReference<Activity> A01;

            {
                this.A01 = new WeakReference<>(activity);
                this.A00 = this;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityCreated(Activity activity2, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity2) {
                if (this.A00 == null) {
                    return;
                }
                Activity activity3 = this.A01.get();
                if (activity3 == null || activity2.equals(activity3)) {
                    this.A00.A06();
                    this.A00 = null;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStarted(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStopped(Activity activity2) {
            }
        };
    }

    public static C12500l A00(J5 j5, Activity activity) {
        return A01(j5, activity, Build.VERSION.SDK_INT);
    }

    @Nullable
    @VisibleForTesting
    public static C12500l A01(J5 j5, Activity activity, int i) {
        if (activity != null && i >= 14) {
            return new C12500l(j5, activity, i);
        }
        return null;
    }

    private void A05(String str, long j, long j2, @Nullable EnumC12420d enumC12420d) {
        HashMap map = new HashMap();
        map.put(A02(9, 10, 8), Long.toString(j));
        map.put(A02(0, 9, 34), Long.toString(j2));
        if (enumC12420d != null) {
            map.put(A02(19, 7, 9), enumC12420d.name());
        }
        this.A05.A8e(str, map);
    }

    @TargetApi(14)
    public final void A06() {
        C12490k c12490k;
        A05(this.A04, this.A00, System.currentTimeMillis(), this.A02);
        Application application = this.A01;
        if (application != null && (c12490k = this.A03) != null) {
            application.unregisterActivityLifecycleCallbacks(c12490k);
            this.A03 = null;
            this.A01 = null;
        }
    }

    public final void A07(@Nullable EnumC12420d enumC12420d) {
        this.A02 = enumC12420d;
    }

    @TargetApi(14)
    public final void A08(String str) {
        this.A04 = str;
        if (this.A03 != null && this.A01 != null) {
            this.A00 = System.currentTimeMillis();
            this.A01.registerActivityLifecycleCallbacks(this.A03);
            return;
        }
        EnumC12420d enumC12420d = EnumC12420d.A03;
        if (A07[2].charAt(6) == '9') {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[5] = "8mgXQ8lZ1oxTn8xtWXCDJO1aYxf7Xnbe";
        strArr[1] = "RSHxB9AoZRnm9g8NXStW2wWwzMRvBUbh";
        A05(str, -1L, -1L, enumC12420d);
    }
}
