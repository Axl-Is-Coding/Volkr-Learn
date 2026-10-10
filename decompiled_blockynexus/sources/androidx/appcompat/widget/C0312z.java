package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: renamed from: androidx.appcompat.widget.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatSpinner.java */
/* JADX INFO: loaded from: classes.dex */
class C0312z implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner f722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner.b f723b;

    C0312z(AppCompatSpinner.b bVar, AppCompatSpinner appCompatSpinner) {
        this.f723b = bVar;
        this.f722a = appCompatSpinner;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppCompatSpinner.this.setSelection(i);
        if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.b bVar = this.f723b;
            AppCompatSpinner.this.performItemClick(view, i, bVar.L.getItemId(i));
        }
        this.f723b.dismiss();
    }
}
