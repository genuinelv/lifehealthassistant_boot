package com.example.lifehealthassistant.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class Diet {


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date datetime;


    private String food;
    private String dietname;
    private String picture1;
    private String picture2;
    private String picture3;

}
