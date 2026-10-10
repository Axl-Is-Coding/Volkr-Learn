package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;

/* JADX INFO: compiled from: MediaSessionManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    z f1761a;

    public y(String str, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1761a = new A(str, i, i2);
        } else {
            this.f1761a = new B(str, i, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return this.f1761a.equals(((y) obj).f1761a);
        }
        return false;
    }

    public int hashCode() {
        return this.f1761a.hashCode();
    }

    public y(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f1761a = new A(remoteUserInfo);
    }
}
