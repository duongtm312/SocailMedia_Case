package com.teamone.socialmediaproject.model.dto;

import lombok.Data;


import java.util.Map;

@Data
public class DataMailDTO {
   private String to;
   private String subject;
   private String content;
   private Map<String,Object> props;
}
