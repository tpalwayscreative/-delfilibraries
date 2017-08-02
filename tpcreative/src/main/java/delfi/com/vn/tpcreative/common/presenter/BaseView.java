package delfi.com.vn.tpcreative.common.presenter;
import android.content.Context;


public interface BaseView {
    void onShowLoading();
    void onHideLoading();
    Context getContext();
}
