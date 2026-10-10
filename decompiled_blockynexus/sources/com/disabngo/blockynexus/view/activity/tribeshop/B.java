package com.disabngo.blockynexus.view.activity.tribeshop;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.K;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeShopPageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class B extends ListItemViewModel<TribeShopPageList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableMap<Long, String> f11149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableMap<Long, String> f11150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableMap<Long, TribeShopPageList> f11151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f11152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f11153e;

    /* JADX WARN: Multi-variable type inference failed */
    public B(Context context, TribeShopPageList tribeShopPageList, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2, ObservableMap<Long, TribeShopPageList> observableMap3) {
        super(context, tribeShopPageList);
        this.f11152d = new ObservableField<>(this.context.getString(R.string.tribe_shop_goods_level, Integer.valueOf(((TribeShopPageList) this.item).getClanLevel())));
        this.f11153e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11165a.f();
            }
        });
        this.f11149a = observableMap;
        this.f11150b = observableMap2;
        this.f11151c = observableMap3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h() {
        String strA = K.a(((TribeShopPageList) this.item).getResourceId());
        if (strA != null) {
            a(strA);
            return;
        }
        a(((TribeShopPageList) this.item).getResourceId().split("\\.")[0] + ".0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(Long l) {
        if (l.longValue() != ((TribeShopPageList) this.item).getTypeId()) {
            this.f11149a.put(l, com.sandboxol.decorate.f.j.a(l.longValue()));
            a(com.sandboxol.decorate.f.j.a(l.longValue()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public /* synthetic */ void f() {
        if (this.f11149a.values().contains(((TribeShopPageList) this.item).getResourceId())) {
            this.f11149a.remove(Long.valueOf(((TribeShopPageList) this.item).getTypeId()));
            this.f11150b.put(Long.valueOf(((TribeShopPageList) this.item).getTypeId()), "empty");
            this.f11151c.remove(Long.valueOf(((TribeShopPageList) this.item).getTypeId()));
            h();
            return;
        }
        this.f11149a.put(Long.valueOf(((TribeShopPageList) this.item).getTypeId()), ((TribeShopPageList) this.item).getResourceId());
        this.f11150b.put(Long.valueOf(((TribeShopPageList) this.item).getTypeId()), ((TribeShopPageList) this.item).getIconUrl());
        this.f11151c.put(Long.valueOf(((TribeShopPageList) this.item).getTypeId()), this.item);
        if (com.sandboxol.decorate.manager.n.b().e() != null && com.sandboxol.decorate.manager.n.b().e().contains(Long.valueOf(((TribeShopPageList) this.item).getTypeId()))) {
            Observable.from(com.sandboxol.decorate.manager.n.b().e()).subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f11166a.a((Long) obj);
                }
            });
            a(com.sandboxol.decorate.f.j.a(16L));
        }
        a(((TribeShopPageList) this.item).getResourceId());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TribeShopPageList getItem() {
        return (TribeShopPageList) super.getItem();
    }

    private void a(String str) {
        Messenger.getDefault().send(str, GameMessageToken.TOKEN_SHOP_CHANGE_CLOTHES);
    }
}
