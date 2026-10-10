package com.sandboxol.videosubmit.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.entity.BGTubeInfoResponse;
import com.sandboxol.videosubmit.view.activity.EventRulesAdapter;
import com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitEventRulesBindingImpl extends VideosubmitEventRulesBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ImageView mboundView1;

    static {
        sViewsWithIds.put(R.id.v_content_rules, 3);
        sViewsWithIds.put(R.id.tv_content_rules_title, 4);
    }

    public VideosubmitEventRulesBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, sIncludes, sViewsWithIds));
    }

    private boolean onChangeVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelConfigInfo(ObservableField<BGTubeInfoResponse> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelEventRulesAdapter(ObservableField<EventRulesAdapter> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> L88
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> L88
            monitor-exit(r25)     // Catch: java.lang.Throwable -> L88
            com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel r0 = r1.mVideoSubmitViewModel
            r6 = 15
            long r6 = r6 & r2
            r8 = 14
            r10 = 11
            r12 = 0
            r13 = 0
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L56
            long r6 = r2 & r10
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L39
            if (r0 == 0) goto L24
            androidx.databinding.ObservableField<com.sandboxol.videosubmit.entity.BGTubeInfoResponse> r6 = r0.configInfo
            goto L25
        L24:
            r6 = r13
        L25:
            r1.updateRegistration(r12, r6)
            if (r6 == 0) goto L31
            java.lang.Object r6 = r6.get()
            com.sandboxol.videosubmit.entity.BGTubeInfoResponse r6 = (com.sandboxol.videosubmit.entity.BGTubeInfoResponse) r6
            goto L32
        L31:
            r6 = r13
        L32:
            if (r6 == 0) goto L39
            java.lang.String r6 = r6.getEventRulesHeadUrl()
            goto L3a
        L39:
            r6 = r13
        L3a:
            long r14 = r2 & r8
            int r7 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r7 == 0) goto L53
            if (r0 == 0) goto L45
            androidx.databinding.ObservableField<com.sandboxol.videosubmit.view.activity.EventRulesAdapter> r0 = r0.eventRulesAdapter
            goto L46
        L45:
            r0 = r13
        L46:
            r7 = 2
            r1.updateRegistration(r7, r0)
            if (r0 == 0) goto L53
            java.lang.Object r0 = r0.get()
            r13 = r0
            com.sandboxol.videosubmit.view.activity.EventRulesAdapter r13 = (com.sandboxol.videosubmit.view.activity.EventRulesAdapter) r13
        L53:
            r16 = r6
            goto L58
        L56:
            r16 = r13
        L58:
            long r6 = r2 & r10
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L63
            int r12 = com.sandboxol.videosubmit.R.mipmap.videosubmit_bg_content_criterria_person
            r18 = r12
            goto L65
        L63:
            r18 = 0
        L65:
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L7d
            android.widget.ImageView r14 = r1.mboundView1
            r15 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r17 = r18
            com.sandboxol.common.binding.adapter.ImageViewBindingAdapters.loadImage(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
        L7d:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L87
            androidx.recyclerview.widget.RecyclerView r0 = r1.rvRules
            r0.setAdapter(r13)
        L87:
            return
        L88:
            r0 = move-exception
            monitor-exit(r25)     // Catch: java.lang.Throwable -> L88
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.videosubmit.databinding.VideosubmitEventRulesBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVideoSubmitViewModelConfigInfo((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeVideoSubmitViewModel((VideoSubmitViewModel) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeVideoSubmitViewModelEventRulesAdapter((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.videoSubmitViewModel != i) {
            return false;
        }
        setVideoSubmitViewModel((VideoSubmitViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitEventRulesBinding
    public void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel) {
        updateRegistration(1, videoSubmitViewModel);
        this.mVideoSubmitViewModel = videoSubmitViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.videoSubmitViewModel);
        super.requestRebind();
    }

    private VideosubmitEventRulesBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RecyclerView) objArr[2], (TextView) objArr[4], (View) objArr[3]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (ImageView) objArr[1];
        this.mboundView1.setTag(null);
        this.rvRules.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
