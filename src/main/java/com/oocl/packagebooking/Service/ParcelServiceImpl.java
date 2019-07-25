package com.oocl.packagebooking.Service;

import com.oocl.packagebooking.Repository.ParcelRespository;
import com.oocl.packagebooking.model.Parcel;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;

@Service
public class ParcelServiceImpl implements ParcelService {

    @Resource
    ParcelRespository parcelRespository;

    @Override
    public List<Parcel> getAllParcel() {
        return parcelRespository.findAll();
    }

    @Override
    public Parcel getParcelByName(String status) {
        return parcelRespository.getByStatus(status);
    }

    @Override
    public Parcel addParcel(Parcel parcel) {
        return parcelRespository.save(parcel);
    }

    @Override
    public Parcel updateParcel(int id){
        Parcel parcel = parcelRespository.getById(id);
        parcel.setStatus("已取件");
        return parcelRespository.save(parcel);
    }
}
