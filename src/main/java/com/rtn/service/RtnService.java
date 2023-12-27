package com.rtn.service;

import org.springframework.stereotype.Service;

import com.rtn.model.Rtn;
@Service
public interface RtnService {

    Rtn getProductById(Integer productId);
}
