package com.disabngo.blockynexus.e.b.W.c;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Wd;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: GdiamondRankFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends TemplateFragment<p, Wd> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Wd wd, p pVar) {
        wd.a(pVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_gdiamond_rank;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public p getViewModel() {
        return new p(getContext(), getArguments());
    }
}
