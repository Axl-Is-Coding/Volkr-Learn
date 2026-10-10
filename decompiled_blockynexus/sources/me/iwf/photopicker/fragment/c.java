package me.iwf.photopicker.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.C0361k;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bumptech.glide.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.PhotoPickerActivity;
import me.iwf.photopicker.R;
import me.iwf.photopicker.adapter.PopupDirectoryListAdapter;
import me.iwf.photopicker.entity.Photo;
import me.iwf.photopicker.entity.PhotoDirectory;
import me.iwf.photopicker.event.OnPhotoClickListener;
import me.iwf.photopicker.utils.MediaStoreHelper;
import me.iwf.photopicker.utils.e;

/* JADX INFO: compiled from: PhotoPickerFragment.java */
/* JADX INFO: loaded from: classes5.dex */
public class c extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f22938a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private me.iwf.photopicker.utils.c f22939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private me.iwf.photopicker.adapter.a f22940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PopupDirectoryListAdapter f22941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<PhotoDirectory> f22942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<String> f22943f;
    int h;
    private ListPopupWindow i;
    private k j;
    private int g = 30;
    private boolean k = true;

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (me.iwf.photopicker.utils.a.a(this)) {
            this.j.resumeRequests();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            if (this.f22939b == null) {
                this.f22939b = new me.iwf.photopicker.utils.c(getActivity());
            }
            this.f22939b.b();
            if (this.f22942e.size() > 0) {
                String strC = this.f22939b.c();
                PhotoDirectory photoDirectory = this.f22942e.get(0);
                photoDirectory.getPhotos().add(0, new Photo(strC.hashCode(), strC));
                photoDirectory.setCoverPath(strC);
                this.f22940c.notifyDataSetChanged();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.j = com.bumptech.glide.c.a(this);
        this.f22942e = new ArrayList();
        this.f22943f = getArguments().getStringArrayList("origin");
        this.h = getArguments().getInt("column", 3);
        boolean z = getArguments().getBoolean("camera", true);
        boolean z2 = getArguments().getBoolean("PREVIEW_ENABLED", true);
        this.f22940c = new me.iwf.photopicker.adapter.a(getActivity(), this.j, this.f22942e, this.f22943f, this.h);
        this.f22940c.b(z);
        this.f22940c.a(z2);
        this.f22941d = new PopupDirectoryListAdapter(this.j, this.f22942e);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("SHOW_GIF", getArguments().getBoolean("gif"));
        MediaStoreHelper.a(getActivity(), bundle2, new MediaStoreHelper.PhotosResultCallback() { // from class: me.iwf.photopicker.fragment.PhotoPickerFragment$1
            @Override // me.iwf.photopicker.utils.MediaStoreHelper.PhotosResultCallback
            public void onResultCallback(List<PhotoDirectory> list) {
                if (this.f22931a.k) {
                    this.f22931a.f22942e.clear();
                    this.f22931a.f22942e.addAll(list);
                    this.f22931a.f22940c.notifyDataSetChanged();
                    this.f22931a.f22941d.notifyDataSetChanged();
                    this.f22931a.g();
                    this.f22931a.k = false;
                }
            }
        });
        this.f22939b = new me.iwf.photopicker.utils.c(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.__picker_fragment_photo_picker, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.rv_photos);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(this.h, 1);
        staggeredGridLayoutManager.a(2);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(this.f22940c);
        recyclerView.setItemAnimator(new C0361k());
        Button button = (Button) viewInflate.findViewById(R.id.button);
        this.i = new ListPopupWindow(getActivity());
        this.i.k(-1);
        this.i.a(button);
        this.i.a(this.f22941d);
        this.i.a(true);
        this.i.f(80);
        this.i.a(new a(this, button));
        this.f22940c.a(new OnPhotoClickListener() { // from class: me.iwf.photopicker.fragment.PhotoPickerFragment$3
            @Override // me.iwf.photopicker.event.OnPhotoClickListener
            public void onClick(View view, int i, boolean z) {
                if (z) {
                    i--;
                }
                ((PhotoPickerActivity) this.f22932a.getActivity()).a(ImagePagerFragment.a(this.f22932a.f22940c.b(), i));
            }
        });
        this.f22940c.a(new View.OnClickListener() { // from class: me.iwf.photopicker.fragment.PhotoPickerFragment$4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.a(this.f22933a) && e.b(this.f22933a)) {
                    this.f22933a.i();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: me.iwf.photopicker.fragment.PhotoPickerFragment$5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f22934a.i.c()) {
                    this.f22934a.i.dismiss();
                } else {
                    if (this.f22934a.getActivity().isFinishing()) {
                        return;
                    }
                    this.f22934a.g();
                    this.f22934a.i.show();
                }
            }
        });
        recyclerView.addOnScrollListener(new b(this));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        List<PhotoDirectory> list = this.f22942e;
        if (list == null) {
            return;
        }
        for (PhotoDirectory photoDirectory : list) {
            photoDirectory.getPhotoPaths().clear();
            photoDirectory.getPhotos().clear();
            photoDirectory.setPhotos(null);
        }
        this.f22942e.clear();
        this.f22942e = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != 0) {
            return;
        }
        if ((i == 1 || i == 3) && e.b(this) && e.a(this)) {
            i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof PhotoPickerActivity) {
            ((PhotoPickerActivity) getActivity()).h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        this.f22939b.b(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        this.f22939b.a(bundle);
        super.onViewStateRestored(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            startActivityForResult(this.f22939b.a(), 1);
        } catch (ActivityNotFoundException e2) {
            Log.e("PhotoPickerFragment", "No Activity Found to handle Intent", e2);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void g() {
        PopupDirectoryListAdapter popupDirectoryListAdapter = this.f22941d;
        if (popupDirectoryListAdapter == null) {
            return;
        }
        int count = popupDirectoryListAdapter.getCount();
        int i = f22938a;
        if (count >= i) {
            count = i;
        }
        ListPopupWindow listPopupWindow = this.i;
        if (listPopupWindow != null) {
            listPopupWindow.g(count * getResources().getDimensionPixelOffset(R.dimen.__picker_item_directory_height));
        }
    }

    public me.iwf.photopicker.adapter.a h() {
        return this.f22940c;
    }

    public static c a(boolean z, boolean z2, boolean z3, int i, int i2, ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("camera", z);
        bundle.putBoolean("gif", z2);
        bundle.putBoolean("PREVIEW_ENABLED", z3);
        bundle.putInt("column", i);
        bundle.putInt("count", i2);
        bundle.putStringArrayList("origin", arrayList);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }
}
