package com.sparta.shop.repository;

import com.sparta.shop.entity.Shop;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long>{
    List<Shop> findAllByOrderByModifiedAtDesc();
    List<Shop> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);
}
