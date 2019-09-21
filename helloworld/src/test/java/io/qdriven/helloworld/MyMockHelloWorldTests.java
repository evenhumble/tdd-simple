//package io.qdriven.helloworld;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import static org.mockito.BDDMockito.*;
//import static org.assertj.core.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MyMockHelloWorldTests {
//
//	@MockBean
//	private RemoteService remoteService;
//
//	@Autowired
//	private Reverser reverser;
//
//	@Test
//	public void exampleTest() {
//		// RemoteService has been injected into the reverser bean
//		given(this.remoteService.someCall()).willReturn("mock");
//		String reverse = reverser.reverseSomeCall();
//		assertThat(reverse).isEqualTo("kcom");
//	}
//
//}