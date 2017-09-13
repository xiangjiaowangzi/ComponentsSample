package com.example.android.persistence.databinding;
import com.example.android.persistence.R;
import com.example.android.persistence.BR;
import android.view.View;
public class ProductItemBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    private final android.support.v7.widget.CardView mboundView0;
    private final android.widget.TextView mboundView2;
    private final android.widget.TextView mboundView3;
    public final android.widget.TextView name;
    // variables
    private com.example.android.persistence.ui.ProductClickCallback mCallback;
    private com.example.android.persistence.model.Product mProduct;
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ProductItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.support.v7.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.name = (android.widget.TextView) bindings[1];
        this.name.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.callback :
                setCallback((com.example.android.persistence.ui.ProductClickCallback) variable);
                return true;
            case BR.product :
                setProduct((com.example.android.persistence.model.Product) variable);
                return true;
        }
        return false;
    }

    public void setCallback(com.example.android.persistence.ui.ProductClickCallback callback) {
        this.mCallback = callback;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.callback);
        super.requestRebind();
    }
    public com.example.android.persistence.ui.ProductClickCallback getCallback() {
        return mCallback;
    }
    public void setProduct(com.example.android.persistence.model.Product product) {
        this.mProduct = product;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.product);
        super.requestRebind();
    }
    public com.example.android.persistence.model.Product getProduct() {
        return mProduct;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        com.example.android.persistence.ui.ProductClickCallback callback = mCallback;
        com.example.android.persistence.model.Product product = mProduct;
        int priceProduct = 0;
        java.lang.String androidStringProduct = null;
        java.lang.String descriptionProduct = null;
        java.lang.String nameProduct = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (product != null) {
                    // read product.price
                    priceProduct = product.getPrice();
                    // read product.description
                    descriptionProduct = product.getDescription();
                    // read product.name
                    nameProduct = product.getName();
                }


                // read @android:string/product_price
                androidStringProduct = mboundView2.getResources().getString(R.string.product_price, priceProduct);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, androidStringProduct);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, descriptionProduct);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.name, nameProduct);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // product
        com.example.android.persistence.model.Product product = mProduct;
        // callback != null
        boolean callbackObjectnull = false;
        // callback
        com.example.android.persistence.ui.ProductClickCallback callback = mCallback;



        callbackObjectnull = (callback) != (null);
        if (callbackObjectnull) {



            callback.onClick(product);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ProductItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ProductItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ProductItemBinding>inflate(inflater, com.example.android.persistence.R.layout.product_item, root, attachToRoot, bindingComponent);
    }
    public static ProductItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ProductItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.android.persistence.R.layout.product_item, null, false), bindingComponent);
    }
    public static ProductItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ProductItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/product_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ProductItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): callback
        flag 1 (0x2L): product
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}