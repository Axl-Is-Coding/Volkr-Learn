package me.iwf.photopicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: PhotoPicker.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {
    public static a a() {
        return new a();
    }

    /* JADX INFO: compiled from: PhotoPicker.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bundle f22922a = new Bundle();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f22923b = new Intent();

        public void a(Activity activity, int i) {
            if (me.iwf.photopicker.utils.e.a(activity)) {
                activity.startActivityForResult(a((Context) activity), i);
            }
        }

        public Intent a(Context context) {
            this.f22923b.setClass(context, PhotoPickerActivity.class);
            this.f22923b.putExtras(this.f22922a);
            return this.f22923b;
        }

        public void a(Activity activity) {
            a(activity, 233);
        }

        public a a(int i) {
            this.f22922a.putInt("MAX_COUNT", i);
            return this;
        }

        public a a(ArrayList<String> arrayList) {
            this.f22922a.putStringArrayList("ORIGINAL_PHOTOS", arrayList);
            return this;
        }

        public a a(boolean z) {
            this.f22922a.putBoolean("PREVIEW_ENABLED", z);
            return this;
        }
    }
}
