package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.Service.ParcelService;
import com.oocl.packagebooking.model.Parcel;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PostMapping("/parcels")
    public Parcel addParcel(@RequestBody Parcel parcel){
        return parcelService.addParcel(parcel);
    }

    @PatchMapping("/parcels/{id}")
    public Parcel updateParcel(@PathVariable int id){
        return parcelService.updateParcel(id);
    }

}
