package org.jumbo.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String title;
    private Double amount;
    private Double amount_express;
    private Double amount_tomorrow;
    private Boolean adults_only;
    private Boolean is_favorite;
    private Boolean is_archived;
    private String unit;
    private String weight_kg;
    private String weight_step;
    private String weight_type;
    private String weight_str;
    private String description;
    private Price price;
    private Object modifications;
    private Button button;
    private ArrayList<Image> images;
    private ArrayList<Object> labels;
    private Object labels_loyalty;
    private Rating rating;
    private Cashback cashback;
    private Object backlight_color;
    private ExpressToggle express_toggle;
    private Boolean in_archive;
    private Check check;
    private Object licenses;
    private Object protocol_log;
    private Dynamic dynamic;
    private Object analogs;
    private ArrayList<Property> properties;
    private Boolean possible_prefer;
    private Integer can_estimate;
    private Object sets;
}
