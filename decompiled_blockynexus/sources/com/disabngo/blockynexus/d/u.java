package com.disabngo.blockynexus.d;

import android.text.TextUtils;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GroupUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class u extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f7239a;

    u(y yVar) {
        this.f7239a = yVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0 || !this.f7239a.a(groupInfo.getGroupMembers(), AccountCenter.newInstance().userId.get().longValue())) {
            return;
        }
        String groupNotice = groupInfo.getGroupNotice();
        List<String> noticePic = groupInfo.getNoticePic();
        if (!TextUtils.isEmpty(groupNotice) || (noticePic != null && noticePic.size() > 0)) {
            if (TextUtils.isEmpty(groupNotice)) {
                groupNotice = "";
            }
            if (noticePic == null || noticePic.size() == 0) {
                noticePic = new ArrayList<>();
            }
            this.f7239a.a(groupInfo.getGroupId(), groupNotice, (List<String>) noticePic);
        } else {
            this.f7239a.b(groupInfo.getGroupId(), "", new ArrayList());
        }
        this.f7239a.f(groupInfo);
        this.f7239a.i(groupInfo);
        this.f7239a.j(groupInfo);
        N.a(groupInfo.getGroupId(), groupInfo.getGroupName(), "");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f7239a.a(), i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f7239a.a(), i);
    }
}
