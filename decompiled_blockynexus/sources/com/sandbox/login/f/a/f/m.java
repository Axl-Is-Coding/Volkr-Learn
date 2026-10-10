package com.sandbox.login.f.a.f;

import com.sandbox.login.R;
import com.sandbox.login.c.H;
import com.sandboxol.common.base.app.BaseFragment;

/* JADX INFO: compiled from: StepFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends BaseFragment<l, H> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(H h, l lVar) {
        h.a(lVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.login_register_step_1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public l getViewModel() {
        return new l(this.activity, (H) this.binding);
    }
}
