package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VK extends C6P {
    public VK(Context context, C13815p c13815p) {
        super(context, c13815p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC14046n A02(HashMap<String, VJ> map) {
        return new WS(SystemClock.elapsedRealtime(), A03(), map, EnumC14036m.A0C);
    }

    public final C6Y A0H() {
        return new VI(this);
    }
}
