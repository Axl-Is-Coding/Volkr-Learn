package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import com.bumptech.glide.e.n;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class i<TranscodeType> extends com.bumptech.glide.request.a<i<TranscodeType>> implements Cloneable, g<i<TranscodeType>> {
    protected static final com.bumptech.glide.request.f DOWNLOAD_ONLY_OPTIONS = new com.bumptech.glide.request.f().diskCacheStrategy(p.f4583c).priority(Priority.LOW).skipMemoryCache(true);
    private final Context context;
    private i<TranscodeType> errorBuilder;
    private final c glide;
    private final f glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private Object model;
    private List<com.bumptech.glide.request.e<TranscodeType>> requestListeners;
    private final k requestManager;
    private Float thumbSizeMultiplier;
    private i<TranscodeType> thumbnailBuilder;
    private final Class<TranscodeType> transcodeClass;
    private l<?, ? super TranscodeType> transitionOptions;

    @SuppressLint({"CheckResult"})
    protected i(c cVar, k kVar, Class<TranscodeType> cls, Context context) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = cVar;
        this.requestManager = kVar;
        this.transcodeClass = cls;
        this.context = context;
        this.transitionOptions = kVar.getDefaultTransitionOptions(cls);
        this.glideContext = cVar.f();
        initRequestListeners(kVar.getDefaultRequestListeners());
        apply((com.bumptech.glide.request.a<?>) kVar.getDefaultRequestOptions());
    }

    private com.bumptech.glide.request.d buildRequest(Target<TranscodeType> target, com.bumptech.glide.request.e<TranscodeType> eVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return buildRequestRecursive(new Object(), target, eVar, null, this.transitionOptions, aVar.getPriority(), aVar.getOverrideWidth(), aVar.getOverrideHeight(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.request.d buildRequestRecursive(Object obj, Target<TranscodeType> target, com.bumptech.glide.request.e<TranscodeType> eVar, RequestCoordinator requestCoordinator, l<?, ? super TranscodeType> lVar, Priority priority, int i, int i2, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        RequestCoordinator requestCoordinator2;
        RequestCoordinator bVar;
        if (this.errorBuilder != null) {
            bVar = new com.bumptech.glide.request.b(obj, requestCoordinator);
            requestCoordinator2 = bVar;
        } else {
            requestCoordinator2 = null;
            bVar = requestCoordinator;
        }
        com.bumptech.glide.request.d dVarBuildThumbnailRequestRecursive = buildThumbnailRequestRecursive(obj, target, eVar, bVar, lVar, priority, i, i2, aVar, executor);
        if (requestCoordinator2 == null) {
            return dVarBuildThumbnailRequestRecursive;
        }
        int overrideWidth = this.errorBuilder.getOverrideWidth();
        int overrideHeight = this.errorBuilder.getOverrideHeight();
        if (n.b(i, i2) && !this.errorBuilder.isValidOverride()) {
            overrideWidth = aVar.getOverrideWidth();
            overrideHeight = aVar.getOverrideHeight();
        }
        i<TranscodeType> iVar = this.errorBuilder;
        com.bumptech.glide.request.b bVar2 = requestCoordinator2;
        bVar2.a(dVarBuildThumbnailRequestRecursive, iVar.buildRequestRecursive(obj, target, eVar, bVar2, iVar.transitionOptions, iVar.getPriority(), overrideWidth, overrideHeight, this.errorBuilder, executor));
        return bVar2;
    }

    private com.bumptech.glide.request.d buildThumbnailRequestRecursive(Object obj, Target<TranscodeType> target, com.bumptech.glide.request.e<TranscodeType> eVar, RequestCoordinator requestCoordinator, l<?, ? super TranscodeType> lVar, Priority priority, int i, int i2, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        i<TranscodeType> iVar = this.thumbnailBuilder;
        if (iVar == null) {
            if (this.thumbSizeMultiplier == null) {
                return obtainRequest(obj, target, eVar, aVar, requestCoordinator, lVar, priority, i, i2, executor);
            }
            com.bumptech.glide.request.h hVar = new com.bumptech.glide.request.h(obj, requestCoordinator);
            hVar.a(obtainRequest(obj, target, eVar, aVar, hVar, lVar, priority, i, i2, executor), obtainRequest(obj, target, eVar, aVar.mo39clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), hVar, lVar, getThumbnailPriority(priority), i, i2, executor));
            return hVar;
        }
        if (this.isThumbnailBuilt) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        l<?, ? super TranscodeType> lVar2 = iVar.isDefaultTransitionOptionsSet ? lVar : iVar.transitionOptions;
        Priority priority2 = this.thumbnailBuilder.isPrioritySet() ? this.thumbnailBuilder.getPriority() : getThumbnailPriority(priority);
        int overrideWidth = this.thumbnailBuilder.getOverrideWidth();
        int overrideHeight = this.thumbnailBuilder.getOverrideHeight();
        if (n.b(i, i2) && !this.thumbnailBuilder.isValidOverride()) {
            overrideWidth = aVar.getOverrideWidth();
            overrideHeight = aVar.getOverrideHeight();
        }
        com.bumptech.glide.request.h hVar2 = new com.bumptech.glide.request.h(obj, requestCoordinator);
        com.bumptech.glide.request.d dVarObtainRequest = obtainRequest(obj, target, eVar, aVar, hVar2, lVar, priority, i, i2, executor);
        this.isThumbnailBuilt = true;
        i<TranscodeType> iVar2 = this.thumbnailBuilder;
        com.bumptech.glide.request.d dVarBuildRequestRecursive = iVar2.buildRequestRecursive(obj, target, eVar, hVar2, lVar2, priority2, overrideWidth, overrideHeight, iVar2, executor);
        this.isThumbnailBuilt = false;
        hVar2.a(dVarObtainRequest, dVarBuildRequestRecursive);
        return hVar2;
    }

    private Priority getThumbnailPriority(Priority priority) {
        int i = h.f4208b[priority.ordinal()];
        if (i == 1) {
            return Priority.NORMAL;
        }
        if (i == 2) {
            return Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + getPriority());
    }

    @SuppressLint({"CheckResult"})
    private void initRequestListeners(List<com.bumptech.glide.request.e<Object>> list) {
        Iterator<com.bumptech.glide.request.e<Object>> it = list.iterator();
        while (it.hasNext()) {
            addListener((com.bumptech.glide.request.e) it.next());
        }
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(com.bumptech.glide.request.a<?> aVar, com.bumptech.glide.request.d dVar) {
        return !aVar.isMemoryCacheable() && dVar.isComplete();
    }

    private i<TranscodeType> loadGeneric(Object obj) {
        this.model = obj;
        this.isModelSet = true;
        return this;
    }

    private com.bumptech.glide.request.d obtainRequest(Object obj, Target<TranscodeType> target, com.bumptech.glide.request.e<TranscodeType> eVar, com.bumptech.glide.request.a<?> aVar, RequestCoordinator requestCoordinator, l<?, ? super TranscodeType> lVar, Priority priority, int i, int i2, Executor executor) {
        Context context = this.context;
        f fVar = this.glideContext;
        return SingleRequest.a(context, fVar, obj, this.model, this.transcodeClass, aVar, i, i2, priority, target, eVar, this.requestListeners, requestCoordinator, fVar.d(), lVar.b(), executor);
    }

    public i<TranscodeType> addListener(com.bumptech.glide.request.e<TranscodeType> eVar) {
        if (eVar != null) {
            if (this.requestListeners == null) {
                this.requestListeners = new ArrayList();
            }
            this.requestListeners.add(eVar);
        }
        return this;
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a apply(com.bumptech.glide.request.a aVar) {
        return apply((com.bumptech.glide.request.a<?>) aVar);
    }

    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(Y y) {
        return (Y) getDownloadOnlyRequest().into(y);
    }

    public i<TranscodeType> error(i<TranscodeType> iVar) {
        this.errorBuilder = iVar;
        return this;
    }

    protected i<File> getDownloadOnlyRequest() {
        return new i(File.class, this).apply((com.bumptech.glide.request.a<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    public <Y extends Target<TranscodeType>> Y into(Y y) {
        return (Y) into(y, null, com.bumptech.glide.e.g.b());
    }

    public i<TranscodeType> listener(com.bumptech.glide.request.e<TranscodeType> eVar) {
        this.requestListeners = null;
        return addListener(eVar);
    }

    public Target<TranscodeType> preload(int i, int i2) {
        return into(com.bumptech.glide.request.target.g.a(this.requestManager, i, i2));
    }

    public com.bumptech.glide.request.c<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public i<TranscodeType> thumbnail(i<TranscodeType> iVar) {
        this.thumbnailBuilder = iVar;
        return this;
    }

    public i<TranscodeType> transition(l<?, ? super TranscodeType> lVar) {
        com.bumptech.glide.e.l.a(lVar);
        this.transitionOptions = lVar;
        this.isDefaultTransitionOptionsSet = false;
        return this;
    }

    @Override // com.bumptech.glide.request.a
    public i<TranscodeType> apply(com.bumptech.glide.request.a<?> aVar) {
        com.bumptech.glide.e.l.a(aVar);
        return (i) super.apply(aVar);
    }

    @Deprecated
    public com.bumptech.glide.request.c<File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().submit(i, i2);
    }

    <Y extends Target<TranscodeType>> Y into(Y y, com.bumptech.glide.request.e<TranscodeType> eVar, Executor executor) {
        into(y, eVar, this, executor);
        return y;
    }

    public com.bumptech.glide.request.c<TranscodeType> submit(int i, int i2) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i, i2);
        return (com.bumptech.glide.request.c) into(requestFutureTarget, requestFutureTarget, com.bumptech.glide.e.g.a());
    }

    public i<TranscodeType> thumbnail(i<TranscodeType>... iVarArr) {
        i<TranscodeType> iVarThumbnail = null;
        if (iVarArr == null || iVarArr.length == 0) {
            return thumbnail((i) null);
        }
        for (int length = iVarArr.length - 1; length >= 0; length--) {
            i<TranscodeType> iVar = iVarArr[length];
            if (iVar != null) {
                iVarThumbnail = iVarThumbnail == null ? iVar : iVar.thumbnail(iVarThumbnail);
            }
        }
        return thumbnail(iVarThumbnail);
    }

    private <Y extends Target<TranscodeType>> Y into(Y y, com.bumptech.glide.request.e<TranscodeType> eVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        com.bumptech.glide.e.l.a(y);
        if (this.isModelSet) {
            com.bumptech.glide.request.d dVarBuildRequest = buildRequest(y, eVar, aVar, executor);
            com.bumptech.glide.request.d request = y.getRequest();
            if (dVarBuildRequest.a(request) && !isSkipMemoryCacheWithCompletePreviousRequest(aVar, request)) {
                com.bumptech.glide.e.l.a(request);
                if (!request.isRunning()) {
                    request.begin();
                }
                return y;
            }
            this.requestManager.clear((Target<?>) y);
            y.setRequest(dVarBuildRequest);
            this.requestManager.track(y, dVarBuildRequest);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @Override // com.bumptech.glide.request.a
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo39clone() {
        i<TranscodeType> iVar = (i) super.mo39clone();
        iVar.transitionOptions = iVar.transitionOptions.m58clone();
        return iVar;
    }

    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public i<TranscodeType> thumbnail(float f2) {
        if (f2 >= WheelView.DividerConfig.FILL && f2 <= 1.0f) {
            this.thumbSizeMultiplier = Float.valueOf(f2);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo45load(Object obj) {
        loadGeneric(obj);
        return this;
    }

    @SuppressLint({"CheckResult"})
    protected i(Class<TranscodeType> cls, i<?> iVar) {
        this(iVar.glide, iVar.requestManager, cls, iVar.context);
        this.model = iVar.model;
        this.isModelSet = iVar.isModelSet;
        apply((com.bumptech.glide.request.a<?>) iVar);
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo40load(Bitmap bitmap) {
        loadGeneric(bitmap);
        return apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.diskCacheStrategyOf(p.f4582b));
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo41load(Drawable drawable) {
        loadGeneric(drawable);
        return apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.diskCacheStrategyOf(p.f4582b));
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo46load(String str) {
        loadGeneric(str);
        return this;
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo42load(Uri uri) {
        loadGeneric(uri);
        return this;
    }

    public ViewTarget<ImageView, TranscodeType> into(ImageView imageView) {
        com.bumptech.glide.request.a aVarOptionalCenterCrop;
        n.b();
        com.bumptech.glide.e.l.a(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (h.f4207a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarOptionalCenterCrop = mo39clone().optionalCenterCrop();
                    break;
                case 2:
                    aVarOptionalCenterCrop = mo39clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarOptionalCenterCrop = mo39clone().optionalFitCenter();
                    break;
                case 6:
                    aVarOptionalCenterCrop = mo39clone().optionalCenterInside();
                    break;
                default:
                    aVarOptionalCenterCrop = this;
                    break;
            }
        } else {
            aVarOptionalCenterCrop = this;
        }
        ViewTarget<ImageView, TranscodeType> viewTargetA = this.glideContext.a(imageView, this.transcodeClass);
        into(viewTargetA, null, aVarOptionalCenterCrop, com.bumptech.glide.e.g.b());
        return viewTargetA;
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo43load(File file) {
        loadGeneric(file);
        return this;
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo44load(Integer num) {
        loadGeneric(num);
        return apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.signatureOf(com.bumptech.glide.d.a.a(this.context)));
    }

    @Override // 
    @Deprecated
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo47load(URL url) {
        loadGeneric(url);
        return this;
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> mo48load(byte[] bArr) {
        loadGeneric(bArr);
        i<TranscodeType> iVarApply = !isDiskCacheStrategySet() ? apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.diskCacheStrategyOf(p.f4582b)) : this;
        return !iVarApply.isSkipMemoryCacheSet() ? iVarApply.apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.skipMemoryCacheOf(true)) : iVarApply;
    }

    @Deprecated
    public com.bumptech.glide.request.c<TranscodeType> into(int i, int i2) {
        return submit(i, i2);
    }
}
