package cn.xq.festec.banxiaappuser20.ui.index.department;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.xq.festec.banxiaappuser20.R;
import cn.xq.festec.banxiaappuser20.http.NetWorkManager;
import cn.xq.festec.banxiaappuser20.http.request.DepartmentRequest;
import cn.xq.festec.banxiaappuser20.http.response.Response;
import cn.xq.festec.banxiaappuser20.model.department.Department;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DepartFragment extends Fragment {

    private DepartViewModel mViewModel;

    public static DepartFragment newInstance() {
        return new DepartFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(DepartViewModel.class);
        return inflater.inflate(R.layout.depart_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DepartmentRequest request = NetWorkManager.getRetrofit().create(DepartmentRequest.class);
        request.list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<Department>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("test", "onSubscribe: ");
                    }

                    @Override
                    public void onNext(Response<List<Department>> listResponse) {
                        for (Department d:
                                listResponse.getData()) {
                            Log.d("test", d.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("test", "" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        // TODO: Use the ViewModel


    }

}
