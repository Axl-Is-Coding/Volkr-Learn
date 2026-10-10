package me.iwf.photopicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.places.model.PlaceFields;
import java.util.ArrayList;

/* JADX INFO: compiled from: PhotoPreview.java */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: compiled from: PhotoPreview.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bundle f22925a = new Bundle();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f22926b = new Intent();

        public void a(Activity activity, int i) {
            activity.startActivityForResult(a((Context) activity), i);
        }

        public void a(Activity activity) {
            a(activity, 666);
        }

        public Intent a(Context context) {
            this.f22926b.setClass(context, PhotoPagerActivity.class);
            this.f22926b.putExtras(this.f22925a);
            return this.f22926b;
        }

        public a a(ArrayList<String> arrayList) {
            this.f22925a.putStringArrayList(PlaceFields.PHOTOS_PROFILE, arrayList);
            return this;
        }

        public a a(int i) {
            this.f22925a.putInt("current_item", i);
            return this;
        }

        public a a(boolean z) {
            this.f22925a.putBoolean("show_delete", z);
            return this;
        }
    }

    public static a a() {
        return new a();
    }
}
