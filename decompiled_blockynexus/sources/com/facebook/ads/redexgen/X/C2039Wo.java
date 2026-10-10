package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.AdSharedPreferences;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2039Wo implements C8K {
    public static byte[] A03;
    public static String[] A04;
    public Context A00;
    public final AtomicBoolean A02 = new AtomicBoolean(false);

    @Nullable
    public C8J A01 = A00();

    static {
        A04();
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{107, 110, 123, 110, 112, 127, 125, 96, 108, 106, 124, 124, 102, 97, 104, 112, 96, 127, 123, 102, 96, 97, 124, 112, 108, 96, 122, 97, 123, 125, 118, 112, 100, 106, 118, 1, 4, 17, 4, 26, 21, 23, 10, 6, 0, 22, 22, 12, 11, 2, 26, 10, 21, 17, 12, 10, 11, 22, 26, ci.l, 0, 28, 106, 111, 122, 111, 113, 126, 124, 97, 109, 107, 125, 125, 103, 96, 105, 113, 97, 126, 122, 103, 97, 96, 125, 113, 125, 122, 111, 122, 107, 113, 101, 107, 119, ci.l, 26, 5, 21, 25, ci.m, 30, 30, 3, 4, ci.k, 25, 21, 1, ci.m, 19};
    }

    public static void A04() {
        A04 = new String[]{"D3PJ2GNcgNGI4MtKfCaHjqEOfdHoPcVQ", "EJL0aGmI3i0Imoz4UWgpTxwTxGm9WRxT", "tfWCUNw0WGkvc5ldnWfg2BDK3aY0ceq2", "VYnzwe", "FWw4Dif8pFGferaZg4Cc6MDYh6zRU5", "BYQArfMrHiqwTG3fAjpcYjBOCFZN2nO4", "ZJiZak5asVL", "k4pPkd4ODWsyAa7ylPFb6IMORyuDH4"};
    }

    public C2039Wo(Context context) {
        this.A00 = context;
    }

    @Nullable
    private C8J A00() {
        return C8J.A00(AdSharedPreferences.getSharedPreferences(this.A00).getString(A01(95, 16, 52), null));
    }

    private void A02() {
        String[] stringArray;
        Integer integer;
        Integer country;
        if (!AdInternalSettings.sDataProcessingOptionsUpdate.getAndSet(false)) {
            return;
        }
        synchronized (AdInternalSettings.sSettingsBundle) {
            stringArray = AdInternalSettings.sSettingsBundle.getStringArray(A01(35, 27, 59));
            integer = AdInternalSettings.sSettingsBundle.getInteger(A01(0, 35, 81));
            country = AdInternalSettings.sSettingsBundle.getInteger(A01(62, 33, 80));
        }
        A05(stringArray, integer, country);
    }

    public final void A05(@Nullable String[] strArr, @Nullable Integer num, @Nullable Integer num2) {
        C8J c8j = new C8J(strArr, num, num2);
        if (c8j.equals(this.A01)) {
            return;
        }
        this.A01 = c8j;
        this.A02.set(true);
        SharedPreferences sharedPreferences = AdSharedPreferences.getSharedPreferences(this.A00);
        if (A04[2].charAt(16) != 'n') {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[7] = "txsFPtaRD11LyA3dzoyK5U0Vbdrctz";
        strArr2[4] = "NLpqiEYsaOJ6LGl2A1qehjxsg53G43";
        sharedPreferences.edit().putString(A01(95, 16, 52), this.A01.A08()).apply();
    }

    @Override // com.facebook.ads.redexgen.X.C8K
    @Nullable
    public final C8J A65() {
        A02();
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.C8K
    public final boolean A7x() {
        A02();
        if (this.A01 == null) {
            return false;
        }
        Set<String> setA0V = C1693Iy.A0V(this.A00);
        String strA08 = this.A01.A08();
        Iterator<String> it = setA0V.iterator();
        while (it.hasNext()) {
            if (strA08.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C8K
    public final boolean ADS() {
        A02();
        return this.A02.getAndSet(false);
    }
}
