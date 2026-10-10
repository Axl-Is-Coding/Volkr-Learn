package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.65, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass65 {

    @Nullable
    public static AnonymousClass65 A07;
    public static String[] A08;
    public static final AtomicBoolean A09;
    public AnonymousClass64 A00 = new AnonymousClass64(this, C14106t.A00().A04().getLooper());
    public C6E A01;
    public C6F A02;
    public List<C6I> A03;
    public final Context A04;
    public final C13815p A05;
    public final EnumC13936c A06;

    public static void A02() {
        A08 = new String[]{"lhELmGRUtbYPcwJFNCjn5HfCntRtzqQU", "Mt1hbHTlPicMeG4rtX3JBcBhsjGdj", "WXTUL6dhKmyeG13MmR9X1nSF3ta0T4v7", "pnvqG2PyjZWupJIeMnGxGNF5M9wfPV2M", "tVIu8wQwIUzvrLJUsX9QEkuDOevngDVu", "qDTAVfu3jvCTQwnOSiE3SjcB7mVx4hBM", "klm6aBATY902pfwdRKxrpHOkJcym9ne5", "D4wxrsR0ab6WquJuKpvZlDWLQMdeNXqb"};
    }

    static {
        A02();
        A09 = new AtomicBoolean();
    }

    public AnonymousClass65(C13815p c13815p, Context context) {
        this.A05 = c13815p;
        this.A04 = context;
        this.A06 = c13815p.A0a();
    }

    public static synchronized AnonymousClass65 A00(Context context, C13815p c13815p) {
        if (A07 == null) {
            A07 = new AnonymousClass65(c13815p, context);
        }
        return A07;
    }

    private synchronized void A03() {
        A09.set(false);
        this.A03 = new ArrayList();
        String[] strArr = A08;
        if (strArr[2].charAt(18) != strArr[4].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "OJ9tJzFQNQxQ8qaEQfi4ar7y8Z5YVilt";
        strArr2[1] = "oKX4c494QlidqOlhH9QFYLNn1ihcq";
    }

    public final synchronized void A04() {
        if (this.A01 != null) {
            this.A01.A04(this.A03);
        }
        A03();
    }

    public final synchronized void A05(Map<Integer, C6V> map, C6Z c6z) {
        A03();
        AnonymousClass69 anonymousClass69 = new AnonymousClass69(this.A05, map);
        for (Map.Entry<Integer, C6V> entry : map.entrySet()) {
            C6V bdSignal = entry.getValue();
            if (bdSignal != null && bdSignal.A04(c6z)) {
                int iIntValue = entry.getKey().intValue();
                if (iIntValue != 10800) {
                    switch (iIntValue) {
                        case 10810:
                            this.A03.add(C6I.A04);
                            break;
                        case 10811:
                            this.A03.add(C6I.A08);
                            break;
                        case 10812:
                            this.A03.add(C6I.A0A);
                            break;
                        case 10813:
                            this.A03.add(C6I.A07);
                            break;
                        case 10814:
                            this.A03.add(C6I.A0B);
                            break;
                        case 10815:
                            this.A03.add(C6I.A0C);
                            break;
                        case 10816:
                            this.A03.add(C6I.A0E);
                            break;
                        case 10817:
                            this.A03.add(C6I.A09);
                            break;
                        case 10818:
                            this.A03.add(C6I.A06);
                            break;
                        case 10819:
                            this.A03.add(C6I.A05);
                            break;
                        case 10820:
                            this.A03.add(C6I.A0D);
                            break;
                    }
                } else {
                    this.A02 = new C6F(this.A04, anonymousClass69, this.A06);
                    A09.set(true);
                }
            }
        }
        this.A01 = new C6E(this.A04, anonymousClass69, this.A06);
        this.A01.A03(this.A03);
        if (!this.A00.getLooper().getThread().isAlive()) {
            this.A00 = new AnonymousClass64(this, C14106t.A00().A04().getLooper());
        }
    }

    public final synchronized boolean A06(MotionEvent motionEvent) {
        if (!A09.get()) {
            return false;
        }
        Message message = new Message();
        message.what = AnonymousClass63.A03.ordinal();
        message.obj = motionEvent;
        this.A00.sendMessage(message);
        return true;
    }
}
