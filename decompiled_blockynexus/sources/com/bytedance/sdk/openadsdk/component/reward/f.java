package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.Map;

/* JADX INFO: compiled from: RewardVideoController.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends com.bytedance.sdk.openadsdk.core.video.d.a {
    public f(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        super(context, viewGroup, hVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected int a() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void a(int i, int i2) {
        if (this.f6447b == null) {
            return;
        }
        boolean z = z();
        String str = z ? "play_error" : "play_start_error";
        Map<String, Object> mapA = ab.a(this.f6447b, i, i2, t());
        mapA.put("play_type", Integer.valueOf(ab.a(this, this.g)));
        if (z) {
            mapA.put("duration", Long.valueOf(o()));
            mapA.put("percent", Integer.valueOf(q()));
            mapA.put("buffers_time", Long.valueOf(n()));
        }
        com.bytedance.sdk.openadsdk.c.d.c(this.f6446a.get(), this.f6447b, "rewarded_video", str, mapA);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void b() {
        Map<String, Object> mapB = B();
        mapB.put("play_type", Integer.valueOf(ab.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f6446a.get(), this.f6447b, "rewarded_video", "feed_over", this.f6448c, 100, mapB);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void c() {
        Map<String, Object> mapB = B();
        mapB.put("play_type", Integer.valueOf(ab.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f6446a.get(), this.f6447b, "rewarded_video", "play_pause", o(), q(), mapB);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void d() {
        Map<String, Object> mapB = B();
        mapB.put("play_type", Integer.valueOf(ab.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f6446a.get(), this.f6447b, "rewarded_video", "continue_play", this.h, q(), mapB);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void e() {
        Map<String, Object> mapA = A();
        mapA.put("play_type", Integer.valueOf(ab.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.b(this.f6446a.get(), this.f6447b, "rewarded_video", "feed_play", mapA);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void f() {
        Map<String, Object> mapA = A();
        mapA.put("play_type", Integer.valueOf(ab.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.b(this.f6446a.get(), this.f6447b, "rewarded_video", "feed_play", mapA);
    }
}
