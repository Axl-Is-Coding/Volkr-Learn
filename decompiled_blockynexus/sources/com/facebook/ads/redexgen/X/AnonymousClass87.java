package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.87, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass87 extends ContextWrapper {
    public final AnonymousClass89 A00;
    public final AtomicReference<String> A01;

    public AnonymousClass87(Context context, AnonymousClass89 anonymousClass89) {
        super(context.getApplicationContext());
        this.A01 = new AtomicReference<>();
        this.A00 = anonymousClass89;
    }

    public final C2027Wc A00() {
        C2027Wc c2027WcA00 = AnonymousClass86.A00();
        if (c2027WcA00 == null) {
            C2027Wc c2027Wc = new C2027Wc(this, this.A00);
            AnonymousClass86.A01(c2027Wc);
            return c2027Wc;
        }
        return c2027WcA00;
    }

    public final AnonymousClass88 A01() {
        return this.A00.A5c(this);
    }

    public final C8A A02() {
        return this.A00.A6F(this);
    }

    public final C8B A03() {
        return this.A00.A6y(this);
    }

    public final C8X A04() {
        return this.A00.A66(this);
    }

    public final C14558x A05() {
        return this.A00.A74();
    }

    public final J5 A06() {
        return this.A00.A5O(A00());
    }

    @Nullable
    public final String A07() {
        return this.A01.get();
    }

    public final void A08(@Nullable String str) {
        this.A01.set(str);
    }
}
