package com.disabngo.blockynexus.e.b.o;

import android.content.Context;
import com.disabngo.blockynexus.web.FriendApi;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.c.P;
import com.sandboxol.greendao.entity.Friend;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ChatModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, Integer> f10019a = new HashMap();

    public void b(Context context) {
        a(context);
    }

    public void c(Context context) {
        GroupChatApi.getGroupChatList(context, 0, 200, new C0896t(this, context));
    }

    public void a(Context context) {
        UserApi.getRongToken(context, new C0892p(this, context));
    }

    public void a(Context context, int i, int i2) {
        FriendApi.friendList(context, i, i2, new C0893q(this, i, context, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Context context) {
        P.newInstance().a(32L, new C0895s(this, i, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, PageData<Friend> pageData) {
        if (pageData.getPageNo() == 0) {
            P.newInstance().b();
        }
        List<Friend> data = pageData.getData();
        this.f10019a.put(Integer.valueOf(pageData.getPageNo()), 0);
        for (int i = 0; i < data.size(); i++) {
            P.newInstance().a(data.get(i), new C0897u(this, pageData, data));
        }
    }
}
