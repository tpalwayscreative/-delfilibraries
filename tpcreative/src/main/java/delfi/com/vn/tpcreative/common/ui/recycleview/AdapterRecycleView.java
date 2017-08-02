package delfi.com.vn.tpcreative.common.ui.recycleview;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import delfi.com.vn.tpcreative.R;
import delfi.com.vn.tpcreative.common.adapter.BaseAdapter;
import delfi.com.vn.tpcreative.common.adapter.BaseHolder;

public class AdapterRecycleView extends BaseAdapter<Object,BaseHolder> {

    private Activity activity ;
    private int resource ;
    public static final String TAG = AdapterRecycleView.class.getSimpleName();


    private ListenerAdapterRecycleView listenerAdapterRecycleView ;
    private int typeResource ;

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

    public class  AdapterRecycleViewHolder extends BaseHolder<Object> {
        private View view ;
        private int resource ;
        private LinearLayout layout ;
        public AdapterRecycleViewHolder(View view) {
            super(view);
            this.view = view;
        }

        @Override
        public void bind(Object data, int position) {
            super.bind(data, position);
            listenerAdapterRecycleView.onShowData(data,view);
        }



    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public interface ListenerAdapterRecycleView {
        void onShowData(Object object,View view);
    }


}
