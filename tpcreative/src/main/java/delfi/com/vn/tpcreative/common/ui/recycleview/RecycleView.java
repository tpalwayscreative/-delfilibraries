package delfi.com.vn.tpcreative.common.ui.recycleview;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import delfi.com.vn.tpcreative.common.adapter.DividerItemDecoration;
import delfi.com.vn.tpcreative.method.CAnyObject;

/**
 * Created by PC on 8/2/2017.
 */

public class RecycleView implements AdapterRecycleView.ListenerAdapterRecycleView {

    private AdapterRecycleView adapter;
    private LinearLayoutManager llm ;
    private static RecycleView instance ;
    private RecyclerView recyclerView ;
    private Activity context ;
    private int reSource ;

    public static RecycleView instance(Activity context){
        if (instance==null){
            instance = new RecycleView();
        }
        instance.context = context ;
        return  instance;
    }

    public void setupRecyclerView() {
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
        adapter = new AdapterRecycleView(context.getLayoutInflater(), context,this,reSource);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onShowData(CAnyObject object) {

    }
}
