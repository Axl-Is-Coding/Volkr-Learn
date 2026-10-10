package androidx.media;

import androidx.media.E;

/* JADX INFO: compiled from: VolumeProviderCompat.java */
/* JADX INFO: loaded from: classes.dex */
class C implements E.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VolumeProviderCompat f1662a;

    C(VolumeProviderCompat volumeProviderCompat) {
        this.f1662a = volumeProviderCompat;
    }

    @Override // androidx.media.E.a
    public void a(int i) {
        this.f1662a.b(i);
    }

    @Override // androidx.media.E.a
    public void b(int i) {
        this.f1662a.a(i);
    }
}
