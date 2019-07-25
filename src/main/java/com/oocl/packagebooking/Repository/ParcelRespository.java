package com.oocl.packagebooking.Repository;

import com.oocl.packagebooking.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParcelRespository extends JpaRepository<Parcel,Integer> {
    public Parcel getByStatus(String status);
}
