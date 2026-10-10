package com.bytedance.sdk.openadsdk.core.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.g;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a.c;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTNativeAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements TTNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6151a;
    protected final n g;
    protected final h h;
    protected final Context i;
    protected TTAdDislike j;
    protected int k;
    protected String l;

    public a(Context context, h hVar, int i) {
        r.a(hVar, "materialMeta can't been null");
        this.h = hVar;
        this.i = context;
        this.k = i;
        this.g = new n(this.i, this, hVar, a(i));
    }

    private String a(int i) {
        return i != 1 ? i != 2 ? (i == 5 || i != 9) ? "embeded_ad" : "draw_ad" : "interaction" : "banner_ad";
    }

    private List<View> a(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return BitmapFactory.decodeResource(this.i.getResources(), t.d(o.a(), "tt_ad_logo_small"));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdLogoView() {
        Context context = this.i;
        if (context == null) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTNativeAdImpl", "getAdLogoView mContext == null");
            return null;
        }
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.tt_ad_logo_small);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.e.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showPrivacyActivity();
            }
        });
        return imageView;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        if (this.h.K() != null) {
            return this.h.K().e();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        if (this.h.K() != null) {
            return this.h.K().d();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        if (this.h.K() != null) {
            return this.h.K().f();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return this.h.I();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return !TextUtils.isEmpty(this.h.G()) ? this.h.G() : this.h.H();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.j == null) {
            a(activity);
        }
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<FilterWord> getFilterWords() {
        h hVar = this.h;
        if (hVar == null) {
            return null;
        }
        return hVar.O();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        if (this.h.y() == null) {
            return null;
        }
        return g.a(this.h.y());
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        if (this.h.B() != null && !this.h.B().isEmpty()) {
            Iterator<g> it = this.h.B().iterator();
            while (it.hasNext()) {
                arrayList.add(g.a(it.next()));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        h hVar = this.h;
        if (hVar == null) {
            return -1;
        }
        return hVar.N();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        h hVar = this.h;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.h;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return this.h.w();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return (this.h.K() == null || TextUtils.isEmpty(this.h.K().b())) ? !TextUtils.isEmpty(getSource()) ? getSource() : this.h.G() : this.h.K().b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        h hVar = this.h;
        if (hVar == null || hVar.v() == null) {
            return null;
        }
        return new TTImage(this.h.v().b(), this.h.v().c(), this.h.v().g());
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        r.a(viewGroup, "container can't been null");
        r.a(view, "clickView can't been null");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        registerViewForInteraction(viewGroup, arrayList, null, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showPrivacyActivity() {
        Context context = this.i;
        if (context != null) {
            h hVar = this.h;
            if (hVar != null) {
                d.a(context, hVar, this.l, "open_policy");
            }
            if (TextUtils.isEmpty(o.h().q())) {
                return;
            }
            b.a(this.i, new Intent(this.i, (Class<?>) TTWebsiteActivity.class), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(final TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(this.h);
            return new TTAdDislike() { // from class: com.bytedance.sdk.openadsdk.core.e.a.1
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void showDislikeDialog() {
                    if ((tTDislikeDialogAbstract.getContext() instanceof Activity) && !((Activity) tTDislikeDialogAbstract.getContext()).isFinishing()) {
                        tTDislikeDialogAbstract.show();
                    }
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        r.a(viewGroup, "container can't been null");
        r.a(list, "clickView can't been null");
        r.a(list.size() > 0, "clickViews size must been more than 1");
        registerViewForInteraction(viewGroup, list, list2, null, adInteractionListener);
    }

    private void a(Activity activity) {
        Context context = this.i;
        Context context2 = activity;
        if (context instanceof Activity) {
            context2 = activity;
            if (!((Activity) context).isFinishing()) {
                context2 = this.i;
            }
        }
        this.j = new com.bytedance.sdk.openadsdk.dislike.b(context2, this.h);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        r.a(viewGroup, "container can't been null");
        r.a(list, "clickView can't been null");
        r.a(list.size() > 0, "clickViews size must been more than 1");
        registerViewForInteraction(viewGroup, null, list, list2, view, adInteractionListener);
    }

    private void a(boolean z) {
        c cVarC = c.b().a(this.k).c(String.valueOf(ab.d(this.h.M())));
        if (z) {
            com.bytedance.sdk.openadsdk.f.a.a().d(cVarC);
        } else {
            com.bytedance.sdk.openadsdk.f.a.a().e(cVarC);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        r.a(viewGroup, "container can't been null");
        r.a(list2, "clickView can't been null");
        r.a(list2.size() > 0, "clickViews size must been more than 1");
        a(list3 != null && list3.size() > 0);
        if (a()) {
            list3 = a(list2, list3);
        }
        this.g.a(viewGroup, list, list2, list3, view, adInteractionListener);
    }

    private boolean a() {
        h hVar = this.h;
        if (hVar == null || hVar.x() == 5) {
            return false;
        }
        if (this.f6151a == 0) {
            this.f6151a = ab.d(this.h.M());
        }
        return o.h().d(this.f6151a) == 1;
    }

    protected void a(String str) {
        this.l = str;
    }
}
