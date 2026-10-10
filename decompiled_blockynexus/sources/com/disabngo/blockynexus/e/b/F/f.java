package com.disabngo.blockynexus.e.b.F;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0644le;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import java.util.List;

/* JADX INFO: compiled from: GroupMemberFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends TemplateFragment<u, AbstractC0644le> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<GroupMember> f9246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9249d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0644le abstractC0644le, u uVar) {
        abstractC0644le.a(uVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_member;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public u getViewModel() {
        int i;
        if (getArguments() != null) {
            int i2 = getArguments().getInt(StringConstant.TYPE_LIST_GROUP);
            this.f9246a = getArguments().getParcelableArrayList(SharedConstant.KEY_GROUP_VIEW_ALL_MEMBER);
            this.f9247b = getArguments().getLong(StringConstant.KEY_ID_GROUP);
            this.f9248c = getArguments().getString(StringConstant.KEY_NAME_GROUP);
            this.f9249d = getArguments().getInt(SharedConstant.KEY_GROUP_IDENTITY, 0);
            i = i2;
        } else {
            i = 0;
        }
        return new u(this.context, i, this.f9246a, this.f9247b, this.f9248c, this.f9249d);
    }
}
