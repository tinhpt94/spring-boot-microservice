package com.tinhpt.order.service;

import com.tinhpt.order.dto.*;
import com.tinhpt.order.entities.*;
import org.springframework.beans.BeanUtils;

class EntityDTOUtils {
    static SaleResponse mapEmployeeEntityToSaleDTO(EmployeeEntity entity) {
        SaleResponse response = new SaleResponse();
        BeanUtils.copyProperties(entity, response);
        response.setCommissionRate(getCommissionRate(entity.getRole()));
        return response;
    }

    static Double getCommissionRate(RoleEntity roleEntity) {
        if (Role.TELE_SALE.toString().equals(roleEntity.getName())) return 1.0;
        if (Role.SALE.toString().equals(roleEntity.getName())) return 7.0;
        if (Role.SALE_ADMIN.toString().equals(roleEntity.getName())) return 0.1;
        if (Role.SALE_MANAGER.toString().equals(roleEntity.getName())) return 4.5;
        return 0.0;
    }

    static EmployeeResponse mapEmployeeEntityToEmployeeDTO(EmployeeEntity entity) {
        EmployeeResponse response = new EmployeeResponse();
        BeanUtils.copyProperties(entity, response);
        response.setRole(entity.getRole().getName());
        response.setJobTitle(entity.getRole().getJobTitle());
        return response;
    }

    static CustomerResponse mapCustomerEntityToDTO(CustomerEntity entity) {
        CustomerResponse response = new CustomerResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    static DepartmentResponse mapDepartmentEntityToDTO(DepartmentEntity entity) {
        DepartmentResponse response = new DepartmentResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    static PaymentResponse mapPaymentHistoryEntityToDTO(PaymentHistoryEntity entity) {
        PaymentResponse response = new PaymentResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    static OrderResponse mapOrderEntityToDTO(OrderEntity entity) {
        OrderResponse response = new OrderResponse();
        BeanUtils.copyProperties(entity, response);
        response.setTeleSale(mapEmployeeEntityToSaleDTO(entity.getTeleSale()));
        response.setSale(mapEmployeeEntityToSaleDTO(entity.getSale()));
        response.setSaleAdmin(mapEmployeeEntityToSaleDTO(entity.getSaleAdmin()));
        response.setSaleManager(mapEmployeeEntityToSaleDTO(entity.getSaleManager()));
        response.setCardName(entity.getCardDetail().toString());
        return response;
    }

    static CardDetailResponse mapCardDetailEntityToResponse(CardDetailEntity entity) {
        CardDetailResponse response = new CardDetailResponse();
        BeanUtils.copyProperties(entity, response);
        CardTypeResponse cardTypeResponse = new CardTypeResponse();
        BeanUtils.copyProperties(entity.getCardType(), cardTypeResponse);
        response.setCardType(cardTypeResponse);
        SeasonTypeResponse seasonTypeResponse = new SeasonTypeResponse();
        BeanUtils.copyProperties(entity.getSeasonType(), seasonTypeResponse);
        response.setSeasonType(seasonTypeResponse);
        RoomTypeResponse roomTypeResponse = new RoomTypeResponse();
        BeanUtils.copyProperties(entity.getRoomType(), roomTypeResponse);
        response.setRoomType(roomTypeResponse);
        return response;
    }


}
