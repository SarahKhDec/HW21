package org.example.HW21.auth;

import org.example.HW21.configuration.MyUserDetailsService;
import org.example.HW21.dto.customer.RegisterCustomerDto;
import org.example.HW21.dto.expert.RegisterExpertDto;
import org.example.HW21.entity.Customer;
import org.example.HW21.entity.Expert;
import org.example.HW21.mappers.CustomerMapper;
import org.example.HW21.mappers.ExpertMapper;
import org.example.HW21.service.impl.ExpertServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final CustomerMapper customerMapper;
    private final ExpertMapper expertMapper;
    private final MyUserDetailsService myUserDetailsService;
    private final ExpertServiceImpl expertService;

    @PostMapping("/customer/register")
    public ResponseEntity<AuthenticationResponse> registerCustomer(@Valid @RequestBody RegisterCustomerDto registerCustomerDto) {
        Customer customer = customerMapper.dtoToCustomer(registerCustomerDto);
        return ResponseEntity.ok(service.registerCustomer(customer));
    }

    @PostMapping("/expert/register")
    public ResponseEntity<AuthenticationResponse> registerExpert(@Valid @ModelAttribute RegisterExpertDto expertDto, BindingResult result,
                                                                 @RequestParam("image") MultipartFile file) throws IOException, NoSuchMethodException, MethodArgumentNotValidException {
        if (result.hasErrors()) {
            throw new MethodArgumentNotValidException(new MethodParameter(getClass().getDeclaredMethod("create", RegisterExpertDto.class, BindingResult.class, MultipartFile.class), 0), result);
        }
        Expert expert = expertMapper.expertDtoToExpert(expertDto);
        return ResponseEntity.ok(service.registerExpert(expert, file));
    }

    @PostMapping("/customer/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateCustomer(@RequestBody AuthenticationRequest request) {
        StringBuffer str = new StringBuffer("customer");
        myUserDetailsService.setTableName(str);
        return ResponseEntity.ok(service.authenticateCustomer(request));
    }

    @PostMapping("/expert/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateExpert(@RequestBody AuthenticationRequest request) {
        StringBuffer str = new StringBuffer("expert");
        myUserDetailsService.setTableName(str);
        return ResponseEntity.ok(service.authenticateExpert(request));
    }

    @PostMapping("/admin/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateAdmin(@RequestBody AuthenticationRequest request) {
        StringBuffer str = new StringBuffer("admin");
        myUserDetailsService.setTableName(str);
        return ResponseEntity.ok(service.authenticateAdmin(request));
    }

    @GetMapping("/verify/expert")
    public ResponseEntity<String> verify(@RequestParam("token") String token) {
        Expert expert = expertService.verifyExpert(token);
        return new ResponseEntity<>(String.format("expert has been successfully verified with this email %s", expert.getEmail()), HttpStatus.OK);
    }
}
