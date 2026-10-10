package com.sandboxol.halloween.view.fragment.tasks;

import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.b.m;

/* JADX INFO: compiled from: TasksFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends BaseFragment<j, m> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(m mVar, j jVar) {
        mVar.a(jVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.halloween_fragment_tasks;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (com.sandboxol.halloween.c.b.b().c()) {
            Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.task.list");
            com.sandboxol.halloween.c.b.b().a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public j getViewModel() {
        return new j(this.context);
    }
}
