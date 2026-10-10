package com.sandboxol.gamedetail.c.a.c;

import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.gamedetail.R;
import com.sandboxol.gamedetail.a.s;

/* JADX INFO: compiled from: GameDetailRankFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends TemplateFragment<n, s> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(s sVar, n nVar) {
        sVar.a(nVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_game_detail_rank;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public n getViewModel() {
        return new n(this.context, getArguments() != null ? getArguments().getString(StringConstant.MINI_GAME_ID) : "");
    }
}
