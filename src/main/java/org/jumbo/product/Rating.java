package org.jumbo.product;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Rating {
    private String all;
    private Integer rating_type;
    private String dynamic;
    private ArrayList<DynamicHistory> dynamic_history;
    private StarsCount stars_count;
    private ArrayList<Manufacturer> manufacturers;
}
