# Test Hello World API

First of all, we create a very simple API,***hello world***:

```java 

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){

        return ResponseEntity.ok("Hello World!");
    }
}
```

The Function is simple: GET "/hello", then return "Hello World!"

