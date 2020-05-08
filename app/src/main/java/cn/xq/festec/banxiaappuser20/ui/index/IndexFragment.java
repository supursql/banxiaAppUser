package cn.xq.festec.banxiaappuser20.ui.index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import cn.xq.festec.banxiaappuser20.R;

public class IndexFragment extends Fragment {

    private View root;

    private IndexViewModel mIndexViewModel;

    private View mViewDoctor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mIndexViewModel = new ViewModelProvider(this).get(IndexViewModel.class);
        root = inflater.inflate(R.layout.fragment_index, container, false);

        initView();

        initData();

        return root;
    }


    private void initView() {

        mViewDoctor = root.findViewById(R.id.viewdoctor);
        mViewDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_navigation_index_to_departFragment);
            }
        });

    }

    private void initData() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mIndexViewModel.getLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
    }
}