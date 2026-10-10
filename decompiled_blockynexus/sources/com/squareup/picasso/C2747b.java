package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import io.rong.common.LibStorageUtils;
import java.io.IOException;

/* JADX INFO: renamed from: com.squareup.picasso.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AssetRequestHandler.java */
/* JADX INFO: loaded from: classes5.dex */
class C2747b extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f19281a = 22;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f19282b;

    public C2747b(Context context) {
        this.f19282b = context.getAssets();
    }

    static String c(C c2) {
        return c2.f19213e.toString().substring(f19281a);
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        Uri uri = c2.f19213e;
        return LibStorageUtils.FILE.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        return new E.a(this.f19282b.open(c(c2)), Picasso.LoadedFrom.DISK);
    }
}
