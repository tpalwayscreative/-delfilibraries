package delfi.com.vn.tpcreative.common.ui.recycleview;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import delfi.com.vn.tpcreative.common.adapter.BaseAdapter;
import delfi.com.vn.tpcreative.common.adapter.BaseHolder;
import delfi.com.vn.tpcreative.method.CAnyObject;

public class AdapterRecycleView extends BaseAdapter<CAnyObject,BaseHolder> {

    private Activity activity ;
    public static final String TAG = AdapterRecycleView.class.getSimpleName();
    private int resource ;
    private ListenerAdapterRecycleView listenerAdapterRecycleView ;

    public AdapterRecycleView(LayoutInflater inflater, Activity activity,ListenerAdapterRecycleView listenerAdapterRecycleView,int resource){
        super(inflater);
        this.activity = activity ;
        this.listenerAdapterRecycleView = listenerAdapterRecycleView ;
        this.resource = resource;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdapterRecycleViewHolder(inflater.inflate(resource, parent, false));
    }

    public class  AdapterRecycleViewHolder extends BaseHolder<CAnyObject> {

        public AdapterRecycleViewHolder(View view) {
            super(view);
        }

        @Override
        public void bind(CAnyObject data, int position) {
            super.bind(data, position);
            listenerAdapterRecycleView.onShowData(data);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public interface ListenerAdapterRecycleView {
        void onShowData(CAnyObject object);
    }


}
