package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.n;
import com.sandboxol.common.base.app.GlideRequests;

/* JADX INFO: compiled from: GeneratedRequestManagerFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class a implements m.a {
    a() {
    }

    @Override // com.bumptech.glide.manager.m.a
    public k a(c cVar, com.bumptech.glide.manager.i iVar, n nVar, Context context) {
        return new GlideRequests(cVar, iVar, nVar, context);
    }
}
