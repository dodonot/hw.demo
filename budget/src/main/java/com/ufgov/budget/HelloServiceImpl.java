package com.ufgov.budget;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

@RestSchema(schemaId = "hello")
@RequestMapping(path = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
public class HelloServiceImpl implements Hello {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHi(String name) {
        String ret = "Hello from Budget [name = " + name + "]";
        log.debug("--- BudgetService.sayHi()  ret = " + ret);
        return ret;
    }

}
