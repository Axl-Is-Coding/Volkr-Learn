package io.rong.imkit.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UriFragment extends BaseFragment {
    public static final String RONG_URI = "RONG_URI";
    private IActionBarHandler mBarHandler;
    private Uri mUri;
    private boolean mViewCreated;

    protected interface IActionBarHandler {
        void onTitleChanged(CharSequence charSequence);

        void onUnreadCountChanged(int i);
    }

    protected IActionBarHandler getActionBarHandler() {
        return this.mBarHandler;
    }

    public Uri getUri() {
        return this.mUri;
    }

    protected abstract void initFragment(Uri uri);

    protected Bundle obtainUriBundle(Uri uri) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(RONG_URI, uri);
        return bundle;
    }

    @Override // io.rong.imkit.fragment.BaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mUri == null) {
            if (bundle != null) {
                this.mUri = (Uri) bundle.getParcelable(RONG_URI);
            } else {
                if (getActivity() == null || getActivity().getIntent() == null) {
                    return;
                }
                this.mUri = getActivity().getIntent().getData();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // io.rong.imkit.fragment.BaseFragment
    public void onRestoreUI() {
        if (getUri() != null) {
            initFragment(getUri());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(RONG_URI, getUri());
        super.onSaveInstanceState(bundle);
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mViewCreated = true;
        if (getUri() != null) {
            initFragment(getUri());
        }
    }

    public void setActionBarHandler(IActionBarHandler iActionBarHandler) {
        this.mBarHandler = iActionBarHandler;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
        if (this.mViewCreated) {
            initFragment(uri);
        }
    }
}
