package me.iwf.photopicker.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.k;
import com.bumptech.glide.request.f;
import com.sandboxol.vip.entity.VipDiamond;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.R;

/* JADX INFO: compiled from: PhotoPagerAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f22910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f22911b;

    public b(k kVar, List<String> list) {
        this.f22910a = new ArrayList();
        this.f22910a = list;
        this.f22911b = kVar;
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.f22911b.clear(view);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.f22910a.size();
    }

    @Override // androidx.viewpager.widget.a
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        final Context context = viewGroup.getContext();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.__picker_picker_item_pager, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_pager);
        String str = this.f22910a.get(i);
        Uri uriFromFile = str.startsWith("http") ? Uri.parse(str) : Uri.fromFile(new File(str));
        if (me.iwf.photopicker.utils.a.a(context)) {
            f fVar = new f();
            fVar.dontAnimate().dontTransform().override(VipDiamond.MVP, VipDiamond.MVP).placeholder(R.drawable.__picker_ic_photo_black_48dp).error(R.drawable.__picker_ic_broken_image_black_48dp);
            this.f22911b.setDefaultRequestOptions(fVar).mo51load(uriFromFile).thumbnail(0.1f).into(imageView);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: me.iwf.photopicker.adapter.PhotoPagerAdapter$1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Context context2 = context;
                if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                    return;
                }
                ((Activity) context).onBackPressed();
            }
        });
        viewGroup.addView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
