package com.disabngo.blockynexus.e.b.n;

import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0763wd;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: ChangeNameFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends TemplateFragment<h, AbstractC0763wd> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0763wd abstractC0763wd, h hVar) {
        abstractC0763wd.a(hVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_change_name;
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
        ((h) this.viewModel).f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public h getViewModel() {
        return new h(this.context);
    }
}
