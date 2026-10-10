package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.Game;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: BaseGameItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class E extends ListItemViewModel<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Observable.a f11760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Observable.a f11761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f11762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f11763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f11764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Integer> f11765f;
    public ObservableField<Boolean> g;
    public ObservableField<Boolean> h;
    public ObservableField<Boolean> i;
    public ObservableField<Boolean> j;

    public E(Context context, Game game) {
        super(context, game);
        this.f11762c = new ObservableField<>(false);
        this.f11763d = new ObservableField<>(false);
        this.f11764e = new ObservableField<>("");
        this.f11765f = new ObservableField<>(0);
        this.g = new ObservableField<>(false);
        this.h = new ObservableField<>(false);
        this.i = new ObservableField<>(false);
        this.j = new ObservableField<>(false);
        initMessenger();
        h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h() {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(((Game) this.item).getGameId());
        if (gameProgressInfo == null) {
            this.g.set(false);
        } else {
            this.i = gameProgressInfo.getIsAnimEnd();
            this.h = gameProgressInfo.getIsError();
            if (this.i.get().booleanValue() || this.h.get().booleanValue()) {
                this.g.set(false);
            } else {
                this.g.set(true);
            }
            this.f11762c = gameProgressInfo.getIsDownload();
            this.f11763d = gameProgressInfo.getIsFinish();
            this.f11764e = gameProgressInfo.getProgressPercentStr();
            this.f11765f = gameProgressInfo.getProgressValue();
            this.f11761b = new C(this, gameProgressInfo);
            this.h.addOnPropertyChangedCallback(this.f11761b);
            this.f11760a = new D(this, gameProgressInfo);
            this.i.addOnPropertyChangedCallback(this.f11760a);
        }
        this.j.set(Boolean.valueOf(SharedUtils.getBoolean(this.context, SharedConstant.IS_BED_WAR_DOWNLOAD, false)));
        notifyChange();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_DOWNLOAD_RES, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.main.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11804a.a((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_DOWNLAOD_BACKGROUND, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11805a.f();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(String str) {
        T t;
        if (str == null || (t = this.item) == 0 || ((Game) t).getGameId() == null || !str.equals(((Game) this.item).getGameId())) {
            return;
        }
        h();
    }

    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void setItem(Game game) {
        super.setItem(game);
        h();
    }

    public /* synthetic */ void f() {
        List<String> downloadGames = AppInfoCenter.newInstance().getAppConfig().getDownloadGames();
        if (downloadGames == null || downloadGames.size() == 0) {
            return;
        }
        Iterator<String> it = downloadGames.iterator();
        while (it.hasNext()) {
            if (it.next().equals(getItem().getGameId())) {
                this.j.set(true);
                return;
            }
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        Observable.a aVar = this.f11761b;
        if (aVar != null) {
            this.h.removeOnPropertyChangedCallback(aVar);
        }
        Observable.a aVar2 = this.f11760a;
        if (aVar2 != null) {
            this.i.removeOnPropertyChangedCallback(aVar2);
        }
        Messenger.getDefault().unregister(this);
        super.onDestroy();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public Game getItem() {
        return (Game) super.getItem();
    }
}
