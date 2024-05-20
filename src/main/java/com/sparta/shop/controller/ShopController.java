package com.sparta.shop.controller;

import com.sparta.shop.dto.ShopRequestDto;
import com.sparta.shop.dto.ShopResponseDto;
import com.sparta.shop.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/shops")
    public ShopResponseDto createShop(@RequestBody ShopRequestDto requestDto) {
        return shopService.createShop(requestDto);
    }

    @GetMapping("/shops")
    public List<ShopResponseDto> getShops() {
        return shopService.getShops();
    }

    @PutMapping("/shops/{id}")
    public Long updateShop(@PathVariable Long id, @RequestBody ShopRequestDto requestDto) {
        return shopService.updateShop(id, requestDto);
    }

    @DeleteMapping("/shops/{id}")
    public Long deleteShop(@PathVariable Long id) {
        return shopService.deleteShop(id);
    }
}
