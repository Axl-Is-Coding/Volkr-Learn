package com.disabngo.blockynexus.e.b.W.b;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Ad;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: ClanRankFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends TemplateFragment<p, Ad> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Ad ad, p pVar) {
        ad.a(pVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_clan_rank;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public p getViewModel() {
        return new p(getContext(), getArguments());
    }
}
