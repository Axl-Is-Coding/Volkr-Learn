package com.disabngo.blockynexus.e.b.W.a;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Xc;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: ActiveRankFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends TemplateFragment<p, Xc> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Xc xc, p pVar) {
        xc.a(pVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_active_rank;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public p getViewModel() {
        return new p(getContext(), getArguments());
    }
}
