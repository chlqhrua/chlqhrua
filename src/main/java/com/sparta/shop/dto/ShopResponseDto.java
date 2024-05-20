package com.sparta.shop.dto;

import com.sparta.shop.entity.Shop;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShopResponseDto {
    private Long id;
    private String username;
    private String contents;
    private String title;
    private int price;

    public ShopResponseDto(Shop shop) {
        this.id = shop.getId();
        this.username = shop.getUsername();
        this.contents = shop.getContents();
        this.title = shop.title();
        this.price = shop.price();
    }
}
