package com.emsiair.emsiaiirmarrakech.Model;

import java.util.List;

public class RéservationRequest {

    private Long userId;
    private Long voyageId;
    private Long hotelId;
    private List<Long> activiteIds;

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(Long voyageId) {
        this.voyageId = voyageId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public List<Long> getActiviteIds() {
        return activiteIds;
    }

    public void setActiviteIds(List<Long> activiteIds) {
        this.activiteIds = activiteIds;
    }
}