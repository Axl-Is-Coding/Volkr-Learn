package com.disabngo.blockynexus.e.b.c;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.ActivityTaskTitle;
import com.disabngo.blockynexus.web.CampaignApi;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.EventRedPointManager;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.c.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0826f extends DataListModel<ActivityTaskTitle> {
    private Context context;

    public C0826f(Context context, int i) {
        super(context, i);
        this.context = context;
    }

    public static void b(List<ActivityTaskTitle> list) {
        for (ActivityTaskTitle activityTaskTitle : list) {
            if (activityTaskTitle.isCloseRedPoint()) {
                EventRedPointManager.getInstance().registerRedPoint(AccountCenter.newInstance().userId.get().longValue(), activityTaskTitle.getTitleType(), activityTaskTitle.getEndTime() != -1, 2);
            } else {
                EventRedPointManager.getInstance().registerRedPoint(AccountCenter.newInstance().userId.get().longValue(), activityTaskTitle.getTitleType(), activityTaskTitle.getEndTime() != -1, activityTaskTitle.getStatus());
            }
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ActivityTaskTitle> listItemViewModel) {
        gVar.a(2, R.layout.item_activity_list);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<ActivityTaskTitle>> onResponseListener) {
        CampaignApi.getActivityTaskTitleList(this.context, new C0825e(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ActivityTaskTitle> getItemViewModel(ActivityTaskTitle activityTaskTitle) {
        return new C0823c(this.context, activityTaskTitle);
    }

    public static void a(List<ActivityTaskTitle> list) {
        Iterator<ActivityTaskTitle> it = list.iterator();
        while (it.hasNext()) {
            ActivityTaskTitle next = it.next();
            if (next.getCountryList() != null && next.getCountryList().size() > 0 && !next.getCountryList().contains(CommonHelper.getLanguage())) {
                it.remove();
            }
        }
    }
}
