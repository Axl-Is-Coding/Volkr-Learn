package com.disabngo.blockynexus.e.b.ma;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.If;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeDetailFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends TemplateFragment<m, If> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(If r1, m mVar) {
        r1.a(mVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_detail;
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
        new LoadingDialog(this.context).show();
        int i = getArguments().getInt(StringConstant.FROM_PAGE, 1);
        return new m(getActivity(), getArguments().getLong("tribe.clan.id"), getArguments().getString(StringConstant.TRIBE_DETAIL_ENTER_TYPE) != null ? getArguments().getString(StringConstant.TRIBE_DETAIL_ENTER_TYPE) : "other", i);
    }
}
