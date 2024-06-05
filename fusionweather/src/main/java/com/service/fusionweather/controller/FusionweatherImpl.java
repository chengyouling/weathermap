package com.service.fusionweather.controller;

//import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.fusionweather.entity.FusionWeatherSummary;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2017-11-01T10:27:01.678+08:00")

@RestController
//@RequestMapping(path = "/fusionweather", produces = MediaType.APPLICATION_JSON)
@RequestMapping(path = "/fusionweather")
public class FusionweatherImpl {
  private static final Logger LOGGER = LoggerFactory.getLogger(FusionweatherImpl.class);

  @Autowired
  private FusionweatherImplDelegate userFusionweatherdataDelegate;

  @Autowired
  private FusionweatherImplBootDelegate bootDelegate;

  @RequestMapping(value = "/show",
      produces = {"application/json"},
      method = RequestMethod.GET)
  public FusionWeatherSummary show(@RequestParam(value = "city", required = true) String city,
      @RequestParam(value = "user", required = false) String user) {
    LOGGER.info("show() is called, city = [{}], user = [{}]", city, user);
    if (city.equals("boot")) {
      return bootDelegate.showFusionWeather(city, user);
    } else {
      return userFusionweatherdataDelegate.showFusionWeather(city, user);
    }
  }

  @RequestMapping(value = "/governanceTest",
      produces = {"application/json"},
      method = RequestMethod.GET)
  public Object circuitBreakerTest(@RequestParam(value = "errorTest", required = false) boolean errorTest)
      throws Exception {
    if (errorTest) {
      return userFusionweatherdataDelegate.forecastError();
    }
    return userFusionweatherdataDelegate.showFusionWeather("shenzhen", null);
  }
}
