package com.disabngo.blockynexus.view.dialog;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.Qa;
import com.sandboxol.center.router.manager.GameDetailManager;
import com.sandboxol.center.utils.GameIdRemarkUtils;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: compiled from: ScrapRewardDetailsDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Ka implements Qa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ La f11316a;

    Ka(La la) {
        this.f11316a = la;
    }

    @Override // com.disabngo.blockynexus.view.dialog.Qa.a
    public void a() {
        Oa oa = this.f11316a.f11318a.f11320a.f11322a;
        oa.f11332c.a(oa.f11331b);
    }

    @Override // com.disabngo.blockynexus.view.dialog.Qa.a
    public void a(String str) {
        Oa oa = this.f11316a.f11318a.f11320a.f11322a;
        oa.f11332c.a(oa.f11331b);
        GameDetailManager.enterGameDetail(((FullScreenDialog) this.f11316a.f11318a.f11320a.f11322a.f11332c).context, ((FullScreenDialog) this.f11316a.f11318a.f11320a.f11322a.f11332c).context.getString(R.string.main_game), GameIdRemarkUtils.singleGameToHallGame(str));
        if (((FullScreenDialog) this.f11316a.f11318a.f11320a.f11322a.f11332c).context instanceof Activity) {
            ((Activity) ((FullScreenDialog) this.f11316a.f11318a.f11320a.f11322a.f11332c).context).finish();
        }
    }
}
