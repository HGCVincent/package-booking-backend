package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.Service.ParcelService;
import com.oocl.packagebooking.model.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PracelController {
    @Autowired
    ParcelService parcelService;

    @GetMapping("/parcels")
    public List<Parcel> getAllParcel(){
        return parcelService.getAllParcel();
    }

    @GetMapping("/parcels/{status}")
    public Parcel getParcelByStatus(@PathVariable String status){
        return parcelService.getParcelByName(status);
    }
}
