package com.facebook.ads.internal.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.facebook.ads.redexgen.X.C1637Gq;
import com.facebook.ads.redexgen.X.IW;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DefaultTrackSelector$Parameters implements Parcelable {
    public static String[] A0I;
    public static final DefaultTrackSelector$Parameters A0J;
    public static final Parcelable.Creator<DefaultTrackSelector$Parameters> CREATOR;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;

    @Nullable
    public final String A07;

    @Nullable
    public final String A08;
    public final boolean A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean A0E;
    public final boolean A0F;
    public final SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> A0G;
    public final SparseBooleanArray A0H;

    public static void A01() {
        A0I = new String[]{"1uD1IV7D8X2FSwLSySpsMcd3fQZ0OK2I", "X8JDcoZekK8R8v3vEfyFt4rHK", "De3gnuhyaRRo1wIKKb0tF8p3R", "K68eMOOAXfhu3P8i4BL4WgotL7owvGg9", "YDqiP1KrSZLqrk6j1D4tO3HA5vwhMr0w", "rlifz9RYl4Hvs6rNSrBLCbq", "exa3hMIhu9HiMPspfK9jv5JkxYqQeWLn", "xGeCbtaF5ov5ZPZJ4BZzeMzjm9y5yA79"};
    }

    static {
        A01();
        A0J = new DefaultTrackSelector$Parameters();
        CREATOR = new C1637Gq();
    }

    public DefaultTrackSelector$Parameters() {
        this(new SparseArray(), new SparseBooleanArray(), null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, 0);
    }

    public DefaultTrackSelector$Parameters(Parcel parcel) {
        this.A0G = A00(parcel);
        this.A0H = parcel.readSparseBooleanArray();
        this.A07 = parcel.readString();
        this.A08 = parcel.readString();
        this.A0E = IW.A0g(parcel);
        this.A00 = parcel.readInt();
        this.A0D = IW.A0g(parcel);
        this.A09 = IW.A0g(parcel);
        this.A0A = IW.A0g(parcel);
        this.A03 = parcel.readInt();
        this.A02 = parcel.readInt();
        this.A01 = parcel.readInt();
        this.A0C = IW.A0g(parcel);
        this.A0B = IW.A0g(parcel);
        this.A06 = parcel.readInt();
        this.A05 = parcel.readInt();
        this.A0F = IW.A0g(parcel);
        this.A04 = parcel.readInt();
    }

    public DefaultTrackSelector$Parameters(SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray, @Nullable String str, @Nullable String str2, boolean z, int i, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4, boolean z5, boolean z6, int i5, int i6, boolean z7, int i7) {
        this.A0G = sparseArray;
        this.A0H = sparseBooleanArray;
        this.A07 = IW.A0L(str);
        this.A08 = IW.A0L(str2);
        this.A0E = z;
        this.A00 = i;
        this.A0D = z2;
        this.A09 = z3;
        this.A0A = z4;
        this.A03 = i2;
        this.A02 = i3;
        this.A01 = i4;
        this.A0C = z5;
        this.A0B = z6;
        this.A06 = i5;
        this.A05 = i6;
        this.A0F = z7;
        this.A04 = i7;
    }

    public static SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> A00(Parcel parcel) {
        int i = parcel.readInt();
        SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray = new SparseArray<>(i);
        for (int rendererIndex = 0; rendererIndex < i; rendererIndex++) {
            int overrideCount = parcel.readInt();
            int i2 = parcel.readInt();
            HashMap map = new HashMap(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                TrackGroupArray trackGroupArray = (TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader());
                DefaultTrackSelector$SelectionOverride override = (DefaultTrackSelector$SelectionOverride) parcel.readParcelable(DefaultTrackSelector$SelectionOverride.class.getClassLoader());
                map.put(trackGroupArray, override);
            }
            sparseArray.put(overrideCount, map);
        }
        return sparseArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006a, code lost:
    
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A02(android.os.Parcel r7, android.util.SparseArray<java.util.Map<com.facebook.ads.internal.exoplayer2.source.TrackGroupArray, com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride>> r8) {
        /*
            int r4 = r8.size()
            r7.writeInt(r4)
            r3 = 0
        L8:
            if (r3 >= r4) goto L6d
            int r2 = r8.keyAt(r3)
            java.lang.Object r1 = r8.valueAt(r3)
            java.util.Map r1 = (java.util.Map) r1
            int r0 = r1.size()
            r7.writeInt(r2)
            r7.writeInt(r0)
            java.util.Set r0 = r1.entrySet()
            java.util.Iterator r6 = r0.iterator()
        L26:
            boolean r5 = r6.hasNext()
            java.lang.String[] r2 = com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters.A0I
            r0 = 1
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L42
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L42:
            java.lang.String[] r2 = com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters.A0I
            java.lang.String r1 = "Yf5UDYoyCKDeBovWDXdmYX2icwRNMgWM"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "Yf5UDYoyCKDeBovWDXdmYX2icwRNMgWM"
            r0 = 4
            r2[r0] = r1
            if (r5 == 0) goto L6a
            java.lang.Object r2 = r6.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r0 = r2.getKey()
            android.os.Parcelable r0 = (android.os.Parcelable) r0
            r1 = 0
            r7.writeParcelable(r0, r1)
            java.lang.Object r0 = r2.getValue()
            android.os.Parcelable r0 = (android.os.Parcelable) r0
            r7.writeParcelable(r0, r1)
            goto L26
        L6a:
            int r3 = r3 + 1
            goto L8
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters.A02(android.os.Parcel, android.util.SparseArray):void");
    }

    public static boolean A03(SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray2) {
        int size = sparseArray.size();
        if (sparseArray2.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            int indexInSecond = sparseArray2.indexOfKey(sparseArray.keyAt(i));
            if (indexInSecond < 0 || !A05(sparseArray.valueAt(i), sparseArray2.valueAt(indexInSecond))) {
                return false;
            }
        }
        return true;
    }

    public static boolean A04(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray.size();
        if (sparseBooleanArray2.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean A05(Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> map, Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> map2) {
        if (map2.size() != map.size()) {
            return false;
        }
        for (Map.Entry<TrackGroupArray, DefaultTrackSelector$SelectionOverride> entry : map.entrySet()) {
            TrackGroupArray key = entry.getKey();
            if (!map2.containsKey(key) || !IW.A0h(entry.getValue(), map2.get(key))) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final DefaultTrackSelector$SelectionOverride A06(int i, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> map = this.A0G.get(i);
        if (map != null) {
            return map.get(trackGroupArray);
        }
        return null;
    }

    public final boolean A07(int i) {
        return this.A0H.get(i);
    }

    public final boolean A08(int i, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> map = this.A0G.get(i);
        return map != null && map.containsKey(trackGroupArray);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = getClass();
            Class<?> cls2 = obj.getClass();
            if (A0I[5].length() != 23) {
                throw new RuntimeException();
            }
            String[] strArr = A0I;
            strArr[0] = "PTX86aGNYIw9JX3myOulYVpgRV6aH44E";
            strArr[0] = "PTX86aGNYIw9JX3myOulYVpgRV6aH44E";
            if (cls == cls2) {
                DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = (DefaultTrackSelector$Parameters) obj;
                if (this.A0E == defaultTrackSelector$Parameters.A0E && this.A00 == defaultTrackSelector$Parameters.A00 && this.A0D == defaultTrackSelector$Parameters.A0D && this.A09 == defaultTrackSelector$Parameters.A09 && this.A0A == defaultTrackSelector$Parameters.A0A && this.A03 == defaultTrackSelector$Parameters.A03 && this.A02 == defaultTrackSelector$Parameters.A02 && this.A0C == defaultTrackSelector$Parameters.A0C && this.A0B == defaultTrackSelector$Parameters.A0B && this.A0F == defaultTrackSelector$Parameters.A0F && this.A06 == defaultTrackSelector$Parameters.A06 && this.A05 == defaultTrackSelector$Parameters.A05 && this.A01 == defaultTrackSelector$Parameters.A01 && this.A04 == defaultTrackSelector$Parameters.A04 && TextUtils.equals(this.A07, defaultTrackSelector$Parameters.A07) && TextUtils.equals(this.A08, defaultTrackSelector$Parameters.A08) && A04(this.A0H, defaultTrackSelector$Parameters.A0H) && A03(this.A0G, defaultTrackSelector$Parameters.A0G)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((((((((((((((((((((((this.A0E ? 1 : 0) * 31) + this.A00) * 31) + (this.A0D ? 1 : 0)) * 31) + (this.A09 ? 1 : 0)) * 31) + (this.A0A ? 1 : 0)) * 31) + this.A03) * 31) + this.A02) * 31) + (this.A0C ? 1 : 0)) * 31) + (this.A0B ? 1 : 0)) * 31) + (this.A0F ? 1 : 0)) * 31) + this.A06) * 31) + this.A05) * 31) + this.A01) * 31) + this.A04) * 31;
        String str = this.A07;
        int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.A08;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        A02(parcel, this.A0G);
        parcel.writeSparseBooleanArray(this.A0H);
        parcel.writeString(this.A07);
        parcel.writeString(this.A08);
        IW.A0W(parcel, this.A0E);
        parcel.writeInt(this.A00);
        IW.A0W(parcel, this.A0D);
        IW.A0W(parcel, this.A09);
        IW.A0W(parcel, this.A0A);
        parcel.writeInt(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A01);
        IW.A0W(parcel, this.A0C);
        IW.A0W(parcel, this.A0B);
        parcel.writeInt(this.A06);
        parcel.writeInt(this.A05);
        IW.A0W(parcel, this.A0F);
        parcel.writeInt(this.A04);
    }
}
