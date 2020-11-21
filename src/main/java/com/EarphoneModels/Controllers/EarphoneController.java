package com.EarphoneModels.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EarphoneModels.Repositories.EarphoneRepository;
import com.EarphoneModels.Entitys.Earphone;

@RestController
@RequestMapping("/api/earphones")
public class EarphoneController extends BaseController<Earphone, EarphoneRepository>{

}
