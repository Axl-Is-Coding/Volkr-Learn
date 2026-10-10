package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1725Kh {
    public static byte[] A00;
    public static String[] A01;
    public static final Package A02;
    public static final String A03;
    public static final String A04;
    public static final String A05;
    public static final Set<C2026Wb> A06;
    public static final AtomicReference<InterfaceC1729Km> A07;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-111, -92, -89, -79, -70, -62, -92, -89, -62, -78, -91, -83, -62, -84, -89, -62, -82, -88, -68, -68, -49, -46, -36, -27, -19, -35, -32, -41, -43, -41, -36, -49, -38, -19, -45, -26, -30, -32, -49, -31, 102, 121, 124, -122, -113, -105, -117, 121, -114, 125, 124, -105, -117, -116, 121, -116, 125, -105, 124, 121, -116, 121, -57, -43, -22, -39, -40, -108, -25, -24, -43, -24, -39, -108, -42, -23, -30, -40, -32, -39, -108, -35, -25, -108, -39, -31, -28, -24, -19, -107};
    }

    public static void A08() {
        A01 = new String[]{"R2O7PMYP6nkOeNui3I4WlXx4fu7rpRKA", "y", "n9RLgUbY6qPVyxnn4C2MCNq6tOX6tKMu", "KtI8XvYnNiAs4lVQz", "VIjGruAAxxfbDEfj8", "jnPluIPOifq7BY1vqnqKLiUetY3DHsfM", "J5aiTqmsNT2689NKU", "zCaDldCe0EtEl2h3W"};
    }

    static {
        A08();
        A07();
        A02 = C1725Kh.class.getPackage();
        A04 = A02 + A06(40, 22, 38);
        A03 = A02 + A06(0, 19, 81);
        A05 = A02 + A06(19, 21, 124);
        A06 = Collections.newSetFromMap(new WeakHashMap());
        A07 = new AtomicReference<>();
    }

    public static Intent A00(Intent cloneIntent) {
        Intent intentCloneFilter = cloneIntent.cloneFilter();
        intentCloneFilter.setFlags(cloneIntent.getFlags());
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(cloneIntent.getExtras());
        intentCloneFilter.putExtra(A05, parcelObtain.marshall());
        parcelObtain.recycle();
        return intentCloneFilter;
    }

    public static Intent A01(Intent startIntent, ClassLoader classLoader) {
        Intent intentCloneFilter = startIntent.cloneFilter();
        intentCloneFilter.setFlags(startIntent.getFlags());
        Bundle bundle = new Bundle();
        Parcel parcelObtain = Parcel.obtain();
        byte[] byteArrayExtra = startIntent.getByteArrayExtra(A05);
        if (byteArrayExtra != null) {
            parcelObtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            parcelObtain.setDataPosition(0);
            bundle = parcelObtain.readBundle(classLoader);
            parcelObtain.recycle();
        }
        intentCloneFilter.putExtras(bundle);
        return intentCloneFilter;
    }

    public static Bundle A02(Bundle bundle, ClassLoader classLoader) {
        Parcel parcelObtain = Parcel.obtain();
        byte[] byteArray = bundle.getByteArray(A04);
        if (byteArray != null) {
            parcelObtain.unmarshall(byteArray, 0, byteArray.length);
            parcelObtain.setDataPosition(0);
            Bundle bundle2 = parcelObtain.readBundle(classLoader);
            parcelObtain.recycle();
            String[] strArr = A01;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "08vXapB5qdF8q1e2g";
            strArr2[3] = "bPV7EQI3jYdBWJzP2";
            return bundle2;
        }
        throw new IllegalStateException(A06(62, 28, 98));
    }

    @Nullable
    public static C2026Wb A03(Intent intent) {
        String adId = intent.getStringExtra(A03);
        if (adId != null) {
            for (C2026Wb c2026Wb : A06) {
                if (adId.equals(c2026Wb.A0A().getId())) {
                    return c2026Wb;
                }
            }
            return null;
        }
        return null;
    }

    public static AdActivityIntent A04(C2026Wb c2026Wb) {
        AdActivityIntent adActivityIntent = new AdActivityIntent(c2026Wb.getApplicationContext(), A05());
        adActivityIntent.putExtra(A03, c2026Wb.A0A().getId());
        A06.add(c2026Wb);
        return adActivityIntent;
    }

    public static Class A05() {
        if (A01[1].length() != 1) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "4NnM5dRGBMW0KGxzs";
        strArr[3] = "N6FCbEqQMIqNBYuck";
        return AudienceNetworkActivity.class;
    }

    public static void A09(Bundle bundle, Bundle bundle2) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle2);
        bundle.putByteArray(A04, parcelObtain.marshall());
        parcelObtain.recycle();
    }

    public static void A0A(C2026Wb c2026Wb, AdActivityIntent adActivityIntent) {
        c2026Wb.getApplicationContext().startActivity(A00(adActivityIntent));
    }

    public static boolean A0B(Intent intent, Set<String> set) {
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String prefix = data.toString();
        for (String url : set) {
            if (prefix.startsWith(url)) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0C(C2026Wb c2026Wb, Intent intent) throws ActivityNotFoundException {
        return A0D(c2026Wb, intent, A07.get());
    }

    @VisibleForTesting
    public static boolean A0D(C2026Wb c2026Wb, Intent intent, @Nullable InterfaceC1729Km interfaceC1729Km) throws ActivityNotFoundException {
        if (A0B(intent, C1693Iy.A0U(c2026Wb))) {
            return false;
        }
        Context context = c2026Wb;
        String[] strArr = A01;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[1] = "W";
        strArr2[1] = "W";
        Activity activityA09 = c2026Wb.A09();
        if (activityA09 != null) {
            context = activityA09;
        } else {
            intent.addFlags(268435456);
        }
        if (interfaceC1729Km == null || A0B(intent, C1693Iy.A0W(c2026Wb))) {
            context.startActivity(intent);
            return true;
        }
        return interfaceC1729Km.startActivity(context, intent);
    }
}
