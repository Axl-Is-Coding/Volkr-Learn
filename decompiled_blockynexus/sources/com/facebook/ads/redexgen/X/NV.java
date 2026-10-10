package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class NV implements DialogInterface.OnClickListener {
    public final /* synthetic */ NX A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ Map A02;

    public NV(NX nx, String str, Map map) {
        this.A00 = nx;
        this.A01 = str;
        this.A02 = map;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.A00.A04.A8c(this.A01, this.A02);
    }
}
