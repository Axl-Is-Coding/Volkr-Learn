package com.disabngo.blockynexus.view.fragment.tribehas;

import com.disabngo.blockynexus.d.C0509f;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.TribeMember;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: TribeHasListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class K extends OnResponseListener<List<TribeMember>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ L f11978b;

    K(L l, OnResponseListener onResponseListener) {
        this.f11978b = l;
        this.f11977a = onResponseListener;
    }

    static /* synthetic */ int a(TribeMember tribeMember, TribeMember tribeMember2) {
        return -(tribeMember.getExperience() - tribeMember2.getExperience());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f11977a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f11977a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<TribeMember> list) {
        Collections.sort(list, new Comparator() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.m
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return K.a((TribeMember) obj, (TribeMember) obj2);
            }
        });
        this.f11977a.onSuccess(list);
        C0509f.a().a(list);
        for (TribeMember tribeMember : list) {
            if (tribeMember.getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
                TribeCenter.newInstance().tribeRole.set(Integer.valueOf(tribeMember.getRole()));
            }
            if (tribeMember.getNickName() != null) {
                com.disabngo.blockynexus.utils.logic.N.a(TribeCenter.newInstance().tribeClanId.get().longValue(), tribeMember.getUserId(), tribeMember.getNickName(), tribeMember.getHeadPic());
            }
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_TRIBE_HAS);
    }
}
