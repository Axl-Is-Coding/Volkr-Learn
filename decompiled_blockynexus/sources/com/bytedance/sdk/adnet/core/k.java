package com.bytedance.sdk.adnet.core;

import android.content.Context;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.File;

/* JADX INFO: compiled from: QueueManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public static l a(Context context) {
        return a(context, (IHttpStack) null);
    }

    public static l a(Context context, IHttpStack iHttpStack) {
        if (iHttpStack == null) {
            iHttpStack = new j();
        }
        return a(context, new a(iHttpStack));
    }

    private static l a(Context context, com.bytedance.sdk.adnet.face.b bVar) {
        l lVar = new l(new f(new File(com.bytedance.sdk.adnet.a.b(context), "reqQueue")), bVar);
        lVar.a();
        return lVar;
    }
}
