package com.sandboxol.common.base.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Priority;
import com.bumptech.glide.i;
import com.bumptech.glide.l;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.o;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.e;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class GlideRequest<TranscodeType> extends i<TranscodeType> implements Cloneable {
    GlideRequest(Class<TranscodeType> cls, i<?> iVar) {
        super(cls, iVar);
    }

    @Override // com.bumptech.glide.i, com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ i apply(com.bumptech.glide.request.a aVar) {
        return apply((com.bumptech.glide.request.a<?>) aVar);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a decode(Class cls) {
        return decode((Class<?>) cls);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a optionalTransform(o oVar) {
        return optionalTransform((o<Bitmap>) oVar);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a set(k kVar, Object obj) {
        return set((k<Object>) kVar, obj);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transform(o oVar) {
        return transform((o<Bitmap>) oVar);
    }

    @Override // com.bumptech.glide.request.a
    @Deprecated
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transforms(o[] oVarArr) {
        return transforms((o<Bitmap>[]) oVarArr);
    }

    GlideRequest(com.bumptech.glide.c cVar, com.bumptech.glide.k kVar, Class<TranscodeType> cls, Context context) {
        super(cVar, kVar, cls, context);
    }

    @Override // com.bumptech.glide.i
    public GlideRequest<TranscodeType> addListener(e<TranscodeType> eVar) {
        super.addListener((e) eVar);
        return this;
    }

    @Override // com.bumptech.glide.i, com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a apply(com.bumptech.glide.request.a aVar) {
        return apply((com.bumptech.glide.request.a<?>) aVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> centerCrop() {
        return (GlideRequest) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> centerInside() {
        return (GlideRequest) super.centerInside();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> circleCrop() {
        return (GlideRequest) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> decode(Class<?> cls) {
        return (GlideRequest) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> disallowHardwareConfig() {
        return (GlideRequest) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> diskCacheStrategy(p pVar) {
        return (GlideRequest) super.diskCacheStrategy(pVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> dontAnimate() {
        return (GlideRequest) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> dontTransform() {
        return (GlideRequest) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> downsample(DownsampleStrategy downsampleStrategy) {
        return (GlideRequest) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> encodeFormat(Bitmap.CompressFormat compressFormat) {
        return (GlideRequest) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> encodeQuality(int i) {
        return (GlideRequest) super.encodeQuality(i);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> fitCenter() {
        return (GlideRequest) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> format(DecodeFormat decodeFormat) {
        return (GlideRequest) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> frame(long j) {
        return (GlideRequest) super.frame(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.i
    public GlideRequest<File> getDownloadOnlyRequest() {
        return new GlideRequest(File.class, this).apply((com.bumptech.glide.request.a<?>) i.DOWNLOAD_ONLY_OPTIONS);
    }

    @Override // com.bumptech.glide.i
    public GlideRequest<TranscodeType> listener(e<TranscodeType> eVar) {
        return (GlideRequest) super.listener((e) eVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean z) {
        return (GlideRequest) super.onlyRetrieveFromCache(z);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> optionalCenterCrop() {
        return (GlideRequest) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> optionalCenterInside() {
        return (GlideRequest) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> optionalCircleCrop() {
        return (GlideRequest) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> optionalFitCenter() {
        return (GlideRequest) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> priority(Priority priority) {
        return (GlideRequest) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.a
    public <Y> GlideRequest<TranscodeType> set(k<Y> kVar, Y y) {
        return (GlideRequest) super.set((k) kVar, (Object) y);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> signature(h hVar) {
        return (GlideRequest) super.signature(hVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> sizeMultiplier(float f2) {
        return (GlideRequest) super.sizeMultiplier(f2);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> skipMemoryCache(boolean z) {
        return (GlideRequest) super.skipMemoryCache(z);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> theme(Resources.Theme theme) {
        return (GlideRequest) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> timeout(int i) {
        return (GlideRequest) super.timeout(i);
    }

    @Override // com.bumptech.glide.request.a
    @Deprecated
    public GlideRequest<TranscodeType> transforms(o<Bitmap>... oVarArr) {
        return (GlideRequest) super.transforms(oVarArr);
    }

    @Override // com.bumptech.glide.i
    public GlideRequest<TranscodeType> transition(l<?, ? super TranscodeType> lVar) {
        super.transition((l) lVar);
        return this;
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> useAnimationPool(boolean z) {
        return (GlideRequest) super.useAnimationPool(z);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z) {
        return (GlideRequest) super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override // com.bumptech.glide.i, com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> apply(com.bumptech.glide.request.a<?> aVar) {
        return (GlideRequest) super.apply(aVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> fallback(Drawable drawable) {
        return (GlideRequest) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> optionalTransform(o<Bitmap> oVar) {
        return (GlideRequest) super.optionalTransform(oVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> override(int i, int i2) {
        return (GlideRequest) super.override(i, i2);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> placeholder(Drawable drawable) {
        return (GlideRequest) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transform(o[] oVarArr) {
        return transform((o<Bitmap>[]) oVarArr);
    }

    @Override // com.bumptech.glide.i, com.bumptech.glide.request.a
    /* JADX INFO: renamed from: clone */
    public GlideRequest<TranscodeType> mo39clone() {
        return (GlideRequest) super.mo39clone();
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> error(Drawable drawable) {
        return (GlideRequest) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> fallback(int i) {
        return (GlideRequest) super.fallback(i);
    }

    @Override // com.bumptech.glide.request.a
    public <Y> GlideRequest<TranscodeType> optionalTransform(Class<Y> cls, o<Y> oVar) {
        return (GlideRequest) super.optionalTransform((Class) cls, (o) oVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> override(int i) {
        return (GlideRequest) super.override(i);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> placeholder(int i) {
        return (GlideRequest) super.placeholder(i);
    }

    @Override // com.bumptech.glide.i
    public GlideRequest<TranscodeType> thumbnail(i<TranscodeType> iVar) {
        super.thumbnail((i) iVar);
        return this;
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> transform(o<Bitmap> oVar) {
        return (GlideRequest) super.transform(oVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> error(int i) {
        return (GlideRequest) super.error(i);
    }

    @Override // com.bumptech.glide.i
    @SafeVarargs
    public final GlideRequest<TranscodeType> thumbnail(i<TranscodeType>... iVarArr) {
        return (GlideRequest) super.thumbnail((i[]) iVarArr);
    }

    @Override // com.bumptech.glide.request.a
    public GlideRequest<TranscodeType> transform(o<Bitmap>... oVarArr) {
        return (GlideRequest) super.transform(oVarArr);
    }

    @Override // com.bumptech.glide.i
    public GlideRequest<TranscodeType> error(i<TranscodeType> iVar) {
        super.error((i) iVar);
        return this;
    }

    @Override // com.bumptech.glide.i
    public GlideRequest<TranscodeType> thumbnail(float f2) {
        super.thumbnail(f2);
        return this;
    }

    @Override // com.bumptech.glide.request.a
    public <Y> GlideRequest<TranscodeType> transform(Class<Y> cls, o<Y> oVar) {
        return (GlideRequest) super.transform((Class) cls, (o) oVar);
    }

    @Override // com.bumptech.glide.i
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo45load(Object obj) {
        super.mo45load(obj);
        return this;
    }

    @Override // com.bumptech.glide.i
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo40load(Bitmap bitmap) {
        return (GlideRequest) super.mo40load(bitmap);
    }

    @Override // com.bumptech.glide.i
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo41load(Drawable drawable) {
        return (GlideRequest) super.mo41load(drawable);
    }

    @Override // com.bumptech.glide.i
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo46load(String str) {
        super.mo46load(str);
        return this;
    }

    @Override // com.bumptech.glide.i
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo42load(Uri uri) {
        super.mo42load(uri);
        return this;
    }

    @Override // com.bumptech.glide.i
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo43load(File file) {
        super.mo43load(file);
        return this;
    }

    @Override // com.bumptech.glide.i
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo44load(Integer num) {
        return (GlideRequest) super.mo44load(num);
    }

    @Override // com.bumptech.glide.i
    @Deprecated
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo47load(URL url) {
        super.mo47load(url);
        return this;
    }

    @Override // com.bumptech.glide.i
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo48load(byte[] bArr) {
        return (GlideRequest) super.mo48load(bArr);
    }
}
