package com.bytedance.sdk.openadsdk.core.video.c;

import android.content.Context;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;

/* JADX INFO: compiled from: PlayableEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Context context, h hVar) {
        d.g(context, hVar, "playable_preload", "preload_start", null);
    }

    public static void a(Context context, h hVar, long j, long j2) {
        HashMap map = new HashMap();
        map.put("loadzip_success_time", Long.valueOf(j));
        map.put("unzip_success_time", Long.valueOf(j2));
        d.g(context, hVar, "playable_preload", "preload_success", map);
    }

    public static void a(Context context, h hVar, int i, String str) {
        HashMap map = new HashMap();
        map.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, Integer.valueOf(i));
        map.put("error_reason", str);
        d.g(context, hVar, "playable_preload", "preload_fail", map);
    }
}
