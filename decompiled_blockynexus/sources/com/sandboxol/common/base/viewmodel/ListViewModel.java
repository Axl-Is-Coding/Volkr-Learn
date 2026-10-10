package com.sandboxol.common.base.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableList;
import com.sandboxol.common.R;
import com.sandboxol.common.base.model.IListModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.msg.InsertMsg;
import com.sandboxol.common.widget.rv.msg.MoreMsg;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.common.widget.rv.msg.RemoveMsg;
import com.sandboxol.common.widget.rv.msg.ReplaceMsg;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ListViewModel<T> extends ViewModel implements IListViewModel<T> {
    protected Context context;
    protected IListModel model;
    public ObservableItemList<ListItemViewModel<T>> itemViewModel = new ObservableItemList<>();
    public ReplyCommand onRefreshCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.common.base.viewmodel.q
        @Override // rx.functions.Action0
        public final void call() {
            this.f16876a.onRefresh();
        }
    });
    public ReplyCommand<Integer> onLoadMoreCommand = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.common.base.viewmodel.j
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f16869a.a((Integer) obj);
        }
    });
    public ListViewStyle viewStyle = new ListViewStyle();
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<T>> itemBinding = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.sandboxol.common.base.viewmodel.a
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f16857a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });
    private boolean enableSetItem = true;
    private List<T> data = new ArrayList();

    /* JADX INFO: renamed from: com.sandboxol.common.base.viewmodel.ListViewModel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$common$widget$rv$msg$RemoveMsg$REMOVE_MODE = new int[RemoveMsg.REMOVE_MODE.values().length];

        static {
            try {
                $SwitchMap$com$sandboxol$common$widget$rv$msg$RemoveMsg$REMOVE_MODE[RemoveMsg.REMOVE_MODE.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sandboxol$common$widget$rv$msg$RemoveMsg$REMOVE_MODE[RemoveMsg.REMOVE_MODE.ITEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sandboxol$common$widget$rv$msg$RemoveMsg$REMOVE_MODE[RemoveMsg.REMOVE_MODE.LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$sandboxol$common$widget$rv$msg$RemoveMsg$REMOVE_MODE[RemoveMsg.REMOVE_MODE.INDEX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ListViewModel(Context context, IListModel iListModel) {
        this.context = context;
        this.model = iListModel;
        this.model.setViewModel(this);
        registerMessenger();
    }

    public /* synthetic */ void a(Integer num) {
        onLoadMore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void add(Object obj, int i, InsertMsg.INSERT_MODE insert_mode) {
        if (obj instanceof List) {
            addItems((List) obj, i, insert_mode);
        } else {
            addItem(obj, i, insert_mode);
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void addItem(T t) {
        addItem(t, 0, InsertMsg.INSERT_MODE.END);
        this.data.add(t);
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void addItemViewModel(ListItemViewModel<T> listItemViewModel) {
        this.itemViewModel.add(listItemViewModel);
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void addItems(List<T> list) {
        addItems(list, 0, InsertMsg.INSERT_MODE.END);
    }

    public /* synthetic */ void b(ListItemViewModel listItemViewModel) {
        this.data.remove(listItemViewModel.item);
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel listItemViewModel) {
        IListModel iListModel = this.model;
        if (iListModel != null) {
            iListModel.onBind(gVar, i, listItemViewModel);
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void clearItems() {
        this.itemViewModel.clear();
        this.data.clear();
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public List<T> getData() {
        List<T> list = this.data;
        return list != null ? list : new ArrayList();
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public int getViewTypeCount() {
        IListModel iListModel = this.model;
        if (iListModel != null) {
            return iListModel.getViewTypeCount();
        }
        return 1;
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void hideEmptyView() {
        if (this.itemViewModel.isEmpty()) {
            showEmptyView(null);
            return;
        }
        ListViewStyle listViewStyle = this.viewStyle;
        IListModel iListModel = this.model;
        listViewStyle.setEmptyText(iListModel != null ? iListModel.getErrorHint() : this.context.getResources().getString(R.string.no_data));
        this.viewStyle.setShowEmptyView(false);
    }

    public boolean isEnableSetItem() {
        return this.enableSetItem;
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        IListModel iListModel = this.model;
        if (iListModel != null) {
            if (iListModel.getRemoveToken() != null) {
                Messenger.getDefault().unregister(this, RemoveMsg.class, this.model.getRemoveToken());
            }
            if (this.model.getInsertToken() != null) {
                Messenger.getDefault().unregister(this, InsertMsg.class, this.model.getInsertToken());
            }
            if (this.model.getReplaceToken() != null) {
                Messenger.getDefault().unregister(this, ReplaceMsg.class, this.model.getReplaceToken());
            }
            if (this.model.getRefreshToken() != null) {
                Messenger.getDefault().unregister(this, RefreshMsg.class, this.model.getRefreshToken());
            }
            Observable.from(this.itemViewModel).subscribe(new Action1() { // from class: com.sandboxol.common.base.viewmodel.o
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ((ListItemViewModel) obj).onDestroy();
                }
            }, p.f16875a);
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void onError(String str) {
        setRefreshing(false);
        showEmptyView(str);
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void onSuccess() {
        setRefreshing(false);
        hideEmptyView();
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void registerMessenger() {
        IListModel iListModel = this.model;
        if (iListModel != null) {
            if (iListModel.getRemoveToken() != null) {
                Messenger.getDefault().register(this, this.model.getRemoveToken(), RemoveMsg.class, new Action1() { // from class: com.sandboxol.common.base.viewmodel.g
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f16864a.a((RemoveMsg) obj);
                    }
                });
            }
            if (this.model.getInsertToken() != null) {
                Messenger.getDefault().register(this, this.model.getInsertToken(), InsertMsg.class, new Action1() { // from class: com.sandboxol.common.base.viewmodel.i
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f16868a.a((InsertMsg) obj);
                    }
                });
            }
            if (this.model.getReplaceToken() != null) {
                Messenger.getDefault().register(this, this.model.getReplaceToken(), ReplaceMsg.class, new Action1() { // from class: com.sandboxol.common.base.viewmodel.f
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f16863a.a((ReplaceMsg) obj);
                    }
                });
            }
            if (this.model.getRefreshToken() != null) {
                Messenger.getDefault().register(this, this.model.getRefreshToken(), RefreshMsg.class, new Action1() { // from class: com.sandboxol.common.base.viewmodel.k
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f16870a.a((RefreshMsg) obj);
                    }
                });
            }
            if (this.model.getLoadMoreToken() != null) {
                Messenger.getDefault().register(this, this.model.getLoadMoreToken(), MoreMsg.class, new Action1() { // from class: com.sandboxol.common.base.viewmodel.n
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f16873a.a((MoreMsg) obj);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void remove(Object obj, int i, RemoveMsg.REMOVE_MODE remove_mode) {
        int i2 = AnonymousClass1.$SwitchMap$com$sandboxol$common$widget$rv$msg$RemoveMsg$REMOVE_MODE[remove_mode.ordinal()];
        if (i2 == 1) {
            clearItems();
            return;
        }
        if (i2 == 2) {
            removeItem(obj);
        } else if (i2 == 3) {
            removeItems(obj);
        } else {
            if (i2 != 4) {
                return;
            }
            removeIndex(i);
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void removeIndex(int i) {
        if (this.itemViewModel.size() > i) {
            this.itemViewModel.remove(i);
        }
        if (this.data.size() > i) {
            this.data.remove(i);
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void removeItem(final T t) {
        Observable<T> observableObserveOn = Observable.from(this.itemViewModel).filter(new Func1() { // from class: com.sandboxol.common.base.viewmodel.l
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return Boolean.valueOf(t == ((ListItemViewModel) obj).item);
            }
        }).doOnNext(new Action1() { // from class: com.sandboxol.common.base.viewmodel.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16859a.a((ListItemViewModel) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        ObservableItemList<ListItemViewModel<T>> observableItemList = this.itemViewModel;
        observableItemList.getClass();
        observableObserveOn.subscribe(new b(observableItemList), p.f16875a);
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void removeItems(Object obj) {
        if (obj instanceof List) {
            final List list = (List) obj;
            if (list.size() <= 10) {
                Observable<T> observableDoOnNext = Observable.from(this.itemViewModel).filter(new Func1() { // from class: com.sandboxol.common.base.viewmodel.m
                    @Override // rx.functions.Func1
                    public final Object call(Object obj2) {
                        return Boolean.valueOf(list.contains(((ListItemViewModel) obj2).item));
                    }
                }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1() { // from class: com.sandboxol.common.base.viewmodel.d
                    @Override // rx.functions.Action1
                    public final void call(Object obj2) {
                        this.f16860a.b((ListItemViewModel) obj2);
                    }
                });
                ObservableItemList<ListItemViewModel<T>> observableItemList = this.itemViewModel;
                observableItemList.getClass();
                observableDoOnNext.subscribe(new b(observableItemList), p.f16875a);
                return;
            }
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            Observable.from(this.itemViewModel).subscribe(new Action1() { // from class: com.sandboxol.common.base.viewmodel.h
                @Override // rx.functions.Action1
                public final void call(Object obj2) {
                    ListViewModel.a(list, arrayList, arrayList2, (ListItemViewModel) obj2);
                }
            }, p.f16875a);
            this.data.removeAll(arrayList);
            this.itemViewModel.clear();
            this.itemViewModel.addAll(arrayList2);
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void replaceAll(List<T> list) {
        clearItems();
        addItems(list);
    }

    public void replaceData(List<T> list) {
        if (list == null || list.size() == 0) {
            getData().clear();
            this.itemViewModel.clear();
            return;
        }
        getData().clear();
        getData().addAll(list);
        int size = this.itemViewModel.size();
        int size2 = list.size();
        ArrayList arrayList = new ArrayList();
        if (size2 >= size) {
            for (int i = 0; i < size; i++) {
                if (this.enableSetItem) {
                    this.itemViewModel.get(i).setItem(list.get(i));
                } else {
                    arrayList.add(this.model.getItemViewModel(list.get(i)));
                }
            }
            for (int i2 = size; i2 < size2; i2++) {
                arrayList.add(this.model.getItemViewModel(list.get(i2)));
            }
            if (!this.enableSetItem && size > 0) {
                this.itemViewModel.removeRange(0, size);
            }
        } else {
            for (int i3 = 0; i3 < size2; i3++) {
                if (this.enableSetItem) {
                    this.itemViewModel.get(i3).setItem(list.get(i3));
                } else {
                    arrayList.add(this.model.getItemViewModel(list.get(i3)));
                }
            }
            if (!this.enableSetItem) {
                size2 = 0;
            }
            if (size - size2 > 0) {
                this.itemViewModel.removeRange(size2, size);
            }
        }
        if (arrayList.size() > 0) {
            this.itemViewModel.addAll(arrayList);
        }
        notifyChange();
    }

    public void setEnableSetItem(boolean z) {
        this.enableSetItem = z;
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void setLoadingMore(boolean z) {
        this.viewStyle.setLoadingMore(z);
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void setRefreshing(boolean z) {
        this.viewStyle.setRefreshing(z);
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void showEmptyView(String str) {
        if (this.itemViewModel.isEmpty()) {
            this.viewStyle.setShowEmptyView(true);
            if (!TextUtils.isEmpty(str)) {
                this.viewStyle.setEmptyText(str);
                return;
            }
            ListViewStyle listViewStyle = this.viewStyle;
            IListModel iListModel = this.model;
            listViewStyle.setEmptyText(iListModel != null ? iListModel.getErrorHint() : this.context.getResources().getString(R.string.no_data));
        }
    }

    public /* synthetic */ void a(List list, Object obj) {
        list.add(this.model.getItemViewModel(obj));
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void addItemViewModel(ListItemViewModel<T> listItemViewModel, int i, InsertMsg.INSERT_MODE insert_mode) {
        if (insert_mode == InsertMsg.INSERT_MODE.END) {
            this.itemViewModel.add(listItemViewModel);
        } else if (insert_mode == InsertMsg.INSERT_MODE.FIRST) {
            this.itemViewModel.add(0, listItemViewModel);
        } else {
            this.itemViewModel.add(i, listItemViewModel);
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void addItems(List<T> list, int i, InsertMsg.INSERT_MODE insert_mode) {
        final ArrayList arrayList = new ArrayList();
        Observable.from(list).subscribe(new Action1() { // from class: com.sandboxol.common.base.viewmodel.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16861a.a(arrayList, obj);
            }
        }, p.f16875a);
        if (insert_mode == InsertMsg.INSERT_MODE.END) {
            this.itemViewModel.addAll(arrayList);
        } else if (insert_mode == InsertMsg.INSERT_MODE.FIRST) {
            this.itemViewModel.addAll(0, arrayList);
        } else {
            this.itemViewModel.addAll(i, arrayList);
        }
        this.data.addAll(list);
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public ObservableList<ListItemViewModel<T>> getItemViewModel() {
        return this.itemViewModel;
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void addItem(T t, int i, InsertMsg.INSERT_MODE insert_mode) {
        if (insert_mode == InsertMsg.INSERT_MODE.END) {
            this.itemViewModel.add(this.model.getItemViewModel(t));
            this.data.add(t);
        } else if (insert_mode == InsertMsg.INSERT_MODE.FIRST) {
            this.itemViewModel.add(0, this.model.getItemViewModel(t));
            this.data.add(0, t);
        } else {
            this.itemViewModel.add(i, this.model.getItemViewModel(t));
            this.data.add(i, t);
        }
    }

    public /* synthetic */ void a(ListItemViewModel listItemViewModel) {
        this.data.remove(listItemViewModel.item);
    }

    static /* synthetic */ void a(List list, List list2, List list3, ListItemViewModel listItemViewModel) {
        if (list.contains(listItemViewModel.item)) {
            list2.add(listItemViewModel.item);
        } else {
            list3.add(listItemViewModel);
        }
    }

    public /* synthetic */ void a(RemoveMsg removeMsg) {
        remove(removeMsg.getData(), removeMsg.getIndex(), removeMsg.getMode());
    }

    public /* synthetic */ void a(InsertMsg insertMsg) {
        add(insertMsg.getData(), insertMsg.getIndex(), insertMsg.getMode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(ReplaceMsg replaceMsg) {
        replaceAll(replaceMsg.getData());
    }

    public /* synthetic */ void a(RefreshMsg refreshMsg) {
        onRefresh();
    }

    public /* synthetic */ void a(MoreMsg moreMsg) {
        onLoadMore();
    }
}
