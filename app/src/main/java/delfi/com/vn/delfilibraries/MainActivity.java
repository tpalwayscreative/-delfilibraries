package delfi.com.vn.delfilibraries;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import delfi.com.vn.tpcreative.common.activity.BaseActivity;
import delfi.com.vn.tpcreative.ui.recycleview.RecyclerViewAdapter;
import delfi.com.vn.tpcreative.ui.recycleview.DPRecyclerView;

public class MainActivity extends BaseActivity implements DPRecyclerView.ListenerRecycleView {

    @BindView(R.id.rlHome)
    RecyclerView recyclerView;
    List<CProduct> list;
    RecyclerViewAdapter adapter ;
    private ViewHolder viewHolder ;

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
    public void onShowData(Object anyObject) {
        CProduct product = (CProduct) anyObject;
        adapter.getAdapterRecycleViewHolder().onClick(viewHolder.llHomeCell);
        viewHolder.textView.setText(product.name);
    }

    @Override
    public void onSetView(View view) {
        viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
    }

    @Override
    public void onShowPosition(int position) {
        Toast.makeText(getApplicationContext(),"Show position now : " + position,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),GridViewActivity.class);
        startActivity(intent);
    }

    protected class ViewHolder {
        @BindView(R.id.tvHomeCell)
        TextView textView ;
        @BindView(R.id.llHomeCell)
        LinearLayout llHomeCell;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

