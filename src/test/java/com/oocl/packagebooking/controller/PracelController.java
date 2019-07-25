package com.oocl.packagebooking.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.Service.ParcelService;
import com.oocl.packagebooking.model.Parcel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PracelController.class)
public class PracelController {
    @Autowired
    MockMvc mvc;
    
    @MockBean
    ParcelService parcelService;

    @Test
    public void should_get_all_pracel_info() throws Exception {
        Parcel parcel = new Parcel();
        parcel.setId(12345651321l);
        parcel.setPhoneNumber("12378914561245");
        parcel.setRecipient("陈先生");
        parcel.setStatus("未取件");

        List<Parcel> parcels = new ArrayList<>();
        parcels.add(parcel);

        when(parcelService.getAllParcel()).thenReturn(parcels);

        mvc.perform(post("/parcels").contentType(MediaType.APPLICATION_JSON).content());

        ResultActions result = mvc.perform(get("/parcels"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$recipient",is("陈先生")));




    }
}
