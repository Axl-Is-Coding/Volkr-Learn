package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Arrays;
import java.util.EnumSet;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC14046n<T> {
    public static byte[] A04;
    public static String[] A05;
    public static final String A06;
    public final long A00;

    @Nullable
    public final C14026l A01;
    public final EnumC14036m A02;
    public final T A03;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A04 = new byte[]{105, 126, 114, 40, 124};
    }

    public static void A05() {
        A05 = new String[]{"IPzGtGdAf7dMWjoiAfsJwT8MSbfW", "XMCeZkZyu3cdrivUr2jZRBASAtioBKsk", "M9df3TmYW4NVaJXwV617xCLf0ka0RL", "QgNQyFbsObpuCkNzfa3XkTwr8fWterHM", "OM6XrXF8htknNzzoWXy", "2umg9hNEEJctkPlZR8BXtgIxIwG9FY0j", "MjJVouBCVmg2kVwWDhDqrlmadtoLZ7M", "22y3hOnyLMExHbJepmdK5jKs80KnwphC"};
    }

    public abstract int A07() throws Exception;

    public abstract JSONObject A09(JSONObject jSONObject) throws JSONException;

    public abstract boolean A0B(AbstractC14046n<T> abstractC14046n);

    static {
        A05();
        A04();
        A06 = AbstractC14046n.class.getSimpleName();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    public AbstractC14046n(long j, @Nullable C14026l c14026l, T signalValue, EnumC14036m enumC14036m) {
        this.A00 = j;
        this.A01 = c14026l;
        this.A03 = signalValue;
        this.A02 = enumC14036m;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    private final long A00() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    @Nullable
    private final C14026l A01() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    private final EnumC14036m A02() {
        return this.A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    @SuppressLint({"CatchGeneralException"})
    public final int A06() {
        int length = (A01() != null ? A01().A03().getBytes().length : 0) + 8;
        try {
            return A07() + length;
        } catch (Exception e2) {
            AnonymousClass61.A04(e2);
            return length;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    public final T A08() {
        return this.A03;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[Catch: all -> 0x008b, TRY_LEAVE, TryCatch #0 {all -> 0x008b, blocks: (B:4:0x0007, B:5:0x0018, B:8:0x001e, B:9:0x002e, B:11:0x0034, B:13:0x003a, B:14:0x003e, B:21:0x006c, B:22:0x0078, B:24:0x007c), top: B:28:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    @android.annotation.SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject A0A(boolean r8) {
        /*
            r7 = this;
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            if (r8 == 0) goto L18
            r2 = 4
            r1 = 1
            r0 = 2
            java.lang.String r2 = A03(r2, r1, r0)     // Catch: java.lang.Throwable -> L8b
            long r4 = r7.A00     // Catch: java.lang.Throwable -> L8b
            float r1 = (float) r4     // Catch: java.lang.Throwable -> L8b
            r0 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r0
            double r0 = (double) r1     // Catch: java.lang.Throwable -> L8b
            r3.put(r2, r0)     // Catch: java.lang.Throwable -> L8b
        L18:
            com.facebook.ads.redexgen.X.6l r0 = r7.A01     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L2e
            if (r8 == 0) goto L2e
            r2 = 0
            r1 = 3
            r0 = 0
            java.lang.String r1 = A03(r2, r1, r0)     // Catch: java.lang.Throwable -> L8b
            com.facebook.ads.redexgen.X.6l r0 = r7.A01     // Catch: java.lang.Throwable -> L8b
            org.json.JSONObject r0 = r0.A04()     // Catch: java.lang.Throwable -> L8b
            r3.put(r1, r0)     // Catch: java.lang.Throwable -> L8b
        L2e:
            com.facebook.ads.redexgen.X.6m r1 = r7.A02     // Catch: java.lang.Throwable -> L8b
            com.facebook.ads.redexgen.X.6m r0 = com.facebook.ads.redexgen.X.EnumC14036m.A04     // Catch: java.lang.Throwable -> L8b
            if (r1 == r0) goto L3e
            java.lang.Object r0 = r7.A08()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L3e
            r7.A09(r3)     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L3e:
            com.facebook.ads.redexgen.X.6m r5 = r7.A02     // Catch: java.lang.Throwable -> L8b
            com.facebook.ads.redexgen.X.6m r4 = com.facebook.ads.redexgen.X.EnumC14036m.A04     // Catch: java.lang.Throwable -> L8b
            r6 = 3
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AbstractC14046n.A05
            r0 = 7
            r1 = r1[r0]
            r0 = 6
            char r1 = r1.charAt(r0)
            r0 = 110(0x6e, float:1.54E-43)
            if (r1 == r0) goto L57
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L57:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC14046n.A05
            java.lang.String r1 = "j6hvLenmhks7DifvzYp6ZMm4s1P7WZuQ"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "j6hvLenmhks7DifvzYp6ZMm4s1P7WZuQ"
            r0 = 7
            r2[r0] = r1
            r1 = 1
            r0 = 71
            java.lang.String r2 = A03(r6, r1, r0)
            if (r5 != r4) goto L78
            T r0 = r7.A03     // Catch: java.lang.Throwable -> L8b
            com.facebook.ads.redexgen.X.6k r0 = (com.facebook.ads.redexgen.X.C14016k) r0     // Catch: java.lang.Throwable -> L8b
            org.json.JSONObject r0 = r0.A09()     // Catch: java.lang.Throwable -> L8b
            r3.put(r2, r0)     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L78:
            T r0 = r7.A03     // Catch: java.lang.Throwable -> L8b
            if (r0 != 0) goto L8f
            com.facebook.ads.redexgen.X.6k r1 = new com.facebook.ads.redexgen.X.6k     // Catch: java.lang.Throwable -> L8b
            com.facebook.ads.redexgen.X.6j r0 = com.facebook.ads.redexgen.X.EnumC14006j.A07     // Catch: java.lang.Throwable -> L8b
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L8b
            org.json.JSONObject r0 = r1.A09()     // Catch: java.lang.Throwable -> L8b
            r3.put(r2, r0)     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L8b:
            r0 = move-exception
            com.facebook.ads.redexgen.X.AnonymousClass61.A04(r0)
        L8f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC14046n.A0A(boolean):org.json.JSONObject");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    public final boolean A0C(@Nullable AbstractC14046n<T> abstractC14046n, EnumSet<EnumC13936c> enumSet) {
        long jA08;
        if (abstractC14046n == null || A02() != abstractC14046n.A02()) {
            return false;
        }
        if (A02() == EnumC14036m.A04 && abstractC14046n.A02() == EnumC14036m.A04) {
            return A0B(abstractC14046n);
        }
        boolean zA0B = false;
        if (enumSet.contains(EnumC13936c.A0E)) {
            zA0B = A0B(abstractC14046n);
        }
        if (enumSet.contains(EnumC13936c.A0C)) {
            zA0B &= (A01() == null || abstractC14046n.A01() == null || !A01().A03().equals(abstractC14046n.A01().A03())) ? false : true;
        }
        if (enumSet.contains(EnumC13936c.A0D)) {
            if (A02() == EnumC14036m.A0D || A02() == EnumC14036m.A0B) {
                jA08 = C13815p.A08();
            } else {
                jA08 = C13815p.A09();
            }
            long epsilon = Math.abs(this.A00 - abstractC14046n.A00());
            return zA0B & (epsilon < jA08);
        }
        return zA0B;
    }
}
