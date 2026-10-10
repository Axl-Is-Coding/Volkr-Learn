package com.sandbox.login.f.a.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.TemplateHelper;

/* JADX INFO: compiled from: ConfirmPasswordModel.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends OnResponseListener<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f15786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f15788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f15789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ e f15790e;

    d(e eVar, ObservableField observableField, String str, Context context, String str2) {
        this.f15790e = eVar;
        this.f15786a = observableField;
        this.f15787b = str;
        this.f15788c = context;
        this.f15789d = str2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        this.f15786a.set(false);
        if (!bool.booleanValue()) {
            AppToastUtils.showShortNegativeTipToast(this.f15788c, R.string.login_change_password_wrong);
            return;
        }
        if (TextUtils.equals(this.f15787b, this.f15788c.getString(R.string.login_more_set_account))) {
            TemplateHelper.startTemplate(this.f15788c, com.sandbox.login.f.a.a.e.class, this.f15787b);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("confirm.fragment.title", this.f15787b);
            bundle.putString("change.password.fragment.old.password", this.f15789d);
            TemplateHelper.startTemplate(this.f15788c, com.sandbox.login.f.a.b.d.class, this.f15787b, bundle);
        }
        ((Activity) this.f15788c).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f15786a.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f15786a.set(false);
    }
}
