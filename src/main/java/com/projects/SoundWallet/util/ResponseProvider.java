package com.projects.SoundWallet.util;

import com.projects.SoundWallet.pojos.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@AllArgsConstructor
public class ResponseProvider {

    public ResponseEntity<ApiResponse<Object>> success(Object payload){
        return ResponseEntity.ok().body(
                new ApiResponse<>("Request Successful", true, payload));
    }

    public ResponseEntity<ApiResponse<Object>> validationFailure(String message){
        return ResponseEntity.badRequest().body(
                new ApiResponse<>(message, false, null));
    }
    public ResponseEntity<ApiResponse<Object>> authFailure(String message){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new ApiResponse<>(message, false, null));
    }
}
