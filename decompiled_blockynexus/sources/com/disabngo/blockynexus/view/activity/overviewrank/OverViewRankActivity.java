package com.disabngo.blockynexus.view.activity.overviewrank;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0715s;
import com.sandboxol.common.base.app.BaseActivity;

/* JADX INFO: loaded from: classes2.dex */
public class OverViewRankActivity extends BaseActivity<k, AbstractC0715s> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0715s abstractC0715s, k kVar) {
        abstractC0715s.a(kVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_overview_rank;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public k getViewModel() {
        return new k(this);
    }
}
