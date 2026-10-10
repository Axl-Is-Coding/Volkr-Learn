package com.disabngo.blockynexus.e.b.L;

import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0775xe;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: InboxFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends TemplateFragment<k, AbstractC0775xe> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0775xe abstractC0775xe, k kVar) {
        abstractC0775xe.a(kVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_inbox;
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

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onRightButtonClick(View view) {
        super.onRightButtonClick(view);
        ((k) this.viewModel).f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public k getViewModel() {
        return new k(this.context);
    }
}
