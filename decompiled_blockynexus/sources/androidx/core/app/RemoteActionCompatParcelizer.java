package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f958a = (IconCompat) versionedParcel.a(remoteActionCompat.f958a, 1);
        remoteActionCompat.f959b = versionedParcel.a(remoteActionCompat.f959b, 2);
        remoteActionCompat.f960c = versionedParcel.a(remoteActionCompat.f960c, 3);
        remoteActionCompat.f961d = (PendingIntent) versionedParcel.a(remoteActionCompat.f961d, 4);
        remoteActionCompat.f962e = versionedParcel.a(remoteActionCompat.f962e, 5);
        remoteActionCompat.f963f = versionedParcel.a(remoteActionCompat.f963f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b(remoteActionCompat.f958a, 1);
        versionedParcel.b(remoteActionCompat.f959b, 2);
        versionedParcel.b(remoteActionCompat.f960c, 3);
        versionedParcel.b(remoteActionCompat.f961d, 4);
        versionedParcel.b(remoteActionCompat.f962e, 5);
        versionedParcel.b(remoteActionCompat.f963f, 6);
    }
}
