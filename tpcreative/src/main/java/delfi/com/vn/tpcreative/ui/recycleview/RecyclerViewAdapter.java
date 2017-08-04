package delfi.com.vn.tpcreative.ui.recycleview;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import delfi.com.vn.tpcreative.common.adapter.BaseAdapter;
import delfi.com.vn.tpcreative.common.adapter.BaseHolder;

public class RecyclerViewAdapter extends BaseAdapter<Object,BaseHolder> {

    private Activity activity ;
    private int resource ;
    public static final String TAG = RecyclerViewAdapter.class.getSimpleName();
    private AdapterRecycleViewHolder adapterRecycleViewHolder;
    private ListenerRecycleViewAdapter listenerRecycleViewAdapter ;

    public RecyclerViewAdapter(LayoutInflater inflater, Activity activity, ListenerRecycleViewAdapter listenerRecycleViewAdapter, int resource){
        super(inflater);
        this.activity = activity ;
        this.listenerRecycleViewAdapter = listenerRecycleViewAdapter ;
        this.resource = resource;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.adapterRecycleViewHolder = new AdapterRecycleViewHolder(inflater.inflate(resource, parent, false));
        return this.adapterRecycleViewHolder;
    }

    public class  AdapterRecycleViewHolder extends BaseHolder<Object> {
        private int position ;

        public AdapterRecycleViewHolder(View view) {
            super(view);
            listenerRecycleViewAdapter.onSetView(view);
        }

        @Override
        public void bind(Object data, int position) {
            super.bind(data, position);
            this.position = position ;
            listenerRecycleViewAdapter.onShowData(data);
        }

        public void onClick(View view){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenerRecycleViewAdapter.onShowPosition(position);
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

    public interface ListenerRecycleViewAdapter {
        void onShowData(Object object);
        void onShowPosition(int position);
        void onSetView(View view);
    }

}
