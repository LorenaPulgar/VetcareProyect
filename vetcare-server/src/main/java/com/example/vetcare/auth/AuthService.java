package com.example.vetcare.auth;

import com.example.vetcare.entity.PetOwner;
import com.example.vetcare.entity.VeterinaryOffice;
import com.example.vetcare.enums.Role;
import com.example.vetcare.exception.AlreadyExistException;
import com.example.vetcare.exception.ResourceNotFoundException;
import com.example.vetcare.repository.PetOwnerRepository;
import com.example.vetcare.repository.VeterinaryOfficeRepository;
import lombok.RequiredArgsConstructor;
import com.example.vetcare.entity.User;
import com.example.vetcare.jwt.JwtService;
import com.example.vetcare.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PetOwnerRepository petOwnerRepository;
    private final VeterinaryOfficeRepository veterinaryRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request, Boolean isVeterinary) {
        User.UserBuilder userBuilder = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .phoneNumber(request.phoneNumber())
                .role(Role.PET_OWNER);

        if (isVeterinary) {
            userBuilder.role(Role.VETERINARY);
        }

        User user = userBuilder.build();
        Long petOwnerId = null;

        try {
            User savedUser = userRepository.save(user);

            if (isVeterinary) {
                veterinaryRepository.save(
                        VeterinaryOffice.builder()
                                .user(savedUser)
                                .address(request.address())
                                .build()
                );
            } else {
                petOwnerId = petOwnerRepository.save(
                        PetOwner.builder()
                                .user(savedUser)
                                .build()
                ).getId();
            }

        } catch (DataIntegrityViolationException err) {
            throw new AlreadyExistException("This email is already taken");
        }

        return new AuthResponse(jwtService.getToken(user), user.getId(), petOwnerId);
    }

    public AuthResponse login(LoginRequest request) {
        User userDetails = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        String token = jwtService.getToken(userDetails);
        var petOwner = petOwnerRepository.findPetOwnerByUser(userDetails);
        var petOwnerId = petOwner == null ? null : petOwner.getId();
        return new AuthResponse(token, userDetails.getId(), petOwnerId);
    }
}
