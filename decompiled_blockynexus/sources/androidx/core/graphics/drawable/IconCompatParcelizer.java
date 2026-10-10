package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1161b = versionedParcel.a(iconCompat.f1161b, 1);
        iconCompat.f1163d = versionedParcel.a(iconCompat.f1163d, 2);
        iconCompat.f1164e = versionedParcel.a(iconCompat.f1164e, 3);
        iconCompat.f1165f = versionedParcel.a(iconCompat.f1165f, 4);
        iconCompat.g = versionedParcel.a(iconCompat.g, 5);
        iconCompat.h = (ColorStateList) versionedParcel.a(iconCompat.h, 6);
        iconCompat.j = versionedParcel.a(iconCompat.j, 7);
        iconCompat.d();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.a(true, true);
        iconCompat.a(versionedParcel.c());
        int i = iconCompat.f1161b;
        if (-1 != i) {
            versionedParcel.b(i, 1);
        }
        byte[] bArr = iconCompat.f1163d;
        if (bArr != null) {
            versionedParcel.b(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1164e;
        if (parcelable != null) {
            versionedParcel.b(parcelable, 3);
        }
        int i2 = iconCompat.f1165f;
        if (i2 != 0) {
            versionedParcel.b(i2, 4);
        }
        int i3 = iconCompat.g;
        if (i3 != 0) {
            versionedParcel.b(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.h;
        if (colorStateList != null) {
            versionedParcel.b(colorStateList, 6);
        }
        String str = iconCompat.j;
        if (str != null) {
            versionedParcel.b(str, 7);
        }
    }
}
