package com.sandbox.login.f.a.e;

import com.sandbox.login.R;
import com.sandbox.login.c.t;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: AccountRecordFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends TemplateFragment<r, t> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(t tVar, r rVar) {
        tVar.a(rVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.login_fragment_account_record;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onEvent(this.context, EventConstant.ENTER_SWITCH_ACC_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public r getViewModel() {
        return new r(this.activity);
    }
}
