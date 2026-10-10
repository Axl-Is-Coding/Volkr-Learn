package com.disabngo.blockynexus.e.b.da;

import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0591gf;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: ScrapMainFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends TemplateFragment<o, AbstractC0591gf> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0591gf abstractC0591gf, o oVar) {
        abstractC0591gf.a(oVar);
        D d2 = this.binding;
        ((AbstractC0591gf) d2).h.setupWithViewPager(((AbstractC0591gf) d2).m);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_scrap_main;
    }

    @Override // com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportDataAdapter.onEvent(this.context, EventConstant.ENTER_COLLECT_ACTIV_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public o getViewModel() {
        return new o(this.activity, (AbstractC0591gf) this.binding);
    }
}
