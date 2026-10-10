package com.disabngo.blockynexus.view.dialog.activity;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.tendcloud.tenddata.ab;
import java.util.TimerTask;

/* JADX INFO: compiled from: ActivityTaskCountDownUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class v extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f11509a;

    v(w wVar) {
        this.f11509a = wVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f11509a.f11514e += ab.R;
        w wVar = this.f11509a;
        wVar.f11515f = SharedUtils.getLong(wVar.f11511b, SharedConstant.ONLINE_TIME);
        if (this.f11509a.g + this.f11509a.f11514e > this.f11509a.j) {
            SharedUtils.putLong(this.f11509a.f11511b, SharedConstant.ONLINE_TIME, 0L);
            this.f11509a.f11514e = 0L;
            return;
        }
        SharedUtils.putLong(this.f11509a.f11511b, SharedConstant.ONLINE_TIME, this.f11509a.f11515f + ab.R);
        w wVar2 = this.f11509a;
        wVar2.k = wVar2.f11514e + this.f11509a.h;
        int i = 0;
        if (this.f11509a.p) {
            if (this.f11509a.l == null || this.f11509a.l.size() == 0) {
                return;
            }
            while (i < this.f11509a.l.size()) {
                if (this.f11509a.n <= i && ((Long) this.f11509a.l.get(i)).longValue() > 0 && ((Long) this.f11509a.l.get(i)).longValue() < this.f11509a.k) {
                    Messenger.getDefault().send(true, MessageToken.TOKEN_ACTIVITY_RED_POINT);
                    this.f11509a.n = i + 1;
                }
                i++;
            }
            return;
        }
        if (this.f11509a.m == null || this.f11509a.m.size() == 0) {
            return;
        }
        while (i < this.f11509a.m.size()) {
            if (this.f11509a.o <= i && ((Long) this.f11509a.m.get(i)).longValue() > 0 && ((Long) this.f11509a.m.get(i)).longValue() < this.f11509a.k) {
                Messenger.getDefault().send(true, MessageToken.TOKEN_ACTIVITY_RED_POINT);
                this.f11509a.o = i + 1;
            }
            i++;
        }
    }
}
