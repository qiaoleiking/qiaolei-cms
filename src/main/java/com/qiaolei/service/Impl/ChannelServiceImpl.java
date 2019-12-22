package com.qiaolei.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiaolei.beans.Channel;
import com.qiaolei.mapper.ChannelMapper;
import com.qiaolei.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
	
	@Autowired
	private ChannelMapper mapper;

	@Override
	public List<Channel> getChannelList() {
		// TODO Auto-generated method stub
		return mapper.getChanneList();
	}
}
