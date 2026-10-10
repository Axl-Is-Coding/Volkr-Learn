package com.disabngo.blockynexus.service;

import android.content.Context;
import android.view.ViewGroup;
import androidx.databinding.ObservableMap;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.disabngo.blockynexus.d.K;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleApi.IPartyDressService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.clothes.EchoesGLSurfaceView;
import com.sandboxol.clothes.EchoesHandler;
import com.sandboxol.clothes.EchoesRenderer;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.web.t;
import com.sandboxol.greendao.entity.TeamMember;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = RouterServicePath.EventPartyDress.PARTY_DRESS_SERVICE)
public class PartyDressService implements IPartyDressService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10489a = "com.disabngo.blockynexus.service.PartyDressService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f10490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EchoesGLSurfaceView f10491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewGroup f10492d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Queue<Action0> f10493e = new LinkedList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10494f = StringConstant.CUSTOM_BG_PARTY_4;
    private boolean g = false;

    private void b() {
        Iterator<Action0> it = this.f10493e.iterator();
        while (it.hasNext()) {
            it.next().call();
        }
        this.f10493e.clear();
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void addMember(TeamMember teamMember) {
        if (this.f10491c != null) {
            if (teamMember.getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
                this.f10491c.changeSex(teamMember.getSex());
                this.f10491c.changeName(teamMember.getNickName());
                if (teamMember.isCaptain()) {
                    this.f10491c.handleChangePartyOwner(teamMember.getNickName());
                }
                if (teamMember.getVip() != 0) {
                    this.f10491c.changeVipLevel(teamMember.getVip());
                }
            } else {
                this.f10491c.handleAddActorDisplay(teamMember.getNickName());
                this.f10491c.changeSexOtherPlayer(teamMember.getSex(), teamMember.getNickName());
                if (teamMember.isCaptain()) {
                    this.f10491c.handleChangePartyOwner(teamMember.getNickName());
                }
                if (teamMember.getVip() != 0) {
                    this.f10491c.changeVipLevelOtherPlayer(teamMember.getVip(), teamMember.getNickName());
                }
                this.f10491c.changeOnGameState(teamMember.getNickName(), teamMember.getStatus() == 1);
            }
            a(this.f10490b, teamMember.getUserId(), teamMember.getNickName());
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void changeBackground(String str) {
        this.f10494f = str;
        EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.changeBackgroundImage(str);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void changeMode(int i, int i2) {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.handleChangeMode(i, i2);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void changeOnGameState(String str, boolean z) {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.changeOnGameState(str, z);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void changePartyOwner(String str) {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.handleChangePartyOwner(str);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void changeSex(int i) {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.changeSex(i);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void changeSexOtherPlayer(int i, String str) {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.changeSexOtherPlayer(i, str);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public boolean getPartyDress() {
        return this.g;
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void onCreate(Context context) {
        this.f10490b = context;
        if (this.f10491c == null) {
            this.f10491c = new EchoesGLSurfaceView(context);
            this.f10491c.setEchoesRenderer(new EchoesRenderer(context));
            if (AccountCenter.newInstance().login.get().booleanValue()) {
                EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
                echoesGLSurfaceView.setMainHandler(new EchoesHandler(context, echoesGLSurfaceView, AccountCenter.newInstance().sex.get().intValue()));
            } else {
                EchoesGLSurfaceView echoesGLSurfaceView2 = this.f10491c;
                echoesGLSurfaceView2.setMainHandler(new EchoesHandler(context, echoesGLSurfaceView2, 1));
            }
            Messenger.getDefault().register(this, CommonMessageToken.TOKEN_DECORATION_INIT_FINISH, new Action0() { // from class: com.disabngo.blockynexus.service.b
                @Override // rx.functions.Action0
                public final void call() {
                    this.f10498a.a();
                }
            });
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void onDestroy() {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.onDestroy();
            this.f10491c = null;
            this.f10492d = null;
        }
        this.g = false;
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void onPauseByGroupView(ViewGroup viewGroup) {
        try {
            this.g = false;
            if (this.f10492d == null || this.f10492d != viewGroup) {
                return;
            }
            this.f10492d.removeView(this.f10491c);
            this.f10492d = null;
        } catch (Exception unused) {
            ReportDataAdapter.onEvent(viewGroup.getContext(), EventConstant.ON_PAUSE_EXCEPTION, f10489a);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void onResumeByViewGroup(Context context, ViewGroup viewGroup, Action0 action0) {
        try {
            this.g = true;
            this.f10493e.offer(action0);
            if (this.f10492d == null) {
                if (this.f10491c == null) {
                    onCreate(context);
                }
                viewGroup.addView(this.f10491c);
                this.f10492d = viewGroup;
            }
        } catch (Exception unused) {
            ReportDataAdapter.onEvent(viewGroup.getContext(), EventConstant.ON_RESUME_EXCEPTION, f10489a);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void removeMember(long j, String str) {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.handleDeleteActorDisplay(str);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IPartyDressService
    public void sendChat(String str, String str2) {
        EchoesGLSurfaceView echoesGLSurfaceView = this.f10491c;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.handleChat(str, str2);
        }
    }

    public /* synthetic */ void a() {
        if (this.f10491c != null) {
            b();
        }
    }

    private void a(Context context, long j, String str) {
        t.b(context, j, new f(this, j, str, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ObservableMap<Long, String> observableMap) {
        if (this.f10491c != null) {
            Observable.from(observableMap.values()).observeOn(Schedulers.newThread()).subscribe(new Action1() { // from class: com.disabngo.blockynexus.service.c
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f10499a.a((String) obj);
                }
            });
        }
    }

    public /* synthetic */ void a(String str) {
        K.a(this.f10491c, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ObservableMap<Long, String> observableMap, final String str) {
        if (this.f10491c != null) {
            Observable.from(observableMap.values()).observeOn(Schedulers.newThread()).subscribe(new Action1() { // from class: com.disabngo.blockynexus.service.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f10496a.a(str, (String) obj);
                }
            });
        }
    }

    public /* synthetic */ void a(String str, String str2) {
        K.a(this.f10491c, str2, str);
    }
}
