package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.disabngo.blockynexus.service.CampaignService;
import com.disabngo.blockynexus.service.DialogService;
import com.disabngo.blockynexus.service.DownloadService;
import com.disabngo.blockynexus.service.FriendService;
import com.disabngo.blockynexus.service.MainService;
import com.disabngo.blockynexus.service.PartyDressService;
import com.disabngo.blockynexus.service.RongIMService;
import com.disabngo.blockynexus.service.WidgetService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.router.path.RouterServicePath;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$app implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.sandboxol.center.router.moduleApi.IDialogService", RouteMeta.build(RouteType.PROVIDER, DialogService.class, RouterServicePath.EventDialog.DIALOG_SERVICE, "dialog", null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.IDownloadService", RouteMeta.build(RouteType.PROVIDER, DownloadService.class, RouterServicePath.EventDownload.DOWNLOAD_SERVICE, "download", null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.IRongIMService", RouteMeta.build(RouteType.PROVIDER, RongIMService.class, RouterServicePath.EventRongIM.RONG_SERVICE, "rong", null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.IWidgetService", RouteMeta.build(RouteType.PROVIDER, WidgetService.class, RouterServicePath.EventWidget.WIDGET_SERVICE, "widget", null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.IFriendService", RouteMeta.build(RouteType.PROVIDER, FriendService.class, RouterServicePath.EventFriend.FRIEND_SERVICE, "friend", null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.IPartyDressService", RouteMeta.build(RouteType.PROVIDER, PartyDressService.class, RouterServicePath.EventPartyDress.PARTY_DRESS_SERVICE, "partydress", null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.ICampaignService", RouteMeta.build(RouteType.PROVIDER, CampaignService.class, RouterServicePath.EventCampaign.CAMPAIGN_SERVICE, FirebaseAnalytics.Param.CAMPAIGN, null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.IMainService", RouteMeta.build(RouteType.PROVIDER, MainService.class, RouterServicePath.EventMain.MAIN_SERVICE, "main", null, -1, Integer.MIN_VALUE));
    }
}
