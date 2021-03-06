package aksar.inji.outthecloset;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class BrandFragment extends Fragment {
    private Brands mBrand;
    private EditText mBrandName;
    private Button mCreateBrandButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBrand = new Brands();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_brand, container, false);

        mBrandName = (EditText) v.findViewById(R.id.brand_name);
        mBrandName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBrand.setmBrandName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCreateBrandButton = (Button) v.findViewById(R.id.create_brand);
        mCreateBrandButton.setText("Create New Brand");
        mCreateBrandButton.setEnabled(false);

        return v;
    }
}
