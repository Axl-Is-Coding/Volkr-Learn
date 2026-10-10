package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2013Vo extends C6P {
    public final Context A00;

    public C2013Vo(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC14046n A03(HashMap<String, C2012Vn> map) {
        return new WS(SystemClock.elapsedRealtime(), A03(), map, EnumC14036m.A0C);
    }

    public final C6Y A0H(List<C6X> list, C6U c6u) {
        return new C2011Vm(this, list, c6u);
    }
}
