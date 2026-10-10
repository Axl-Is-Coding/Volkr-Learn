package com.sandboxol.common.base.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.k;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.i;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.f;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class GlideRequests extends k {
    public GlideRequests(com.bumptech.glide.c cVar, i iVar, n nVar, Context context) {
        super(cVar, iVar, nVar, context);
    }

    @Override // com.bumptech.glide.k
    public /* bridge */ /* synthetic */ k addDefaultRequestListener(e eVar) {
        return addDefaultRequestListener((e<Object>) eVar);
    }

    @Override // com.bumptech.glide.k
    protected void setRequestOptions(f fVar) {
        if (fVar instanceof GlideOptions) {
            super.setRequestOptions(fVar);
        } else {
            super.setRequestOptions(new GlideOptions().apply((com.bumptech.glide.request.a<?>) fVar));
        }
    }

    @Override // com.bumptech.glide.k
    public GlideRequests addDefaultRequestListener(e<Object> eVar) {
        super.addDefaultRequestListener(eVar);
        return this;
    }

    @Override // com.bumptech.glide.k
    public synchronized GlideRequests applyDefaultRequestOptions(f fVar) {
        super.applyDefaultRequestOptions(fVar);
        return this;
    }

    @Override // com.bumptech.glide.k
    public <ResourceType> GlideRequest<ResourceType> as(Class<ResourceType> cls) {
        return new GlideRequest<>(this.glide, this, cls, this.context);
    }

    @Override // com.bumptech.glide.k
    public GlideRequest<Bitmap> asBitmap() {
        return (GlideRequest) super.asBitmap();
    }

    @Override // com.bumptech.glide.k
    public GlideRequest<Drawable> asDrawable() {
        return (GlideRequest) super.asDrawable();
    }

    @Override // com.bumptech.glide.k
    public GlideRequest<File> asFile() {
        return (GlideRequest) super.asFile();
    }

    @Override // com.bumptech.glide.k
    public GlideRequest<GifDrawable> asGif() {
        return (GlideRequest) super.asGif();
    }

    @Override // com.bumptech.glide.k
    public GlideRequest<File> download(Object obj) {
        return (GlideRequest) super.download(obj);
    }

    @Override // com.bumptech.glide.k
    public GlideRequest<File> downloadOnly() {
        return (GlideRequest) super.downloadOnly();
    }

    @Override // com.bumptech.glide.k
    public synchronized GlideRequests setDefaultRequestOptions(f fVar) {
        super.setDefaultRequestOptions(fVar);
        return this;
    }

    @Override // com.bumptech.glide.k
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo49load(Bitmap bitmap) {
        return (GlideRequest) super.mo49load(bitmap);
    }

    @Override // com.bumptech.glide.k
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo50load(Drawable drawable) {
        return (GlideRequest) super.mo50load(drawable);
    }

    @Override // com.bumptech.glide.k
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo55load(String str) {
        return (GlideRequest) super.mo55load(str);
    }

    @Override // com.bumptech.glide.k
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo51load(Uri uri) {
        return (GlideRequest) super.mo51load(uri);
    }

    @Override // com.bumptech.glide.k
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo52load(File file) {
        return (GlideRequest) super.mo52load(file);
    }

    @Override // com.bumptech.glide.k
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo53load(Integer num) {
        return (GlideRequest) super.mo53load(num);
    }

    @Override // com.bumptech.glide.k
    @Deprecated
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo56load(URL url) {
        return (GlideRequest) super.mo56load(url);
    }

    @Override // com.bumptech.glide.k
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo57load(byte[] bArr) {
        return (GlideRequest) super.mo57load(bArr);
    }

    @Override // com.bumptech.glide.k
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo54load(Object obj) {
        return (GlideRequest) super.mo54load(obj);
    }
}
