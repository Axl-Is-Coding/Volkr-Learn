package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.videosubmit.view.dialog.GuideDialog;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class lc implements com.sandboxol.greendao.a.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ nc f10927a;

    lc(nc ncVar) {
        this.f10927a = ncVar;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        if (!bool.booleanValue() || BaseApplication.getApp().getMetaDataAppVersion() < AppInfoCenter.newInstance().getAppConfig().getVideoSubmitActivityCode()) {
            this.f10927a.f10940d.a((Context) this.f10927a.f10939c, false);
        } else {
            this.f10927a.f10940d.a(this.f10927a.f10939c, new GuideDialog.Listener() { // from class: com.disabngo.blockynexus.view.activity.main.P
                @Override // com.sandboxol.videosubmit.view.dialog.GuideDialog.Listener
                public final void callBack() {
                    this.f10817a.a();
                }
            });
        }
        com.disabngo.blockynexus.b.b.a().a(this.f10927a.f10939c, this.f10927a.w);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }

    public /* synthetic */ void a() {
        this.f10927a.f10940d.a((Context) this.f10927a.f10939c, false);
    }
}
