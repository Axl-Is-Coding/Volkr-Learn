package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: GameListItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class F extends ListItemViewModel<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableList<ListItemViewModel<Game>> f11766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<Game>> f11767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f11768c;

    public F(Context context, Game game) {
        super(context, game);
        this.f11766a = new ObservableArrayList();
        this.f11767b = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.view.fragment.main.c
            @Override // me.tatarka.bindingcollectionadapter2.l
            public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
                this.f11806a.bindView(gVar, i, (ListItemViewModel) obj);
            }
        });
        this.f11768c = new ObservableField<>(false);
    }

    public abstract void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel listItemViewModel);

    public abstract ListItemViewModel<Game> c(Game game);

    protected void replaceData(List<Game> list) {
        if (list == null || list.size() <= 0) {
            this.f11768c.set(false);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f11768c.set(true);
        if (this.f11766a.size() > 0 && this.f11766a.size() <= list.size()) {
            for (int i = 0; i < this.f11766a.size(); i++) {
                this.f11766a.get(i).setItem(list.get(i));
            }
        } else if (this.f11766a.size() > list.size()) {
            for (int size = this.f11766a.size() - 1; size > list.size() - 1; size--) {
                arrayList2.add(this.f11766a.get(size));
            }
        }
        for (int size2 = this.f11766a.size(); size2 < list.size(); size2++) {
            arrayList.add(c(list.get(size2)));
        }
        if (arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                this.f11766a.remove((ListItemViewModel) it.next());
            }
        }
        if (arrayList.size() > 0) {
            this.f11766a.addAll(arrayList);
        }
    }
}
