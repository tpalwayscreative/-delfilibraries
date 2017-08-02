package delfi.com.vn.delfilibraries;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import delfi.com.vn.tpcreative.common.activity.BaseActivity;
import delfi.com.vn.tpcreative.common.ui.recycleview.AdapterRecycleView;
import delfi.com.vn.tpcreative.common.ui.recycleview.RecycleView;

public class MainActivity extends BaseActivity implements RecycleView.ListenerRecycleView {

    @BindView(R.id.rlHome)
    RecyclerView recyclerView;
    List<CProduct> list;
    RecycleView customRecycleView ;
    AdapterRecycleView adapterRecycleView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add(new CProduct("a"));
        list.add(new CProduct("b"));
        list.add(new CProduct("c"));
        list.add(new CProduct("e"));
        list.add(new CProduct("f"));
        list.add(new CProduct("g"));
        list.add(new CProduct("h"));
        list.add(new CProduct("j"));
        list.add(new CProduct("k"));
        customRecycleView = RecycleView.instance(this,recyclerView,R.layout.home_cell,this);
        adapterRecycleView = customRecycleView.adapterRecycleView();
        adapterRecycleView.setDataSource(new ArrayList(list));
    }

    @Override
    public void onShowData(Object anyObject, View view) {
        CProduct product = (CProduct) anyObject;
        TextView textView = view.findViewById(R.id.tvHomeCell);
        adapterRecycleView.getAdapterRecycleViewHolder().onClick(view.findViewById(R.id.llHomeCell));
        textView.setText(product.name);
    }

    @Override
    public void onShowPosition(int position) {
        Toast.makeText(getApplicationContext(),"Show position now : " + position,Toast.LENGTH_SHORT).show();
    }
}

