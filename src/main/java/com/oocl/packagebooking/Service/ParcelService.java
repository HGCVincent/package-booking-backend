package com.oocl.packagebooking.Service;

import com.oocl.packagebooking.model.Parcel;

import java.util.List;

public interface ParcelService {
    List<Parcel> getAllParcel();

    Parcel getParcelByName(String status);

    Parcel addParcel(Parcel parcel);

    Parcel updateParcel(Parcel parcel);
}
