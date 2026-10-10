package com.disabngo.blockynexus.view.fragment.partyhall;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Ne;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.tendcloud.tenddata.ab;

/* JADX INFO: compiled from: PartyHallFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends TemplateFragment<G, Ne> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Ne ne, G g) {
        ne.a(g);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_party_hall;
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
    public G getViewModel() {
        ReportDataAdapter.onEvent(this.context, EventConstant.PARTY_LIST_TIME);
        com.apkfuns.logutils.c.a(ab.u).d("onEvent being called! eventEvent: 进入派对大厅");
        return new G(this.context, (Ne) this.binding);
    }
}
