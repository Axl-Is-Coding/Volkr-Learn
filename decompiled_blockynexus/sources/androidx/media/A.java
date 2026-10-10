package androidx.media;

import android.media.session.MediaSessionManager;

/* JADX INFO: compiled from: MediaSessionManagerImplApi28.java */
/* JADX INFO: loaded from: classes.dex */
final class A implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f1655a;

    A(String str, int i, int i2) {
        this.f1655a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof A) {
            return this.f1655a.equals(((A) obj).f1655a);
        }
        return false;
    }

    public int hashCode() {
        return androidx.core.f.c.a(this.f1655a);
    }

    A(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f1655a = remoteUserInfo;
    }
}
