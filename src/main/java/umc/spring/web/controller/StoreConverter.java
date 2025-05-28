package umc.spring.web.controller;

import umc.spring.domain.Review;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;

public class StoreConverter {

    // ... 기타 코드들 (8주차 미션에 있었던 리뷰 추가 등등)

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return null;
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList){
        return null;
    }
}