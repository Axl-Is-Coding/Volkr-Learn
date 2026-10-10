package com.disabngo.blockynexus.e.b.o;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.o.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChatModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0893q extends OnResponseListener<PageData<Friend>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f10008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ v f10009d;

    C0893q(v vVar, int i, Context context, int i2) {
        this.f10009d = vVar;
        this.f10006a = i;
        this.f10007b = context;
        this.f10008c = i2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10009d.a(this.f10006a, this.f10007b);
        FriendOnError.showErrorTip(this.f10007b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10009d.a(this.f10006a, this.f10007b);
        ServerOnError.showOnServerError(this.f10007b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<Friend> pageData) {
        if (pageData != null && pageData.getData() != null && pageData.getData().size() != 0 && this.f10006a == 0) {
            ReportDataAdapter.onEvent(this.f10007b, EventConstant.HAS_FRIEND, String.valueOf(pageData.getTotalSize()));
        }
        if (pageData == null) {
            return;
        }
        if (this.f10006a == 0) {
            Friend friend = new Friend();
            friend.setNickName(this.f10007b.getString(R.string.friend_system_message));
            friend.setUserId(32L);
            friend.setPicUrl(UrlConstant.IC_CUSTOM_SERVICE);
            friend.setStatus(10);
            pageData.getData().add(0, friend);
            pageData.getData().add(AccountCenter.newInstance().getMyInfo());
        }
        this.f10009d.a(this.f10007b, (PageData<Friend>) pageData);
        int totalPage = pageData.getTotalPage() - 1;
        int i = this.f10006a;
        if (totalPage > i) {
            this.f10009d.a(this.f10007b, i + 1, this.f10008c);
        }
    }
}
