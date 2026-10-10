package com.disabngo.blockynexus.e.a.a;

import android.app.Activity;
import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.E;
import com.disabngo.blockynexus.interfaces.OnViewClickListener;
import com.disabngo.blockynexus.view.dialog.NoticeDialog;
import com.disabngo.blockynexus.web.GeoApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.tencent.map.geolocation.TencentLocation;

/* JADX INFO: compiled from: StartGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    public void a(Context context, OnViewClickListener onViewClickListener) {
        if (AppInfoCenter.newInstance().getStopServiceAnnouncementInfo() == null) {
            GameApi.getStopServiceAnnouncementInfo(context, new i(this, context, onViewClickListener));
        } else if (AppInfoCenter.newInstance().getStopServiceAnnouncementInfo().isIsShow()) {
            new NoticeDialog(context, context.getString(R.string.stop_service_announcement), AppInfoCenter.newInstance().getStopServiceAnnouncementInfo()).show();
        } else {
            onViewClickListener.onClick();
        }
    }

    public static void a(Activity activity) {
        UserApi.postUserLanguage(activity, new j(activity));
    }

    public void a(final Activity activity, final OnDataListener<TencentLocation> onDataListener) {
        if (E.a(activity)) {
            com.sandboxol.tencentmaputils.c.a(activity, new OnDataListener() { // from class: com.disabngo.blockynexus.e.a.a.a
                @Override // com.sandboxol.common.interfaces.OnDataListener
                public final void onSuccess(Object obj) {
                    this.f9063a.a(activity, onDataListener, (TencentLocation) obj);
                }
            });
        }
    }

    public /* synthetic */ void a(Activity activity, OnDataListener onDataListener, TencentLocation tencentLocation) {
        if (tencentLocation != null && tencentLocation.getLongitude() != 0.0d && tencentLocation.getLatitude() != 0.0d) {
            a(activity, tencentLocation, (OnDataListener<TencentLocation>) onDataListener);
            return;
        }
        ReportDataAdapter.onEvent(activity, EventConstant.CLICK_FRIEND_MATCH_NO_LOCATION);
        ReportDataAdapter.onEvent(activity, EventConstant.CLICK_FRIEND_MATCH_FAIL, EventConstant.CLICK_FRIEND_MATCH_NO_LOCATION);
        AppToastUtils.showShortNegativeTipToast(activity, R.string.friend_get_location_fail_by_native);
    }

    public void a(Activity activity, TencentLocation tencentLocation, OnDataListener<TencentLocation> onDataListener) {
        GeoApi.postUserGeoInfo(activity, Double.valueOf(tencentLocation.getLongitude()), Double.valueOf(tencentLocation.getLatitude()), new k(this, activity, tencentLocation, onDataListener));
    }
}
