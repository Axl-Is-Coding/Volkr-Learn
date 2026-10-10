package androidx.media;

import android.media.VolumeProvider;
import androidx.media.E;

/* JADX INFO: compiled from: VolumeProviderCompatApi21.java */
/* JADX INFO: loaded from: classes.dex */
class D extends VolumeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E.a f1663a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    D(int i, int i2, int i3, E.a aVar) {
        super(i, i2, i3);
        this.f1663a = aVar;
    }

    @Override // android.media.VolumeProvider
    public void onAdjustVolume(int i) {
        this.f1663a.b(i);
    }

    @Override // android.media.VolumeProvider
    public void onSetVolumeTo(int i) {
        this.f1663a.a(i);
    }
}
