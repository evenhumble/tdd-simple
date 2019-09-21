package io.qdriven.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
//@Import()
//@AutoConfigureWebTestClient
public class HelloWorldControllerClientTest {

    @Autowired
    private WebTestClient webClient;

    @LocalServerPort
    private  int portNo;

    @Test
    public void helloWorld() throws Exception {
        System.out.println(this.portNo);
        this.webClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Hello World!");
    }
}