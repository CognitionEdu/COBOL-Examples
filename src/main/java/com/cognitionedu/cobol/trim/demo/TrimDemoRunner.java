package com.cognitionedu.cobol.trim.demo;

import com.cognitionedu.cobol.trim.service.StringTrimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TrimDemoRunner implements CommandLineRunner {
    
    @Autowired
    private StringTrimService trimService;
    
    @Override
    public void run(String... args) throws Exception {
        String testString1 = "    hello world               ";
        String testString2;
        
        System.out.println("--" + testString1 + "--");
        System.out.println("--" + trimService.trimBoth(testString1) + "--");
        System.out.println("--" + trimService.trimLeading(testString1) + "--");
        System.out.println("--" + trimService.trimTrailing(testString1) + "--");
        
        testString2 = "******************************";
        System.out.println(testString2);
        testString2 = testString1;
        System.out.println(testString2);
        
        testString2 = "******************************";
        System.out.println(testString2);
        testString2 = trimService.trimBoth(testString1);
        System.out.println(testString2);
        
        testString2 = "******************************";
        System.out.println(testString2);
        testString2 = trimService.trimLeading(testString1);
        System.out.println(testString2);
        
        testString2 = "******************************";
        System.out.println(testString2);
        testString2 = trimService.trimTrailing(testString1);
        System.out.println(testString2);
        
        System.out.println("--" + "    String literal    " + "--");
        System.out.println("--" + trimService.trimBoth("   String literal    ") + "--");
        System.out.println("--" + trimService.trimLeading("     String literal   ") + "--");
        System.out.println("--" + trimService.trimTrailing("   String literal    ") + "--");
    }
}
