package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.h;

/* JADX INFO: compiled from: RewardBarClickListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends a {
    public e(Context context, h hVar, String str, int i) {
        super(context, hVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        a_(view, i, i2, i3, i4);
        super.a(view, i, i2, i3, i4);
    }

    protected abstract void a_(View view, int i, int i2, int i3, int i4);
}
