
package android.databinding;
import com.example.android.persistence.BR;
class DataBinderMapper {
    final static int TARGET_MIN_SDK = 19;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.example.android.persistence.R.layout.product_fragment:
                    return com.example.android.persistence.databinding.ProductFragmentBinding.bind(view, bindingComponent);
                case com.example.android.persistence.R.layout.comment_item:
                    return com.example.android.persistence.databinding.CommentItemBinding.bind(view, bindingComponent);
                case com.example.android.persistence.R.layout.product_item:
                    return com.example.android.persistence.databinding.ProductItemBinding.bind(view, bindingComponent);
                case com.example.android.persistence.R.layout.list_fragment:
                    return com.example.android.persistence.databinding.ListFragmentBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -399488426: {
                if(tag.equals("layout/product_fragment_0")) {
                    return com.example.android.persistence.R.layout.product_fragment;
                }
                break;
            }
            case 198676841: {
                if(tag.equals("layout/comment_item_0")) {
                    return com.example.android.persistence.R.layout.comment_item;
                }
                break;
            }
            case 144912601: {
                if(tag.equals("layout/product_item_0")) {
                    return com.example.android.persistence.R.layout.product_item;
                }
                break;
            }
            case 727741277: {
                if(tag.equals("layout/list_fragment_0")) {
                    return com.example.android.persistence.R.layout.list_fragment;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"callback"
            ,"comment"
            ,"isLoading"
            ,"product"
            ,"productViewModel"};
    }
}