package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.64, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass64 extends Handler {
    public final /* synthetic */ AnonymousClass65 A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnonymousClass64(AnonymousClass65 anonymousClass65, Looper looper) {
        super(looper);
        this.A00 = anonymousClass65;
    }

    @Override // android.os.Handler
    @SuppressLint({"CatchGeneralException"})
    public final void handleMessage(Message message) throws Throwable {
        MotionEvent motionEvent;
        if (KL.A02(this)) {
            return;
        }
        try {
            if (AnonymousClass62.A00[AnonymousClass63.values()[message.what].ordinal()] == 1 && (motionEvent = (MotionEvent) message.obj) != null) {
                this.A00.A02.A01(motionEvent);
            }
        } catch (Throwable th) {
            try {
                AnonymousClass61.A04(th);
            } catch (Throwable th2) {
                KL.A00(th2, this);
            }
        }
    }
}
