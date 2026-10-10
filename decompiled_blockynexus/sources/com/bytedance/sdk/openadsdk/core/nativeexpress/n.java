package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: compiled from: TTNativeExpressVideoAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends k {
    public n(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        super(context, hVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.f6316a = new NativeExpressVideoView(context, hVar, adSlot, "embeded_ad");
        a(this.f6316a, this.f6318c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        NativeExpressView nativeExpressView = this.f6316a;
        if (nativeExpressView != null) {
            return ((NativeExpressVideoView) nativeExpressView).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        NativeExpressView nativeExpressView = this.f6316a;
        if (nativeExpressView != null) {
            nativeExpressView.setVideoAdListener(expressVideoAdListener);
        }
    }
}
