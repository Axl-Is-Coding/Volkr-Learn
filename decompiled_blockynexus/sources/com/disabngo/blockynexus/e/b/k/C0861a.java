package com.disabngo.blockynexus.e.b.k;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0719sd;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.k.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CashHelpFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0861a extends TemplateFragment<C0864d, AbstractC0719sd> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0719sd abstractC0719sd, C0864d c0864d) {
        abstractC0719sd.a(c0864d);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_cash_help;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        super.onBackPressed();
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_CODECOMQUES_BACK);
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
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_SHOW_COMMONQUES);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public C0864d getViewModel() {
        return new C0864d(this.context, getArguments() != null ? getArguments().getParcelableArrayList(StringConstant.STAR_CONFIG) : null);
    }
}
