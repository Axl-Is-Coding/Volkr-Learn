package com.disabngo.blockynexus.e.b.l;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.fragment.main.U;
import com.disabngo.blockynexus.view.fragment.main.V;
import com.disabngo.blockynexus.view.fragment.main.W;
import com.disabngo.blockynexus.view.fragment.main.X;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import com.sandboxol.greendao.c.ha;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.l.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CategoryGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0868d extends PageListModel<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, Boolean> f9896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObservableField<Boolean> f9898d;

    public C0868d(Context context, int i, ObservableField<Boolean> observableField) {
        super(context, i);
        this.f9895a = -1;
        this.f9896b = new HashMap();
        this.f9897c = true;
        this.f9898d = observableField;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_CATEGORY_TYPE;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 4;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<Game> listItemViewModel) {
        if (listItemViewModel.getItem().getPageType() == 1) {
            gVar.a(529, R.layout.content_category_lately_play);
            return;
        }
        if (listItemViewModel.getItem().getPageType() == 2) {
            gVar.a(505, R.layout.content_category_guess_you_like);
        } else if (listItemViewModel.getItem().getPageType() == 3) {
            gVar.a(265, R.layout.content_category_follow_friends);
        } else {
            gVar.a(493, R.layout.item_more_game_item_new_view);
        }
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<Game>> onResponseListener) {
        if (i != 0 || this.f9897c) {
            this.f9897c = false;
        } else {
            Messenger.getDefault().send(false, MessageToken.TOKEN_REFRESH_LATELY_TYPE);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_RECOMMEND_TYPE);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_FOLLOW_FRIENDS_LIST);
        }
        ha.newInstance().b(i, new C0865a(this, i, i2, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<Game> getItemViewModel(Game game) {
        if (game.getPageType() == 1) {
            return new W(this.context, game, this.f9898d);
        }
        if (game.getPageType() == 2) {
            return new V(this.context, game);
        }
        if (game.getPageType() == 3) {
            return new U(this.context, game);
        }
        return new X(this.context, game);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, OnResponseListener<PageData<Game>> onResponseListener) {
        GameApi.getGameListMore(this.context, i, i2, new C0866b(this, i, onResponseListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PageData<Game> pageData, int i) {
        ha.newInstance().a(i, new C0867c(this, pageData, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, PageData<Game> pageData, OnResponseListener<PageData<Game>> onResponseListener) {
        if (i == 0) {
            PageData<Game> pageData2 = new PageData<>();
            ArrayList arrayList = new ArrayList();
            if (pageData.getData() != null && pageData.getData().size() > 0) {
                arrayList.addAll(pageData.getData());
            }
            arrayList.add(0, new Game("lately_played", 1));
            arrayList.add(1, new Game("guess_you_like", 2));
            arrayList.add(2, new Game("follow_friends", 3));
            pageData2.setData(arrayList);
            onResponseListener.onSuccess(pageData2);
            return;
        }
        onResponseListener.onSuccess(pageData);
    }
}
