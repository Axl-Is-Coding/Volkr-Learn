package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1650Hf implements Comparable<C1650Hf> {
    public final long A00;
    public final long A01;
    public final long A02;

    @Nullable
    public final File A03;
    public final String A04;
    public final boolean A05;

    public C1650Hf(String str, long j, long j2, long j3, @Nullable File file) {
        this.A04 = str;
        this.A02 = j;
        this.A01 = j2;
        this.A05 = file != null;
        this.A03 = file;
        this.A00 = j3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(@NonNull C1650Hf c1650Hf) {
        if (!this.A04.equals(c1650Hf.A04)) {
            return this.A04.compareTo(c1650Hf.A04);
        }
        long j = this.A02 - c1650Hf.A02;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public final boolean A01() {
        return !this.A05;
    }

    public final boolean A02() {
        return this.A01 == -1;
    }
}
