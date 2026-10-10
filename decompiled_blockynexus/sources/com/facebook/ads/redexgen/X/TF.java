package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TF implements C5N {
    public static byte[] A03;
    public static String[] A04;
    public final Q8 A01;
    public Set<C5Q> A00 = new HashSet();
    public final List<C5P> A02 = new ArrayList();

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-72, -72, -67, 11, -46, -72, -67, 11, 41, 59, 59, 45, 60, 59};
    }

    public static void A03() {
        A04 = new String[]{"Yyt8Jrp", "FvQHlihhdkZe9tXm7YLHdG4gIBqm", "h7ITXytSbKbsxwMfZDKdUPEvMsTrizAq", "0TuNzKSIMRKA8K3EzRQL94hbriXTa7QT", "ySuQOOQJHVodSpCznPaDLfXVVxuxvbGA", "XYB8XYCfCTfWBGtKG07Wi1HuHmIQx2qC", "71D0xe3tljOi7f3b0iOVOXaXnoSWhNo4", "dwdYeokke3ChTNA3vTF4hdqHGwVronGN"};
    }

    public TF(QK qk) {
        this.A01 = qk.A4N(Q9.A0B);
        this.A01.A3I(new TE(this));
        A04();
    }

    @Nullable
    public static Set<C5Q> A01(JSONObject jSONObject) {
        TG tgA00;
        HashSet hashSet = new HashSet();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A00(8, 6, 93));
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject assetJson = jSONArrayOptJSONArray.optJSONObject(i);
            if (assetJson == null || (tgA00 = TG.A00(assetJson)) == null) {
                return null;
            }
            hashSet.add(tgA00);
            int i2 = A04[1].length();
            if (i2 == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "2zeGpFgTpOohtr7xv9EhLTO87hKhrQIZ";
            strArr[3] = "Z45Lb0RXWpRaUi2IX7mXCACeVe5qt7dU";
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A04() {
        if (!this.A01.A7w()) {
            BuildConfigApi.isDebug();
            return;
        }
        Set<C5Q> setA01 = A01(this.A01.A64());
        if (!this.A00.equals(setA01) && setA01 != null) {
            this.A00 = setA01;
            for (C5P listener : this.A02) {
                listener.A3T();
            }
        }
        if (BuildConfigApi.isDebug()) {
            for (C5Q c5q : this.A00) {
                String.format(Locale.US, A00(0, 8, 45), c5q.A7I(), c5q.getUrl());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C5N
    public final void A3G(C5P c5p) {
        this.A02.add(c5p);
    }

    @Override // com.facebook.ads.redexgen.X.C5N
    public final synchronized Set<C5Q> A5V() {
        return new HashSet(this.A00);
    }
}
