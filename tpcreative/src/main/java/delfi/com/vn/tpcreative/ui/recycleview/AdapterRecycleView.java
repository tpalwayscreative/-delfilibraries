package delfi.com.vn.tpcreative.ui.recycleview;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import delfi.com.vn.tpcreative.common.adapter.BaseAdapter;
import delfi.com.vn.tpcreative.common.adapter.BaseHolder;

public class AdapterRecycleView extends BaseAdapter<Object,BaseHolder> {

    private Activity activity ;
    private int resource ;
    public static final String TAG = AdapterRecycleView.class.getSimpleName();
    private AdapterRecycleViewHolder adapterRecycleViewHolder;
    private ListenerAdapterRecycleView listenerAdapterRecycleView ;

    public AdapterRecycleView(LayoutInflater inflater, Activity activity,ListenerAdapterRecycleView listenerAdapterRecycleView,int resource){
        super(inflater);
        this.activity = activity ;
        this.listenerAdapterRecycleView = listenerAdapterRecycleView ;
        this.resource = resource;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.adapterRecycleViewHolder = new AdapterRecycleViewHolder(inflater.inflate(resource, parent, false));
        return this.adapterRecycleViewHolder;
    }

    public class  AdapterRecycleViewHolder extends BaseHolder<Object> {
        private View view ;
        private int position ;

        public AdapterRecycleViewHolder(View view) {
            super(view);
            this.view = view;
        }

        @Override
        public void bind(Object data, int position) {
            super.bind(data, position);
            this.position = position ;
            listenerAdapterRecycleView.onShowData(data,view);
        }

        public void onClick(View view){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenerAdapterRecycleView.onShowPosition(position);
                }
            });
        }
    }

    public AdapterRecycleViewHolder getAdapterRecycleViewHolder(){
        return this.adapterRecycleViewHolder;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public interface ListenerAdapterRecycleView {
        void onShowData(Object object, View view);
        void onShowPosition(int position);
    }

}
