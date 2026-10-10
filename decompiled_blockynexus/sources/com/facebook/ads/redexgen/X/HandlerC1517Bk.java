package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"HandlerLeak"})
public class HandlerC1517Bk extends Handler {
    public final /* synthetic */ C2073Xw A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bk != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T>$MediaDrmHandler */
    public HandlerC1517Bk(C2073Xw c2073Xw, Looper looper) {
        super(looper);
        this.A00 = c2073Xw;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bk != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T>$MediaDrmHandler */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T> */
    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            byte[] bArr = (byte[]) message.obj;
            for (C2070Xt c2070Xt : this.A00.A09) {
                if (c2070Xt.A0O(bArr)) {
                    c2070Xt.A0K(message.what);
                    return;
                }
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
