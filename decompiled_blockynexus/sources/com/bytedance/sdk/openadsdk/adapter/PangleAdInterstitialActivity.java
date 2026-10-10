package com.bytedance.sdk.openadsdk.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.CustomEventInterstitialListener;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PangleAdInterstitialActivity extends Activity {
    public static final String INTENT_TYPE = "intent_type";
    public static final int INTENT_TYPE_IMAGE_2_3 = 2;
    public static final int INTENT_TYPE_IMAGE_3_2 = 1;
    private static CustomEventInterstitialListener n;
    private static TTNativeAd o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f5727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RelativeLayout f5728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NiceImageView f5729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f5730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f5731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f5732f;
    private TTRatingBar g;
    private Intent h;
    private ViewGroup i;
    private RelativeLayout j;
    private ViewGroup k;
    private float l;
    private float m;

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.adapter.PangleAdInterstitialActivity.b():void");
    }

    private void c() {
        this.f5728b.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.adapter.PangleAdInterstitialActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PangleAdInterstitialActivity.this.finish();
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialDismissed();
                }
            }
        });
    }

    private void d() {
        this.g = (TTRatingBar) findViewById(t.e(this, "tt_pangle_ad_score"));
        TTRatingBar tTRatingBar = this.g;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.g.setStarFillNum(4);
            this.g.setStarImageWidth(ac.c(getApplicationContext(), 15.0f));
            this.g.setStarImageHeight(ac.c(getApplicationContext(), 14.0f));
            this.g.setStarImagePadding(ac.c(getApplicationContext(), 4.0f));
            this.g.a();
        }
        this.f5727a = (ImageView) findViewById(t.e(this, "tt_pangle_ad_main_img"));
        this.f5728b = (RelativeLayout) findViewById(t.e(this, "tt_pangle_ad_close_layout"));
        this.f5729c = (NiceImageView) findViewById(t.e(this, "tt_pangle_ad_icon"));
        this.f5730d = (TextView) findViewById(t.e(this, "tt_pangle_ad_title"));
        this.f5731e = (TextView) findViewById(t.e(this, "tt_pangle_ad_content"));
        this.f5732f = (Button) findViewById(t.e(this, "tt_pangle_ad_btn"));
        this.i = (ViewGroup) findViewById(t.e(this, "tt_pangle_ad_content_layout"));
        this.j = (RelativeLayout) findViewById(t.e(this, "tt_pangle_ad_image_layout"));
        this.k = (ViewGroup) findViewById(t.e(this, "tt_pangle_ad_root"));
    }

    public static void showAd(Context context, TTNativeAd tTNativeAd, int i, CustomEventInterstitialListener customEventInterstitialListener) {
        o = tTNativeAd;
        n = customEventInterstitialListener;
        Intent intent = new Intent(context, (Class<?>) PangleAdInterstitialActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(INTENT_TYPE, i);
        b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.adapter.PangleAdInterstitialActivity.1
            @Override // com.bytedance.sdk.openadsdk.utils.b.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.b.a
            public void a(Throwable th) {
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialShowFail();
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = getIntent();
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        o = null;
        n = null;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.l = ac.c((Context) this);
        this.m = ac.d(this);
        if (this.h.getIntExtra(INTENT_TYPE, 0) == 2) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        if (this.h != null) {
            b();
        }
    }

    private void a(int i) {
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.height = i;
        this.j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
        layoutParams2.height = (int) (this.m - i);
        this.i.setLayoutParams(layoutParams2);
    }

    private void a(TTNativeAd tTNativeAd) {
        TTImage tTImage;
        if (tTNativeAd != null) {
            if (o.getImageList() != null && !o.getImageList().isEmpty() && (tTImage = o.getImageList().get(0)) != null && tTImage.isValid()) {
                d.a(this).a(tTImage.getImageUrl(), this.f5727a);
            }
            if (o.getIcon() != null && o.getIcon().isValid() && o.getIcon().getImageUrl() != null) {
                d.a(this).a(o.getIcon().getImageUrl(), this.f5729c);
            }
            this.f5730d.setText(o.getTitle());
            this.f5731e.setText(o.getDescription());
            this.f5732f.setText(o.getButtonText());
            c();
            b(tTNativeAd);
        }
    }

    private void b(TTNativeAd tTNativeAd) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f5727a);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f5732f);
        tTNativeAd.registerViewForInteraction(this.k, arrayList, arrayList2, this.f5728b, new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.adapter.PangleAdInterstitialActivity.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd tTNativeAd2) {
                o.b("PangleAdInterstitial", "PangleAdInterstitialActivity-onAdClicked....");
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd2) {
                o.b("PangleAdInterstitial", "PangleAdInterstitialActivity-onAdClicked....");
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd2) {
                o.b("PangleAdInterstitial", "PangleAdInterstitialActivity-onAdShow....");
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialShown();
                }
            }
        });
    }
}
