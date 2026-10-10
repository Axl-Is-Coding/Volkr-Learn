package com.google.android.ads.mediationtestsuite.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.ads.mediationtestsuite.AdLoadCallback;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.dataobjects.AdFormat;
import com.google.android.ads.mediationtestsuite.dataobjects.DataStore;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.ads.mediationtestsuite.dataobjects.TestResult;
import com.google.android.ads.mediationtestsuite.utils.AdManager;
import com.google.android.ads.mediationtestsuite.utils.logging.RequestEvent;
import com.google.android.ads.mediationtestsuite.utils.o;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: AdLoadViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends RecyclerView.w implements AdLoadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NetworkConfig f12695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<String> f12697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImageView f12698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f12699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f12700f;
    private final Button g;
    private final FrameLayout h;
    private final ConstraintLayout i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private AdManager m;

    public b(View view) {
        super(view);
        this.f12696b = false;
        this.f12697c = new ArrayDeque<>();
        this.f12698d = (ImageView) view.findViewById(R.id.gmts_image_view);
        this.f12699e = (TextView) view.findViewById(R.id.gmts_title_text);
        this.f12700f = (TextView) view.findViewById(R.id.gmts_detail_text);
        this.g = (Button) view.findViewById(R.id.gmts_action_button);
        this.h = (FrameLayout) view.findViewById(R.id.gmts_ad_view_frame);
        this.i = (ConstraintLayout) view.findViewById(R.id.gmts_native_assets);
        this.l = new View.OnClickListener() { // from class: com.google.android.ads.mediationtestsuite.viewmodels.AdLoadViewHolder$1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f12691a.d();
            }
        };
        this.k = new View.OnClickListener() { // from class: com.google.android.ads.mediationtestsuite.viewmodels.AdLoadViewHolder$2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f12692a.a(true);
                b bVar = this.f12692a;
                bVar.m = bVar.f12695a.getAdapter().getFormat().createAdLoader(this.f12692a.f12695a, this.f12692a);
                Context context = view2.getContext();
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext() instanceof Activity) {
                        context = contextWrapper.getBaseContext();
                    }
                }
                this.f12692a.m.a(context);
            }
        };
        this.j = new View.OnClickListener() { // from class: com.google.android.ads.mediationtestsuite.viewmodels.AdLoadViewHolder$3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.google.android.ads.mediationtestsuite.utils.logging.e.a(new com.google.android.ads.mediationtestsuite.utils.logging.f(this.f12693a.f12695a), view2.getContext());
                this.f12693a.m.c();
                this.f12693a.g.setText(R.string.gmts_button_load_ad);
                this.f12693a.b();
            }
        };
    }

    private void f() {
        this.f12700f.setText(R.string.gmts_error_no_fill_message);
    }

    private void g() {
        this.f12699e.setText(DataStore.getContext().getString(R.string.gmts_ad_format_load_success_title, this.f12695a.getAdapter().getFormat().getDisplayString()));
        this.f12700f.setVisibility(8);
    }

    private void h() {
        if (!this.f12695a.getAdapter().getFormat().equals(AdFormat.BANNER)) {
            this.h.setVisibility(4);
            if (this.f12695a.testedSuccessfully()) {
                this.g.setVisibility(0);
                this.g.setText(R.string.gmts_button_load_ad);
            }
        }
        TestState testState = this.f12695a.getLastTestResult().getTestState();
        int drawableResourceId = testState.getDrawableResourceId();
        int backgroundColorResId = testState.getBackgroundColorResId();
        int imageTintColorResId = testState.getImageTintColorResId();
        this.f12698d.setImageResource(drawableResourceId);
        ImageView imageView = this.f12698d;
        ViewCompat.a(imageView, ColorStateList.valueOf(imageView.getResources().getColor(backgroundColorResId)));
        androidx.core.widget.g.a(this.f12698d, ColorStateList.valueOf(this.f12698d.getResources().getColor(imageTintColorResId)));
        if (this.f12695a.isTestable() && !this.f12696b) {
            if (this.f12695a.testedSuccessfully()) {
                g();
                return;
            }
            if (this.f12695a.getLastTestResult().equals(TestResult.UNTESTED)) {
                this.g.setText(R.string.gmts_button_load_ad);
                this.f12699e.setText(R.string.gmts_not_tested_title);
                return;
            } else {
                a(this.f12695a.getLastTestResult());
                f();
                this.g.setText(R.string.gmts_button_try_again);
                return;
            }
        }
        if (!this.f12696b) {
            this.f12699e.setText(R.string.gmts_section_missing_components);
            this.f12700f.setText(R.string.gmts_error_missing_components_message);
            this.g.setVisibility(8);
            return;
        }
        this.f12698d.setImageResource(R.drawable.gmts_quantum_ic_progress_activity_white_24);
        int color = this.f12698d.getResources().getColor(R.color.gmts_blue_bg);
        int color2 = this.f12698d.getResources().getColor(R.color.gmts_blue);
        ViewCompat.a(this.f12698d, ColorStateList.valueOf(color));
        androidx.core.widget.g.a(this.f12698d, ColorStateList.valueOf(color2));
        this.f12699e.setText(R.string.gmts_ad_load_in_progress_title);
        this.g.setText(R.string.gmts_button_cancel);
    }

    @Override // com.google.android.ads.mediationtestsuite.AdLoadCallback
    public void onAdFailedToLoad(AdManager adManager, int i) {
        if (!this.f12697c.isEmpty()) {
            this.f12697c.removeFirst();
            return;
        }
        e();
        TestResult failureResult = TestResult.getFailureResult(i);
        a(false);
        b();
        a(failureResult);
        f();
    }

    @Override // com.google.android.ads.mediationtestsuite.AdLoadCallback
    public void onAdLoaded(AdManager adManager) {
        if (!this.f12697c.isEmpty()) {
            this.f12697c.removeFirst();
            return;
        }
        e();
        int i = a.f12694a[adManager.b().getAdapter().getFormat().ordinal()];
        if (i == 1) {
            AdView adViewD = ((com.google.android.ads.mediationtestsuite.utils.e) this.m).d();
            if (adViewD != null && adViewD.getParent() == null) {
                this.h.addView(adViewD);
            }
            this.g.setVisibility(8);
            this.h.setVisibility(0);
            a(false);
            return;
        }
        if (i != 2) {
            a(false);
            this.g.setText(R.string.gmts_button_show_ad);
            c();
            return;
        }
        a(false);
        UnifiedNativeAd unifiedNativeAdD = ((o) this.m).d();
        if (unifiedNativeAdD == null) {
            b();
            this.g.setText(R.string.gmts_button_load_ad);
            this.g.setVisibility(0);
            this.i.setVisibility(8);
            return;
        }
        ((TextView) this.i.findViewById(R.id.gmts_detail_text)).setText(new j(this.itemView.getContext(), unifiedNativeAdD).a());
        this.g.setVisibility(8);
        this.i.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.g.setOnClickListener(this.k);
    }

    private void c() {
        this.g.setOnClickListener(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.m.a();
        this.f12697c.addFirst("cancel");
        this.f12696b = false;
        this.g.setText(R.string.gmts_button_load_ad);
        h();
        b();
        this.h.setVisibility(4);
    }

    private void e() {
        com.google.android.ads.mediationtestsuite.utils.logging.e.a(new RequestEvent(this.f12695a, RequestEvent.Origin.AD_SOURCE), this.itemView.getContext());
    }

    public void a(NetworkConfig networkConfig) {
        this.f12695a = networkConfig;
        this.f12696b = false;
        h();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f12696b = z;
        if (z) {
            a();
        }
        h();
    }

    private void a() {
        this.g.setOnClickListener(this.l);
    }

    private void a(TestResult testResult) {
        this.f12699e.setText(testResult.getText(this.itemView.getContext()));
    }
}
