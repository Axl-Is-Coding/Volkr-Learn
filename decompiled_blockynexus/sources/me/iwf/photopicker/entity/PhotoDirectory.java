package me.iwf.photopicker.entity;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.iwf.photopicker.utils.b;

/* JADX INFO: loaded from: classes5.dex */
public class PhotoDirectory {
    private String coverPath;
    private long dateAdded;
    private String id;
    private String name;
    private List<Photo> photos = new ArrayList();

    public void addPhoto(int i, String str) {
        if (b.a(str)) {
            this.photos.add(new Photo(i, str));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoDirectory)) {
            return false;
        }
        PhotoDirectory photoDirectory = (PhotoDirectory) obj;
        boolean z = !TextUtils.isEmpty(this.id);
        boolean zIsEmpty = true ^ TextUtils.isEmpty(photoDirectory.id);
        if (z && zIsEmpty && TextUtils.equals(this.id, photoDirectory.id)) {
            return TextUtils.equals(this.name, photoDirectory.name);
        }
        return false;
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public long getDateAdded() {
        return this.dateAdded;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getPhotoPaths() {
        ArrayList arrayList = new ArrayList(this.photos.size());
        Iterator<Photo> it = this.photos.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPath());
        }
        return arrayList;
    }

    public List<Photo> getPhotos() {
        return this.photos;
    }

    public int hashCode() {
        if (!TextUtils.isEmpty(this.id)) {
            int iHashCode = this.id.hashCode();
            return TextUtils.isEmpty(this.name) ? iHashCode : (iHashCode * 31) + this.name.hashCode();
        }
        if (TextUtils.isEmpty(this.name)) {
            return 0;
        }
        return this.name.hashCode();
    }

    public void setCoverPath(String str) {
        this.coverPath = str;
    }

    public void setDateAdded(long j) {
        this.dateAdded = j;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhotos(List<Photo> list) {
        if (list == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Photo photo = list.get(i);
            if (photo == null || !b.a(photo.getPath())) {
                list.remove(i);
            } else {
                i++;
            }
        }
        this.photos = list;
    }
}
