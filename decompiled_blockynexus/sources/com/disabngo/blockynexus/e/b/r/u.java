package com.disabngo.blockynexus.e.b.r;

import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.disabngo.blockynexus.view.activity.start.StartActivity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import io.reactivex.w;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class u implements w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10121a;

    u(v vVar) {
        this.f10121a = vVar;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
    }

    @Override // io.reactivex.w
    public void onComplete() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        ReportDataAdapter.onEvent(this.f10121a.f10122a, EventConstant.CLEAN_ALL_SUC);
        this.f10121a.m.set(false);
        Intent intent = new Intent(this.f10121a.f10122a, (Class<?>) StartActivity.class);
        intent.setFlags(268468224);
        this.f10121a.f10122a.startActivity(intent);
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        ReportDataAdapter.onError(this.f10121a.f10122a, th);
        this.f10121a.m.set(false);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
