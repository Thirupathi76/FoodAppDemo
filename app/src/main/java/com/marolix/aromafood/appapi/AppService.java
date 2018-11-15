package com.marolix.aromafood.appapi;

import com.marolix.aromafood.bean.Categories;
import retrofit2.Call;
import retrofit2.http.GET;


public interface AppService {


    /*@GET("job_list.json")
    Call<JobList> getJobList();

    @GET("product_list.json")
    Call<ProdList> getProdList();*/

    @GET("categories.json")
    Call<Categories> getCategories();
    /*
            @Field("username") String user_name,
            @Field("password") String password,
            @Field("imei_no") String imei
    );*/

    /*@FormUrlEncoded
    @POST("location_details.php")
    Call<LocationDetails> sendLocation(
            @Field("loc_det") String user_name,
            @Field("emp_id") String password
    );


    @FormUrlEncoded
    @POST("employeetracking_report.php")
    Call<ResponseReport> getTravelDetails(
            @Field("emp_id") String emp_id,
            @Field("report_type") String report_type,
            @Field("from_date") String from_date,
            @Field("to_date") String to_date
    );

    @FormUrlEncoded
    @POST("logout.php")
    Call<ResponseStatus> logoutData(
            @Field("emp_id") String emp_id,
            @Field("distance") String distance,
            @Field("login_first_rec_time") String login_first_rec_time,
            @Field("login_time") String login_time,
            @Field("logout_time") String logout_time,
            @Field("date") String date,
            @Field("last_lat") String lat,
            @Field("last_lon") String lon
    );

//    @Field("imei") String imei

    @FormUrlEncoded
    @POST("forgot_password.php")
    Call<ResponseStatus> getPassword(
            @Field("username") String user_name,
            @Field("mobile") String mobile,
            @Field("imei") String imei
    );*/

}
