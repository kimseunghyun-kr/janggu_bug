package janggu_bug.janggu_bug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import janggu_bug.janggu_bug.domain.JangGu;
import janggu_bug.janggu_bug.service.JangGuService;

@Controller
@RequestMapping("/buy")
public class JangGuListingController {

    @Autowired
    public JangGuService jangGuService;
    
    @GetMapping("/home")
    public String JangGuBuyHomePage() {
        return "/buy/home";
    }
    
    public String JangguSelectPurchase(@RequestParam("productId") Long id, Model model) {
        JangGu requestJanggu = jangGuService.findOnebyId(id);
        model.addAttribute(requestJanggu);
        return "/buy/JangGuPurchase";
    }

    @ResponseBody
    public Page<JangGu> JanguPageLoad(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return jangGuService.pageLoad(pageRequest);
    }
}
