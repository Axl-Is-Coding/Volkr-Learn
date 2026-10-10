package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static C0346b read(VersionedParcel versionedParcel) {
        C0346b c0346b = new C0346b();
        c0346b.f1698a = (AudioAttributes) versionedParcel.a(c0346b.f1698a, 1);
        c0346b.f1699b = versionedParcel.a(c0346b.f1699b, 2);
        return c0346b;
    }

    public static void write(C0346b c0346b, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b(c0346b.f1698a, 1);
        versionedParcel.b(c0346b.f1699b, 2);
    }
}
