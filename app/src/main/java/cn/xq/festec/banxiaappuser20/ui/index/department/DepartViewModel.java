package cn.xq.festec.banxiaappuser20.ui.index.department;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import cn.xq.festec.banxiaappuser20.http.NetWorkManager;
import cn.xq.festec.banxiaappuser20.http.request.DepartmentRequest;
import cn.xq.festec.banxiaappuser20.http.response.Response;
import cn.xq.festec.banxiaappuser20.model.department.Department;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DepartViewModel extends ViewModel {

    private MutableLiveData<Department> mData;

    public DepartViewModel() {
        list();
        mData = new MutableLiveData<>();
    }

    /**
     * 获得所有的科室资料
     */
    public void list() {
        Log.d("test", "DepartViewModel: ");

        DepartmentRequest request = NetWorkManager.getRetrofit().create(DepartmentRequest.class);
        request.list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<Department>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<List<Department>> listResponse) {
                        for (Department d:
                             listResponse.getData()) {
                            System.out.println(listResponse.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<Department> getLiveData() {
        return mData;
    }
}
