package cn.xq.festec.banxiaappuser20.ui.index;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IndexViewModel extends ViewModel {

    private MutableLiveData<String> mData;

    public IndexViewModel() {
        mData = new MutableLiveData<>();
    }

    public LiveData<String> getLiveData() {
        return mData;
    }
}