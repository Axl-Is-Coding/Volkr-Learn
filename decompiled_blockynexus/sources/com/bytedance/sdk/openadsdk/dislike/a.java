package com.bytedance.sdk.openadsdk.dislike;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.List;

/* JADX INFO: compiled from: DislikeDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p<com.bytedance.sdk.openadsdk.c.a> f6704b = o.f();

    private a() {
    }

    public static a a() {
        if (f6703a == null) {
            synchronized (a.class) {
                if (f6703a == null) {
                    f6703a = new a();
                }
            }
        }
        return f6703a;
    }

    public void a(h hVar, List<FilterWord> list) {
        this.f6704b.a(hVar, list);
    }
}
