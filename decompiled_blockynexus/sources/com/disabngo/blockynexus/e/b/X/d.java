package com.disabngo.blockynexus.e.b.X;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.d.A;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.SystemAnnouncementInfo;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: compiled from: RecommendModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public void a(Context context, ObservableList<String> observableList) {
        GameApi.getGameUpdateContentList(context, new c(this, context, observableList));
    }

    public void a(Context context, ObservableField<Boolean> observableField, ObservableField<String> observableField2) {
        SystemAnnouncementInfo systemAnnouncementInfo = AppInfoCenter.newInstance().getSystemAnnouncementInfo();
        SystemAnnouncementInfo stopServiceAnnouncementInfo = AppInfoCenter.newInstance().getStopServiceAnnouncementInfo();
        if (stopServiceAnnouncementInfo != null && stopServiceAnnouncementInfo.isIsShowInGame() && stopServiceAnnouncementInfo.getUpdateTime() != SharedUtils.getLong(context, SharedConstant.MAIN_ANNOUNCEMENT_VERSION_MODIFY_TIME)) {
            observableField.set(true);
            observableField2.set(A.c(stopServiceAnnouncementInfo.getContent()));
        } else {
            if (systemAnnouncementInfo == null || !systemAnnouncementInfo.isIsShowInGame() || systemAnnouncementInfo.getUpdateTime() == SharedUtils.getLong(context, SharedConstant.MAIN_ANNOUNCEMENT_VERSION_MODIFY_TIME)) {
                return;
            }
            observableField.set(true);
            observableField2.set(A.c(systemAnnouncementInfo.getContent()));
        }
    }
}
