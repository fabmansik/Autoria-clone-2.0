package milansomyk.springboothw.controllers;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import milansomyk.springboothw.dto.ModelDto;
import milansomyk.springboothw.dto.ProducerDto;
import milansomyk.springboothw.dto.UserDto;
import milansomyk.springboothw.dto.response.ResponseContainer;
import milansomyk.springboothw.service.entityServices.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final ModelService modelService;
    private final ProducerService producerService;
    private final ImageService imageService;
    private final CurrencyService currencyService;

    @PostMapping("/managers")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseContainer> createManager(@RequestBody UserDto userDto){
        ResponseContainer responseContainer = userService.createManager(userDto);
        return ResponseEntity.status(responseContainer.getStatusCode()).body(responseContainer);
    }
    @PostMapping("/producer")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseContainer> addProducer(@RequestBody ProducerDto producerDto){
        ResponseContainer responseContainer = producerService.addProducer(producerDto);
        return ResponseEntity.status(responseContainer.getStatusCode()).body(responseContainer);
    }
    @PostMapping("/model")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseContainer> addModel(@RequestBody ModelDto model, @RequestParam Integer producerId){
        ResponseContainer responseContainer = modelService.addModel(producerId, model);
        return ResponseEntity.status(responseContainer.getStatusCode()).body(responseContainer);
    }
    @PostMapping("/currency")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseContainer> uploadCurrencies(){
        ResponseContainer responseContainer = currencyService.uploadCurrencies();
        return ResponseEntity.status(responseContainer.getStatusCode()).body(responseContainer);
    }
    @GetMapping("/managers")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseContainer> getAllManagers(){
        ResponseContainer responseContainer = userService.getAllManagers();
        return ResponseEntity.status(responseContainer.getStatusCode()).body(responseContainer);
    }
    @PutMapping("/managers")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseContainer> setManagerById(@RequestParam int id){
        ResponseContainer responseContainer = userService.setManager(id);
        return ResponseEntity.status(responseContainer.getStatusCode()).body(responseContainer);
    }
    @PutMapping("/premium")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseContainer> setPremiumById(@RequestParam int id){
        ResponseContainer responseContainer = userService.setPremium(id);
        return ResponseEntity.status(responseContainer.getStatusCode()).body(responseContainer);
    }
    @DeleteMapping("/users")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseContainer> deleteUserById(@RequestParam int id){
        ResponseContainer responseContainer = userService.deleteUserById(id);
        return ResponseEntity.status(responseContainer.getStatusCode()).body(responseContainer);
    }
    @DeleteMapping("/images")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseContainer> deleteImageById(@RequestParam Integer carId, @RequestParam Integer imageId){
        ResponseContainer responseContainer = imageService.deleteImage(imageId, carId);
        return ResponseEntity.status(responseContainer.getStatusCode()).body(responseContainer);
    }
}
