package delfi.com.vn.tpcreative.ui.gridview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.List;

import delfi.com.vn.tpcreative.common.adapter.DividerItemDecoration;
import delfi.com.vn.tpcreative.ui.recycleview.RecyclerViewAdapter;

/**
 * Created by PC on 8/2/2017.
 */

public class DPGridView implements GridViewAdapter.ListenerGridViewAdapter,AdapterView.OnItemClickListener {

    private GridViewAdapter adapter;
    private LinearLayoutManager llm ;
    private static DPGridView instance ;
    private GridView gridView ;
    private Activity context ;
    private int reSource ;
    private GridViewAdapter.ListenerGridViewAdapter listenerGridViewAdapter;
    private List<Object>list ;

    public static DPGridView instance(Activity context, GridView gridView, int reSource, GridViewAdapter.ListenerGridViewAdapter listenerGridViewAdapter,List<Object>list){
        if (instance==null){
            instance = new DPGridView();
        }
        instance.context = context ;
        instance.gridView = gridView ;
        instance.listenerGridViewAdapter = listenerGridViewAdapter;
        instance.reSource = reSource ;
        instance.list = list ;
        instance.setupGridView();
        return  instance;
    }

    public void setupGridView() {
        adapter = new  GridViewAdapter(instance.context,list ,reSource, listenerGridViewAdapter);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    public GridViewAdapter gridViewAdapter(){
        return adapter ;
    }

    @Override
    public void onShowData(Object object, Object view) {
        listenerGridViewAdapter.onShowData(object,view);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        listenerGridViewAdapter.onShowPosition(i);
    }

    @Override
    public void onShowPosition(int position) {
    }

    public interface ListenerGridView extends GridViewAdapter.ListenerGridViewAdapter {
        @Override
        void onShowData(Object object, Object view);
        @Override
        void onSetView(View view);
        @Override
        void onShowPosition(int position);
    }

    @Override
    public void onSetView(View view) {
        this.onSetView(view);
    }



}
