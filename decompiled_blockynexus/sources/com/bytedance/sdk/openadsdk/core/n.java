package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: InteractionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.d.h f6253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.a.a.a.a.a.b f6254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f6255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TTNativeAd f6256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<View> f6257e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f6258f;
    private TTNativeAd.AdInteractionListener g;

    public n(Context context, TTNativeAd tTNativeAd, com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        this.f6258f = "embeded_ad";
        this.f6256d = tTNativeAd;
        this.f6253a = hVar;
        this.f6255c = context;
        this.f6258f = str;
        if (this.f6253a.x() == 4) {
            this.f6254b = b.a.a.a.a.a.c.a(this.f6255c, this.f6253a, this.f6258f);
        }
    }

    public void a(View view, int i) {
        TTNativeAd.AdInteractionListener adInteractionListener = this.g;
        if (adInteractionListener != null) {
            adInteractionListener.onAdCreativeClick(view, this.f6256d);
        }
    }

    public void a(final ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, final TTNativeAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
        this.f6257e = list;
        com.bytedance.sdk.openadsdk.c.d.a(this.f6253a);
        EmptyView emptyViewA = a(viewGroup);
        if (emptyViewA == null) {
            emptyViewA = new EmptyView(this.f6255c, viewGroup);
            viewGroup.addView(emptyViewA);
        }
        emptyViewA.a();
        emptyViewA.setRefClickViews(list2);
        emptyViewA.setRefCreativeViews(list3);
        Context context = this.f6255c;
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f6253a;
        String str = this.f6258f;
        com.bytedance.sdk.openadsdk.core.a.b bVar = new com.bytedance.sdk.openadsdk.core.a.b(context, hVar, str, ab.a(str));
        bVar.a(viewGroup);
        bVar.b(view);
        bVar.a(this.f6254b);
        bVar.a(this.f6256d);
        bVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view2, int i) {
                TTNativeAd.AdInteractionListener adInteractionListener2 = adInteractionListener;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onAdClicked(view2, n.this.f6256d);
                }
            }
        });
        Context context2 = this.f6255c;
        com.bytedance.sdk.openadsdk.core.d.h hVar2 = this.f6253a;
        String str2 = this.f6258f;
        com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(context2, hVar2, str2, ab.a(str2));
        aVar.a(viewGroup);
        aVar.b(view);
        aVar.a(this.f6254b);
        aVar.a(this.f6256d);
        aVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.n.2
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view2, int i) {
                TTNativeAd.AdInteractionListener adInteractionListener2 = adInteractionListener;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onAdCreativeClick(view2, n.this.f6256d);
                }
            }
        });
        emptyViewA.a(list2, bVar);
        emptyViewA.a(list3, aVar);
        emptyViewA.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.n.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view2) {
                HashMap map = new HashMap();
                if (n.this.f6257e != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (View view3 : n.this.f6257e) {
                        if (view3 != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view3.getWidth());
                                jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view3.getHeight());
                                jSONObject.put("alpha", view3.getAlpha());
                            } catch (Throwable unused) {
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                    map.put("image_view", jSONArray.toString());
                }
                if (viewGroup != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, viewGroup.getWidth());
                        jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, viewGroup.getHeight());
                        jSONObject2.put("alpha", viewGroup.getAlpha());
                    } catch (Throwable unused2) {
                    }
                    map.put("root_view", jSONObject2.toString());
                }
                com.bytedance.sdk.openadsdk.c.d.a(n.this.f6255c, n.this.f6253a, n.this.f6258f, map);
                TTNativeAd.AdInteractionListener adInteractionListener2 = adInteractionListener;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onAdShow(n.this.f6256d);
                }
                if (n.this.f6253a.R()) {
                    ab.a(n.this.f6253a, view2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }
        });
        emptyViewA.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
