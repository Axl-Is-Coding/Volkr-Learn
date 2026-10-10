package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfg {
    private static final char[] zzaaf = "0123456789abcdef".toCharArray();

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String zza(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zzehy.zza(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzar(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID uuidFromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
        byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
        return zzcv.zza(bArr, true);
    }

    public static boolean zzas(String str) {
        return str == null || str.isEmpty();
    }

    public static Activity zzd(View view) {
        View rootView = view.getRootView();
        if (rootView != null) {
            view = rootView;
        }
        Context context = view.getContext();
        for (int i = 0; (context instanceof ContextWrapper) && i < 10; i++) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static boolean zza(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == WheelView.DividerConfig.FILL) ? false : true;
    }

    public static long zza(double d2, DisplayMetrics displayMetrics) {
        double d3 = displayMetrics.density;
        Double.isNaN(d3);
        return Math.round(d2 / d3);
    }
}
