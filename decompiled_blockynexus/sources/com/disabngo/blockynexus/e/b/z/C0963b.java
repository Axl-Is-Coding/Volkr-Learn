package com.disabngo.blockynexus.e.b.z;

import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding._d;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.app.TemplateFragment;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.z.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GroupAdminManageFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0963b extends TemplateFragment<C0966e, _d> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(_d _dVar, C0966e c0966e) {
        _dVar.a(c0966e);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_admin_manage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public C0966e getViewModel() {
        GroupInfo groupInfo;
        int i;
        Bundle arguments = getArguments();
        if (arguments != null) {
            groupInfo = (GroupInfo) arguments.getParcelable(SharedConstant.KEY_GROUP_INFO);
            i = arguments.getInt(SharedConstant.KEY_GROUP_STATUS);
        } else {
            groupInfo = null;
            i = 0;
        }
        return new C0966e(this.context, i, groupInfo);
    }
}
