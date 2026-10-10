package com.disabngo.blockynexus.e.b.j;

import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0676od;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: CashApplyFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends TemplateFragment<k, AbstractC0676od> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0676od abstractC0676od, k kVar) {
        abstractC0676od.a(kVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_cash_apply;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        super.onBackPressed();
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_CASHOUTAPPLY_APP);
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
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_SHOW_USDAPPLY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public k getViewModel() {
        Bundle arguments = getArguments();
        return new k(this.context, arguments != null ? arguments.getDouble(StringConstant.CASH_AMOUNT) : 0.0d);
    }
}
