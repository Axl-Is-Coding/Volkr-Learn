package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ab, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1485Ab {
    public static String[] A06;
    public C1486Ac A01;
    public C1486Ac A02;
    public boolean A03;
    public final ArrayList<C1486Ac> A05 = new ArrayList<>();
    public final AX A04 = new AX();
    public AZ A00 = AZ.A01;

    static {
        A03();
    }

    public static void A03() {
        A06 = new String[]{"KiEP2P9b6TLdkEYwaN5ndNVtk9NQ5Y9p", "yrQkoPMIPCp0FUw5bDslSTdDJuyK", "OV0qCkDU4pR0s48LAW0LoXOWDo4ZunO9", "CNzCLbPvty9jTQMUswZxpqZWQtb7JEv9", "Vf", "ol3MR5ayifXszMqJK7WjfrE4Lr8bJhi8", "Hh8EscwfVF04VFT3j4sJSJqD2SmetI3K", "DN3PdRai96zSFxDytd4qNigxYecPuw8S"};
    }

    private C1486Ac A00(C1486Ac c1486Ac, AZ az) {
        int iA05;
        if (az.A0F() || this.A00.A0F() || (iA05 = az.A05(this.A00.A0B(c1486Ac.A01.A02, this.A04, true).A03)) == -1) {
            return c1486Ac;
        }
        return new C1486Ac(az.A0A(iA05, this.A04).A00, c1486Ac.A01.A01(iA05));
    }

    private void A02() {
        if (!this.A05.isEmpty()) {
            this.A01 = this.A05.get(0);
        }
    }

    @Nullable
    public final C1486Ac A04() {
        return this.A01;
    }

    @Nullable
    public final C1486Ac A05() {
        if (this.A05.isEmpty()) {
            return null;
        }
        return this.A05.get(r1.size() - 1);
    }

    @Nullable
    public final C1486Ac A06() {
        if (this.A05.isEmpty() || this.A00.A0F() || this.A03) {
            return null;
        }
        return this.A05.get(0);
    }

    @Nullable
    public final C1486Ac A07() {
        return this.A02;
    }

    @Nullable
    public final F6 A08(int timelinePeriodCount) {
        F6 f6 = null;
        AZ az = this.A00;
        if (az != null) {
            int periodIndex = az.A01();
            for (int i = 0; i < this.A05.size(); i++) {
                C1486Ac c1486Ac = this.A05.get(i);
                int i2 = c1486Ac.A01.A02;
                if (i2 < periodIndex && this.A00.A0A(i2, this.A04).A00 == timelinePeriodCount) {
                    if (f6 != null) {
                        return null;
                    }
                    f6 = c1486Ac.A01;
                }
            }
        }
        return f6;
    }

    public final void A09() {
        this.A03 = false;
        A02();
    }

    public final void A0A() {
        this.A03 = true;
    }

    public final void A0B(int i) {
        A02();
    }

    public final void A0C(int i, F6 f6) {
        this.A05.add(new C1486Ac(i, f6));
        if (this.A05.size() == 1) {
            boolean zA0F = this.A00.A0F();
            if (A06[0].charAt(21) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[0] = "SFS5Xb2c2LrmqtbhPrHYALinOi1MehvJ";
            strArr[0] = "SFS5Xb2c2LrmqtbhPrHYALinOi1MehvJ";
            if (!zA0F) {
                A02();
            }
        }
    }

    public final void A0D(int i, F6 f6) {
        C1486Ac c1486Ac = new C1486Ac(i, f6);
        this.A05.remove(c1486Ac);
        if (!c1486Ac.equals(this.A02)) {
            return;
        }
        this.A02 = this.A05.isEmpty() ? null : this.A05.get(0);
    }

    public final void A0E(int i, F6 f6) {
        this.A02 = new C1486Ac(i, f6);
    }

    public final void A0F(AZ az) {
        for (int i = 0; i < this.A05.size(); i++) {
            ArrayList<C1486Ac> arrayList = this.A05;
            arrayList.set(i, A00(arrayList.get(i), az));
        }
        C1486Ac c1486Ac = this.A02;
        if (A06[0].charAt(21) == 'U') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "OE27bQwCbSc4SHZoCTNTYydrCDTv";
        strArr[1] = "OE27bQwCbSc4SHZoCTNTYydrCDTv";
        if (c1486Ac != null) {
            this.A02 = A00(c1486Ac, az);
        }
        this.A00 = az;
        A02();
    }

    public final boolean A0G() {
        return this.A03;
    }
}
