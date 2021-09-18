package com.rubicon.watermanagment.serviceimpl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubicon.watermanagment.entity.UserEntity;
import com.rubicon.watermanagment.entity.Water;
import com.rubicon.watermanagment.model.request.WaterUpdateStatusRequestModel;
import com.rubicon.watermanagment.respositary.UserRepository;
import com.rubicon.watermanagment.respositary.WaterRepository;
import com.rubicon.watermanagment.service.WaterService;
import com.rubicon.watermanagment.shared.dto.WaterDto;

@Service
public class WaterServiceImpl implements WaterService {

	@Autowired
	private WaterRepository waterRepository;

	@Autowired
	private UserRepository UserRepository;

	@Override
	public WaterDto CreateOrder(WaterDto dto, String UserId) {
		System.out.println("UserId" + UserId);
		Water waterEntity = new Water();
		UserEntity user = UserRepository.findByUserId(UserId);
		if (user == null) {
			return null;
		}
		BeanUtils.copyProperties(dto, waterEntity);

		waterEntity.setCreatedAt(new Date());
		waterEntity.setUserDetails(user);
		waterEntity.setDuration("skdfjhsd");
		waterEntity.setStatus("Requested");
		Water returnValue = waterRepository.save(waterEntity);
		WaterDto waterDto = new WaterDto();
		BeanUtils.copyProperties(returnValue, waterDto);
		System.out.println("Created order id: " + returnValue.getId());
		return waterDto;
	}

	@Override
	public WaterDto getSingleOrder(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WaterDto updateStatus(String userId, WaterUpdateStatusRequestModel update) {
		UserEntity user = UserRepository.findByUserId(userId);
		WaterDto waterDto = new WaterDto();
		if (user != null) {
			Optional<Water> water = waterRepository.findById(update.getId());
			if (water.isPresent()) {
				Water waterValue = water.get();
				System.out.println(waterValue.getStatus());
				if (user.getId() == waterValue.getUserDetails().getId()) {
					waterValue.setStatus(update.getStatus());
					waterRepository.save(waterValue);
					BeanUtils.copyProperties(waterValue, waterDto);
					return waterDto;

				}

			} else {
				throw new RuntimeException("Not found");
			}

		}
		return null;
	}

}
