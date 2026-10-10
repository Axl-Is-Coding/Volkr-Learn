package com.sandboxol.gamedetail.c.a.b;

import android.os.Bundle;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.gamedetail.R;
import com.sandboxol.gamedetail.a.q;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailIntroduceFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends TemplateFragment<n, q> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(q qVar, n nVar) {
        qVar.a(nVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_game_detail_introduce;
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
    public n getViewModel() {
        Bundle arguments = getArguments();
        return new n(this.context, arguments != null ? (Game) arguments.getSerializable(StringConstant.GAME_DETAIL_INTRODUCTION) : null);
    }
}
