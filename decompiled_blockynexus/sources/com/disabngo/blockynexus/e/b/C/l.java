package com.disabngo.blockynexus.e.b.C;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.utils.IconUploadHelper;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import java.io.File;
import java.util.ArrayList;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: GroupEditViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GroupInfoParam f9146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f9147c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private StringBuilder f9150f;
    private StringBuilder k;
    public String l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Integer> f9148d = new ObservableField<>();
    public ObservableField<Boolean> g = new ObservableField<>();
    public ObservableField<String> h = new ObservableField<>();
    public ReplyCommand<String> i = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.C.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9132a.a((String) obj);
        }
    });
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.C.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f9131a.f();
        }
    });
    public ObservableField<String> m = new ObservableField<>();
    public ObservableField<Integer> n = new ObservableField<>(0);
    public ReplyCommand<String> o = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.C.c
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9126a.b((String) obj);
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.C.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9125a.h();
        }
    });

    public l(Context context, GroupInfoParam groupInfoParam, int i, g gVar) {
        this.f9145a = context;
        this.f9146b = groupInfoParam;
        this.f9147c = gVar;
        b(i);
        ObservableField<String> observableField = this.m;
        if (observableField == null || observableField.get() == null || this.m.get().length() <= 0) {
            return;
        }
        this.n.set(Integer.valueOf(this.m.get().length()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
        if (this.f9148d.get().intValue() == 0) {
            if (CommonHelper.countString(str) > 20) {
                AppToastUtils.showShortNegativeTipToast(this.f9145a, R.string.group_name_max_length);
                this.h.set(str.substring(0, str.length() - 1));
            } else {
                if (TextUtils.isEmpty(str) || str.equals(this.f9149e)) {
                    this.g.set(false);
                    notifyPropertyChanged(R.id.btn_change);
                    return;
                }
                this.g.set(true);
                notifyPropertyChanged(R.id.btn_change);
                StringBuilder sb = this.f9150f;
                sb.delete(0, sb.length());
                this.f9150f.append(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        if (this.f9148d.get().intValue() == 1) {
            if (CommonHelper.countString(str) > 1000) {
                AppToastUtils.showShortNegativeTipToast(this.f9145a, R.string.group_notice_max_length);
                this.m.set(str.substring(0, str.length() - 1));
            } else {
                StringBuilder sb = this.k;
                sb.delete(0, sb.length());
                this.k.append(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ReportDataAdapter.onEvent(this.f9145a, EventConstant.GROUP_MODIFYNAME_CLICK);
        this.f9146b.setGroupName(this.f9150f.toString());
        if (CommonHelper.countString(this.f9150f.toString()) > 20) {
            AppToastUtils.showShortNegativeTipToast(this.f9145a, R.string.group_name_max_length);
        } else {
            GroupChatApi.updateGroupInfo(this.f9145a, this.f9146b, new j(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ReportDataAdapter.onEvent(this.f9145a, EventConstant.GROUP_ANN_CLICK_LORD);
        this.f9146b.setGroupNotice(this.k.toString());
        if (this.f9147c != null) {
            final i iVar = new i();
            final ArrayList<File> arrayListG = this.f9147c.g();
            if (arrayListG.size() > 0) {
                final ArrayList arrayList = new ArrayList();
                Observable.from(arrayListG).subscribe(new Action1() { // from class: com.disabngo.blockynexus.e.b.C.d
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f9127a.a(arrayList, arrayListG, iVar, (File) obj);
                    }
                });
            } else {
                this.f9146b.setNoticePic(new ArrayList());
                iVar.a(this.f9145a, this.f9146b);
            }
        }
    }

    private String c(String str) {
        String[] strArrSplit = str.split(":");
        return strArrSplit[0] + ":/" + strArrSplit[1];
    }

    private void b(int i) {
        this.f9148d.set(Integer.valueOf(i));
        int iIntValue = this.f9148d.get().intValue();
        if (iIntValue == 0) {
            this.f9150f = new StringBuilder();
            this.f9149e = this.f9146b.getGroupName();
        } else {
            if (iIntValue != 1) {
                return;
            }
            this.k = new StringBuilder();
            if (this.f9146b.getGroupNotice() == null) {
                this.l = "";
                this.m.set("");
            } else {
                this.l = this.f9146b.getGroupNotice();
                this.m.set(this.f9146b.getGroupNotice());
            }
        }
    }

    public /* synthetic */ void a(ArrayList arrayList, ArrayList arrayList2, i iVar, File file) {
        new LoadingDialog(this.f9145a).show();
        if (file.exists()) {
            IconUploadHelper.uploadIcon(this.f9145a, file, file.getName(), new k(this, arrayList, arrayList2, iVar));
            return;
        }
        arrayList.add(c(file.getPath()));
        if (arrayList.size() == arrayList2.size()) {
            this.f9146b.setNoticePic(arrayList);
            iVar.a(this.f9145a, this.f9146b);
        }
    }
}
