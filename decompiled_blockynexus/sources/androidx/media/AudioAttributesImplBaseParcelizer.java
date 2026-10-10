package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static C0347c read(VersionedParcel versionedParcel) {
        C0347c c0347c = new C0347c();
        c0347c.f1700a = versionedParcel.a(c0347c.f1700a, 1);
        c0347c.f1701b = versionedParcel.a(c0347c.f1701b, 2);
        c0347c.f1702c = versionedParcel.a(c0347c.f1702c, 3);
        c0347c.f1703d = versionedParcel.a(c0347c.f1703d, 4);
        return c0347c;
    }

    public static void write(C0347c c0347c, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b(c0347c.f1700a, 1);
        versionedParcel.b(c0347c.f1701b, 2);
        versionedParcel.b(c0347c.f1702c, 3);
        versionedParcel.b(c0347c.f1703d, 4);
    }
}
