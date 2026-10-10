package com.disabngo.blockynexus.view.activity.discover;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.A;
import com.disabngo.blockynexus.view.fragment.main.X;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import com.sandboxol.common.widget.rv.pagerv.TypePageData;
import com.sandboxol.greendao.c.B;
import com.sandboxol.greendao.c.C2716aa;
import com.sandboxol.greendao.c.C2720ca;
import com.sandboxol.greendao.c.W;
import com.sandboxol.greendao.c.Y;
import com.sandboxol.greendao.entity.Game;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DiscoverGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends PageListModel<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f10592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Integer, Boolean> f10593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<Long, Integer> f10594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private B f10595e;

    public m(Context context, int i, String str, long j) {
        super(context, i);
        this.f10593c = new HashMap();
        this.f10594d = new HashMap();
        this.f10591a = str;
        this.f10592b = j;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_DISCOVER_TYPE;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<Game> listItemViewModel) {
        gVar.a(493, R.layout.item_more_game_item_new_view);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<Game>> onResponseListener) {
        if (i == 0) {
            this.f10593c.clear();
        }
        if (this.f10591a.equals(StringConstant.GAME_ORDER_TYPE_ONLINE)) {
            this.f10595e = C2720ca.newInstance();
            C2720ca.newInstance().a(i, this.f10592b, new g(this, i, i2, onResponseListener));
        } else if (this.f10591a.equals("new")) {
            this.f10595e = C2716aa.newInstance();
            C2716aa.newInstance().a(i, this.f10592b, new h(this, i, i2, onResponseListener));
        } else if (this.f10591a.equals(StringConstant.GAME_ORDER_TYPE_APPRECIATE)) {
            this.f10595e = W.newInstance();
            W.newInstance().a(i, this.f10592b, new i(this, i, i2, onResponseListener));
        } else {
            this.f10595e = Y.newInstance();
            Y.newInstance().a(i, this.f10592b, new j(this, i, i2, onResponseListener));
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<Game> getItemViewModel(Game game) {
        return new X(this.context, game);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, List<Game> list, OnResponseListener<PageData<Game>> onResponseListener) {
        PageData<Game> pageData = new PageData<>();
        if (list != null && list.size() > 0) {
            pageData.setPageNo(i);
            pageData.setPageSize(i2);
            this.f10593c.put(Integer.valueOf(i), true);
            pageData.setData(list);
            if (this.f10594d.containsKey(Long.valueOf(this.f10592b))) {
                pageData.setTotalPage(this.f10594d.get(Long.valueOf(this.f10592b)).intValue());
            } else {
                pageData.setTotalPage(i + 2);
            }
            onResponseListener.onSuccess(pageData);
        } else {
            this.f10593c.put(Integer.valueOf(i), false);
        }
        a(i, i2, onResponseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, OnResponseListener<PageData<Game>> onResponseListener) {
        if (i == 0 && A.a()) {
            i2 += 10;
        }
        GameApi.getGameListByCondition(this.context, this.f10591a, this.f10592b, i, i2, new k(this, i, onResponseListener));
    }

    public void a(String str, long j) {
        this.f10591a = str;
        this.f10592b = j;
        Messenger.getDefault().send(RefreshMsg.create(), getRefreshToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TypePageData<Game> typePageData, int i) {
        B b2 = this.f10595e;
        if (b2 != null) {
            b2.a(i, new l(this, typePageData, i));
        }
    }
}
