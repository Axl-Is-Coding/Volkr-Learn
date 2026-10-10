package me.iwf.photopicker.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.k;
import com.bumptech.glide.request.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.iwf.photopicker.R;
import me.iwf.photopicker.entity.Photo;
import me.iwf.photopicker.entity.PhotoDirectory;
import me.iwf.photopicker.event.OnPhotoClickListener;

/* JADX INFO: compiled from: PhotoGridAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends c<C0247a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k f22905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private me.iwf.photopicker.event.a f22906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OnPhotoClickListener f22907f;
    private View.OnClickListener g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;

    /* JADX INFO: renamed from: me.iwf.photopicker.adapter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PhotoGridAdapter.java */
    public static class C0247a extends RecyclerView.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImageView f22908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private View f22909b;

        public C0247a(View view) {
            super(view);
            this.f22908a = (ImageView) view.findViewById(R.id.iv_photo);
            this.f22909b = view.findViewById(R.id.v_selected);
        }
    }

    public a(Context context, k kVar, List<PhotoDirectory> list) {
        this.f22906e = null;
        this.f22907f = null;
        this.g = null;
        this.h = true;
        this.i = true;
        this.k = 3;
        this.f22912a = list;
        this.f22905d = kVar;
        a(context, this.k);
    }

    public ArrayList<String> f() {
        ArrayList<String> arrayList = new ArrayList<>(d());
        Iterator<String> it = this.f22913b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public boolean g() {
        return this.h && this.f22914c == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        int size = this.f22912a.size() == 0 ? 0 : c().size();
        return g() ? size + 1 : size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemViewType(int i) {
        return (g() && i == 0) ? 100 : 101;
    }

    private void a(Context context, int i) {
        this.k = i;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.j = displayMetrics.widthPixels / i;
    }

    public void b(boolean z) {
        this.h = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public C0247a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0247a c0247a = new C0247a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.__picker_item_photo, viewGroup, false));
        if (i == 100) {
            c0247a.f22909b.setVisibility(8);
            c0247a.f22908a.setScaleType(ImageView.ScaleType.CENTER);
            c0247a.f22908a.setOnClickListener(new View.OnClickListener() { // from class: me.iwf.photopicker.adapter.PhotoGridAdapter$1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f22893a.g != null) {
                        this.f22893a.g.onClick(view);
                    }
                }
            });
        }
        return c0247a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final C0247a c0247a, int i) {
        final Photo photo;
        if (getItemViewType(i) != 101) {
            c0247a.f22908a.setImageResource(R.drawable.__picker_camera);
            return;
        }
        List<Photo> listC = c();
        if (g()) {
            photo = listC.get(i - 1);
        } else {
            photo = listC.get(i);
        }
        if (me.iwf.photopicker.utils.a.a(c0247a.f22908a.getContext())) {
            f fVar = new f();
            f fVarDontAnimate = fVar.centerCrop().dontAnimate();
            int i2 = this.j;
            fVarDontAnimate.override(i2, i2).placeholder(R.drawable.__picker_ic_photo_black_48dp).error(R.drawable.__picker_ic_broken_image_black_48dp);
            this.f22905d.setDefaultRequestOptions(fVar).mo52load(new File(photo.getPath())).thumbnail(0.5f).into(c0247a.f22908a);
        }
        boolean zA = a(photo);
        c0247a.f22909b.setSelected(zA);
        c0247a.f22908a.setSelected(zA);
        c0247a.f22908a.setOnClickListener(new View.OnClickListener() { // from class: me.iwf.photopicker.adapter.PhotoGridAdapter$2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f22895b.f22907f != null) {
                    int adapterPosition = c0247a.getAdapterPosition();
                    if (this.f22895b.i) {
                        this.f22895b.f22907f.onClick(view, adapterPosition, this.f22895b.g());
                    } else {
                        c0247a.f22909b.performClick();
                    }
                }
            }
        });
        c0247a.f22909b.setOnClickListener(new View.OnClickListener() { // from class: me.iwf.photopicker.adapter.PhotoGridAdapter$3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = c0247a.getAdapterPosition();
                boolean zA2 = true;
                if (this.f22898c.f22906e != null) {
                    zA2 = this.f22898c.f22906e.a(adapterPosition, photo, this.f22898c.e().size() + (this.f22898c.a(photo) ? -1 : 1));
                }
                if (zA2) {
                    this.f22898c.b(photo);
                    this.f22898c.notifyItemChanged(adapterPosition);
                }
            }
        });
    }

    public a(Context context, k kVar, List<PhotoDirectory> list, ArrayList<String> arrayList, int i) {
        this(context, kVar, list);
        a(context, i);
        this.f22913b = new ArrayList();
        if (arrayList != null) {
            this.f22913b.addAll(arrayList);
        }
    }

    public void a(me.iwf.photopicker.event.a aVar) {
        this.f22906e = aVar;
    }

    public void a(OnPhotoClickListener onPhotoClickListener) {
        this.f22907f = onPhotoClickListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void a(boolean z) {
        this.i = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C0247a c0247a) {
        this.f22905d.clear(c0247a.f22908a);
        super.onViewRecycled(c0247a);
    }
}
