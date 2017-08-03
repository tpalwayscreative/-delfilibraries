package delfi.com.vn.tpcreative.ui.recycleview;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import delfi.com.vn.tpcreative.common.adapter.DividerItemDecoration;

/**
 * Created by PC on 8/2/2017.
 */

public class DPRecyclerView implements AdapterRecycleView.ListenerAdapterRecycleView {

    private AdapterRecycleView adapter;
    private LinearLayoutManager llm ;
    private static DPRecyclerView instance ;
    private RecyclerView recyclerView ;
    private Activity context ;
    private int reSource ;
    private ListenerRecycleView listenerRecycleView;

    public static DPRecyclerView instance(Activity context, RecyclerView recyclerView, int reSource, ListenerRecycleView listenerRecycleView){
        if (instance==null){
            instance = new DPRecyclerView();
        }
        instance.context = context ;
        instance.recyclerView = recyclerView ;
        instance.listenerRecycleView = listenerRecycleView;
        instance.reSource = reSource ;
        instance.setupRecyclerView();
        return  instance;
    }

    public void setupRecyclerView() {
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
        adapter = new AdapterRecycleView(context.getLayoutInflater(), context,this,reSource);
        recyclerView.setAdapter(adapter);
    }

    public AdapterRecycleView adapterRecycleView(){
        return adapter ;
    }

    @Override
    public void onShowData(Object object, View view) {
        listenerRecycleView.onShowData(object,view);
    }

    @Override
    public void onShowPosition(int position) {
        listenerRecycleView.onShowPosition(position);
    }

    public interface ListenerRecycleView extends AdapterRecycleView.ListenerAdapterRecycleView {
        @Override
        void onShowPosition(int position);
        @Override
        void onShowData(Object object, View view);
    }


}
