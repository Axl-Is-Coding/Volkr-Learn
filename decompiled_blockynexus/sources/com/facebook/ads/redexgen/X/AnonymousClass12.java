package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.12, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass12 extends BroadcastReceiver {
    public static String[] A03;
    public RJ A00;
    public AnonymousClass11 A01;
    public String A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"JgmY627JJ4fVvMUsUI7dBJzvca", "2Fivc7ze9Y6M7vLBAhVCw66dd2zEUTp", "oqNyJxLxp23hnAfKGRpFUMlaCTnSy4au", "HRO7fC4J0U3bXqsrOiWljP6J940cuLTJ", "rhEs9JkkityiMJcgD18RNPKtdGmllPs6", "c8I5EiJJKjWgwuyghylYWruaZ4nXJiut", "YeKDqRnNq5JcEGU0HYsnt6sxK1D4K6hE", "zIQMBMVVQmczFglCifMrZtV9RNUhKeCf"};
    }

    public AnonymousClass12(String str, RJ rj, AnonymousClass11 anonymousClass11) {
        this.A00 = rj;
        this.A01 = anonymousClass11;
        this.A02 = str;
    }

    public final IntentFilter A01() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EnumC1836Or.A06.A03(this.A02));
        intentFilter.addAction(EnumC1836Or.A09.A03(this.A02));
        intentFilter.addAction(EnumC1836Or.A04.A03(this.A02));
        intentFilter.addAction(EnumC1836Or.A0A.A03(this.A02));
        intentFilter.addAction(EnumC1836Or.A05.A03(this.A02));
        intentFilter.addAction(EnumC1836Or.A0C.A03(this.A02));
        intentFilter.addAction(EnumC1836Or.A0B.A03(this.A02));
        intentFilter.addAction(EnumC1836Or.A03.A03(this.A02));
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (EnumC1836Or.A06.A03(this.A02).equals(action)) {
            AnonymousClass11 anonymousClass11 = this.A01;
            RJ rj = this.A00;
            if (A03[1].length() != 11) {
                String[] strArr = A03;
                strArr[0] = "z37hhVYNur1y5njE4t22VYTMbB";
                strArr[0] = "z37hhVYNur1y5njE4t22VYTMbB";
                anonymousClass11.ABA(rj);
                return;
            }
        } else if (EnumC1836Or.A09.A03(this.A02).equals(action)) {
            boolean zA17 = C1693Iy.A17(context);
            String[] strArr2 = A03;
            if (strArr2[3].charAt(16) != strArr2[4].charAt(16)) {
                String[] strArr3 = A03;
                strArr3[0] = "a2nbOp8yH430aeg70B0MHQFnwN";
                strArr3[0] = "a2nbOp8yH430aeg70B0MHQFnwN";
                if (zA17) {
                    AnonymousClass11 anonymousClass112 = this.A01;
                    RJ rj2 = this.A00;
                    AdError adError = AdError.AD_PRESENTATION_ERROR;
                    String[] strArr4 = A03;
                    if (strArr4[3].charAt(16) != strArr4[4].charAt(16)) {
                        String[] strArr5 = A03;
                        strArr5[2] = "Smm3aT6IchFgLH9ob00fwQqxHFnPPG6O";
                        strArr5[5] = "wzZfDEncWZ9M4YUYJFr8Gzf2lfnMb6hd";
                        anonymousClass112.ABB(rj2, adError);
                        return;
                    }
                    String[] strArr6 = A03;
                    strArr6[6] = "douVyTcHxmEKv1YyJqQbVTsvWWCOpXBn";
                    strArr6[7] = "x6yn97aV8hj96Z0WREVv4HAdEeLr9VIY";
                    anonymousClass112.ABB(rj2, adError);
                    return;
                }
                this.A01.ABB(this.A00, AdError.INTERNAL_ERROR);
                return;
            }
        } else {
            if (EnumC1836Or.A04.A03(this.A02).equals(action)) {
                this.A01.AB7(this.A00);
                return;
            }
            if (EnumC1836Or.A0A.A03(this.A02).equals(action)) {
                this.A01.AB9(this.A00);
                return;
            }
            if (EnumC1836Or.A05.A03(this.A02).equals(action)) {
                this.A01.onRewardedVideoClosed();
                return;
            }
            if (EnumC1836Or.A0B.A03(this.A02).equals(action)) {
                this.A01.AB5(this.A00);
                return;
            } else if (EnumC1836Or.A0C.A03(this.A02).equals(action)) {
                this.A01.AB6(this.A00);
                return;
            } else {
                if (!EnumC1836Or.A03.A03(this.A02).equals(action)) {
                    return;
                }
                this.A01.onRewardedVideoActivityDestroyed();
                return;
            }
        }
        throw new RuntimeException();
    }
}
