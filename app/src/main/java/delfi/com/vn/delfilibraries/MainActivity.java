package delfi.com.vn.delfilibraries;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import delfi.com.vn.tpcreative.common.activity.BaseActivity;
import delfi.com.vn.tpcreative.ui.recycleview.AdapterRecycleView;
import delfi.com.vn.tpcreative.ui.recycleview.DPRecyclerView;

public class MainActivity extends BaseActivity implements DPRecyclerView.ListenerRecycleView {

    @BindView(R.id.rlHome)
    RecyclerView recyclerView;
    List<CProduct> list;
    AdapterRecycleView adapter ;

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
        adapter = DPRecyclerView.instance(this,recyclerView,R.layout.home_cell,this).adapterRecycleView();
        adapter.setDataSource(new ArrayList(list));
    }

    @Override
    public void onShowData(Object anyObject, View view) {
        CProduct product = (CProduct) anyObject;
        TextView textView = view.findViewById(R.id.tvHomeCell);
        adapter.getAdapterRecycleViewHolder().onClick(view.findViewById(R.id.llHomeCell));
        textView.setText(product.name);
    }

    @Override
    public void onShowPosition(int position) {
        Toast.makeText(getApplicationContext(),"Show position now : " + position,Toast.LENGTH_SHORT).show();
    }

}

