package me.iwf.photopicker.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import me.iwf.photopicker.entity.PhotoDirectory;

/* JADX INFO: compiled from: PhotoPickerFragment.java */
/* JADX INFO: loaded from: classes5.dex */
class a implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Button f22935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f22936b;

    a(c cVar, Button button) {
        this.f22936b = cVar;
        this.f22935a = button;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f22936b.i.dismiss();
        this.f22935a.setText(((PhotoDirectory) this.f22936b.f22942e.get(i)).getName());
        this.f22936b.f22940c.a(i);
        this.f22936b.f22940c.notifyDataSetChanged();
    }
}
