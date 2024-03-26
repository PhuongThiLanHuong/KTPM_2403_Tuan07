package vn.edu.iuh.fit.user.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.user.dto.ProductDTO;
import vn.edu.iuh.fit.user.dto.UserDTO;
import vn.edu.iuh.fit.user.models.User;
import vn.edu.iuh.fit.user.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users=userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getApi() {
        RestTemplate restTemplate = new RestTemplate();

        String request = "http://localhost:8081/ap1/v2/products";
        ProductDTO[] productDTOS = restTemplate.getForObject(request, ProductDTO[].class);
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (int i = 1; i < Objects.requireNonNull(productDTOS).length; i++) {
            ProductDTO productDTO = productDTOS[i];
            User user = users.get(i);
            UserDTO userDTO = UserDTO.builder().
                    userId(user.getId())
                    .productId(productDTO.getId())
                    .namePerson(user.getNamePerson())
                    .name(productDTO.getName())
                    .price(productDTO.getPrice()).build();

            userDTOS.add(userDTO);
        }
        return ResponseEntity.ok(userDTOS);
    }


}
