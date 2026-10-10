package com.sandbox.login.f.a.a;

import com.sandbox.login.R;
import com.sandbox.login.c.F;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: SetAccountFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends TemplateFragment<i, F> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(F f2, i iVar) {
        f2.a(iVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.login_fragment_set_account;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onEvent(this.context, EventConstant.ENTER_USERNAME_SET_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public i getViewModel() {
        return new i((F) this.binding, this.context);
    }
}
