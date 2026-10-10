package com.disabngo.blockynexus.e.b.ea;

import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Cif;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: SecretEmailVerifyFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends TemplateFragment<k, Cif> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Cif cif, k kVar) {
        cif.a(kVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_secret_email_verify;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        ((k) this.viewModel).onBack();
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onLeftButtonClick(View view) {
        onBackPressed();
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
    public k getViewModel() {
        return new k(this.context);
    }
}
