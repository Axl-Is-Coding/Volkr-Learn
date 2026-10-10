package me.iwf.photopicker.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.iwf.photopicker.entity.Photo;
import me.iwf.photopicker.entity.PhotoDirectory;

/* JADX INFO: compiled from: SelectableAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c<VH extends RecyclerView.w> extends RecyclerView.a<VH> implements me.iwf.photopicker.event.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22914c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<PhotoDirectory> f22912a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<String> f22913b = new ArrayList();

    public boolean a(Photo photo) {
        return e().contains(photo.getPath());
    }

    public void b(Photo photo) {
        if (this.f22913b.contains(photo.getPath())) {
            this.f22913b.remove(photo.getPath());
        } else {
            this.f22913b.add(photo.getPath());
        }
    }

    public List<Photo> c() {
        return this.f22912a.get(this.f22914c).getPhotos();
    }

    public int d() {
        return this.f22913b.size();
    }

    public List<String> e() {
        return this.f22913b;
    }

    public void a(int i) {
        this.f22914c = i;
    }

    public List<String> b() {
        ArrayList arrayList = new ArrayList(c().size());
        Iterator<Photo> it = c().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPath());
        }
        return arrayList;
    }
}
