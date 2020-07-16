package com.example.controller;

import com.example.domain.store.Store;
import com.example.domain.store.StoreDto;
import com.example.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/store/list")
    public String dispStoreList(Model model){
        List<Store> storeList = storeService.findAll();
        List<StoreDto> collect = storeList.stream().map(StoreDto::new).collect(Collectors.toList());
        model.addAttribute("stores",collect);
        return "store/storeList";
    }

    @GetMapping("/store/new")
    public String createStoreForm(Model model){
        model.addAttribute("storeForm",new StoreDto());
        return "store/createStoreForm";
    }

    @PostMapping("/store/new")
    public String createStore(@Valid StoreDto storeDto, BindingResult result) {

        if (result.hasErrors()) {
            return "store/createStoreForm";
        }
        Store store = Store.builder().storeName(storeDto.getName())
                .address(storeDto.getAddress())
                .phoneNum(storeDto.getPhoneNum())
                .build();

        if (storeService.save(store)) {
            // 등록에 성공했을 경우
            return "redirect:/";
        } else {
            // 등록 실패했을 경우
            return "store/createStoreForm";
        }
    }
}
