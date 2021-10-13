package com.sydml.k8s;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuming
 * @date 2021-10-13 9:51:43
 */
@RestController
public class KuberController {
    @GetMapping
    public String helloK8s(){
        return "hello k8s";
    }
}
