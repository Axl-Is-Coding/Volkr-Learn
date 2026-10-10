package com.facebook.ads.redexgen.X;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13484i {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 3);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{ci.k, 72, 85, 89, 39, 107, 108, 123, 108, 106, 123, 108, 107, 65, -43, -31, -33, -96, -40, -45, -43, -41, -44, -31, -31, -35, -96, -45, -42, -27};
    }

    @Nullable
    private String A00() {
        for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
            if (stackTraceElement.getClassName().startsWith(A01(14, 16, 111))) {
                return stackTraceElement.toString();
            }
        }
        return null;
    }

    private Map<Thread, StackTraceElement[]> A02() {
        final Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new Comparator<Thread>() { // from class: com.facebook.ads.redexgen.X.4h
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final int compare(Thread thread2, Thread thread3) {
                if (thread2 == thread3) {
                    return 0;
                }
                Thread thread4 = thread;
                if (thread2 == thread4) {
                    return -1;
                }
                if (thread3 == thread4) {
                    return 1;
                }
                return thread3.getName().compareTo(thread2.getName());
            }
        });
        Map<Thread, StackTraceElement[]> stackTraces = Thread.getAllStackTraces();
        treeMap.putAll(stackTraces);
        return treeMap;
    }

    public final String A04() {
        StringBuilder sb = new StringBuilder();
        sb.append(A01(1, 13, 4));
        sb.append(A00());
        String strA01 = A01(0, 1, 0);
        sb.append(strA01);
        for (Map.Entry<Thread, StackTraceElement[]> entry : A02().entrySet()) {
            Thread thread = entry.getKey();
            sb.append(thread.getName());
            sb.append(strA01);
            for (StackTraceElement element : entry.getValue()) {
                sb.append('\t');
                sb.append(element.toString());
                sb.append(strA01);
            }
        }
        return sb.toString();
    }

    public final boolean A05() {
        return A00() != null;
    }
}
