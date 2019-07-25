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
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
        parcel.setId(1234565132);
        parcel.setPhoneNumber("12378914561245");
        parcel.setRecipient("陈先生");
        parcel.setStatus("未取件");

        List<Parcel> parcels = new ArrayList<>();
        parcels.add(parcel);

        String ParcelJson = "{\n" +
                "\"id\": 1234565132,\n" +
                "\"phonenumber\": \"12378914561245\",\n" +
                "\"recipient\": \"陈先生\"\n" +
                "}";

        when(parcelService.getAllParcel()).thenReturn(parcels);

        mvc.perform(post("/parcels").contentType(MediaType.APPLICATION_JSON).content(ParcelJson));

        ResultActions result = mvc.perform(get("/parcels"));

        result.andExpect(status().isOk()).andExpect((ResultMatcher) jsonPath("$.recipient",is("陈先生")));
    }

    @Test
    public void should_get_pracel_by_status() throws Exception {
        Parcel parcel = new Parcel();
        parcel.setId(1234565132);
        parcel.setPhoneNumber("12378914561245");
        parcel.setRecipient("陈先生");
        parcel.setStatus("未取件");

        List<Parcel> parcels = new ArrayList<>();
        parcels.add(parcel);

        String ParcelJson = "{\n" +
                "\"id\": 1234565132,\n" +
                "\"phonenumber\": \"12378914561245\",\n" +
                "\"recipient\": \"陈先生\"\n" +
                "}";

        when(parcelService.getAllParcel()).thenReturn(parcels);

        mvc.perform(post("/parcels").contentType(MediaType.APPLICATION_JSON).content(ParcelJson));

        ResultActions result = mvc.perform(get("/parcels/{status}","未取件"));

        result.andExpect(status().isOk()).andExpect((ResultMatcher) jsonPath("$.recipient",is("陈先生")));
    }

    @Test
    public void should_add_parcel() throws Exception {
        Parcel parcel =new Parcel();
        parcel.setId(1234565132);
        parcel.setPhoneNumber("12378914561245");
        parcel.setRecipient("陈先生");
        parcel.setStatus("未取件");

        String ParcelJson = "{\n" +
                "\"id\": 1234565132,\n" +
                "\"phonenumber\": \"12378914561245\",\n" +
                "\"recipient\": \"陈先生\"\n" +
                "}";

        when(parcelService.addParcel(any())).thenReturn(parcel);
        ResultActions result = mvc.perform(post("/parcels").contentType(MediaType.APPLICATION_JSON).content(ParcelJson));

        result.andExpect(status().isOk()).andExpect((ResultMatcher) jsonPath("$.recipient",is("陈先生")));

        verify(parcelService).addParcel(any());
    }
}
