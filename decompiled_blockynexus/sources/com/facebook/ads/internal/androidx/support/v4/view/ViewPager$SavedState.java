package com.facebook.ads.internal.androidx.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewPager$SavedState extends AbsSavedState {
    public static byte[] A03;
    public static String[] A04;
    public static final Parcelable.Creator<ViewPager$SavedState> CREATOR;
    public int A00;
    public Parcelable A01;
    public ClassLoader A02;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {26, 74, 85, 73, 83, 78, 83, 85, 84, 7, 104, 92, 79, 73, 67, 75, 64, 90, 126, 79, 73, 75, 92, 0, 125, 79, 88, 75, 74, 125, 90, 79, 90, 75, 85, 110};
        if (A04[0].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[4] = "6MXMF3gfP26OkwGb8wx6s6o6EzMLPjev";
        strArr[6] = "tN9YMGevxJBQbN1CuNoijuB9DRrwOltB";
        A03 = bArr;
    }

    public static void A03() {
        A04 = new String[]{"AuWUrmLwM7GJPOP8rAuSpECd", "zFZ56n4eT6FX9g05wYbCu7I1KdVlhoN5", "3SSlkU9NidmbZe3U4TW9jjT4o2WSslgz", "APX54tRZsJmOx3lXT4kxzRZl5L0Cy1ng", "WyhnJgw7sEVfHQ6PVTSepOeMPj7Mc4Ks", "C9gBfAnfslWjb6MmPGJedCbgsvPnDQHc", "ftNuqlGlWzKSfY1f2k31BPROKX0YPmxK", "PuGcjbCEvSEVXUJBdaZJQ0xYiuJzE14G"};
    }

    static {
        A03();
        A02();
        CREATOR = new Parcelable.ClassLoaderCreator<ViewPager$SavedState>() { // from class: com.facebook.ads.redexgen.X.35
            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final ViewPager$SavedState createFromParcel(Parcel parcel) {
                return new ViewPager$SavedState(parcel, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
            public final ViewPager$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new ViewPager$SavedState(parcel, classLoader);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
            public final ViewPager$SavedState[] newArray(int i) {
                return new ViewPager$SavedState[i];
            }
        };
    }

    public ViewPager$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
        this.A00 = parcel.readInt();
        this.A01 = parcel.readParcelable(classLoader);
        this.A02 = classLoader;
    }

    public ViewPager$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public final String toString() {
        return A01(10, 25, 49) + Integer.toHexString(System.identityHashCode(this)) + A01(0, 10, 37) + this.A00 + A01(35, 1, 12);
    }

    @Override // com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.A00);
        parcel.writeParcelable(this.A01, i);
    }
}
