package com.disabngo.blockynexus.view.activity.newsearch;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.RecommendFriendEntity;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchRecommendListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends DataListModel<RecommendFriendEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f11036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11038f;
    private int g;
    private boolean h;
    private ObservableField<Boolean> i;
    private Map<String, String> j;
    public ObservableField<Boolean> k;

    public r(Context context, int i, ObservableField<Boolean> observableField, Map<String, String> map, boolean z) {
        super(context, i);
        this.i = observableField;
        this.j = map;
        this.h = z;
        this.f11036d = null;
        this.g = 6;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_RECOMMEND_FRIEND;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<RecommendFriendEntity> listItemViewModel) {
        gVar.a(2, R.layout.item_new_recommand_friend);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<RecommendFriendEntity>> onResponseListener) {
        FriendApi.friendRecommendation(this.context, this.f11033a, this.f11034b, this.f11035c, this.f11036d, this.f11037e, new q(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<RecommendFriendEntity> getItemViewModel(RecommendFriendEntity recommendFriendEntity) {
        return new p(this.context, recommendFriendEntity, this.j, this.f11038f, this.h);
    }

    public void a(ObservableField<Boolean> observableField) {
        this.f11033a = 0;
        this.f11036d = null;
        this.f11035c = null;
        this.f11034b = null;
        this.f11037e = null;
        this.k = observableField;
        this.f11038f = 6;
        this.g = 7;
        Messenger.getDefault().send(RefreshMsg.create(), getRefreshToken());
    }

    public void a(String str, String str2, int i, String str3, int i2, int i3) {
        this.f11038f = i2;
        this.g = i3;
        this.f11033a = 1;
        if (i == 0) {
            this.f11036d = null;
        } else {
            this.f11036d = Integer.valueOf(i);
        }
        if (TextUtils.isEmpty(str)) {
            this.f11034b = null;
        } else {
            this.f11034b = str;
        }
        if (TextUtils.isEmpty(str2)) {
            this.f11035c = null;
        } else {
            this.f11035c = str2;
        }
        if (TextUtils.isEmpty(str3)) {
            this.f11037e = null;
        } else {
            this.f11037e = str3;
        }
        Messenger.getDefault().send(RefreshMsg.create(), getRefreshToken());
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f11037e = null;
        } else {
            this.f11037e = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        switch (this.g) {
            case 1:
                ReportDataAdapter.onEvent(this.context, EventConstant.SHOW_FILTER_FRI, "Boy");
                break;
            case 2:
                ReportDataAdapter.onEvent(this.context, EventConstant.SHOW_FILTER_FRI, "Girl");
                break;
            case 3:
                ReportDataAdapter.onEvent(this.context, EventConstant.SHOW_FILTER_FRI, "Language");
                break;
            case 4:
                ReportDataAdapter.onEvent(this.context, EventConstant.SHOW_FILTER_FRI, "Game");
                break;
            case 5:
                ReportDataAdapter.onEvent(this.context, EventConstant.SHOW_SEARCH_FRI);
                break;
            case 6:
                ReportDataAdapter.onEvent(this.context, EventConstant.SHOW_RECOMMEND_FRI, "Default");
                break;
            case 7:
                ReportDataAdapter.onEvent(this.context, EventConstant.SHOW_RECOMMEND_FRI, "Refresh");
                break;
        }
    }
}
