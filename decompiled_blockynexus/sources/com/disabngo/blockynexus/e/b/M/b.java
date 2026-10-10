package com.disabngo.blockynexus.e.b.M;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Be;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: IncomeFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends TemplateFragment<g, Be> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Be be, g gVar) {
        be.a(gVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_income;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        super.onBackPressed();
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_BALANCE_BACK);
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
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_SHOW_CODEBALANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public g getViewModel() {
        return new g(this.context);
    }
}
