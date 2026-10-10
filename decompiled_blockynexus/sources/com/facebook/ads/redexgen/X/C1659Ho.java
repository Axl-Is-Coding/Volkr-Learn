package com.facebook.ads.redexgen.X;

import android.os.ConditionVariable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ho, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1659Ho extends Thread {
    public final /* synthetic */ ConditionVariable A00;
    public final /* synthetic */ C2181av A01;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1659Ho(C2181av c2181av, String str, ConditionVariable conditionVariable) {
        super(str);
        this.A01 = c2181av;
        this.A00 = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            synchronized (this.A01) {
                try {
                    this.A00.open();
                    this.A01.A04();
                } finally {
                    th = th;
                    while (true) {
                        try {
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
