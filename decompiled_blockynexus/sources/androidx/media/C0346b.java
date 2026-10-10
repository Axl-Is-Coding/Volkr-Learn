package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* JADX INFO: renamed from: androidx.media.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AudioAttributesImplApi21.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class C0346b implements InterfaceC0345a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AudioAttributes f1698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1699b = -1;

    C0346b() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0346b) {
            return this.f1698a.equals(((C0346b) obj).f1698a);
        }
        return false;
    }

    public int hashCode() {
        return this.f1698a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1698a;
    }
}
