package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.Game;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: PageGuessYouLikeItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class V extends F {
    public V(Context context, Game game) {
        super(context, game);
        List<Game> listB = com.disabngo.blockynexus.e.a.a.h.c().b();
        if (listB != null && listB.size() > 0) {
            replaceData(listB);
        }
        com.disabngo.blockynexus.e.a.a.h.c().a(context, new C1134d(this));
        initMessenger();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_RECOMMEND_TYPE, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.w
            @Override // rx.functions.Action0
            public final void call() {
                this.f11833a.f();
            }
        });
    }

    @Override // com.disabngo.blockynexus.view.fragment.main.F
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel listItemViewModel) {
        gVar.a(520, R.layout.item_guess_you_like_item_new_view);
        int i2 = i + 1;
        ((Game) listItemViewModel.getItem()).setIndex(i2);
        ((com.disabngo.blockynexus.e.b.I.c) listItemViewModel).b(i2);
    }

    @Override // com.disabngo.blockynexus.view.fragment.main.F
    public ListItemViewModel<Game> c(Game game) {
        return new com.disabngo.blockynexus.e.b.I.c(this.context, game);
    }

    public /* synthetic */ void f() {
        com.disabngo.blockynexus.e.a.a.h.c().a(this.context, new C1134d(this));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
