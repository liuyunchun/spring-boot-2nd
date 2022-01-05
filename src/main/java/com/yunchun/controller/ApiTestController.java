package com.yunchun.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunchun.domain.WeatherAPI;
import org.h2.util.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller("com.yunchun.controller.ApiTestController")
public class ApiTestController {

    @GetMapping("/api")
    public String apiTestForm(){
        return "/font/api/index";
    }

    @PostMapping("/callapi")
    public String callApi(Model model){
        String url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0001-001?Authorization=rdec-key-123-45678-011121314";

        try {
            InputStream is = new URL(url).openStream();

            BufferedReader rd =  new BufferedReader(new InputStreamReader(is, "utf-8"));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }

            ObjectMapper objectMapper = new ObjectMapper();
//            List<WeatherAPI> result = objectMapper.readValue(sb, new TypeReference<List<WeatherAPI>>(){});
            List<WeatherAPI> result = objectMapper.readValue(sb, objectMapper.getTypeFactory().constructCollectionType(List.class, WeatherAPI.class));
            WeatherAPI data = objectMapper.readValue(sb.toString(), WeatherAPI.class);

            model.addAttribute("data", data);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/font/api/list";
    }
}
