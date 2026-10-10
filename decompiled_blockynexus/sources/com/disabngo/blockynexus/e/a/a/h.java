package com.disabngo.blockynexus.e.a.a;

import android.content.Context;
import com.sandboxol.center.utils.GameIdRemarkUtils;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.greendao.c.C2716aa;
import com.sandboxol.greendao.c.C2720ca;
import com.sandboxol.greendao.c.W;
import com.sandboxol.greendao.c.Y;
import com.sandboxol.greendao.c.ga;
import com.sandboxol.greendao.c.ha;
import com.sandboxol.greendao.c.ja;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: GameListDBCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Game> f9076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Game> f9077b;

    /* JADX INFO: compiled from: GameListDBCache.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f9078a = new h(null);
    }

    /* synthetic */ h(b bVar) {
        this();
    }

    public static h c() {
        return a.f9078a;
    }

    public List<Game> d() {
        return this.f9076a;
    }

    private h() {
        this.f9076a = new ArrayList();
        this.f9077b = new ArrayList();
    }

    public void c(Context context) {
        ga.newInstance().b(new b(this));
    }

    public void a(Context context) {
        c(context);
        b(context);
    }

    public void b(Context context, Action1<List<Game>> action1) {
        GameApi.recentlyPlayList(context, new c(this, action1));
    }

    public void b(Context context) {
        ja.newInstance().c(new d(this));
    }

    public void a() {
        this.f9076a.clear();
        ga.newInstance().a();
    }

    public List<Game> b() {
        return this.f9077b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<Game> list) {
        ga.newInstance().a(new f(this, list));
    }

    public void a(Context context, Action1<List<Game>> action1) {
        GameApi.getGameListGuessYouLike(context, new e(this, action1));
    }

    public List<Game> a(Game game) {
        game.setGameId(GameIdRemarkUtils.singleGameToHallGame(game.getGameId()));
        if (!this.f9076a.contains(game)) {
            this.f9076a.add(0, game);
            ga.newInstance().a(game);
        } else {
            List<Game> list = this.f9076a;
            Collections.swap(list, list.indexOf(game), 0);
        }
        return this.f9076a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<Game> list) {
        ja.newInstance().a(new g(this, list));
    }

    public void a(boolean z) {
        if (z) {
            ja.newInstance().a();
            ga.newInstance().a();
            ha.newInstance().a();
            C2720ca.newInstance().a();
            C2716aa.newInstance().a();
            W.newInstance().a();
            Y.newInstance().a();
        }
    }
}
