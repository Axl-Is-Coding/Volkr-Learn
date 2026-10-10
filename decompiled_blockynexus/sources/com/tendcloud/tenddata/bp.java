package com.tendcloud.tenddata;

import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f19877a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f19878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HandlerThread f19879c;

    static {
        try {
            f19879c = new HandlerThread("excHandlerThread", 10);
            f19879c.start();
            f19878b = new Handler(f19879c.getLooper());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(boolean z, String str, String str2) {
        if (z && !af.b(str2) && str2.contains(aa.h)) {
            return false;
        }
        return z || !str.contains("api/q/a");
    }

    public static void postSDKError(final Throwable th) {
        try {
            f19878b.post(new Runnable() { // from class: com.tendcloud.tenddata.bp.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String strC = af.c(th.getMessage());
                        if (bp.f19877a.contains(strC)) {
                            return;
                        }
                        bx bxVar = new bx();
                        bxVar.f19906b = ServerProtocol.DIALOG_PARAM_SDK_VERSION;
                        bxVar.f19907c = "error";
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("type", th.toString());
                        treeMap.put("msg", th.getMessage());
                        treeMap.put("stack", bp.a(th));
                        bxVar.f19908d = treeMap;
                        bxVar.f19905a = a.ENV;
                        ag.a().post(bxVar);
                        bp.f19877a.add(strC);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void a(final String str, final boolean z, final Map<String, Object> map) {
        try {
            f19878b.post(new Runnable() { // from class: com.tendcloud.tenddata.bp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (map == null || map.isEmpty() || !bp.b(z, String.valueOf(map.get("targetUrl")), str)) {
                            return;
                        }
                        m.dForInternal(map.toString() + " host: " + str);
                        bx bxVar = new bx();
                        bxVar.f19906b = ServerProtocol.DIALOG_PARAM_SDK_VERSION;
                        bxVar.f19907c = z ? "send_ok" : "send_fail";
                        bxVar.f19908d = map;
                        bxVar.f19905a = a.ENV;
                        ag.a().post(bxVar);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static final String a(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(th.toString());
        sb.append("\r\n");
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = 50;
            if (stackTrace.length <= 50) {
                length = stackTrace.length;
            }
            for (int i = 0; i < length; i++) {
                sb.append("\t");
                sb.append(stackTrace[i]);
                sb.append("\r\n");
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(sb, stackTrace, cause, 1);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static final void a(StringBuilder sb, StackTraceElement[] stackTraceElementArr, Throwable th, int i) {
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length - 1;
            for (int length2 = stackTraceElementArr.length - 1; length >= 0 && length2 >= 0 && stackTrace[length].equals(stackTraceElementArr[length2]); length2--) {
                length--;
            }
            int i2 = 50;
            if (length <= 50) {
                i2 = length;
            }
            sb.append("Caused by : ");
            sb.append(th);
            sb.append("\r\n");
            for (int i3 = 0; i3 <= i2; i3++) {
                sb.append("\t");
                sb.append(stackTrace[i3]);
                sb.append("\r\n");
            }
            if (i < 5 && th.getCause() != null) {
                a(sb, stackTrace, th, i + 1);
            }
        } catch (Throwable unused) {
        }
    }
}
