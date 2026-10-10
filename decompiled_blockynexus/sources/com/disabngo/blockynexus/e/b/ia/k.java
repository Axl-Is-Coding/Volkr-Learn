package com.disabngo.blockynexus.e.b.ia;

import android.content.Intent;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0721sf;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: SettingFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends TemplateFragment<m, AbstractC0721sf> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0721sf abstractC0721sf, m mVar) {
        abstractC0721sf.a(mVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 100) {
            this.activity.finish();
        }
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
    public m getViewModel() {
        return new m(this.activity, (AbstractC0721sf) this.binding);
    }
}
