package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6K {
    public static final String A08 = C6K.class.getSimpleName();
    public final int A00;
    public final Context A01;
    public final C13815p A02;
    public final AnonymousClass66 A03;
    public final TS A04;
    public final TT A05;
    public final TU A06;
    public final C14086r A07;

    /* JADX WARN: Type inference failed for: r2v0, types: [com.facebook.ads.redexgen.X.6N] */
    public C6K(final Context context, final C13815p c13815p) {
        final C6O c6o = new C6O(new C6Q(context, c13815p));
        ?? r2 = new Object(context, c6o, c13815p) { // from class: com.facebook.ads.redexgen.X.6N
            public static byte[] A07;
            public static String[] A08;
            public int A00;
            public final C13815p A01;
            public final TS A02;
            public final TT A03;
            public final TU A04;
            public final C6O A05;
            public final C14086r A06;

            static {
                A05();
                A04();
            }

            public static String A02(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 75);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A04() {
                A07 = new byte[]{-31, 4};
            }

            public static void A05() {
                A08 = new String[]{"Nj4TqS4QnuHXli7th2heksSDMg2Z", "RSouwChKZWzGhunCWCHEu7HkA4YX3nJn", "5fVToSkDBkuydhS3BZw", "o644y0JXIVns0cvIXh4fs0HcxxzuSHU9", "L6wIWC4w0dKe6dclyvwc8pXUf7KK", "NV8kH7O4XMciCHnyYHa8lR80N34PEowy", "S6E1x33SpjjOrFFRELF", "CEXaqd5N8FzuUquPi7vxqko1f9a5yOv1"};
            }

            {
                this.A03 = new TT(context, c13815p);
                this.A04 = new TU(context, c13815p);
                this.A02 = new TS(context, c13815p);
                this.A06 = new C14086r(context, c13815p);
                this.A05 = c6o;
                this.A01 = c13815p;
                A06();
            }

            @Nullable
            public static C6X A00(int i, String str, int i2, int i3) {
                if (i != 10300) {
                    if (i == 10920) {
                        return A01(str, i2, i3, C6W.A03);
                    }
                    if (i != 10940 && i != 10941) {
                        switch (i) {
                            case 10943:
                            case 10944:
                            case 10945:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                return A01(str, i2, i3, C6W.A04);
            }

            @Nullable
            public static C6X A01(String str, int i, int i2, C6W c6w) {
                int i3 = C6M.A00[c6w.ordinal()];
                if (i3 == 1) {
                    return new C6X(Integer.valueOf(Integer.parseInt(str)), i, i2);
                }
                if (i3 != 2) {
                    return null;
                }
                return new C6X(str, i, i2);
            }

            @Nullable
            private List<C6X> A03(int i) throws JSONException {
                ArrayList arrayList = new ArrayList();
                Map<Integer, String> mapA0i = this.A01.A0i();
                if (mapA0i == null || mapA0i.isEmpty() || !mapA0i.containsKey(Integer.valueOf(i))) {
                    return arrayList;
                }
                JSONObject jSONObject = new JSONObject(mapA0i.get(Integer.valueOf(i)));
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray != null && jSONArray.length() == 2) {
                        int i2 = jSONArray.getInt(0);
                        int minApiLevel = jSONArray.getInt(1);
                        arrayList.add(A00(i, next, i2, minApiLevel));
                    }
                }
                return arrayList;
            }

            @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
            private final void A06() {
                String strA02 = A02(1, 1, 69);
                try {
                    JSONObject jSONObject = new JSONObject(this.A01.A0h());
                    Integer numValueOf = jSONObject.has(strA02) ? Integer.valueOf(jSONObject.getInt(strA02)) : null;
                    if (numValueOf == null) {
                        return;
                    }
                    this.A00 = numValueOf.intValue();
                    this.A06.A04(this.A00);
                    A07(jSONObject.getJSONArray(A02(0, 1, 51)));
                } catch (Throwable th) {
                    AnonymousClass61.A04(th);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00c1  */
            @android.annotation.SuppressLint({"BadMethodUse-android.util.Log.e"})
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private void A07(org.json.JSONArray r11) throws java.lang.Exception {
                /*
                    Method dump skipped, instruction units count: 272
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6N.A07(org.json.JSONArray):void");
            }

            private final boolean A08(EnumSet<EnumC13936c> enumSet) {
                return (enumSet.contains(this.A01.A0a()) && enumSet.contains(EnumC13936c.A05) && enumSet.contains(EnumC13936c.A06) && !enumSet.contains(EnumC13936c.A0A)) ? false : true;
            }

            public final int A09() {
                return this.A00;
            }

            public final TS A0A() {
                return this.A02;
            }

            public final TT A0B() {
                return this.A03;
            }

            public final TU A0C() {
                return this.A04;
            }

            public final C14086r A0D() {
                return this.A06;
            }
        };
        this.A01 = context;
        this.A05 = r2.A0B();
        this.A06 = r2.A0C();
        this.A04 = r2.A0A();
        this.A00 = r2.A09();
        this.A02 = c13815p;
        this.A03 = new AnonymousClass66();
        this.A03.A01(this.A04);
        this.A07 = r2.A0D();
        this.A07.A03();
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    public static JSONObject A00() {
        JSONObject jsonSignalObject = new JSONObject();
        Map<Integer, C13865u<AbstractC14046n>> mapA03 = C13916a.A01().A03();
        if (mapA03 == null || mapA03.isEmpty()) {
            return jsonSignalObject;
        }
        try {
            for (Integer num : mapA03.keySet()) {
                List<AbstractC14046n> listA04 = mapA03.get(num).A04();
                JSONArray jSONArray = new JSONArray();
                Iterator<AbstractC14046n> it = listA04.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().A0A(true));
                }
                jsonSignalObject.put(num.toString(), jSONArray);
            }
        } catch (Throwable th) {
            AnonymousClass61.A04(th);
        }
        return jsonSignalObject;
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    private void A01(String str, C6Z c6z, EnumC13946d enumC13946d) {
        C5z c5zA0Y = this.A02.A0Y();
        if (c5zA0Y != null) {
            int sessionEndTime = (int) (System.currentTimeMillis() / 1000);
            c5zA0Y.A8Z(C14136w.A05(), str, this.A00, c6z.A03(), sessionEndTime, A00(), enumC13946d);
        }
        C14136w.A0C(this.A02, EnumC13885w.A07.A02(), str);
    }

    public final void A02() {
        this.A03.A00();
    }

    public final void A03(C6Z c6z) {
        this.A04.A04(c6z, this.A01);
    }

    public final void A04(EnumC13926b enumC13926b, C6Z c6z, @Nullable String str) {
        A05(enumC13926b, c6z, str, EnumC13946d.A04);
    }

    public final void A05(EnumC13926b enumC13926b, C6Z c6z, @Nullable String str, EnumC13946d enumC13946d) {
        this.A05.A05(c6z);
        if (enumC13926b == EnumC13926b.A02) {
            this.A06.A04(c6z);
            if (str != null) {
                A01(str, c6z, enumC13946d);
            }
        }
    }

    public final boolean A06() {
        List<C6V> listA03 = this.A05.A03();
        return (listA03 == null || listA03.isEmpty()) ? false : true;
    }
}
