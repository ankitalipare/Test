package com.base;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(features = "src/test/resources/features",
glue = "com.stepDefinations", dryRun = true, plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})
public class Runner extends AbstractTestNGCucumberTests{

}
