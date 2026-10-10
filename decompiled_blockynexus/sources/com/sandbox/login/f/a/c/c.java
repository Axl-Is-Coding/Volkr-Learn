package com.sandbox.login.f.a.c;

import android.app.Activity;
import android.text.TextUtils;
import com.sandbox.login.R;
import com.sandbox.login.c.x;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: ConfirmPasswordFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends TemplateFragment<g, x> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(x xVar, g gVar) {
        xVar.a(gVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.login_fragment_confirm_password;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public g getViewModel() {
        String string = getArguments() != null ? getArguments().getString("confirm.fragment.title") : "";
        if (TextUtils.isEmpty(string)) {
            ((Activity) this.context).finish();
        }
        return new g(this.context, string, (x) this.binding);
    }
}
