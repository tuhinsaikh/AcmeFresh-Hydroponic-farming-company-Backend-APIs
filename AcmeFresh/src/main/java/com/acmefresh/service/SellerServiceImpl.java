package com.acmefresh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.CustomerException;
import com.acmefresh.model.Seller;
import com.acmefresh.repository.SellerDao;

@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	private SellerDao sellerDao;

	@Override
	public Seller registerSeller(Seller seller) {
		return sellerDao.save(seller);
	}

	@Override
	public Seller updateSellerDetails(Seller seller, Integer sellerId) {
		Optional<Seller> optSeller = sellerDao.findById(sellerId);
		if(optSeller.isEmpty()) {
			throw new CustomerException("seller not found");
		}
		Seller savedSeller = optSeller.get();
		savedSeller.setSellerAddress(seller.getSellerAddress());
		savedSeller.setSellerMobile(seller.getSellerMobile());
		savedSeller.setSellerName(seller.getSellerName());
		return sellerDao.save(savedSeller);
	}

}
