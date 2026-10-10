package androidx.databinding.a;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.databinding.a.e;

/* JADX INFO: compiled from: TextViewBindingAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class d implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e.b f1347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e.c f1348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ androidx.databinding.f f1349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ e.a f1350d;

    d(e.b bVar, e.c cVar, androidx.databinding.f fVar, e.a aVar) {
        this.f1347a = bVar;
        this.f1348b = cVar;
        this.f1349c = fVar;
        this.f1350d = aVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        e.a aVar = this.f1350d;
        if (aVar != null) {
            aVar.afterTextChanged(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        e.b bVar = this.f1347a;
        if (bVar != null) {
            bVar.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        e.c cVar = this.f1348b;
        if (cVar != null) {
            cVar.onTextChanged(charSequence, i, i2, i3);
        }
        androidx.databinding.f fVar = this.f1349c;
        if (fVar != null) {
            fVar.a();
        }
    }
}
