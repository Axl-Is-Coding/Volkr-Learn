package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HY implements InterfaceC1835Oq {
    public static String[] A0C;

    @Nullable
    public LU A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final AbstractC1708Jp A07 = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.7h
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9A
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A04(C14257j c14257j) {
            this.A00.A05.removeCallbacksAndMessages(null);
            if (this.A00.A0E(PA.A05)) {
                this.A00.A03();
                this.A00.A07(true, false);
            }
            this.A00.A03 = true;
        }
    };
    public final AbstractC1714Jv A06 = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.7g
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9A
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A04(C7l c7l) {
            this.A00.A03();
            this.A00.A07(false, false);
            this.A00.A03 = true;
        }
    };
    public final AbstractC1696Jb A08 = new C14227f(this);
    public final IU A09 = new IU() { // from class: com.facebook.ads.redexgen.X.7e
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9A
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A04(C14247i c14247i) {
            if (this.A00.A02 || !this.A00.A0E(PA.A05)) {
                return;
            }
            this.A00.A03();
            this.A00.A07(true, false);
        }
    };
    public final I2 A0A = new C14207d(this);
    public final Handler A05 = new Handler();
    public final List<PB> A0B = new ArrayList();
    public int A00 = 2000;

    static {
        A04();
    }

    public static void A04() {
        A0C = new String[]{"ua4Z1F3Vn1tdURaP0tTj5Z", "VlqKJtfjGqtNso0qX2A6lmnvOZsZ2xTE", "1pb0xsuTqC4ySw1JjiCpjHk6a0KK", "HW9a8amQa56v9usqS4J3KzzxMBRp7oUY", "lzg290ZQq0ECc78zj7A2Pt", "9JBQniCNh78hbF6UnJo6", "DIRAqcjzgSQz4x9q8OrEXdtc6Zce0V5V", "FPN1H6gS7aT4O5CCkRk249I"};
    }

    public HY(boolean z) {
        this.A02 = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        this.A05.removeCallbacksAndMessages(null);
        Iterator<PB> it = this.A0B.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0C[2].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[1] = "SzC94btdcN1119JNHgRanzsWdfoutew0";
            strArr[1] = "SzC94btdcN1119JNHgRanzsWdfoutew0";
            if (zHasNext) {
                it.next().cancel();
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(boolean z, boolean z2) {
        for (PB pb : this.A0B) {
            if (A0C[2].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[1] = "qWrr7wKcnD6M25Nm7U3j0NNRElcnIA4d";
            strArr[1] = "qWrr7wKcnD6M25Nm7U3j0NNRElcnIA4d";
            pb.A3O(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0E(PA pa) {
        Iterator<PB> it = this.A0B.iterator();
        while (it.hasNext()) {
            if (it.next().A78() != pa) {
                return false;
            }
        }
        return true;
    }

    public final void A0F() {
        this.A0B.clear();
    }

    public final void A0G() {
        if (this.A02) {
            this.A05.removeCallbacksAndMessages(null);
            this.A02 = false;
        }
    }

    public final void A0H() {
        this.A04 = true;
        this.A03 = true;
        A07(false, false);
    }

    public final void A0I(int i) {
        this.A00 = i;
    }

    public final void A0J(PB pb) {
        this.A0B.add(pb);
    }

    public final boolean A0K() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void A86(LU lu) {
        this.A01 = lu;
        lu.getEventBus().A04(this.A07, this.A0A, this.A08, this.A09, this.A06);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void ADt(LU lu) {
        A03();
        lu.getEventBus().A05(this.A06, this.A0A, this.A08, this.A09, this.A07);
        this.A01 = null;
    }
}
