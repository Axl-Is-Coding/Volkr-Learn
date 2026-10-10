package com.disabngo.blockynexus.e.b.aa;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.utils.IconUploadHelper;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import java.io.File;
import java.util.ArrayList;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ReportDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9642a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f9644c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9643b = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f9645d = new ObservableField<>("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f9646e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.aa.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9620a.onSubmit();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand<String> f9647f = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.aa.c
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9621a.a((String) obj);
        }
    });

    public i(Context context, e eVar) {
        this.f9642a = context;
        this.f9644c = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubmit() {
        if (this.f9644c.i().isEmpty()) {
            AppToastUtils.showShortNegativeTipToast(this.f9642a, R.string.report_image_need_upload);
            return;
        }
        new LoadingDialog(this.f9642a).show();
        if (this.f9644c != null) {
            final g gVar = new g();
            final long jG = this.f9644c.g();
            final String strH = this.f9644c.h();
            final ArrayList<File> arrayListI = this.f9644c.i();
            final ArrayList arrayList = new ArrayList();
            final int[] iArr = {0};
            Observable.from(arrayListI).subscribe(new Action1() { // from class: com.disabngo.blockynexus.e.b.aa.d
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f9622a.a(arrayList, arrayListI, gVar, jG, strH, iArr, (File) obj);
                }
            });
        }
    }

    public /* synthetic */ void a(String str) {
        this.f9643b = str;
        this.f9645d.set(str.length() + "/200");
    }

    public /* synthetic */ void a(ArrayList arrayList, ArrayList arrayList2, g gVar, long j, String str, int[] iArr, File file) {
        IconUploadHelper.uploadIcon(this.f9642a, file, file.getName(), new h(this, arrayList, arrayList2, gVar, j, str, iArr));
    }
}
