package me.iwf.photopicker;

import android.widget.Toast;
import java.util.List;
import me.iwf.photopicker.entity.Photo;

/* JADX INFO: compiled from: PhotoPickerActivity.java */
/* JADX INFO: loaded from: classes5.dex */
class e implements me.iwf.photopicker.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PhotoPickerActivity f22924a;

    e(PhotoPickerActivity photoPickerActivity) {
        this.f22924a = photoPickerActivity;
    }

    @Override // me.iwf.photopicker.event.a
    public boolean a(int i, Photo photo, int i2) {
        this.f22924a.f22883c.setEnabled(i2 > 0);
        if (this.f22924a.f22884d <= 1) {
            List<String> listE = this.f22924a.f22881a.h().e();
            if (!listE.contains(photo.getPath())) {
                listE.clear();
                this.f22924a.f22881a.h().notifyDataSetChanged();
            }
            return true;
        }
        if (i2 > this.f22924a.f22884d) {
            PhotoPickerActivity photoPickerActivityG = this.f22924a.g();
            PhotoPickerActivity photoPickerActivity = this.f22924a;
            Toast.makeText(photoPickerActivityG, photoPickerActivity.getString(R.string.__picker_over_max_count_tips, new Object[]{Integer.valueOf(photoPickerActivity.f22884d)}), 1).show();
            return false;
        }
        if (this.f22924a.f22884d > 1) {
            this.f22924a.f22883c.setTitle(this.f22924a.getString(R.string.__picker_done_with_count, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.f22924a.f22884d)}));
        } else {
            this.f22924a.f22883c.setTitle(this.f22924a.getString(R.string.__picker_done));
        }
        return true;
    }
}
