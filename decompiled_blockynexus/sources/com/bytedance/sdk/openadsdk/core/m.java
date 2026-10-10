package com.bytedance.sdk.openadsdk.core;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: compiled from: InsertAdDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f6247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f6248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageView f6249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f6250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f6251f;
    private FrameLayout g;
    private a h;
    private boolean i;

    /* JADX INFO: compiled from: InsertAdDialog.java */
    public interface a {
        void a(View view);

        void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout);
    }

    public m(Context context) {
        this(context, 0);
    }

    private void b() {
        try {
            if (this.g != null && this.g.getChildCount() > 0) {
                View childAt = this.g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        this.g.setVisibility(0);
                        this.f6248c.setVisibility(8);
                        this.f6249d.setVisibility(8);
                        this.f6250e.setVisibility(8);
                        this.f6251f.setVisibility(8);
                        View viewFindViewById = nativeExpressView.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.f6247b, "tt_bu_close"));
                        if (viewFindViewById == null || this.h == null) {
                            return;
                        }
                        this.h.a(viewFindViewById);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void show() {
        b();
        super.show();
    }

    public m(Context context, int i) {
        super(context, i == 0 ? com.bytedance.sdk.openadsdk.utils.t.g(context, "tt_wg_insert_dialog") : i);
        this.i = false;
        this.f6247b = context;
    }

    public void a(boolean z, a aVar) {
        this.i = z;
        this.h = aVar;
        a();
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.a(this.f6248c, this.f6249d, this.g);
        }
    }

    private void a() {
        setCancelable(false);
        this.f6246a = LayoutInflater.from(this.f6247b).inflate(com.bytedance.sdk.openadsdk.utils.t.f(this.f6247b, "tt_insert_ad_layout"), (ViewGroup) null);
        setContentView(this.f6246a);
        this.f6248c = (ImageView) this.f6246a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.f6247b, "tt_insert_ad_img"));
        this.f6249d = (ImageView) this.f6246a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.f6247b, "tt_insert_dislike_icon_img"));
        this.f6250e = (ImageView) this.f6246a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.f6247b, "tt_insert_ad_logo"));
        this.f6251f = (TextView) this.f6246a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.f6247b, "tt_insert_ad_text"));
        this.g = (FrameLayout) this.f6246a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.f6247b, "tt_insert_express_ad_fl"));
        int iC = ac.c(this.f6247b);
        int i = iC / 3;
        this.f6248c.setMaxWidth(iC);
        this.f6248c.setMinimumWidth(i);
        this.f6248c.setMinimumHeight(i);
        this.g.setMinimumWidth(i);
        this.g.setMinimumHeight(i);
        this.f6248c.setVisibility(this.i ? 8 : 0);
        this.f6249d.setVisibility(0);
        this.f6250e.setVisibility(this.i ? 8 : 0);
        this.f6251f.setVisibility(this.i ? 8 : 0);
        this.g.setVisibility(this.i ? 0 : 8);
        int iA = (int) ac.a(this.f6247b, 15.0f);
        ac.a(this.f6249d, iA, iA, iA, iA);
        this.f6249d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.h != null) {
                    m.this.h.a(view);
                }
            }
        });
    }
}
