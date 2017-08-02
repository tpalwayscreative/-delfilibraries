package delfi.com.vn.delfilibraries;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import delfi.com.vn.tpcreative.common.activity.BaseActivity;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tvHelloWorld)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView.setText("Hello abc !!");
    }
}

