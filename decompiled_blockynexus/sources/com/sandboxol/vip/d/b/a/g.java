package com.sandboxol.vip.d.b.a;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.vip.entity.PrivilegeInfo;

/* JADX INFO: compiled from: PrivilegeDetailPageViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class g extends ListItemViewModel<PrivilegeInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19079a;

    public g(Context context, PrivilegeInfo privilegeInfo, int i) {
        super(context, privilegeInfo);
        this.f19079a = i;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public PrivilegeInfo getItem() {
        return (PrivilegeInfo) super.getItem();
    }
}
