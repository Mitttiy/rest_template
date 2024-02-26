package org.example.output;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class Response {

    private RestTemplate restTemplate;

    public void makeApiRequests() {
        ResponseEntity<String> response1 = restTemplate.getForEntity("http://94.198.50.185:7081/api/users", String.class);
        String sessionId = response1.getHeaders().getFirst("set-cookie"); // извлекает значение заголовка "set-cookie" из ответа response1 и сохраняет его в переменную sessionId. Значение этого заголовка будет использоваться для аутентификации в последующих запросах.

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.COOKIE, sessionId); //добавляет заголовок "Cookie" в httpHeaders с значением sessionId. Это позволяет передавать аутентификационную информацию в последующих запросах.
        httpHeaders.setContentType(MediaType.APPLICATION_JSON); //устанавливает тип контента запроса как "application/json". Это указывает серверу, что тело запроса будет в формате JSON.

        User user1 = new User(3L, "James", "Brown", (byte) 20);
        HttpEntity<User> request1 = new HttpEntity<>(user1, httpHeaders); // - создает объект HttpEntity с телом запроса user1 и заголовками httpHeaders. HttpEntity представляет собой сущность запроса, которая содержит тело и заголовки.
        ResponseEntity<String> response2 = restTemplate.postForEntity("http://94.198.50.185:7081/api/users", request1, String.class); // POST-запрос для создания нового пользователя.
        String firstPartCode = response2.getBody();

        User user2 = new User(3L, "Thomas", "Shelby", (byte) 30);
        HttpEntity<User> request2 = new HttpEntity<>(user2, httpHeaders);
        ResponseEntity<String> response3 = restTemplate.exchange("http://94.198.50.185:7081/api/users", HttpMethod.PUT, request2, String.class);
        String secondPartCode = response3.getBody();

        ResponseEntity<String> response4 = restTemplate.exchange("http://94.198.50.185:7081/api/users/3", HttpMethod.DELETE, new HttpEntity<>(httpHeaders), String.class);
        String thirdPartCode = response4.getBody();

        String code = firstPartCode + secondPartCode + thirdPartCode;
        System.out.println("Сконкатинированный код = " + code + ", " + code.length() + " символов");
        //5ebfebe7cb975dfcf9
    }
}