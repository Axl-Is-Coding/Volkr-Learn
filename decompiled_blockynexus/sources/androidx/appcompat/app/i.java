package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* JADX INFO: compiled from: AlertController.java */
/* JADX INFO: loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AlertController f306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AlertController.a f307c;

    i(AlertController.a aVar, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.f307c = aVar;
        this.f305a = recycleListView;
        this.f306b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean[] zArr = this.f307c.F;
        if (zArr != null) {
            zArr[i] = this.f305a.isItemChecked(i);
        }
        this.f307c.J.onClick(this.f306b.f199b, i, this.f305a.isItemChecked(i));
    }
}
