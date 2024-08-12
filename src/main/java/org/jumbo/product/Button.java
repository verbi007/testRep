package org.jumbo.product;

import lombok.Data;

@Data
public class Button {
    private Integer id;
    private String color_button;
    private String text;
    private String color_text;
    private String color_text_dark;
    private String icon_url;
    private String color_button_dark;
    private String url_by_tap;
    private String type_button;
    private Object meta;
}
