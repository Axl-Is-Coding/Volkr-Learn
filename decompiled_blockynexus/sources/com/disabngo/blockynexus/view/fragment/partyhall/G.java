package com.disabngo.blockynexus.view.fragment.partyhall;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Ne;
import com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow;
import com.google.common.collect.Maps;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.manager.PartyDressManager;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequest;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.RequestType;
import com.sandboxol.center.utils.LocalDataRequest;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.messager.MessagerClient;
import com.tendcloud.tenddata.ab;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.functions.Action0;

/* JADX INFO: compiled from: PartyHallViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class G extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Ne f11897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private E f11898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f11899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f11900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SearchFriendPopupWindow f11901f;
    private SearchFriendPopupWindow g;
    private PartyAuthInfo h;
    private List<String> j;
    private Map<String, String> k;
    private List<String> n;
    private ObservableField<PartyListRequest> i = new ObservableField<>();
    public ObservableField<String> l = new ObservableField<>("");
    public ObservableField<String> m = new ObservableField<>();
    private Map<String, String> o = Maps.c();
    public ObservableField<Boolean> p = new ObservableField<>(false);
    private ObservableArrayList<PartyItem> q = new ObservableArrayList<>();
    public ObservableField<String> r = new ObservableField<>("");
    public ObservableField<String> s = new ObservableField<>();
    public ObservableField<Boolean> t = new ObservableField<>(true);
    public ReplyCommand u = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.l
        @Override // rx.functions.Action0
        public final void call() {
            this.f11928a.h();
        }
    });
    public ReplyCommand v = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.k
        @Override // rx.functions.Action0
        public final void call() {
            this.f11927a.i();
        }
    });
    public ReplyCommand w = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.j
        @Override // rx.functions.Action0
        public final void call() {
            this.f11926a.onRefresh();
        }
    });
    public ReplyCommand x = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.n
        @Override // rx.functions.Action0
        public final void call() {
            this.f11930a.j();
        }
    });
    public ReplyCommand y = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f11924a.k();
        }
    });

    public G(Context context, Ne ne) {
        this.f11896a = context;
        this.f11897b = ne;
        initData();
        initMessenger();
    }

    private void initData() {
        this.f11898c = new E();
        this.k = LocalDataRequest.getSearchFriendLanguage();
        this.f11898c.b(this.f11896a, this.t, new OnDataListener() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.o
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                this.f11931a.a((List) obj);
            }
        });
        this.f11900e = new v();
        this.f11899d = new w(this.f11896a, R.string.party_hall_not_data, this.q, this.k);
        this.m.set(this.f11896a.getString(R.string.app_party_hall_choose_language));
        this.s.set(this.f11896a.getString(R.string.app_party_hall_choose_game));
        m();
        l();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_PARTY, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.m
            @Override // rx.functions.Action0
            public final void call() {
                this.f11929a.f();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TEAM_START_GAME_EXIT_CHAT, new F(this));
    }

    private void l() {
        this.f11898c.a(this.f11896a, this.p, new OnDataListener() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.i
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                this.f11925a.a((PartyAuthInfo) obj);
            }
        });
    }

    private void m() {
        this.i.set(PartyListRequest.newBuilder().setSelectLang(this.l.get()).setSelectGameType(this.r.get()).setRequestType(RequestType.LIST).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRefresh() {
        this.p.set(true);
        PartyAuthInfo partyAuthInfo = this.h;
        if (partyAuthInfo != null) {
            this.f11898c.a(this.f11896a, this.q, this.p, partyAuthInfo, this.i);
        } else {
            this.p.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        m();
        onRefresh();
    }

    public /* synthetic */ void h() {
        ReportDataAdapter.onEvent(this.f11896a, EventConstant.CLICK_PARTY_BUILD_ADD);
        com.apkfuns.logutils.c.a(ab.u).b("onEvent being called! eventEvent: 点击创建");
        if (this.t.get().booleanValue()) {
            this.f11898c.b(this.f11896a, this.t, null);
        }
    }

    public /* synthetic */ void i() {
        this.f11898c.a(this.f11896a, this.r.get(), this.l.get());
    }

    public /* synthetic */ void j() {
        b(1);
    }

    public /* synthetic */ void k() {
        b(2);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        try {
            this.f11898c.b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        MessagerClient.getIns().unRegisterMsg(G.class);
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        if (this.f11898c.a()) {
            m();
            l();
            this.f11898c.a(false);
        }
        PartyDressManager.onDestroy();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void b(int i) {
        Map<String, String> map;
        Map<String, String> map2;
        if (i != 1) {
            if (this.o.isEmpty()) {
                return;
            }
            if (this.g == null && (map = this.o) != null && map.size() != 0) {
                this.n = new ArrayList(this.o.values());
                this.g = new SearchFriendPopupWindow(this.f11896a, this.n, 2);
            }
            if (this.g.isShowing()) {
                this.g.dismiss();
                return;
            }
            SearchFriendPopupWindow searchFriendPopupWindow = this.g;
            LinearLayout linearLayout = this.f11897b.f7709a;
            searchFriendPopupWindow.showLocation(linearLayout, linearLayout.getWidth());
            this.g.setOnMoreItemClickListener(new SearchFriendPopupWindow.OnMoreItemClickListener() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.PartyHallViewModel$3
                @Override // com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow.OnMoreItemClickListener
                public void a() {
                }

                @Override // com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow.OnMoreItemClickListener
                public void onClick(int i2, long j) {
                    G g = this.f11905a;
                    g.s.set((String) g.n.get(i2));
                    ObservableField<String> observableField = this.f11905a.s;
                    if (observableField == null || !observableField.get().equals(this.f11905a.f11896a.getString(R.string.app_update_user_all_game))) {
                        G g2 = this.f11905a;
                        g2.s.set((String) g2.n.get(i2));
                        G g3 = this.f11905a;
                        g3.r.set(com.disabngo.blockynexus.view.activity.searchfriend.l.a(g3.o, (String) this.f11905a.n.get(i2)));
                        ReportDataAdapter.onEvent(this.f11905a.f11896a, EventConstant.LIST_PARTY_CLICK_FILTER, com.disabngo.blockynexus.view.activity.searchfriend.l.a(this.f11905a.o, (String) this.f11905a.n.get(i2)));
                    } else {
                        G g4 = this.f11905a;
                        g4.s.set(g4.f11896a.getString(R.string.app_party_hall_choose_game));
                        this.f11905a.r.set("");
                        ReportDataAdapter.onEvent(this.f11905a.f11896a, EventConstant.LIST_PARTY_CLICK_FILTER, "All Games");
                    }
                    this.f11905a.p();
                }
            });
            return;
        }
        if (this.f11901f == null && (map2 = this.k) != null && map2.size() != 0) {
            com.disabngo.blockynexus.view.activity.searchfriend.l lVar = new com.disabngo.blockynexus.view.activity.searchfriend.l();
            Map<String, String> map3 = this.k;
            lVar.a(map3);
            this.k = map3;
            this.j = new ArrayList(this.k.values());
            this.f11901f = new SearchFriendPopupWindow(this.f11896a, this.j, 1);
        }
        if (this.f11901f.isShowing()) {
            this.f11901f.dismiss();
            return;
        }
        SearchFriendPopupWindow searchFriendPopupWindow2 = this.f11901f;
        LinearLayout linearLayout2 = this.f11897b.f7710b;
        searchFriendPopupWindow2.showLocation(linearLayout2, linearLayout2.getWidth());
        this.f11901f.setOnMoreItemClickListener(new SearchFriendPopupWindow.OnMoreItemClickListener() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.PartyHallViewModel$2
            @Override // com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow.OnMoreItemClickListener
            public void a() {
            }

            @Override // com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow.OnMoreItemClickListener
            public void onClick(int i2, long j) {
                G g = this.f11904a;
                g.m.set((String) g.j.get(i2));
                ObservableField<String> observableField = this.f11904a.m;
                if (observableField == null || !observableField.get().equals(this.f11904a.f11896a.getString(R.string.app_update_user_all_language))) {
                    G g2 = this.f11904a;
                    g2.m.set((String) g2.j.get(i2));
                    G g3 = this.f11904a;
                    g3.l.set(com.disabngo.blockynexus.view.activity.searchfriend.l.a(g3.k, (String) this.f11904a.j.get(i2)));
                    ReportDataAdapter.onEvent(this.f11904a.f11896a, EventConstant.LIST_PARTY_CLICK_FILTER, com.disabngo.blockynexus.view.activity.searchfriend.l.a(this.f11904a.k, (String) this.f11904a.j.get(i2)));
                } else {
                    G g4 = this.f11904a;
                    g4.m.set(g4.f11896a.getString(R.string.app_party_hall_choose_language));
                    this.f11904a.l.set("");
                    ReportDataAdapter.onEvent(this.f11904a.f11896a, EventConstant.LIST_PARTY_CLICK_FILTER, "All Languages");
                }
                this.f11904a.p();
            }
        });
    }

    public /* synthetic */ void a(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                this.o.put("All", this.f11896a.getString(R.string.app_update_user_all_game));
            }
            this.o.put(((AllGameIdInfo) list.get(i)).getGameId(), ((AllGameIdInfo) list.get(i)).getGameName());
        }
    }

    public /* synthetic */ void f() {
        this.f11899d.a(this.q);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_PARTY_LIST);
    }

    public /* synthetic */ void a(PartyAuthInfo partyAuthInfo) {
        this.h = partyAuthInfo;
        this.f11898c.a(partyAuthInfo.getPartyService());
        this.f11898c.b(this.f11896a, this.q, this.p, partyAuthInfo, this.i);
        this.f11898c.a(this.f11896a, this.q, this.p, partyAuthInfo, this.i);
    }
}
