package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.Locale;

/* JADX INFO: compiled from: FeedExpressBackupView.java */
/* JADX INFO: loaded from: classes.dex */
class h extends BackupView {
    private static i[] j = {new i(2, 3.0241935f, 375, 124), new i(3, 1.25f, 375, 300), new i(4, 1.4044944f, 375, 267), new i(16, 1.25f, 375, 300), new i(5, 1.25f, 375, 300), new i(15, 1.25f, 375, 300), new i(50, 1.25f, 375, 300)};
    boolean h;
    boolean i;
    private int k;
    private View l;
    private NativeExpressView m;
    private b.a.a.a.a.a.b n;

    public h(Context context) {
        super(context);
        this.h = true;
        this.i = true;
        this.f6266a = context;
    }

    private void b(ImageView imageView) {
        com.bytedance.sdk.openadsdk.g.d.a(this.f6266a).a(this.f6267b.B().get(0).a(), imageView);
    }

    private void c() {
        i iVarA = a(this.f6267b.N());
        this.f6271f = ac.c(this.f6266a, this.m.getExpectExpressWidth());
        this.g = ac.c(this.f6266a, this.m.getExpectExpressHeight());
        if (this.f6271f <= 0) {
            this.f6271f = ac.c(this.f6266a);
        }
        if (this.g <= 0) {
            this.g = Float.valueOf(this.f6271f / iVarA.f6313b).intValue();
        }
        int i = this.f6271f;
        if (i > 0 && i > ac.c(this.f6266a)) {
            this.f6271f = ac.c(this.f6266a);
            this.g = Float.valueOf(this.g * (ac.c(this.f6266a) / this.f6271f)).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f6271f, this.g);
        }
        layoutParams.width = this.f6271f;
        layoutParams.height = this.g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (ab.c(this.f6267b.M()) == 9) {
            this.f6270e = "draw_ad";
            h();
            return;
        }
        this.f6270e = "embeded_ad";
        int iN = this.f6267b.N();
        if (iN == 2) {
            e();
            return;
        }
        if (iN == 3) {
            f();
            return;
        }
        if (iN == 5) {
            i();
            return;
        }
        if (iN == 50) {
            d();
        } else if (iN == 15) {
            g();
        } else {
            if (iN != 16) {
                return;
            }
            j();
        }
    }

    private void d() {
        this.l = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(t.e(this.f6266a, "tt_bu_video_container"));
        frameLayout.setVisibility(0);
        this.l.findViewById(t.e(this.f6266a, "tt_bu_img_container")).setVisibility(8);
        ImageView imageView = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView3 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_download"));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView3.setText(this.f6267b.I());
        }
        View viewB = b();
        if (viewB != null) {
            frameLayout.removeAllViews();
            int i = this.f6271f;
            frameLayout.addView(viewB, new ViewGroup.LayoutParams(i, (i * 9) / 16));
        }
        a((View) this, false);
        a((View) textView3, true);
    }

    private void e() {
        this.l = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_feed_img_small"), (ViewGroup) this, true);
        ImageView imageView = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_title"));
        a(imageView);
        textView.setText(getDescription());
        textView2.setText(getTitle());
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        a((View) this, true);
    }

    private void f() {
        this.l = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.l.findViewById(t.e(this.f6266a, "tt_bu_video_container")).setVisibility(8);
        this.l.findViewById(t.e(this.f6266a, "tt_bu_img_container")).setVisibility(0);
        ImageView imageView = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView3 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_download"));
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.g);
        a(imageView);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView3.setText(this.f6267b.I());
        }
        a((View) this, false);
        a((View) textView3, true);
    }

    private void g() {
        this.l = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.l.findViewById(t.e(this.f6266a, "tt_bu_video_container")).setVisibility(0);
        this.l.findViewById(t.e(this.f6266a, "tt_bu_img_container")).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(t.e(this.f6266a, "tt_bu_video_container_inner"));
        ImageView imageView = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_video_icon"));
        ImageView imageView2 = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView3 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_video_name1"));
        TextView textView4 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_video_name2"));
        TextView textView5 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_download"));
        TextView textView6 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_video_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.l.findViewById(t.e(this.f6266a, "tt_bu_video_score_bar"));
        com.bytedance.sdk.openadsdk.g.d.a(this.f6266a).a(this.f6267b.y().a(), imageView);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        int iD = this.f6267b.K() != null ? this.f6267b.K().d() : 4;
        textView6.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iD)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iD);
        tTRatingBar.setStarImageWidth(ac.c(this.f6266a, 15.0f));
        tTRatingBar.setStarImageHeight(ac.c(this.f6266a, 14.0f));
        tTRatingBar.setStarImagePadding(ac.c(this.f6266a, 4.0f));
        tTRatingBar.a();
        textView3.setText(getNameOrSource());
        textView4.setText(getTitle());
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView5.setText(this.f6267b.I());
        }
        View viewB = b();
        if (viewB != null) {
            int i = (this.f6271f * 123) / 375;
            frameLayout.removeAllViews();
            frameLayout.addView(viewB, new ViewGroup.LayoutParams(i, (i * 16) / 9));
        }
        a((View) this, false);
        a((View) textView5, true);
    }

    private void h() {
        this.l = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_draw"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(t.e(this.f6266a, "tt_bu_video_container"));
        TextView textView = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView3 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_download"));
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView3.setText(this.f6267b.I());
        }
        View viewB = b();
        if (viewB != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewB, new ViewGroup.LayoutParams(-1, -1));
        }
        a((View) textView2, false);
        a((View) textView, false);
        a((View) textView3, true);
    }

    private void i() {
        this.l = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(t.e(this.f6266a, "tt_bu_video_container"));
        frameLayout.setVisibility(0);
        this.l.findViewById(t.e(this.f6266a, "tt_bu_img_container")).setVisibility(8);
        ImageView imageView = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView3 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_download"));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView3.setText(this.f6267b.I());
        }
        View viewB = b();
        if (viewB != null) {
            frameLayout.removeAllViews();
            int i = this.f6271f;
            frameLayout.addView(viewB, new ViewGroup.LayoutParams(i, (i * 9) / 16));
        }
        a((View) this, false);
        a((View) textView3, true);
    }

    private void j() {
        this.l = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.l.findViewById(t.e(this.f6266a, "tt_bu_video_container")).setVisibility(8);
        this.l.findViewById(t.e(this.f6266a, "tt_bu_img_container")).setVisibility(0);
        ImageView imageView = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.l.findViewById(t.e(this.f6266a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView3 = (TextView) this.l.findViewById(t.e(this.f6266a, "tt_bu_download"));
        b(imageView);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView3.setText(this.f6267b.I());
        }
        a((View) this, false);
        a((View) textView3, true);
    }

    void a(com.bytedance.sdk.openadsdk.core.d.h hVar, NativeExpressView nativeExpressView, b.a.a.a.a.a.b bVar) {
        o.b("FeedExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f6267b = hVar;
        this.m = nativeExpressView;
        this.n = bVar;
        this.k = ab.d(this.f6267b.M());
        b(this.k);
        c();
        this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    public View b() {
        NativeVideoTsView nativeVideoTsView;
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f6267b;
        if (hVar != null && this.f6266a != null) {
            if (x.a(hVar)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.f6266a, this.f6267b);
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.7
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j2, long j3, long j4, boolean z2) {
                        }
                    });
                    nativeVideoTsView.setIsAutoPlay(this.h);
                    nativeVideoTsView.setIsQuiet(this.i);
                } catch (Throwable unused) {
                    nativeVideoTsView = null;
                }
                if (!x.a(this.f6267b) && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
                    return nativeVideoTsView;
                }
            } else {
                nativeVideoTsView = null;
                if (!x.a(this.f6267b)) {
                }
            }
        }
        return null;
    }

    private i a(int i) {
        i[] iVarArr = j;
        i iVar = iVarArr[0];
        try {
            for (i iVar2 : iVarArr) {
                if (iVar2.f6312a == i) {
                    return iVar2;
                }
            }
            return iVar;
        } catch (Throwable unused) {
            return iVar;
        }
    }

    private void b(int i) {
        this.i = com.bytedance.sdk.openadsdk.core.o.h().a(this.k);
        int iC = com.bytedance.sdk.openadsdk.core.o.h().c(i);
        if (3 == iC) {
            this.h = false;
            return;
        }
        if (1 == iC && q.d(this.f6266a)) {
            this.h = true;
        } else if (2 == iC) {
            if (q.e(this.f6266a) || q.d(this.f6266a)) {
                this.h = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.widget.ImageView r10) {
        /*
            r9 = this;
            com.bytedance.sdk.openadsdk.core.d.h r0 = r9.f6267b
            java.util.List r0 = r0.B()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.bytedance.sdk.openadsdk.core.d.g r0 = (com.bytedance.sdk.openadsdk.core.d.g) r0
            if (r0 == 0) goto L71
            java.lang.String r2 = r0.a()
            int r3 = r0.b()
            int r0 = r0.c()
            float r4 = (float) r3
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 * r5
            float r6 = (float) r0
            float r4 = r4 / r6
            r6 = 1
            r7 = 1098907648(0x41800000, float:16.0)
            int r8 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r8 > 0) goto L39
            int r0 = r9.g
            android.content.Context r1 = r9.f6266a
            int r1 = com.bytedance.sdk.openadsdk.utils.ac.c(r1, r7)
            int r0 = r0 - r1
            int r1 = r9.g
        L34:
            float r1 = (float) r1
            float r1 = r1 * r5
            int r3 = (int) r1
            goto L54
        L39:
            r5 = 1071896330(0x3fe3d70a, float:1.78)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L53
            r5 = 1072986849(0x3ff47ae1, float:1.91)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L53
            int r0 = r9.g
            android.content.Context r1 = r9.f6266a
            int r1 = com.bytedance.sdk.openadsdk.utils.ac.c(r1, r7)
            int r0 = r0 - r1
            int r1 = r9.g
            goto L34
        L53:
            r6 = 0
        L54:
            if (r6 == 0) goto L68
            android.view.ViewGroup$LayoutParams r1 = r10.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            r1.height = r0
            r1.width = r3
            r0 = 8388659(0x800033, float:1.1755015E-38)
            r1.gravity = r0
            r10.setLayoutParams(r1)
        L68:
            android.content.Context r0 = r9.f6266a
            com.bytedance.sdk.openadsdk.g.d r0 = com.bytedance.sdk.openadsdk.g.d.a(r0)
            r0.a(r2, r10)
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.h.a(android.widget.ImageView):void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(i, fVar);
        }
    }
}
