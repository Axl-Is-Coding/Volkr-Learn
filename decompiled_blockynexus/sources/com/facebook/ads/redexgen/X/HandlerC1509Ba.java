package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ba, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"HandlerLeak"})
public class HandlerC1509Ba extends Handler {
    public final /* synthetic */ C2070Xt A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ba != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostResponseHandler */
    public HandlerC1509Ba(C2070Xt c2070Xt, Looper looper) {
        super(looper);
        this.A00 = c2070Xt;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ba != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostResponseHandler */
    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                this.A00.A0B(obj, obj2);
                return;
            }
            this.A00.A0C(obj, obj2);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
