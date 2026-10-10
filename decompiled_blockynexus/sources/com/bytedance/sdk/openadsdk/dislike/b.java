package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.r;

/* JADX INFO: compiled from: TTAdDislikeImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements TTAdDislike {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f6706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f6707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TTAdDislike.DislikeInteractionCallback f6708d;

    public b(Context context, h hVar) {
        r.a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.f6705a = context;
        this.f6706b = hVar;
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f6708d = dislikeInteractionCallback;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        Context context = this.f6705a;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            this.f6707c.show();
        }
    }

    private void a() {
        this.f6707c = new c(this.f6705a, this.f6706b);
        this.f6707c.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.dislike.b.1
            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a() {
                o.b("TTAdDislikeImpl", "onDislikeShow: ");
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void b() {
                o.e("TTAdDislikeImpl", "onDislikeDismiss: ");
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void c() {
                o.e("TTAdDislikeImpl", "onDislikeOptionBack: ");
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions() && b.this.f6708d != null) {
                        b.this.f6708d.onSelected(i, filterWord.getName());
                    }
                    o.e("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + String.valueOf(filterWord.getName()));
                } catch (Throwable th) {
                    o.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
    }

    public void a(h hVar) {
        this.f6707c.a(hVar);
    }
}
