package org.jumbo.product;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Manufacturer {
    private Integer manufacturer_id;
    private String manufacturer_name;
    private String rating;
    private Integer rating_type;
    private Integer star1;
    private Integer star2;
    private Integer star3;
    private Integer star4;
    private Integer star5;
    private String dynamic;
    private ArrayList<DynamicHistory> dynamic_history;
}
