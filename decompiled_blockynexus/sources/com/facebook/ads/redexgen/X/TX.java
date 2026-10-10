package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class TX implements C6Y {
    public final /* synthetic */ C1953Tg A00;

    public TX(C1953Tg c1953Tg) {
        this.A00 = c1953Tg;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 16) {
            return this.A00.A08(EnumC14006j.A05);
        }
        if (this.A00.A02 != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            this.A00.A02.getMemoryInfo(memoryInfo);
            return this.A00.A07(memoryInfo.totalMem / 1048576);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
