package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* JADX INFO: compiled from: AlertController.java */
/* JADX INFO: loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AlertController f303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AlertController.a f304b;

    h(AlertController.a aVar, AlertController alertController) {
        this.f304b = aVar;
        this.f303a = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f304b.x.onClick(this.f303a.f199b, i);
        if (this.f304b.H) {
            return;
        }
        this.f303a.f199b.dismiss();
    }
}
