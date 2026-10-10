package com.bytedance.sdk.openadsdk.core.video.f;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.o;

/* JADX INFO: compiled from: VideoPreloadUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(com.bytedance.sdk.openadsdk.h.f.b bVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            new com.bytedance.sdk.openadsdk.core.video.a.b.a(o.a(), bVar.f6930a, bVar.f6932c, bVar.f6931b).b();
        } else {
            com.bytedance.sdk.openadsdk.h.f.a.a().a(bVar);
        }
    }
}
