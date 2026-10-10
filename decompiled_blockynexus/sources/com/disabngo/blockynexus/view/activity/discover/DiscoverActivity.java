package com.disabngo.blockynexus.view.activity.discover;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0563e;
import com.sandboxol.common.base.app.BaseActivity;

/* JADX INFO: loaded from: classes2.dex */
public class DiscoverActivity extends BaseActivity<n, AbstractC0563e> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0563e abstractC0563e, n nVar) {
        abstractC0563e.a(nVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_discover;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public n getViewModel() {
        return new n(this, (AbstractC0563e) this.binding);
    }
}
