package com.oocl.packagebooking.Service;

import com.oocl.packagebooking.Repository.ParcelRespository;
import com.oocl.packagebooking.model.Parcel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

}
