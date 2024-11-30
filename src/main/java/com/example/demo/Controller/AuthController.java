package com.example.demo.Controller;//package com.example.demo.Controller;
//
//import com.example.demo.DTO.IMPL.UserDTO;
//import com.example.demo.Exception.DataPersistException;
//import com.example.demo.Secure.JWTAuthResponse;
//import com.example.demo.Service.AuthService;
//import com.example.demo.Service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("api/vi/auth")
//public class AuthController {
//    private final UserService userService;
//    private final AuthService authService;
//    private final PasswordEncoder passwordEncoder;
//
//    @PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<JWTAuthResponse> saveUser(@RequestPart("email") String email,
//                                                    @RequestPart("password") String password,
//                                                    @RequestPart("role") String role) {
//
//        try {
//            UserDTO userDTO = new UserDTO();
//            userDTO.setEmail(email);
//            userDTO.setPassword(passwordEncoder.encode(password));
//            userDTO.setRole(role);
//            userService.saveUser(userDTO);
//            return ResponseEntity.ok(authService.signUp(userDTO));
//        } catch (DataPersistException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
