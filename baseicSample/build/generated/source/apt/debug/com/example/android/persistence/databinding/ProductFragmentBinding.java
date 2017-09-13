package com.example.android.persistence.databinding;
import com.example.android.persistence.R;
import com.example.android.persistence.BR;
import android.view.View;
public class ProductFragmentBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(5);
        sIncludes.setIncludes(0, 
            new String[] {"product_item"},
            new int[] {3},
            new int[] {R.layout.product_item});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.comments_list_wrapper, 4);
    }
    // views
    public final android.support.v7.widget.RecyclerView commentList;
    public final android.widget.FrameLayout commentsListWrapper;
    public final android.widget.TextView loadingCommentsTv;
    private final com.example.android.persistence.databinding.ProductItemBinding mboundView0;
    private final android.widget.LinearLayout mboundView01;
    // variables
    private com.example.android.persistence.viewmodel.ProductViewModel mProductViewModel;
    private boolean mIsLoading;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ProductFragmentBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.commentList = (android.support.v7.widget.RecyclerView) bindings[2];
        this.commentList.setTag(null);
        this.commentsListWrapper = (android.widget.FrameLayout) bindings[4];
        this.loadingCommentsTv = (android.widget.TextView) bindings[1];
        this.loadingCommentsTv.setTag(null);
        this.mboundView0 = (com.example.android.persistence.databinding.ProductItemBinding) bindings[3];
        this.mboundView01 = (android.widget.LinearLayout) bindings[0];
        this.mboundView01.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        mboundView0.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView0.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.productViewModel :
                setProductViewModel((com.example.android.persistence.viewmodel.ProductViewModel) variable);
                return true;
            case BR.isLoading :
                setIsLoading((boolean) variable);
                return true;
        }
        return false;
    }

    public void setProductViewModel(com.example.android.persistence.viewmodel.ProductViewModel productViewModel) {
        this.mProductViewModel = productViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.productViewModel);
        super.requestRebind();
    }
    public com.example.android.persistence.viewmodel.ProductViewModel getProductViewModel() {
        return mProductViewModel;
    }
    public void setIsLoading(boolean isLoading) {
        this.mIsLoading = isLoading;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.isLoading);
        super.requestRebind();
    }
    public boolean getIsLoading() {
        return mIsLoading;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeProductProdu((android.databinding.ObservableField<com.example.android.persistence.db.entity.ProductEntity>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeProductProdu(android.databinding.ObservableField<com.example.android.persistence.db.entity.ProductEntity> productProductViewModel, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        boolean logicalNotIsLoading = false;
        com.example.android.persistence.viewmodel.ProductViewModel productViewModel = mProductViewModel;
        android.databinding.ObservableField<com.example.android.persistence.db.entity.ProductEntity> productProductViewMo = null;
        boolean isLoading = mIsLoading;
        com.example.android.persistence.db.entity.ProductEntity productProductViewMo1 = null;

        if ((dirtyFlags & 0xbL) != 0) {



                if (productViewModel != null) {
                    // read productViewModel.product
                    productProductViewMo = productViewModel.product;
                }
                updateRegistration(0, productProductViewMo);


                if (productProductViewMo != null) {
                    // read productViewModel.product.get()
                    productProductViewMo1 = productProductViewMo.get();
                }
        }
        if ((dirtyFlags & 0xcL) != 0) {



                // read !isLoading
                logicalNotIsLoading = !isLoading;
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            com.example.android.persistence.ui.BindingAdapters.showHide(this.commentList, logicalNotIsLoading);
            com.example.android.persistence.ui.BindingAdapters.showHide(this.loadingCommentsTv, isLoading);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            this.mboundView0.setProduct(productProductViewMo1);
        }
        mboundView0.executePendingBindings();
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ProductFragmentBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ProductFragmentBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ProductFragmentBinding>inflate(inflater, com.example.android.persistence.R.layout.product_fragment, root, attachToRoot, bindingComponent);
    }
    public static ProductFragmentBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ProductFragmentBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.android.persistence.R.layout.product_fragment, null, false), bindingComponent);
    }
    public static ProductFragmentBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ProductFragmentBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/product_fragment_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ProductFragmentBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): productViewModel.product
        flag 1 (0x2L): productViewModel
        flag 2 (0x3L): isLoading
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}