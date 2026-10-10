package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadq extends zzaed {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzddk;
    private final double zzddl;

    public zzadq(Drawable drawable, Uri uri, double d2, int i, int i2) {
        this.zzddk = drawable;
        this.uri = uri;
        this.zzddl = d2;
        this.width = i;
        this.height = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final int getHeight() {
        return this.height;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final double getScale() {
        return this.zzddl;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final Uri getUri() throws RemoteException {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final int getWidth() {
        return this.width;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final IObjectWrapper zzsg() throws RemoteException {
        return ObjectWrapper.wrap(this.zzddk);
    }
}
