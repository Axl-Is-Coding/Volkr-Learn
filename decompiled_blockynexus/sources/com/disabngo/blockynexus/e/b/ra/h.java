package com.disabngo.blockynexus.e.b.ra;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Wf;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeRankFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends TemplateFragment<n, Wf> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Wf wf, n nVar) {
        wf.a(nVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_rank;
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
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_ENTER_RANK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public n getViewModel() {
        return new n(this.context);
    }
}
