package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.72, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass72 implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ AnonymousClass77 A01;

    public AnonymousClass72(AnonymousClass77 anonymousClass77, AnonymousClass76 anonymousClass76) {
        this.A01 = anonymousClass77;
        new Handler(Looper.getMainLooper()).post(new WZ(this, anonymousClass77, anonymousClass76));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(AnonymousClass76 anonymousClass76) {
        PS psA05 = PS.A05(this.A01.A04);
        Uri uri = Uri.parse(anonymousClass76.A08);
        long jA0L = anonymousClass76.A00;
        if (jA0L == -1) {
            jA0L = C1693Iy.A0L(this.A01.A04);
        }
        psA05.A0F(uri, new C2025Wa(this), jA0L);
    }
}
