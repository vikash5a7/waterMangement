package com.rubicon.watermanagment.service;

import org.springframework.stereotype.Service;

import com.rubicon.watermanagment.model.request.WaterUpdateStatusRequestModel;
import com.rubicon.watermanagment.shared.dto.WaterDto;


@Service
public interface WaterService {
	WaterDto CreateOrder(WaterDto userDto, String userId);
	WaterDto getSingleOrder(String email);
	WaterDto updateStatus(String userId, WaterUpdateStatusRequestModel update);
}
