package com.sandboxol.googlepay.c.a.b;

import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.googlepay.R;
import com.sandboxol.googlepay.a.e;

/* JADX INFO: compiled from: RechargeDetailFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends TemplateFragment<b, e> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(e eVar, b bVar) {
        eVar.a(bVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_recharge_detail;
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
    public b getViewModel() {
        return new b(this.context, (PayRecordInfo) getArguments().getSerializable(StringConstant.RECHARGE_DETAIL_INFO));
    }
}
