package io.qdriven.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.MBeanServer;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.jmx.enabled=true")
@RunWith(SpringRunner.class)
@DirtiesContext
//@Import()
//@AutoConfigureWebTestClient
public class HelloWorldRestClientTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private  int portNo;

    @Autowired
    private MBeanServer mBeanServer;

    @Test
    public void helloWorld() throws Exception {
        System.out.println(this.portNo);
        String body = this.restTemplate.getForObject("/hello",String.class);
        assertThat(body).isEqualTo("Hello World!");
    }

    @Test
    public void useNewMBeanServer(){
       int mBeanCount =  this.mBeanServer.getMBeanCount();
        System.out.println(mBeanCount);
    }
}