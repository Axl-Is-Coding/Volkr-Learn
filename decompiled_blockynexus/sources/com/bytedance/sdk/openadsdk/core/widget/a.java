package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: compiled from: CustomCommonDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0085a f6582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f6583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f6585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Button f6586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f6587f;
    private View g;
    private Context h;
    private String i;
    private String j;
    private String k;
    private String l;
    private int m;
    private boolean n;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CustomCommonDialog.java */
    public interface InterfaceC0085a {
        void a();

        void b();
    }

    public a(Context context) {
        super(context, t.g(context, "tt_custom_dialog"));
        this.m = -1;
        this.n = false;
        this.h = context;
    }

    private void a() {
        this.f6587f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InterfaceC0085a interfaceC0085a = a.this.f6582a;
                if (interfaceC0085a != null) {
                    interfaceC0085a.a();
                }
            }
        });
        this.f6586e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InterfaceC0085a interfaceC0085a = a.this.f6582a;
                if (interfaceC0085a != null) {
                    interfaceC0085a.b();
                }
            }
        });
    }

    private void b() {
        if (TextUtils.isEmpty(this.j)) {
            this.f6584c.setVisibility(8);
        } else {
            this.f6584c.setText(this.j);
            this.f6584c.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.f6585d.setText(this.i);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.f6587f.setText(t.a(o.a(), "tt_postive_txt"));
        } else {
            this.f6587f.setText(this.k);
        }
        if (TextUtils.isEmpty(this.l)) {
            this.f6586e.setText(t.a(o.a(), "tt_negtive_txt"));
        } else {
            this.f6586e.setText(this.l);
        }
        int i = this.m;
        if (i != -1) {
            this.f6583b.setImageResource(i);
            this.f6583b.setVisibility(0);
        } else {
            this.f6583b.setVisibility(8);
        }
        if (this.n) {
            this.g.setVisibility(8);
            this.f6586e.setVisibility(8);
        } else {
            this.f6586e.setVisibility(0);
            this.g.setVisibility(0);
        }
    }

    private void c() {
        this.f6586e = (Button) findViewById(t.e(this.h, "tt_negtive"));
        this.f6587f = (Button) findViewById(t.e(this.h, "tt_positive"));
        this.f6584c = (TextView) findViewById(t.e(this.h, "tt_title"));
        this.f6585d = (TextView) findViewById(t.e(this.h, "tt_message"));
        this.f6583b = (ImageView) findViewById(t.e(this.h, "tt_image"));
        this.g = findViewById(t.e(this.h, "tt_column_line"));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f(this.h, "tt_custom_dailog_layout"));
        setCanceledOnTouchOutside(false);
        c();
        b();
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    public a a(InterfaceC0085a interfaceC0085a) {
        this.f6582a = interfaceC0085a;
        return this;
    }

    public a a(String str) {
        this.i = str;
        return this;
    }

    public a c(String str) {
        this.l = str;
        return this;
    }

    public a b(String str) {
        this.k = str;
        return this;
    }
}
