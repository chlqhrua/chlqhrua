package com.sparta.shop.service;

import com.sparta.shop.dto.ShopRequestDto;
import com.sparta.shop.dto.ShopResponseDto;
import com.sparta.shop.entity.Shop;
import com.sparta.shop.repository.ShopRepository;

import java.util.List;

public class ShopService {
    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public ShopResponseDto createShop(ShopRequestDto requestDto) {
        // RequestDto -> Entity(table 내 한 줄)
        Shop shop = new Shop(requestDto);

        // DB 저장
        Shop saveShop = shopRepository.save(shop);

        // Entity -> ResponseDto
        ShopResponseDto shopResponseDto = new ShopResponseDto(shop);

        return shopResponseDto;
    }

    public List<ShopResponseDto> getShops() {
        // DB 조회
        return shopRepository.findAllByOrderByModifiedAtDesc().stream().map(ShopResponseDto::new).toList();
    }

    @Transactional
    public Long updateShop(Long id, ShopRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Shop shop = findShop(id);

        // shop 내용 수정
        shop.update(requestDto);

        return id;
    }

    public Long deleteShop(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Shop shop = findShop(id);

        // shop 삭제
        shopRepository.delete(shop);

        return id;
    }

    private Shop findShop(Long id){
        return shopRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}
