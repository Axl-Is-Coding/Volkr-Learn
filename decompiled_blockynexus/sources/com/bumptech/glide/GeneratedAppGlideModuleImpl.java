package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.sandboxol.common.base.app.BaseAppGlideModule;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaseAppGlideModule f4072a = new BaseAppGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.sandboxol.common.base.app.BaseAppGlideModule");
        }
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public Set<Class<?>> a() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.b.a
    public void applyOptions(Context context, e eVar) {
        this.f4072a.applyOptions(context, eVar);
    }

    @Override // com.bumptech.glide.b.a
    public boolean isManifestParsingEnabled() {
        return this.f4072a.isManifestParsingEnabled();
    }

    @Override // com.bumptech.glide.b.d
    public void registerComponents(Context context, c cVar, Registry registry) {
        this.f4072a.registerComponents(context, cVar, registry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public a b() {
        return new a();
    }
}
