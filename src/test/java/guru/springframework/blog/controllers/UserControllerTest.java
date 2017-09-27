package guru.springframework.blog.controllers;

import guru.springframework.blog.BlogPostsApplication;
import guru.springframework.blog.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

/**
 * Created by Simanta.Sarma on 27-09-2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogPostsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {


    String user1;

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    User user;

    @Before
    public void setUp() throws Exception {
         user = new User("3","Paul Dawson",25);
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSaveUser() throws Exception {

        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/add"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User saved successfully",actual);
    }

    @Test
    public void testList() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/list"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);

    }
    @Test
    public void testGetUser() throws Exception {

    }
    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}