package com.disabngo.blockynexus.e.b.O;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.D;
import com.disabngo.blockynexus.d.E;
import com.disabngo.blockynexus.entity.UserMapInfo;
import com.disabngo.blockynexus.view.dialog.FriendMatchPermissionApplyDialog;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.entity.TribeClanMembersBean;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.ColorTextHelper;
import com.sandboxol.common.utils.PermissionUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.tencent.map.geolocation.TencentLocation;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MakeFriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {
    static /* synthetic */ void b(Activity activity) {
        PermissionUtils.checkAndApplyfPermissionActivity(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1005);
        ReportDataAdapter.onEvent(activity, EventConstant.POSITION_TIME);
    }

    static /* synthetic */ List a(q qVar, List list) {
        qVar.a((List<TribeClanMembersBean>) list);
        return list;
    }

    public void a(Context context) {
        TribeApi.getTribeId(context, new o(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j) {
        TribeApi.tribeDetail(context, j, new p(this, context));
    }

    public void a(final Activity activity) {
        String string = SharedUtils.getString(activity, SharedConstant.FRIEND_MATCH_LONGITUDE);
        String string2 = SharedUtils.getString(activity, SharedConstant.FRIEND_MATCH_LATITUDE);
        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string2)) {
            D.a(activity, new UserMapInfo(Double.parseDouble(string2), Double.parseDouble(string), AccountCenter.newInstance().picUrl.get(), AccountCenter.newInstance().userId.get().longValue()));
            return;
        }
        if (activity != null) {
            if (E.a(activity)) {
                if (com.disabngo.blockynexus.d.p.a(activity)) {
                    new com.disabngo.blockynexus.e.a.a.l().a(activity, new OnDataListener() { // from class: com.disabngo.blockynexus.e.b.O.c
                        @Override // com.sandboxol.common.interfaces.OnDataListener
                        public final void onSuccess(Object obj) {
                            TencentLocation tencentLocation = (TencentLocation) obj;
                            D.a(activity, new UserMapInfo(tencentLocation.getLatitude(), tencentLocation.getLongitude(), AccountCenter.newInstance().picUrl.get(), AccountCenter.newInstance().userId.get().longValue()));
                        }
                    });
                    return;
                }
                ReportDataAdapter.onEvent(activity, EventConstant.ENTER_GPS_SETTING);
                ReportDataAdapter.onEvent(activity, EventConstant.CLICK_FRIEND_MATCH_FAIL, EventConstant.ENTER_GPS_SETTING);
                com.disabngo.blockynexus.d.p.a(activity, 2001);
                return;
            }
            new FriendMatchPermissionApplyDialog(activity).setTitleText(R.string.friend_match_access_request).setDetailText("<font color='#666666'>" + activity.getString(R.string.friend_match_access_request_get) + ColorTextHelper.HTML_LABEL_FONT_END + "<font color='#0ab950'>" + activity.getString(R.string.friend_match_location_access) + ColorTextHelper.HTML_LABEL_FONT_END + "<font color='#666666'>" + activity.getString(R.string.friend_match_location_search_friend) + ColorTextHelper.HTML_LABEL_FONT_END).a(new FriendMatchPermissionApplyDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.O.b
                @Override // com.disabngo.blockynexus.view.dialog.FriendMatchPermissionApplyDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    q.b(activity);
                }
            }).show();
            ReportDataAdapter.onEvent(activity, EventConstant.CLICK_FRIEND_MATCH_NO_PERMISSION);
            ReportDataAdapter.onEvent(activity, EventConstant.CLICK_FRIEND_MATCH_FAIL, EventConstant.CLICK_FRIEND_MATCH_NO_PERMISSION);
        }
    }

    private List<TribeClanMembersBean> a(List<TribeClanMembersBean> list) {
        Iterator<TribeClanMembersBean> it = list.iterator();
        while (it.hasNext()) {
            TribeClanMembersBean next = it.next();
            if (next.getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
                TribeCenter.newInstance().setTribeRole(next.getRole());
            }
            if (next.getRole() == 0) {
                it.remove();
            }
        }
        Collections.sort(list, new Comparator() { // from class: com.disabngo.blockynexus.e.b.O.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return q.a((TribeClanMembersBean) obj, (TribeClanMembersBean) obj2);
            }
        });
        return list;
    }

    static /* synthetic */ int a(TribeClanMembersBean tribeClanMembersBean, TribeClanMembersBean tribeClanMembersBean2) {
        return tribeClanMembersBean2.getRole() - tribeClanMembersBean.getRole();
    }
}
