package com.ioomex.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author sutton
 * @since 2024-05-04 22:17
 */
@Slf4j
@RestController
public class TestController {

  @GetMapping("/test")
public String test() {
    log.info("test");
    return "test";
  }
}