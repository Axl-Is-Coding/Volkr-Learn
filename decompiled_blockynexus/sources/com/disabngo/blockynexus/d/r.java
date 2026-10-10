package com.disabngo.blockynexus.d;

import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.widget.NineGirdImageView;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: GroupUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class r extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ NineGirdImageView f7233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f7234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f7235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ y f7236d;

    r(y yVar, NineGirdImageView nineGirdImageView, Map map, long j) {
        this.f7236d = yVar;
        this.f7233a = nineGirdImageView;
        this.f7234b = map;
        this.f7235c = j;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (GroupMember groupMember : groupInfo.getGroupMembers()) {
            if (groupMember.getPic() != null) {
                arrayList.add(groupMember.getPic());
                if (arrayList.size() >= 9) {
                    break;
                }
            }
        }
        this.f7233a.setImagesData(arrayList);
        this.f7234b.put(Long.valueOf(this.f7235c), arrayList);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f7236d.a(), i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f7236d.a(), i);
    }
}
