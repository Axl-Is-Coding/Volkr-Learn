package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
class NetworkRequestHandler extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Downloader f19256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final H f19257b;

    static class ContentLengthException extends IOException {
        public ContentLengthException(String str) {
            super(str);
        }
    }

    public NetworkRequestHandler(Downloader downloader, H h) {
        this.f19256a = downloader;
        this.f19257b = h;
    }

    @Override // com.squareup.picasso.E
    int a() {
        return 2;
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        String scheme = c2.f19213e.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // com.squareup.picasso.E
    boolean b() {
        return true;
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        Downloader.a aVarA = this.f19256a.a(c2.f19213e, c2.f19212d);
        if (aVarA == null) {
            return null;
        }
        Picasso.LoadedFrom loadedFrom = aVarA.f19229c ? Picasso.LoadedFrom.DISK : Picasso.LoadedFrom.NETWORK;
        Bitmap bitmapA = aVarA.a();
        if (bitmapA != null) {
            return new E.a(bitmapA, loadedFrom);
        }
        InputStream inputStreamC = aVarA.c();
        if (inputStreamC == null) {
            return null;
        }
        if (loadedFrom == Picasso.LoadedFrom.DISK && aVarA.b() == 0) {
            P.a(inputStreamC);
            throw new ContentLengthException("Received response with 0 content-length header.");
        }
        if (loadedFrom == Picasso.LoadedFrom.NETWORK && aVarA.b() > 0) {
            this.f19257b.a(aVarA.b());
        }
        return new E.a(inputStreamC, loadedFrom);
    }

    @Override // com.squareup.picasso.E
    boolean a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }
}
