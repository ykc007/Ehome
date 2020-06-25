package com.fly.tour.api;

import com.fly.tour.api.dto.RespDTO;
import com.fly.tour.api.entity.BaseEntity;
import com.fly.tour.api.entity.ContractEntity;
import com.fly.tour.api.entity.LoginEntity;
import com.fly.tour.api.entity.SalesOrderEntity;
import com.fly.tour.api.security.Token;
import com.fly.tour.api.user.LoginDTO;

import io.reactivex.Observable;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CommonService {

    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("user/login")
    Observable<LoginEntity> login( @Query("sign") String sign);

    @POST("/oauth/token")
    Observable<Token> getToken(@Header(value = "Authorization") String authorization, @Query("grant_type") String type,
                               @Query("username") String username, @Query("password") String password);

    @POST("order/index")
    Observable<SalesOrderEntity> getSalesOrder(@Header(value = "Authorization") String authorization, @Query("page") int page,
                                               @Query("show_num") int show_num, @Query("sign") String sign);

    @POST("contract/index")
    Observable<ContractEntity> getContract(@Header(value = "Authorization") String authorization, @Query("page") int page,
                                           @Query("show_num") int show_num);

}
