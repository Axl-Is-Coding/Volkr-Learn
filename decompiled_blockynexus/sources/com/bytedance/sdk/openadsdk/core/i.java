package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ab;

/* JADX INFO: compiled from: H5AdInteractionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.d.h f6232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b.a.a.a.a.a.b f6233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.nativeexpress.e f6234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.nativeexpress.d f6235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f6236f;
    private String g;

    public i(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, View view) {
        this.g = "rewarded_video";
        this.f6232b = hVar;
        this.f6231a = context;
        this.f6236f = view;
        this.g = ab.b(ab.c(hVar.M()));
        if (this.f6232b.x() == 4) {
            this.f6233c = b.a.a.a.a.a.c.a(this.f6231a, this.f6232b, this.g);
        }
        String str = this.g;
        this.f6234d = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, hVar, str, ab.a(str));
        this.f6234d.a(this.f6236f);
        this.f6234d.a(this.f6233c);
        String str2 = this.g;
        this.f6235e = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, hVar, str2, ab.a(str2));
        this.f6235e.a(this.f6236f);
        this.f6235e.a(this.f6233c);
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i == -1 || fVar == null) {
            return;
        }
        int i2 = fVar.f6088a;
        int i3 = fVar.f6089b;
        int i4 = fVar.f6090c;
        int i5 = fVar.f6091d;
        if (i != 1) {
            if (i == 2 && (dVar = this.f6235e) != null) {
                dVar.a(fVar);
                this.f6235e.a(this.f6236f, i2, i3, i4, i5);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f6234d;
        if (eVar != null) {
            eVar.a(fVar);
            this.f6234d.a(this.f6236f, i2, i3, i4, i5);
        }
    }
}
