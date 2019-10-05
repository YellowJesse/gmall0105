package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper addressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        // 这是手动写法
        // List<UmsMember> umsMembers = userMapper.selectAllUser();

        // 这是使用通用mapper的写法
        List<UmsMember> umsMembers = userMapper.selectAll();

        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {

        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);

        // umsMemberReceiveAddress这个JavaBean的memberId这个字段非空，那么它就是select() 的过滤条件。
        List<UmsMemberReceiveAddress> receiveAddresses = addressMapper.select(umsMemberReceiveAddress);

        return receiveAddresses;
    }
}
