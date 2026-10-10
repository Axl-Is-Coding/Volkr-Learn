package me.iwf.photopicker.utils;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.a;
import com.umeng.analytics.pro.ay;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.R;
import me.iwf.photopicker.entity.PhotoDirectory;

/* JADX INFO: loaded from: classes5.dex */
public class MediaStoreHelper {

    public interface PhotosResultCallback {
        void onResultCallback(List<PhotoDirectory> list);
    }

    private static class a implements a.InterfaceC0024a<Cursor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f22944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PhotosResultCallback f22945b;

        public a(Context context, PhotosResultCallback photosResultCallback) {
            this.f22944a = context;
            this.f22945b = photosResultCallback;
        }

        @Override // androidx.loader.app.a.InterfaceC0024a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(androidx.loader.content.c<Cursor> cVar, Cursor cursor) {
            if (cursor == null) {
                return;
            }
            List<PhotoDirectory> arrayList = new ArrayList<>();
            PhotoDirectory photoDirectory = new PhotoDirectory();
            photoDirectory.setName(this.f22944a.getString(R.string.__picker_all_image));
            photoDirectory.setId("ALL");
            while (cursor.moveToNext()) {
                int i = cursor.getInt(cursor.getColumnIndexOrThrow(ay.f20688d));
                String string = cursor.getString(cursor.getColumnIndexOrThrow("bucket_id"));
                String string2 = cursor.getString(cursor.getColumnIndexOrThrow("bucket_display_name"));
                String string3 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (cursor.getInt(cursor.getColumnIndexOrThrow("_size")) >= 1) {
                    PhotoDirectory photoDirectory2 = new PhotoDirectory();
                    photoDirectory2.setId(string);
                    photoDirectory2.setName(string2);
                    if (arrayList.contains(photoDirectory2)) {
                        arrayList.get(arrayList.indexOf(photoDirectory2)).addPhoto(i, string3);
                    } else {
                        photoDirectory2.setCoverPath(string3);
                        photoDirectory2.addPhoto(i, string3);
                        photoDirectory2.setDateAdded(cursor.getLong(cursor.getColumnIndexOrThrow("date_added")));
                        arrayList.add(photoDirectory2);
                    }
                    photoDirectory.addPhoto(i, string3);
                }
            }
            if (photoDirectory.getPhotoPaths().size() > 0) {
                photoDirectory.setCoverPath(photoDirectory.getPhotoPaths().get(0));
            }
            arrayList.add(0, photoDirectory);
            PhotosResultCallback photosResultCallback = this.f22945b;
            if (photosResultCallback != null) {
                photosResultCallback.onResultCallback(arrayList);
            }
        }

        @Override // androidx.loader.app.a.InterfaceC0024a
        public androidx.loader.content.c<Cursor> onCreateLoader(int i, Bundle bundle) {
            return new f(this.f22944a, bundle.getBoolean("SHOW_GIF", false));
        }

        @Override // androidx.loader.app.a.InterfaceC0024a
        public void onLoaderReset(androidx.loader.content.c<Cursor> cVar) {
        }
    }

    public static void a(FragmentActivity fragmentActivity, Bundle bundle, PhotosResultCallback photosResultCallback) {
        fragmentActivity.getSupportLoaderManager().a(0, bundle, new a(fragmentActivity, photosResultCallback));
    }
}
