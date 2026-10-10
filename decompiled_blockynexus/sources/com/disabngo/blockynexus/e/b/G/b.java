package com.disabngo.blockynexus.e.b.G;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0688pe;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import java.util.ArrayList;

/* JADX INFO: compiled from: GroupNoticeFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends TemplateFragment<f, AbstractC0688pe> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0688pe abstractC0688pe, f fVar) {
        abstractC0688pe.a(fVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_notice;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public f getViewModel() {
        ArrayList<String> arrayList;
        GroupInfoParam groupInfoParam = null;
        if (getArguments() != null) {
            groupInfoParam = (GroupInfoParam) getArguments().getSerializable(SharedConstant.KEY_GROUP_INFO);
            arrayList = getArguments().getStringArrayList(SharedConstant.KEY_GROUP_OWNER);
        } else {
            arrayList = null;
        }
        if (groupInfoParam == null) {
            groupInfoParam = new GroupInfoParam();
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        return new f(this.context, groupInfoParam, arrayList);
    }
}
