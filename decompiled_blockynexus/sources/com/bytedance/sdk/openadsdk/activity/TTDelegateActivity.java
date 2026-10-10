package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.f.d;
import com.bytedance.sdk.openadsdk.core.f.e;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.utils.f;
import com.bytedance.sdk.openadsdk.utils.t;
import com.facebook.internal.NativeProtocol;

/* JADX INFO: loaded from: classes.dex */
public class TTDelegateActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f5640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AlertDialog f5641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f5642c;

    private void b() {
        if (h.b().l()) {
            getWindow().addFlags(2621440);
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = WheelView.DividerConfig.FILL;
        window.setAttributes(attributes);
    }

    private void c() {
        int intExtra = this.f5640a.getIntExtra("type", 0);
        String stringExtra = this.f5640a.getStringExtra("app_download_url");
        this.f5640a.getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
        if (intExtra != 1) {
            if (intExtra == 3) {
                a(stringExtra, this.f5640a.getStringExtra("dialog_title_key"), this.f5640a.getStringExtra("dialog_content_key"));
                return;
            }
            if (intExtra == 4) {
                a(this.f5640a.getStringExtra("permission_id_key"), this.f5640a.getStringArrayExtra("permission_content_key"));
            } else if (intExtra != 5) {
                finish();
            } else {
                d();
            }
        }
    }

    private void d() {
        this.f5642c = new b(this);
        this.f5642c.a(t.a(this, "no_thank_you"), new b.InterfaceC0086b() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.b.InterfaceC0086b
            public void a() {
                h.b().b(0);
                if (TTDelegateActivity.this.f5642c.isShowing()) {
                    TTDelegateActivity.this.f5642c.dismiss();
                }
                TTDelegateActivity.this.finish();
            }
        }).a(t.a(this, "yes_i_agree"), new b.c() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.b.c
            public void a() {
                h.b().b(1);
                if (TTDelegateActivity.this.f5642c.isShowing()) {
                    TTDelegateActivity.this.f5642c.dismiss();
                }
                TTDelegateActivity.this.finish();
            }
        });
        this.f5642c.show();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.f5640a = getIntent();
        if (o.a() == null) {
            o.a(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.f5641b != null && this.f5641b.isShowing()) {
                this.f5641b.dismiss();
            }
            if (this.f5642c != null && this.f5642c.isShowing()) {
                this.f5642c.dismiss();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (o.a() == null) {
            o.a(this);
        }
        setIntent(intent);
        this.f5640a = intent;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        d.a().a(this, strArr, iArr);
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            c();
        }
    }

    public static void a() {
        Intent intent = new Intent(o.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 5);
        if (o.a() != null) {
            o.a().startActivity(intent);
        }
    }

    private void a(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    d.a().a(this, strArr, new e() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.3
                        @Override // com.bytedance.sdk.openadsdk.core.f.e
                        public void a() {
                            f.a(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.f.e
                        public void a(String str2) {
                            f.a(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            } else {
                com.bytedance.sdk.openadsdk.utils.o.b(TTAdConstant.TAG, "已经有权限");
                finish();
                return;
            }
        }
        finish();
    }

    private void a(final String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = t.a(this, "tt_tip");
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        a(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.bytedance.sdk.openadsdk.utils.e.a(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.bytedance.sdk.openadsdk.utils.e.b(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                com.bytedance.sdk.openadsdk.utils.e.c(str);
                TTDelegateActivity.this.finish();
            }
        });
    }

    private void a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.f5641b == null) {
                this.f5641b = new AlertDialog.Builder(this, t.g(this, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).create();
            }
            this.f5641b.setTitle(String.valueOf(str));
            this.f5641b.setMessage(String.valueOf(str2));
            this.f5641b.setButton(-1, t.a(this, "tt_label_ok"), onClickListener);
            this.f5641b.setButton(-2, t.a(this, "tt_label_cancel"), onClickListener2);
            this.f5641b.setOnCancelListener(onCancelListener);
            if (this.f5641b.isShowing()) {
                return;
            }
            this.f5641b.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
