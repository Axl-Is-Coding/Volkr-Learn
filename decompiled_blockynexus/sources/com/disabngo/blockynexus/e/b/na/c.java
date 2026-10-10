package com.disabngo.blockynexus.e.b.na;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Mf;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeInviteFriend.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends TemplateFragment<j, Mf> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Mf mf, j jVar) {
        mf.a(jVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_invite_friend;
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
    public j getViewModel() {
        return new j(getActivity(), getArguments().getBoolean(StringConstant.TRIBE_IS_FINISH_INVITE));
    }
}
