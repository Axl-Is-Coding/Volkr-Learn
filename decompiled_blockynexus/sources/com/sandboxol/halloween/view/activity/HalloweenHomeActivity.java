package com.sandboxol.halloween.view.activity;

import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.halloween.R;

/* JADX INFO: loaded from: classes4.dex */
public class HalloweenHomeActivity extends BaseActivity<l, com.sandboxol.halloween.b.k> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(com.sandboxol.halloween.b.k kVar, l lVar) {
        kVar.a(lVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.halloween_fragment_home;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public l getViewModel() {
        return new l(this, (com.sandboxol.halloween.b.k) this.binding);
    }
}
