package cn.xq.festec.banxiaappuser20.http.request;

import java.util.List;

import cn.xq.festec.banxiaappuser20.http.response.Response;
import cn.xq.festec.banxiaappuser20.model.department.Department;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DepartmentRequest {

    @GET("department/list")
    Observable<Response<List<Department>>> list();

}

