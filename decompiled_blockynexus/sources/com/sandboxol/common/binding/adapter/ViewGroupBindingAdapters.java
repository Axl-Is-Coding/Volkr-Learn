package com.sandboxol.common.binding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableList;
import com.sandboxol.common.base.vm.ViewModel;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class ViewGroupBindingAdapters {
    public static void addView(ViewGroup viewGroup, View view) {
        if (view != null) {
            viewGroup.addView(view);
        }
    }

    public static void addViews(ViewGroup viewGroup, me.tatarka.bindingcollectionadapter2.g gVar, ObservableList<ViewModel> observableList) {
        if (observableList == null || observableList.isEmpty()) {
            return;
        }
        viewGroup.removeAllViews();
        Iterator<ViewModel> it = observableList.iterator();
        while (it.hasNext()) {
            androidx.databinding.e.a(LayoutInflater.from(viewGroup.getContext()), gVar.a(), viewGroup, true).setVariable(gVar.b(), it.next());
        }
    }
}
