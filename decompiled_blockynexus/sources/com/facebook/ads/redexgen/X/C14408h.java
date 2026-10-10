package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14408h {
    public static Sensor A00;
    public static Sensor A01;
    public static SensorEventListener A02;
    public static SensorEventListener A03;
    public static SensorManager A04;
    public static Map<String, String> A05;
    public static byte[] A06;
    public static String[] A07;
    public static final AtomicReference<String> A08;
    public static volatile float[] A09;
    public static volatile float[] A0A;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{-97, -12, -16, -14, -14, -12, -5, -12, 1, -2, -4, -12, 3, -12, 1, -18, -67, -65, -48, -59, -46, -59, -48, -43, 41, 54, 44, 58, 55, 49, 44, -10, 49, 54, 60, 45, 54, 60, -10, 41, 43, 60, 49, 55, 54, -10, 10, 9, 28, 28, ci.k, 26, 33, 39, 11, ci.n, 9, 22, ci.m, ci.k, 12, 23, 44, 23, 31, 34, 23, 24, 34, 27, 21, 35, 27, 35, 37, 40, 47, 33, 32, 51, 51, 36, 49, 56, -4, 1, -6, 11, 0, 2, 7, 0, 35, 47, 34, 34, 28, 48, 45, 30, 32, 34, -18, -20, -11, -20, -7, -16, -22, 19, 12, 29, 12, 19, -60, -63, -58, -77, -58, -69, -63, -64, -79, -60, -76, -78, -67, -74, 4, -10, -1, 4, 0, 3, 8, 9, -10, 9, 10, 8, 45, 40, 45, 26, 37, 24, 38, 30, 38, 40, 43, 50, ci.n, 17, -49};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A08(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String strValueOf = String.valueOf(((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()));
        A08.set(strValueOf);
        A05.put(A01(92, 10, 111), strValueOf);
    }

    static {
        A03();
        A04 = null;
        A00 = null;
        A01 = null;
        A05 = new ConcurrentHashMap();
        A07 = new String[]{A01(152, 1, 74), A01(153, 1, 74), A01(154, 1, 7)};
        A08 = new AtomicReference<>();
    }

    @Nullable
    public static String A00() {
        return A08.get();
    }

    public static Map<String, String> A02() {
        Map<String, String> currentAnalogInfo = new HashMap<>();
        currentAnalogInfo.putAll(A05);
        A0C(currentAnalogInfo);
        return currentAnalogInfo;
    }

    public static synchronized void A06() {
        if (A04 != null) {
            A04.unregisterListener(A02);
        }
        A02 = null;
    }

    public static synchronized void A07() {
        if (A04 != null) {
            A04.unregisterListener(A03);
        }
        A03 = null;
    }

    public static void A09(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(A01(16, 8, 14))).getMemoryInfo(memoryInfo);
        A05.put(A01(61, 16, 104), String.valueOf(memoryInfo.availMem));
        if (Build.VERSION.SDK_INT >= 16) {
            A05.put(A01(140, 12, 107), String.valueOf(memoryInfo.totalMem));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.ads.redexgen.X.87] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.facebook.ads.redexgen.X.87] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.content.Intent] */
    public static void A0A(AnonymousClass87 anonymousClass87) {
        try {
            anonymousClass87 = anonymousClass87.registerReceiver(null, new IntentFilter(A01(24, 37, 122)));
            if (anonymousClass87 == 0) {
                return;
            }
            int status = anonymousClass87.getIntExtra(A01(109, 5, 89), -1);
            int level = anonymousClass87.getIntExtra(A01(123, 5, 3), -1);
            int intExtra = anonymousClass87.getIntExtra(A01(134, 6, 71), -1);
            boolean z = intExtra == 2 || intExtra == 5;
            float f2 = WheelView.DividerConfig.FILL;
            if (level > 0) {
                float batteryLevel = level;
                f2 = (status / batteryLevel) * 100.0f;
            }
            A05.put(A01(77, 7, 113), String.valueOf(f2));
            A05.put(A01(84, 8, 75), z ? A01(1, 1, 117) : A01(0, 1, 33));
        } catch (IllegalArgumentException e2) {
            anonymousClass87.A04().A8H(A01(102, 7, 57), C8Y.A1B, new C8Z(e2));
        }
    }

    public static synchronized void A0B(AnonymousClass87 anonymousClass87) {
        A09(anonymousClass87);
        A0A(anonymousClass87);
        if (A04 == null) {
            A04 = (SensorManager) anonymousClass87.getSystemService(A01(128, 6, 67));
            if (A04 == null) {
                return;
            }
        }
        if (A00 == null) {
            A00 = A04.getDefaultSensor(1);
        }
        if (A01 == null) {
            A01 = A04.getDefaultSensor(4);
        }
        C14378e c14378e = null;
        if (A02 == null) {
            A02 = new C14388f();
            if (A00 != null) {
                A04.registerListener(A02, A00, 3);
            }
        }
        if (A03 == null) {
            A03 = new C14398g();
            if (A01 != null) {
                A04.registerListener(A03, A01, 3);
            }
        }
    }

    public static void A0C(Map<String, String> map) {
        float[] currentGyroscopeValues = A09;
        float[] fArr = A0A;
        if (currentGyroscopeValues != null) {
            int iMin = Math.min(A07.length, currentGyroscopeValues.length);
            for (int i = 0; i < iMin; i++) {
                map.put(A01(2, 14, 65) + A07[i], String.valueOf(currentGyroscopeValues[i]));
            }
        }
        if (fArr != null) {
            int iMin2 = Math.min(A07.length, fArr.length);
            for (int i2 = 0; i2 < iMin2; i2++) {
                map.put(A01(114, 9, 4) + A07[i2], String.valueOf(fArr[i2]));
            }
        }
    }
}
