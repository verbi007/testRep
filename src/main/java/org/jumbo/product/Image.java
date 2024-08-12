package org.jumbo.product;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Image {
    private String type;
    private ArrayList<Image> images;
    private Integer pos;
    private String url;
}
