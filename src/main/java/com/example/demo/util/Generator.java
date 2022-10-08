package com.example.demo.util;

import com.example.demo.dto.core.GeneratedIdentificationDTO;

import com.example.demo.repo.CatagoryRepo;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Generator {
private final CatagoryRepo catagoryRepo;

    public Generator(CatagoryRepo catagoryRepo) {
        this.catagoryRepo = catagoryRepo;
    }
//    private final DeliveryPartnerRepo deliveryPartnerRepo;
//
//    public Generator(DeliveryPartnerRepo deliveryPartnerRepo) {
//        this.deliveryPartnerRepo = deliveryPartnerRepo;
//    }

    private final Random RANDOM = new Random();
    private final String NUMERIC = "0123456789";
    public final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";



    public Long generateDigits(int length) {
        return generateRandomDigits(length);
    }

    private Long generateRandomDigits(int length) {
        StringBuilder returnValue = new StringBuilder(length);


        for (int i = 0; i < length; i++) {
            returnValue.append(NUMERIC.charAt(RANDOM.nextInt(NUMERIC.length())));
        }
        return Long.parseLong(returnValue.toString());
    }

    public GeneratedIdentificationDTO createId() {
        StringBuilder sb = new StringBuilder(4);

//            int randomNumber = new Random().nextInt(16 - 1) + 1;
            for (int i = 0; i < 4; i++) {

                int index = (int) (ALPHABET.length() * Math.random());

                sb.append(ALPHABET.charAt(index));
            }




        Long digits = generateDigits(8);

        return new GeneratedIdentificationDTO(digits, sb.toString());
    }

//    public String createNewDeliveryPartnerId(String prefix) {
//        String lastId = deliveryPartnerRepo.findLastId(prefix+"-DP-",prefix.length()+4);
//        if (lastId == null) {
//            return prefix + "-DP-1";
//        }
//
//        int i = (Integer.parseInt(lastId.split(prefix + "-DP-")[1]))+1;
//        System.out.println(i);
//        return prefix + "-DP-" + i;
//    }
public String createCatagoryCode(String prefix) {
    String lastId = catagoryRepo.findLastId(prefix+"-B-",prefix.length()+4);
    if (lastId == null) {
        return prefix + "-B-1";
    }

    int i = (Integer.parseInt(lastId.split(prefix + "-B-")[1]))+1;
    System.out.println(i);
    return prefix + "-B-" + i;
}
}
