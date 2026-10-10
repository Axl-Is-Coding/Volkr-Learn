package androidx.appcompat.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;

/* JADX INFO: renamed from: androidx.appcompat.app.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AlertController.java */
/* JADX INFO: loaded from: classes.dex */
class C0286f extends ArrayAdapter<CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AlertController.a f297b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0286f(AlertController.a aVar, Context context, int i, int i2, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i, i2, charSequenceArr);
        this.f297b = aVar;
        this.f296a = recycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.f297b.F;
        if (zArr != null && zArr[i]) {
            this.f296a.setItemChecked(i, true);
        }
        return view2;
    }
}
