package com.bytedance.sdk.openadsdk.core.c;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: compiled from: InteractionExpressBackupView.java */
/* JADX INFO: loaded from: classes.dex */
class a extends BackupView {
    private static i[] h = {new i(1, 1.0f, 300, 300), new i(2, 0.6666667f, 300, 450), new i(3, 1.5f, 300, 200)};
    private View i;
    private NativeExpressView j;
    private b.a.a.a.a.a.b k;
    private int l;
    private Dialog m;

    public a(Context context) {
        super(context);
        this.l = 1;
        this.f6266a = context;
    }

    private void b() {
        i iVarA = a(this.j.getExpectExpressWidth(), this.j.getExpectExpressHeight());
        if (this.j.getExpectExpressWidth() <= 0 || this.j.getExpectExpressHeight() <= 0) {
            this.f6271f = ac.c(this.f6266a, iVarA.f6314c);
            this.g = ac.c(this.f6266a, iVarA.f6315d);
        } else if (this.j.getExpectExpressWidth() > this.j.getExpectExpressHeight()) {
            this.f6271f = ac.c(this.f6266a, this.j.getExpectExpressHeight() * iVarA.f6313b);
            this.g = ac.c(this.f6266a, this.j.getExpectExpressHeight());
        } else {
            this.f6271f = ac.c(this.f6266a, this.j.getExpectExpressWidth());
            this.g = ac.c(this.f6266a, this.j.getExpectExpressWidth() / iVarA.f6313b);
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
        setLayoutParams(layoutParams);
        int i2 = iVarA.f6312a;
        if (i2 == 1) {
            c();
            return;
        }
        if (i2 == 2) {
            d();
        } else if (i2 == 3) {
            e();
        } else {
            c();
        }
    }

    private void c() {
        this.i = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_insert_layout1"), (ViewGroup) this, true);
        ImageView imageView = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_img"));
        View viewFindViewById = this.i.findViewById(t.e(this.f6266a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_icon"));
        TextView textView = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView2 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_download"));
        TextView textView4 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_dislike"));
        int iA = (int) ac.a(this.f6266a, 15.0f);
        ac.a(viewFindViewById, iA, iA, iA, iA);
        a(viewFindViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView3.setText(this.f6267b.I());
        }
        a(imageView);
        d.a(this.f6266a).a(this.f6267b.y().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, false);
        a((View) textView3, true);
        a((View) textView4, true);
    }

    private void d() {
        this.i = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_insert_layout2"), (ViewGroup) this, true);
        ImageView imageView = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_img"));
        View viewFindViewById = this.i.findViewById(t.e(this.f6266a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_icon"));
        TextView textView = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView2 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_download"));
        TextView textView4 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_dislike"));
        int iA = (int) ac.a(this.f6266a, 15.0f);
        ac.a(viewFindViewById, iA, iA, iA, iA);
        a(viewFindViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView3.setText(this.f6267b.I());
        }
        a(imageView);
        d.a(this.f6266a).a(this.f6267b.y().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, false);
        a((View) textView3, true);
        a((View) textView4, true);
    }

    private void e() {
        this.i = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_insert_layout3"), (ViewGroup) this, true);
        ImageView imageView = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_img"));
        View viewFindViewById = this.i.findViewById(t.e(this.f6266a, "tt_bu_close"));
        TextView textView = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_dislike"));
        int iA = (int) ac.a(this.f6266a, 15.0f);
        ac.a(viewFindViewById, iA, iA, iA, iA);
        a(viewFindViewById);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        a(imageView);
        textView.setText(getDescription());
        a((View) this, false);
        a(this.i, true);
        a((View) textView2, true);
    }

    public void a(Dialog dialog) {
        this.m = dialog;
    }

    void a(h hVar, NativeExpressView nativeExpressView, b.a.a.a.a.a.b bVar) {
        setBackgroundColor(-1);
        this.f6267b = hVar;
        this.j = nativeExpressView;
        this.k = bVar;
        this.f6270e = "interaction";
        this.j.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void a(ImageView imageView) {
        d.a(this.f6266a).a(this.f6267b.B().get(0).a(), imageView);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.m != null) {
                    a.this.m.dismiss();
                }
            }
        });
    }

    private i a(int i, int i2) {
        try {
            float fFloatValue = Float.valueOf(i).floatValue() / Float.valueOf(i2).floatValue();
            i iVar = h[0];
            i iVar2 = iVar;
            float f2 = Float.MAX_VALUE;
            for (i iVar3 : h) {
                float fAbs = Math.abs(iVar3.f6313b - fFloatValue);
                if (fAbs <= f2) {
                    iVar2 = iVar3;
                    f2 = fAbs;
                }
            }
            return iVar2;
        } catch (Throwable unused) {
            return h[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, f fVar) {
        NativeExpressView nativeExpressView = this.j;
        if (nativeExpressView != null) {
            nativeExpressView.a(i, fVar);
        }
    }
}
