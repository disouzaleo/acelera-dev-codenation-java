package br.com.codenation.aplicacao.controller;

import br.com.codenation.aplicacao.domain.vo.CompanyVO;
import br.com.codenation.aplicacao.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public CompanyVO createCompany(@RequestBody CompanyVO company) {

        return companyService.createCompany(company);
        //ResponseEntity.ok().build();
    }

    @GetMapping
    public List<CompanyVO> findAllByName(@RequestParam String name){
        return companyService.findAllByName(name);
    }

    @DeleteMapping
    public void deleteCompany(@Param("id") Long id){
        companyService.deleteById(id);
    }



////    @GetMapping("/")
//    @RequestMapping(value = "/teste", method = RequestMethod.GET)
//    @ResponseBody
//    public String teste(){
//        return "Ok";
////        return ResponseEntity.ok().build();
//    }
//
//    public void deleteCompany() {
//
//    }

}
