package com.disabngo.blockynexus.view.widget.gameRank;

import android.content.Context;
import android.widget.PopupWindow;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.activity.discover.n;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action1;

/* JADX INFO: compiled from: GameTypeRankingViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f12095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PopupWindow f12096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f12097c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.disabngo.blockynexus.view.widget.gameRank.a.d f12098d;

    public d(Context context, final n nVar, final PopupWindow popupWindow, String str, long j) {
        this.f12095a = nVar;
        this.f12096b = popupWindow;
        this.f12098d = new com.disabngo.blockynexus.view.widget.gameRank.a.d(context, R.string.category_no_data, str, j);
        if (j >= 0) {
            Messenger.getDefault().register(this, MessageToken.TOKEN_SELECT_DISCOVER_TYPE, Long.class, new Action1() { // from class: com.disabngo.blockynexus.view.widget.gameRank.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    d.a(nVar, popupWindow, (Long) obj);
                }
            });
        } else {
            Messenger.getDefault().register(this, MessageToken.TOKEN_SELECT_DISCOVER_TYPE, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.widget.gameRank.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    d.a(nVar, popupWindow, (String) obj);
                }
            });
        }
    }

    static /* synthetic */ void a(n nVar, PopupWindow popupWindow, Long l) {
        nVar.a(l.longValue());
        popupWindow.dismiss();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void init() {
        super.init();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    static /* synthetic */ void a(n nVar, PopupWindow popupWindow, String str) {
        nVar.a(str);
        popupWindow.dismiss();
    }
}
