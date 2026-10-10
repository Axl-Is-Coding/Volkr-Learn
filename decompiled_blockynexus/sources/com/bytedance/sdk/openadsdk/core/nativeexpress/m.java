package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;

/* JADX INFO: compiled from: TTNativeExpressDrawVideoAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends n {
    public m(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        super(context, hVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.n, com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.f6319d = "draw_ad";
        this.f6316a = new NativeExpressVideoView(context, hVar, adSlot, "draw_ad");
        a(this.f6316a, this.f6318c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        NativeExpressView nativeExpressView = this.f6316a;
        if (nativeExpressView != null) {
            ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
        }
    }
}
