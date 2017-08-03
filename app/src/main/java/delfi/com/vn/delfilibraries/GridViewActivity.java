package delfi.com.vn.delfilibraries;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import delfi.com.vn.tpcreative.common.activity.BaseActivity;
import delfi.com.vn.tpcreative.ui.gridview.DPGridView;
import delfi.com.vn.tpcreative.ui.gridview.GridViewAdapter;

public class GridViewActivity extends BaseActivity implements DPGridView.ListenerGridView {

    @BindView(R.id.gridview)
    GridView gridView;
    private GridViewAdapter adapter ;
    List<CProduct> list;
    private ViewHolder viewHolder ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
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
        adapter = DPGridView.instance(this,gridView,R.layout.home_cell_gridview, this,new ArrayList(list)).gridViewAdapter();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onShowData(Object object, Object view) {
        CProduct product = (CProduct)object;
        viewHolder = (ViewHolder) view;
        viewHolder.textView.setText(product.name);
    }

    @Override
    public void onShowPosition(int position) {
        Toast.makeText(getApplicationContext(),"Show position now : " + position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSetView(View view) {
        viewHolder = new ViewHolder(view) ;
        view.setTag(viewHolder);
    }

    protected class ViewHolder {
        @BindView(R.id.tvHomeCell)
        TextView textView ;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
