package com.disabngo.blockynexus.view.dialog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0707rc;
import com.opensource.svgaplayer.SVGAParser;
import com.sandboxol.center.config.StringConstant;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ScrapReceivedAnimDialog extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractC0707rc f11373a;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11374b = "translationY";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11375c = "translationX";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11376d = "alpha";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11377e = "scaleX";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11378f = "scaleY";
    private final long m = 1000;

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f11373a.f8756b, "translationX", this.g, this.i).setDuration(1000L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f11373a.f8756b, "translationY", this.h, this.j).setDuration(1000L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.f11373a.f8756b, "scaleX", this.k, this.l).setDuration(1000L);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.f11373a.f8756b, "scaleY", this.k, this.l).setDuration(1000L);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(this.f11373a.f8756b, "alpha", 1.0f, WheelView.DividerConfig.FILL).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, duration3, duration4);
        animatorSet.play(duration5).after(duration);
        animatorSet.start();
        animatorSet.addListener(new Ia(this));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11373a = (AbstractC0707rc) androidx.databinding.e.a(this, R.layout.dialog_scrap_received_anim);
        this.f11373a.a(this);
        this.i = getIntent().getIntExtra(StringConstant.SCRAP_ENTRANCE_X, this.g);
        this.j = getIntent().getIntExtra(StringConstant.SCRAP_ENTRANCE_Y, this.h);
        this.l = getIntent().getIntExtra(StringConstant.SCRAP_ENTRANCE_SIZE, 0);
        a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f11373a.f8756b.clearAnimation();
    }

    @SuppressLint({"CheckResult"})
    private void a() {
        io.reactivex.p.just(true).delay(100L, TimeUnit.MILLISECONDS).observeOn(io.reactivex.android.b.b.a()).subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.view.dialog.J
            @Override // io.reactivex.b.g
            public final void accept(Object obj) throws Exception {
                this.f11312a.a((Boolean) obj);
            }
        });
    }

    private void b() {
        SVGAParser sVGAParserB = SVGAParser.f15448c.b();
        sVGAParserB.a(this);
        sVGAParserB.a("app_start_1.svga", new Ga(this));
        this.f11373a.f8756b.setCallback(new Ha(this));
    }

    public /* synthetic */ void a(Boolean bool) throws Exception {
        this.g = (this.f11373a.f8756b.getLeft() + this.f11373a.f8756b.getRight()) / 2;
        this.h = (this.f11373a.f8756b.getTop() + this.f11373a.f8756b.getBottom()) / 2;
        this.k = this.f11373a.f8756b.getWidth();
        b();
    }
}
