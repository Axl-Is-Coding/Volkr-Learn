package com.disabngo.blockynexus.e.b.xa;

import android.content.Context;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.widget.rv.msg.MoreMsg;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.entity.BannerEntity;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: VideoRecommendModel.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public void a(Context context, ObservableList<String> observableList, ObservableList<String> observableList2, ObservableList<BannerEntity> observableList3) {
        List<BannerEntity> videoBanner = AppInfoCenter.newInstance().getAppConfig().getVideoBanner();
        if (videoBanner != null) {
            a(videoBanner);
            a(videoBanner, observableList, observableList2, observableList3);
        }
    }

    public void b(int i) {
        if (i == R.id.rbHot) {
            Messenger.getDefault().send(RefreshMsg.create(), "token.video.total.refreshtop");
        } else {
            if (i != R.id.rbNew) {
                return;
            }
            Messenger.getDefault().send(RefreshMsg.create(), "token.video.total.refreshnew");
        }
    }

    private void a(List<BannerEntity> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<BannerEntity> it = list.iterator();
        while (it.hasNext()) {
            BannerEntity next = it.next();
            if (next.getCountryList() != null && next.getCountryList().size() > 0 && !next.getCountryList().contains(CommonHelper.getLanguage())) {
                it.remove();
            }
        }
    }

    public void a(List<BannerEntity> list, ObservableList<String> observableList, ObservableList<String> observableList2, ObservableList<BannerEntity> observableList3) {
        String str;
        if (list.size() > 0) {
            observableList.clear();
            observableList2.clear();
            observableList3.clear();
        }
        for (BannerEntity bannerEntity : list) {
            if (bannerEntity != null) {
                if (bannerEntity.getTitles() != null) {
                    str = bannerEntity.getTitles().get(CommonHelper.getLanguage());
                    if (str == null) {
                        str = bannerEntity.getTitles().get("en_US");
                    }
                } else {
                    str = "";
                }
                if (BaseApplication.getApp().getMetaDataAppVersion() >= bannerEntity.getVersion()) {
                    bannerEntity.setTitle(str);
                    observableList.add(str);
                    observableList2.add(bannerEntity.getImage());
                    observableList3.add(bannerEntity);
                }
            }
        }
    }

    public void a(int i) {
        if (i == R.id.rbHot) {
            Messenger.getDefault().send(MoreMsg.create(), "token.video.total.load.moretop");
        } else {
            if (i != R.id.rbNew) {
                return;
            }
            Messenger.getDefault().send(MoreMsg.create(), "token.video.total.load.morenew");
        }
    }
}
