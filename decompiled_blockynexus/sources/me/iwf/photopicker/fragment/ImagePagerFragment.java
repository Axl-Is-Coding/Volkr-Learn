package me.iwf.photopicker.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.iwf.photopicker.PhotoPickerActivity;
import me.iwf.photopicker.R;

/* JADX INFO: loaded from: classes5.dex */
public class ImagePagerFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f22927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewPager f22928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private me.iwf.photopicker.adapter.b f22929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22930d = 0;

    public static ImagePagerFragment a(List<String> list, int i) {
        ImagePagerFragment imagePagerFragment = new ImagePagerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("PATHS", (String[]) list.toArray(new String[list.size()]));
        bundle.putInt("ARG_CURRENT_ITEM", i);
        imagePagerFragment.setArguments(bundle);
        return imagePagerFragment;
    }

    public void b(List<String> list, int i) {
        this.f22927a.clear();
        this.f22927a.addAll(list);
        this.f22930d = i;
        this.f22928b.setCurrentItem(i);
        this.f22928b.getAdapter().notifyDataSetChanged();
    }

    public int g() {
        return this.f22928b.getCurrentItem();
    }

    public ArrayList<String> h() {
        ArrayList<String> arrayList = new ArrayList<>();
        int currentItem = this.f22928b.getCurrentItem();
        ArrayList<String> arrayList2 = this.f22927a;
        if (arrayList2 != null && arrayList2.size() > currentItem) {
            arrayList.add(this.f22927a.get(currentItem));
        }
        return arrayList;
    }

    public ArrayList<String> i() {
        return this.f22927a;
    }

    public ViewPager j() {
        return this.f22928b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f22927a = new ArrayList<>();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String[] stringArray = arguments.getStringArray("PATHS");
            this.f22927a.clear();
            if (stringArray != null) {
                this.f22927a = new ArrayList<>(Arrays.asList(stringArray));
            }
            this.f22930d = arguments.getInt("ARG_CURRENT_ITEM");
        }
        this.f22929c = new me.iwf.photopicker.adapter.b(com.bumptech.glide.c.a(this), this.f22927a);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.__picker_picker_fragment_image_pager, viewGroup, false);
        this.f22928b = (ViewPager) viewInflate.findViewById(R.id.vp_photos);
        this.f22928b.setAdapter(this.f22929c);
        this.f22928b.setCurrentItem(this.f22930d);
        this.f22928b.setOffscreenPageLimit(5);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f22927a.clear();
        this.f22927a = null;
        ViewPager viewPager = this.f22928b;
        if (viewPager != null) {
            viewPager.setAdapter(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof PhotoPickerActivity) {
            ((PhotoPickerActivity) getActivity()).h();
        }
    }
}
