package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1728Kk implements Application.ActivityLifecycleCallbacks {
    public static Context A00;
    public static C2027Wc A01;
    public static byte[] A02;
    public static String[] A03;
    public static final List<InterfaceC1727Kj> A04;
    public static final List<Runnable> A05;
    public static final Map<Activity, Integer> A06;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[4].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[4] = "4AKSMNDzmxTAf23dNNcZP8";
            strArr2[7] = "cH1";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 12);
            i4++;
        }
    }

    public static void A02() {
        A02 = new byte[]{54, 58, 91, 121, 110, 115, 108, 115, 110, 99, 32, 58, 92, 80, 2, 21, 22, 74, 80, 115, 81, 70, 91, 68, 91, 70, 75, 18, 86, 91, 65, 81, 64, 87, 66, 83, 92, 81, 91, 87, 65, 28, 55, 6, 6, 53, 25, 24, 2, 19, ci.l, 2, 86, 31, 5, 86, 24, 25, 2, 86, 55, 6, 6, 26, 31, 21, 23, 2, 31, 25, 24, 88, 40, 4, 5, 8, 30, 25, 25, ci.l, 5, 31, 75, 6, 4, ci.m, 2, ci.k, 2, 8, 10, 31, 2, 4, 5, 75, ci.l, 19, 8, ci.l, 27, 31, 2, 4, 5, 75, 31, 3, 25, 4, 28, 5, ci.m, 30, 25, 2, 5, 12, 75, 25, ci.l, 12, 2, 24, 31, ci.l, 25, 42, 8, 31, 2, 29, 2, 31, 18, 40, 10, 7, 7, 9, 10, 8, 0, 24, 39, 2, 24, 31, ci.l, 5, ci.l, 25, 10, 41, 33, 101, 36, 38, 49, 44, 51, 44, 49, 60, 101, 54, 49, 36, 49, 32, 127, 101, 115, 66, 86, 80, 70, 71, 3, 66, 64, 87, 74, 85, 74, 87, 90, 3, 74, 80, 3, 77, 76, 87, 3, 81, 70, 80, 86, 78, 70, 71, ci.k, 74, 125, 107, 34, 56, 31, 29, 10, 33, 11, 10, 23, 18, 4, 21, 12};
    }

    public static void A03() {
        A03 = new String[]{"ouMPsLdF8VOzsynXqmRiTnVq9sCULlEK", "RDluICFSUJyOT3sC2lXOFgStPQc7gg7Y", "UmtUlnThENixw5hdz8sG1KFdsGmJDk97", "fTn296Ch3TXxkAVBDyGQxp9TrJ", "IUqXVRs0X8uhoFuXuWrDHC", "AqSoSQ8lTXl56yd6tw1FPxb5AEpw6", "5ylHfIThOZnGyEtaFkstDkkPbeVs18fd", "i0x"};
    }

    static {
        A03();
        A02();
        A06 = Collections.synchronizedMap(new WeakHashMap());
        A04 = Collections.synchronizedList(new ArrayList());
        A05 = new ArrayList();
    }

    @Nullable
    public static synchronized Activity A00() {
        Activity lastResumedActivity = null;
        Iterator<Map.Entry<Activity, Integer>> it = A06.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Activity, Integer> next = it.next();
            if (next.getValue().intValue() == 3) {
                Activity lastResumedActivity2 = next.getKey();
                lastResumedActivity = lastResumedActivity2;
                break;
            }
        }
        Activity activityA00 = null;
        boolean z = lastResumedActivity == null || Build.VERSION.SDK_INT < 28;
        if (z) {
            activityA00 = C1724Kg.A00();
        }
        if (A01 != null && z && lastResumedActivity != activityA00) {
            C8Z c8z = new C8Z(A01(19, 23, 62), A01(203, 5, 20) + lastResumedActivity + A01(12, 7, 124) + activityA00);
            c8z.A03(1);
            A01.A04().A8H(A01(208, 8, 114), C8Y.A01, c8z);
        }
        return lastResumedActivity != null ? lastResumedActivity : activityA00;
    }

    public static void A04(@NonNull C2026Wb c2026Wb) {
        if (!C1693Iy.A13(c2026Wb) || Build.VERSION.SDK_INT >= 29) {
            return;
        }
        RunnableC1726Ki runnableC1726Ki = new RunnableC1726Ki(c2026Wb);
        synchronized (A05) {
            A05.add(runnableC1726Ki);
        }
        LS.A01.A01().postDelayed(runnableC1726Ki, 2000L);
    }

    public static synchronized void A05(C2027Wc c2027Wc) {
        A01 = c2027Wc;
        A00 = c2027Wc.getApplicationContext();
        if (A00 instanceof Application) {
            ANActivityLifecycleCallbacksListener aNActivityLifecycleCallbacksListener = ANActivityLifecycleCallbacksListener.getANActivityLifecycleCallbacksListener();
            if (aNActivityLifecycleCallbacksListener != null) {
                Map<Activity, Integer> activityStateMap = aNActivityLifecycleCallbacksListener.getActivityStateMap();
                synchronized (activityStateMap) {
                    try {
                        Map<Activity, Integer> activityStateMap2 = A06;
                        activityStateMap2.putAll(activityStateMap);
                    } catch (ConcurrentModificationException unused) {
                        c2027Wc.A04().A8H(A01(208, 8, 114), C8Y.A00, new C8Z(A01(72, 80, 103)));
                    }
                }
                ANActivityLifecycleCallbacksListener.unregisterActivityCallbacks(c2027Wc);
            }
            ((Application) A00).registerActivityLifecycleCallbacks(new C1728Kk());
        } else {
            c2027Wc.A04().A8H(A01(216, 3, 105), C8Y.A0S, new C8Z(A01(42, 30, 122)));
        }
    }

    public static void A06(InterfaceC1727Kj interfaceC1727Kj) {
        A04.add(interfaceC1727Kj);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        A06.put(activity, 1);
        Iterator<InterfaceC1727Kj> it = A04.iterator();
        while (it.hasNext()) {
            it.next().onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        A06.put(activity, 6);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        ArrayList arrayList;
        Integer num = A06.get(activity);
        if (num == null || num.intValue() != 3) {
            C8Z c8z = new C8Z(A01(172, 31, 47), A01(152, 20, 73) + num + A01(0, 12, 22) + activity);
            c8z.A03(0);
            A01.A04().A8H(A01(208, 8, 114), C8Y.A01, c8z);
        }
        A06.put(activity, 4);
        if (activity.getClass() != AudienceNetworkActivity.class) {
            synchronized (A05) {
                arrayList = new ArrayList(A05);
                A05.clear();
            }
            Iterator it = arrayList.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                if (A03[0].charAt(23) == 's') {
                    throw new RuntimeException();
                }
                String[] strArr = A03;
                strArr[4] = "UBshke7O6W3uGW5erxsbv0";
                strArr[7] = "uKB";
                if (zHasNext) {
                    LS.A01.A01().removeCallbacks((Runnable) it.next());
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        A06.put(activity, 3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        A06.put(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        A06.put(activity, 5);
    }
}
