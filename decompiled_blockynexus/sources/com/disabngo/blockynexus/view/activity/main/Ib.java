package com.disabngo.blockynexus.view.activity.main;

import android.app.Activity;
import android.os.Process;
import android.util.Log;
import com.disabngo.blockynexus.view.dialog.ReportDialog;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.ReportInfo;
import com.sandboxol.center.router.moduleInfo.login.LoginMessageToken;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.messager.MessagerClient;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Ib implements Observer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f10785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10786b;

    Ib(bc bcVar, Activity activity) {
        this.f10786b = bcVar;
        this.f10785a = activity;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            SharedUtils.putString(this.f10785a, SharedConstant.REPORT_INFO, jSONObject.toString());
            final ReportInfo reportInfo = (ReportInfo) new com.google.gson.j().a(jSONObject.toString(), ReportInfo.class);
            if (1 == reportInfo.getStatus()) {
                Observable<Long> observableObserveOn = Observable.timer(3L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
                final Activity activity = this.f10785a;
                observableObserveOn.subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.x
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f10982a.a(activity, reportInfo, (Long) obj);
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void b() {
        MessagerClient.getIns().sendMsg0(LoginMessageToken.REPEAT_LOGIN);
        this.f10786b.f10881b = null;
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
    }

    public /* synthetic */ void a(Activity activity, ReportInfo reportInfo, Long l) {
        if (this.f10786b.f10881b == null || !this.f10786b.f10881b.isShowing()) {
            this.f10786b.f10881b = new ReportDialog(activity, reportInfo).a(new ReportDialog.a() { // from class: com.disabngo.blockynexus.view.activity.main.v
                @Override // com.disabngo.blockynexus.view.dialog.ReportDialog.a
                public final void onLeftClick() {
                    Ib.a();
                }
            }).a(new ReportDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.main.w
                @Override // com.disabngo.blockynexus.view.dialog.ReportDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f10979a.b();
                }
            });
            this.f10786b.f10881b.show();
        }
    }

    static /* synthetic */ void a() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        Process.killProcess(Process.myPid());
    }
}
