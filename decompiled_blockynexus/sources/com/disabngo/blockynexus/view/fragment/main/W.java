package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.Game;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: PageLatelyPlayedItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class W extends F {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObservableField<Boolean> f11803d;

    public W(Context context, Game game, ObservableField<Boolean> observableField) {
        super(context, game);
        this.f11803d = observableField;
        List<Game> listD = com.disabngo.blockynexus.e.a.a.h.c().d();
        if (listD == null || listD.size() <= 0) {
            com.disabngo.blockynexus.e.a.a.h.c().b(context, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.main.x
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f11834a.a((List) obj);
                }
            });
        } else {
            replaceData(listD);
        }
        initMessenger();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_LATELY_TYPE, Game.class, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.main.z
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11836a.d((Game) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_LATELY_TYPE, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.main.A
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11754a.a((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void a(List list) {
        replaceData(list);
        if (ChannelManager.isBeta() || list == null || list.size() != 0) {
            return;
        }
        Messenger.getDefault().send(true, MessageToken.TOKEN_NEW_USER_MAIN_FRAGMENT_GUIDE);
    }

    public /* synthetic */ void b(List list) {
        replaceData(list);
    }

    @Override // com.disabngo.blockynexus.view.fragment.main.F
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel listItemViewModel) {
        gVar.a(368, R.layout.item_lately_play_item_new_view);
    }

    @Override // com.disabngo.blockynexus.view.fragment.main.F
    public ListItemViewModel<Game> c(Game game) {
        return new com.disabngo.blockynexus.e.b.N.c(this.context, game, this.f11803d);
    }

    public /* synthetic */ void d(Game game) {
        replaceData(com.disabngo.blockynexus.e.a.a.h.c().a(game));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public /* synthetic */ void a(Boolean bool) {
        com.disabngo.blockynexus.e.a.a.h.c().b(this.context, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.main.y
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11835a.b((List) obj);
            }
        });
    }
}
