package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Al, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1495Al {
    public static final C1495Al A04 = new C1494Ak().A00();
    public AudioAttributes A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public C1495Al(int i, int i2, int i3) {
        this.A01 = i;
        this.A02 = i2;
        this.A03 = i3;
    }

    @TargetApi(21)
    public final AudioAttributes A00() {
        if (this.A00 == null) {
            this.A00 = new AudioAttributes.Builder().setContentType(this.A01).setFlags(this.A02).setUsage(this.A03).build();
        }
        return this.A00;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1495Al c1495Al = (C1495Al) obj;
        return this.A01 == c1495Al.A01 && this.A02 == c1495Al.A02 && this.A03 == c1495Al.A03;
    }

    public final int hashCode() {
        int i = ((17 * 31) + this.A01) * 31;
        int result = this.A02;
        return ((i + result) * 31) + this.A03;
    }
}
