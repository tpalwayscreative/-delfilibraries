
package delfi.com.vn.tpcreative.ui.gridview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;

public class GridViewAdapter extends BaseAdapter {

  private final Context mContext;
  private List<Object> list;
  private int resource ;
  private View view ;
  private ListenerGridViewAdapter listenerGridViewAdapter ;

  public GridViewAdapter(Context context, List<Object>list,int resource,ListenerGridViewAdapter listenerGridViewAdapter) {
    this.mContext = context;
    this.list = list;
    this.resource = resource ;
    this.listenerGridViewAdapter = listenerGridViewAdapter ;
  }

  @Override
  public int getCount() {
    return list.size();
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
      convertView = layoutInflater.inflate(resource,null);
      listenerGridViewAdapter.onSetView(convertView);
    }
    listenerGridViewAdapter.onShowData(list.get(position),convertView.getTag());
    return convertView;
  }

  public View getView(){
    return view;
  }

  public void setView(View view){
    this.view = view ;
  }

  public interface ListenerGridViewAdapter {
    void onShowData(Object object, Object view);
    void onShowPosition(int position);
    void onSetView(View view);
  }

}
