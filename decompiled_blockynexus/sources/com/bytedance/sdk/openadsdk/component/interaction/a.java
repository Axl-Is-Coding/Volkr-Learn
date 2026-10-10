package com.bytedance.sdk.openadsdk.component.interaction;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;

/* JADX INFO: compiled from: InteractionAdManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f5853a = o.f();

    private a() {
    }

    public static a a() {
        return new a();
    }

    public void a(final Context context, AdSlot adSlot, final TTAdNative.InteractionAdListener interactionAdListener) {
        this.f5853a.a(adSlot, null, 2, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.interaction.a.1
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                interactionAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    interactionAdListener.onError(-3, g.a(-3));
                    return;
                }
                h hVar = aVar.c().get(0);
                if (!hVar.W()) {
                    interactionAdListener.onError(-4, g.a(-4));
                } else {
                    final b bVar = new b(context, hVar);
                    bVar.a(new k() { // from class: com.bytedance.sdk.openadsdk.component.interaction.a.1.1
                        @Override // com.bytedance.sdk.openadsdk.core.k
                        public void a() {
                            interactionAdListener.onInteractionAdLoad(bVar);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.k
                        public void b() {
                            interactionAdListener.onError(-6, g.a(-6));
                        }
                    });
                }
            }
        });
    }
}
