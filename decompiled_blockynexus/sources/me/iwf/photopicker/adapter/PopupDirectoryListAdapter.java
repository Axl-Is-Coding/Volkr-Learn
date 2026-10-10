package me.iwf.photopicker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.k;
import com.bumptech.glide.request.f;
import com.sandboxol.vip.entity.VipDiamond;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.R;
import me.iwf.photopicker.entity.PhotoDirectory;

/* JADX INFO: loaded from: classes5.dex */
public class PopupDirectoryListAdapter extends BaseAdapter {
    private List<PhotoDirectory> directories;
    private k glide;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f22901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f22902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f22903c;

        public a(View view) {
            this.f22901a = (ImageView) view.findViewById(R.id.iv_dir_cover);
            this.f22902b = (TextView) view.findViewById(R.id.tv_dir_name);
            this.f22903c = (TextView) view.findViewById(R.id.tv_dir_count);
        }

        public void a(PhotoDirectory photoDirectory) {
            f fVar = new f();
            fVar.dontAnimate().dontTransform().override(VipDiamond.MVP, VipDiamond.MVP).placeholder(R.drawable.__picker_ic_photo_black_48dp).error(R.drawable.__picker_ic_broken_image_black_48dp);
            PopupDirectoryListAdapter.this.glide.setDefaultRequestOptions(fVar).mo55load(photoDirectory.getCoverPath()).thumbnail(0.1f).into(this.f22901a);
            this.f22902b.setText(photoDirectory.getName());
            TextView textView = this.f22903c;
            textView.setText(textView.getContext().getString(R.string.__picker_image_count, Integer.valueOf(photoDirectory.getPhotos().size())));
        }
    }

    public PopupDirectoryListAdapter(k kVar, List<PhotoDirectory> list) {
        this.directories = new ArrayList();
        this.directories = list;
        this.glide = kVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.directories.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.directories.get(i).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.__picker_item_directory, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a(this.directories.get(i));
        return view;
    }

    @Override // android.widget.Adapter
    public PhotoDirectory getItem(int i) {
        return this.directories.get(i);
    }
}
