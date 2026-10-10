package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8q, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14498q {
    public static byte[] A05;
    public C14508r A01;

    @Nullable
    public String A02;

    @Nullable
    public String A03;
    public int A00 = 0;
    public List<C14478o> A04 = new ArrayList();

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 109);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{79, 88};
    }

    public C14498q(C14508r c14508r, @Nullable String str, @Nullable String str2) {
        this.A01 = c14508r;
        this.A03 = str;
        this.A02 = str2;
    }

    public final int A02() {
        return this.A04.size();
    }

    public final long A03() {
        C14508r c14508r = this.A01;
        if (c14508r != null) {
            return c14508r.A0C() + ((long) this.A01.A03());
        }
        return -1L;
    }

    public final C14478o A04() {
        if (this.A00 < this.A04.size()) {
            this.A00++;
            return this.A04.get(this.A00 - 1);
        }
        return null;
    }

    public final C14508r A05() {
        return this.A01;
    }

    @Nullable
    public final String A06() {
        return this.A02;
    }

    @Nullable
    public final String A07() {
        int i = this.A00;
        if (i > 0 && i <= this.A04.size()) {
            return this.A04.get(this.A00 - 1).A06().optString(A00(0, 2, 65));
        }
        return null;
    }

    @Nullable
    public final String A08() {
        return this.A03;
    }

    public final void A09(C14478o c14478o) {
        this.A04.add(c14478o);
    }

    public final boolean A0A() {
        return this.A01 == null || LP.A00() > this.A01.A0C() + ((long) this.A01.A03());
    }
}
