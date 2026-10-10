package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.banner.b;

/* JADX INFO: loaded from: classes.dex */
public class TTC1Proxy {
    public static void load(Context context, AdSlot adSlot, TTAdNative.BannerAdListener bannerAdListener) {
        b.a(context).a(adSlot, bannerAdListener);
    }
}
