package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.drm.ExoMediaDrm;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"HandlerLeak"})
public class BZ extends Handler {
    public final /* synthetic */ C2070Xt A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BZ != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    public BZ(C2070Xt c2070Xt, Looper looper) {
        super(looper);
        this.A00 = c2070Xt;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BZ != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    private long A00(int i) {
        return Math.min((i - 1) * 1000, 5000);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BZ != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    private boolean A01(Message message) {
        int i;
        if (!(message.arg1 == 1) || (i = message.arg2 + 1) > this.A00.A0D) {
            return false;
        }
        Message messageObtain = Message.obtain(message);
        messageObtain.arg2 = i;
        sendMessageDelayed(messageObtain, A00(i));
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BZ != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    public final void A02(int i, Object obj, boolean z) {
        obtainMessage(i, z ? 1 : 0, 0, obj).sendToTarget();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BZ != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            Object obj = message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    e = this.A00.A0B.executeProvisionRequest(this.A00.A0C, (C0) obj);
                } else if (i == 1) {
                    Pair<ExoMediaDrm.KeyRequest, String> keyRequest = (Pair) obj;
                    e = this.A00.A0B.executeKeyRequest(this.A00.A0C, (InterfaceC1522Bw) keyRequest.first, (String) keyRequest.second);
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e2) {
                e = e2;
                if (A01(message)) {
                    return;
                }
            }
            this.A00.A0A.obtainMessage(message.what, Pair.create(obj, e)).sendToTarget();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
