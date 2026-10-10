package com.disabngo.blockynexus.view.fragment.partyhall;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequest;
import com.sandboxol.center.router.moduleInfo.game.team.util.GRPCUtils;
import com.sandboxol.center.router.moduleInfo.game.team.util.PartyManagerClient;
import com.sandboxol.center.router.moduleInfo.game.team.util.QuickInManagerClient;
import com.sandboxol.center.utils.AppSharedUtils;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.TemplateHelper;
import com.sandboxol.imchat.utils.CompareList;
import com.sandboxol.imchat.web.ChatGameApi;
import com.sandboxol.imchat.web.PartyApi;
import com.tendcloud.tenddata.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PartyHallModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PartyManagerClient f11889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private QuickInManagerClient f11890b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11893e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11891c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11892d = 10;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<Long, String> f11894f = new HashMap();
    private Map<Long, String> g = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f11890b.shutDownQuickIn();
        this.f11890b = null;
    }

    public void b(Context context, List<PartyItem> list, ObservableField<Boolean> observableField, PartyAuthInfo partyAuthInfo, ObservableField<PartyListRequest> observableField2) {
        PartyManagerClient partyManagerClient = this.f11889a;
        if (partyManagerClient != null) {
            partyManagerClient.setPartyListListener(new y(this, observableField, list, context, partyAuthInfo, observableField2));
        }
    }

    public void a(Context context, ObservableField<Boolean> observableField, OnDataListener<PartyAuthInfo> onDataListener) {
        ChatGameApi.getPartyAuth(context, AccountCenter.newInstance().userId.get().longValue(), null, false, new x(this, onDataListener, observableField, context));
    }

    public void b() {
        PartyManagerClient partyManagerClient = this.f11889a;
        if (partyManagerClient != null) {
            try {
                try {
                    partyManagerClient.shutDownPartList();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.f11889a = null;
            }
        }
    }

    public void a(String str) {
        String[] strArrSplit = str.split(":");
        if (this.f11889a == null) {
            this.f11889a = PartyManagerClient.newInstance(strArrSplit[0], Integer.valueOf(strArrSplit[1]).intValue(), AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get());
        }
    }

    public void a(final Context context, final List<PartyItem> list, final ObservableField<Boolean> observableField, PartyAuthInfo partyAuthInfo, final ObservableField<PartyListRequest> observableField2) {
        PartyManagerClient partyManagerClient = this.f11889a;
        if (partyManagerClient != null) {
            if (partyManagerClient.isDisConnect()) {
                a(context, observableField, new OnDataListener() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.f
                    @Override // com.sandboxol.common.interfaces.OnDataListener
                    public final void onSuccess(Object obj) {
                        this.f11915a.a(context, list, observableField, observableField2, (PartyAuthInfo) obj);
                    }
                });
            } else {
                this.f11889a.connectPartyList(GRPCUtils.createPartyList(20, partyAuthInfo.getRegion(), observableField2.get().getSelectLang(), observableField2.get().getSelectGameType(), observableField2.get().getRequestType(), ""));
            }
        }
    }

    public void b(Context context, ObservableField<Boolean> observableField, OnDataListener<List<AllGameIdInfo>> onDataListener) {
        if (context != null) {
            List<AllGameIdInfo> allGameIdInfo = AppSharedUtils.newInstance().getAllGameIdInfo();
            if (!allGameIdInfo.isEmpty()) {
                if (onDataListener == null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(StringConstant.PARTY_CREATE_ALL_GAME_ID_INFO, new com.google.gson.j().a(allGameIdInfo));
                    TemplateHelper.startTemplate(context, com.disabngo.blockynexus.e.b.S.l.class, context.getString(R.string.party_create_party), bundle);
                }
                a(context, false, observableField, onDataListener);
                observableField.set(false);
                return;
            }
            a(context, true, observableField, onDataListener);
        }
    }

    public /* synthetic */ void a(Context context, List list, ObservableField observableField, ObservableField observableField2, PartyAuthInfo partyAuthInfo) {
        this.f11889a = null;
        PartyManagerClient.destroyTeamManagerClient();
        a(partyAuthInfo.getPartyService());
        b(context, list, observableField, partyAuthInfo, observableField2);
        this.f11889a.connectPartyList(GRPCUtils.createPartyList(20, partyAuthInfo.getRegion(), ((PartyListRequest) observableField2.get()).getSelectLang(), ((PartyListRequest) observableField2.get()).getSelectGameType(), ((PartyListRequest) observableField2.get()).getRequestType(), ""));
    }

    private void a(Context context, boolean z, ObservableField<Boolean> observableField, OnDataListener<List<AllGameIdInfo>> onDataListener) {
        GameApi.getAllGameIdInfo(context, new z(this, observableField, onDataListener, z, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> b(String str) {
        Iterator it = new HashMap(this.g).keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = ((Long) it.next()).longValue();
            if (System.currentTimeMillis() - jLongValue > 60000) {
                this.g.remove(Long.valueOf(jLongValue));
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.g.put(Long.valueOf(System.currentTimeMillis()), str);
        }
        if (this.g.size() > 0) {
            ArrayList arrayList = new ArrayList(this.g.values());
            CompareList.cleanDisRepeat(arrayList);
            return arrayList;
        }
        return new ArrayList();
    }

    public void a(final Context context, final String str, final String str2) {
        ReportDataAdapter.onEvent(context, EventConstant.LIST_PARTY_CLICK_JOIN);
        com.apkfuns.logutils.c.a(ab.u).b("onEvent being called! eventEvent: 派对大厅点击快速加入");
        DialogUtils.newsInstant().showLoadingDialog(context);
        a(context, new ObservableField<>(false), new OnDataListener() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.g
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                this.f11920a.a(context, str, str2, (PartyAuthInfo) obj);
            }
        });
    }

    public /* synthetic */ void a(Context context, String str, String str2, PartyAuthInfo partyAuthInfo) {
        String[] strArrSplit = partyAuthInfo.getPartyService().split(":");
        this.f11890b = QuickInManagerClient.newInstance(strArrSplit[0], Integer.valueOf(strArrSplit[1]).intValue(), AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get());
        this.f11890b.setQuickInListener(new A(this, context, partyAuthInfo, str, str2));
        this.f11890b.connectQuickIn(GRPCUtils.quickIn(partyAuthInfo.getRegion(), b((String) null), str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void a(Context context, PartyAuthInfo partyAuthInfo, PartyItem partyItem) {
        PartyApi.isPartyExist(context, partyAuthInfo.getPartyQuerierService(), AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get(), partyItem.getTeamId(), new C(this, partyItem, context, partyAuthInfo));
    }

    public boolean a() {
        return this.f11893e;
    }

    public void a(boolean z) {
        this.f11893e = z;
    }
}
