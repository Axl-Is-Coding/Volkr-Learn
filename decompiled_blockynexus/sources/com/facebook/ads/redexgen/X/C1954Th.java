package com.facebook.ads.redexgen.X;

import android.content.pm.ApplicationInfo;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Th, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1954Th implements C6Y {
    public static String[] A01;
    public final /* synthetic */ U1 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"273FKnw5fEMMMPHYpDWr2uCxLH", "MURfYE", "2MrWxfjycJYz8CRz8nVEoUtgAppiNGkb", "dgs6GO1Bgwq7bEpFzLz1V7Vq3FkVRsxg", "uUhMN1Ac0a0MVvdzsNpT9rjxKSsemVru", "HLxj17LMU0ZLExoNf0E99eYx3QTlHuEl", "3ccBwYNuPT2bbHKd70up9vlieZX79PEX", "FpcSlILO2LyEt0C9jtDQqRZtHAa4Q2N9"};
    }

    public C1954Th(U1 u1) {
        this.A00 = u1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A01 != null) {
            U1 u1 = this.A00;
            ApplicationInfo applicationInfo = u1.A01;
            if (A01[1].length() == 3) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "Yec9tINwCXE8zEgRYPM9thJfbPEs0Pqz";
            strArr[3] = "Yec9tINwCXE8zEgRYPM9thJfbPEs0Pqz";
            return u1.A09(applicationInfo.taskAffinity);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
