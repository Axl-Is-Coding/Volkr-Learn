package com.sandbox.login.f.a.b;

import android.app.Activity;
import android.text.TextUtils;
import com.sandbox.login.R;
import com.sandbox.login.c.v;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: ChangePasswordFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends TemplateFragment<h, v> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(v vVar, h hVar) {
        vVar.a(hVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.login_fragment_change_password;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onEvent(this.context, EventConstant.ENTER_PASSWORD_SET_PAGE);
        ReportDataAdapter.onResume(this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public h getViewModel() {
        String string;
        String string2 = "";
        if (getArguments() != null) {
            string2 = getArguments().getString("confirm.fragment.title");
            string = getArguments().getString("change.password.fragment.old.password");
        } else {
            string = "";
        }
        if (TextUtils.isEmpty(string2)) {
            ((Activity) this.context).finish();
        }
        return TextUtils.isEmpty(string) ? new h(this.context, string2) : new h(this.context, string2, string);
    }
}
