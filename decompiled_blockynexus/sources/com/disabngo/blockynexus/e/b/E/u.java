package com.disabngo.blockynexus.e.b.E;

import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0622je;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: compiled from: GroupManageFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends TemplateFragment<x, AbstractC0622je> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0622je abstractC0622je, x xVar) {
        abstractC0622je.a(xVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_manage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public x getViewModel() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        return new x(this.context, (GroupInfo) arguments.getParcelable(SharedConstant.KEY_GROUP_INFO));
    }
}
