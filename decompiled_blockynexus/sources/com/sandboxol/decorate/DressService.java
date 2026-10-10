package com.sandboxol.decorate;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.databinding.ObservableMap;
import cn.qqtheme.framework.widget.WheelView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.PartyDressManager;
import com.sandboxol.center.router.moduleApi.IDressService;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.clothes.EchoesGLSurfaceView;
import com.sandboxol.clothes.EchoesHandler;
import com.sandboxol.clothes.EchoesRenderer;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.manager.g;
import com.sandboxol.decorate.manager.h;
import com.sandboxol.decorate.manager.n;
import com.sandboxol.decorate.manager.v;
import com.sandboxol.decorate.web.t;
import com.sandboxol.decorate.web.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = RouterServicePath.EventDress.DRESS_SERVICE)
public class DressService implements IDressService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16951a = "com.sandboxol.decorate.DressService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EchoesGLSurfaceView f16952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewGroup f16953c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewGroup f16954d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Queue<Action0> f16955e = new LinkedList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16956f = StringConstant.CUSTOM_BG_0;
    private float g = 1.0f;
    private float h = WheelView.DividerConfig.FILL;
    private boolean i = true;
    private boolean j = true;
    private int k;

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Iterator<Action0> it = this.f16955e.iterator();
        while (it.hasNext()) {
            it.next().call();
            it.remove();
        }
    }

    public void b() {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f16952b;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.onResume();
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void changeBackground(String str) {
        this.f16956f = str;
        EchoesGLSurfaceView echoesGLSurfaceView = this.f16952b;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.changeBackgroundImage(str);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void changeSex(int i) {
        this.k = i;
        EchoesGLSurfaceView echoesGLSurfaceView = this.f16952b;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.changeSex(i);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void checkRes(int i, String str, String str2) {
        try {
            this.f16952b.checkResource(i, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void clothTypes(String str) {
        if (this.f16952b == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length != 2) {
                if (strArrSplit.length == 1) {
                    String[] strArrSplit2 = str.split("-");
                    this.f16952b.changeSkinColor(g.b(strArrSplit2[0]), g.b(strArrSplit2[1]), g.b(strArrSplit2[2]), g.b(strArrSplit2[3]));
                    return;
                }
                return;
            }
            if (!str.contains("idle") && !str.contains("_action")) {
                if (!str.contains("_bg")) {
                    this.f16952b.changeParts(strArrSplit[0], strArrSplit[1]);
                    return;
                }
                EchoesGLSurfaceView echoesGLSurfaceView = this.f16952b;
                StringBuilder sb = new StringBuilder();
                sb.append(strArrSplit[0]);
                String str2 = ".png";
                if (!strArrSplit[1].equals("png")) {
                    str2 = strArrSplit[1] + ".png";
                }
                sb.append(str2);
                echoesGLSurfaceView.changeBackgroundImage(sb.toString());
                return;
            }
            this.f16952b.changeChangeDefaultIdle(Integer.valueOf(strArrSplit[1]).intValue());
        } catch (Exception e2) {
            Log.e("clothTypes", "clothTypes: " + e2.toString());
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void getFriendUsingList(Context context, long j, OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        t.b(context, j, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void getUsingDressList(Context context, OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        t.c(context, new f(this, onResponseListener, context));
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void getUsingList(Context context) {
        if (!v.a().c() || v.a().d()) {
            t.c(context, new e(this, context));
        } else {
            c();
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void handleOnesies(List<SingleDressInfo> list, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2, boolean z) {
        n.b().a(list, observableMap, observableMap2, z);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void onCreate(final Context context) {
        if (this.f16952b == null) {
            this.f16952b = new EchoesGLSurfaceView(context);
            this.f16952b.setEchoesRenderer(new EchoesRenderer(context));
            if (AccountCenter.newInstance().login.get().booleanValue()) {
                EchoesGLSurfaceView echoesGLSurfaceView = this.f16952b;
                echoesGLSurfaceView.setMainHandler(new EchoesHandler(context, echoesGLSurfaceView, AccountCenter.newInstance().sex.get().intValue()));
            } else {
                EchoesGLSurfaceView echoesGLSurfaceView2 = this.f16952b;
                echoesGLSurfaceView2.setMainHandler(new EchoesHandler(context, echoesGLSurfaceView2, 1));
            }
            Messenger.getDefault().register(this, CommonMessageToken.TOKEN_DECORATION_INIT_FINISH, new Action0() { // from class: com.sandboxol.decorate.b
                @Override // rx.functions.Action0
                public final void call() {
                    this.f16971a.a(context);
                }
            });
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void onDestroy() {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f16952b;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.onDestroy();
            this.f16952b = null;
            this.f16953c = null;
        }
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void onPauseByGroupView(ViewGroup viewGroup) {
        a();
        try {
            if (this.f16953c != null && this.f16953c == viewGroup) {
                this.f16953c.removeView(this.f16952b);
                this.f16953c = null;
            }
            if (this.f16954d != null) {
                this.f16954d.addView(this.f16952b);
                this.f16953c = this.f16954d;
                this.f16954d = null;
            }
        } catch (Exception unused) {
            ReportDataAdapter.onEvent(viewGroup.getContext(), EventConstant.ON_PAUSE_EXCEPTION, f16951a);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void onResumeByViewGroup(ViewGroup viewGroup, Action0 action0) {
        onCreate(BaseApplication.getContext());
        this.f16956f = StringConstant.CUSTOM_BG_0;
        this.k = AccountCenter.newInstance().sex.get().intValue();
        try {
            this.f16955e.offer(action0);
            if (this.f16953c == null) {
                viewGroup.addView(this.f16952b);
                this.f16953c = viewGroup;
            } else if (this.f16953c != viewGroup) {
                this.f16954d = viewGroup;
            } else {
                getUsingList(viewGroup.getContext());
            }
        } catch (Exception unused) {
            ReportDataAdapter.onEvent(viewGroup.getContext(), EventConstant.ON_RESUME_EXCEPTION, f16951a);
        }
        b();
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void reloadActor() {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f16952b;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.reloadActor();
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void setShowUsingDress(boolean z) {
        this.j = z;
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void showShopErrorTip(Context context, int i) {
        x.a(context, i);
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void startShopActivity(Context context) {
        h.a(context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void useClothes(ObservableMap<Long, String> observableMap) {
        if (this.f16952b != null) {
            Observable.from(observableMap.values()).observeOn(Schedulers.newThread()).subscribe(new Action1() { // from class: com.sandboxol.decorate.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f16957a.a((String) obj);
                }
            });
        }
    }

    public /* synthetic */ void a(Context context) {
        if (this.f16952b != null) {
            if (!PartyDressManager.isPartyDress()) {
                this.f16952b.handleChangeMode(0, 1);
            }
            this.f16952b.changeBackgroundImage(this.f16956f);
            this.f16952b.changeSex(this.k);
            if (!this.j || PartyDressManager.isPartyDress()) {
                c();
            } else {
                getUsingList(context);
            }
        }
    }

    public void a() {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f16952b;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.onPause();
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IDressService
    public void onPauseByGroupView() {
        a();
        try {
            if (this.f16952b != null) {
                this.f16952b.onDestroy();
                this.f16952b = null;
            }
            Messenger.getDefault().unregister(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(String str) {
        g.a(this.f16952b, str);
    }
}
