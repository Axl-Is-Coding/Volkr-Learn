package com.disabngo.blockynexus.e.b.M;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.StarCodeUserIncomeInfo;
import com.sandboxol.center.utils.TimeUtil;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IncomePageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends PageListModel<StarCodeUserIncomeInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<Double> f9351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9352b;

    public f(Context context, ObservableField<Double> observableField, int i) {
        super(context, i);
        this.f9351a = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<StarCodeUserIncomeInfo> listItemViewModel) {
        if (listItemViewModel.getItem().isTitle()) {
            gVar.a(2, R.layout.item_income_title);
        } else {
            gVar.a(2, R.layout.item_income_detail);
        }
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<StarCodeUserIncomeInfo>> onResponseListener) {
        UserApi.getStarCodeUserIncomeDetail(this.context, i, i2, new e(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<StarCodeUserIncomeInfo> getItemViewModel(StarCodeUserIncomeInfo starCodeUserIncomeInfo) {
        return new d(this.context, starCodeUserIncomeInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<StarCodeUserIncomeInfo> a(PageData<StarCodeUserIncomeInfo> pageData) {
        List<StarCodeUserIncomeInfo> data = pageData.getData();
        if (data == null || data.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String dateToString = null;
        int i = 0;
        boolean z = false;
        while (i < data.size()) {
            if (i == 0) {
                dateToString = TimeUtil.getDateToString(TimeUtil.DEFAULT_DAY_FORMAT, data.get(i).getCreateTime());
            }
            String dateToString2 = TimeUtil.getDateToString(TimeUtil.DEFAULT_DAY_FORMAT, data.get(i).getCreateTime());
            if (pageData.getPageNo() == 0 && i == 0) {
                arrayList.add(0, new StarCodeUserIncomeInfo(data.get(i).getCreateTime(), true));
            }
            if (pageData.getPageNo() != 0 && !dateToString.equals(this.f9352b) && !z) {
                arrayList.add(0, new StarCodeUserIncomeInfo(data.get(i).getCreateTime(), true));
                z = true;
            }
            int i2 = i + 1;
            if (i2 < data.size()) {
                if (TimeUtil.getDateToString(TimeUtil.DEFAULT_DAY_FORMAT, data.get(i2).getCreateTime()).equals(dateToString2)) {
                    arrayList.add(data.get(i));
                } else {
                    arrayList.add(data.get(i));
                    arrayList.add(new StarCodeUserIncomeInfo(data.get(i2).getCreateTime(), true));
                }
            } else {
                arrayList.add(data.get(i));
            }
            i = i2;
        }
        this.f9352b = TimeUtil.getDateToString(TimeUtil.DEFAULT_DAY_FORMAT, data.get(data.size() - 1).getCreateTime());
        return arrayList;
    }
}
