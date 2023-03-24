package com.yashwin.blog.blogappapis.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    
    private int id;
    @NotEmpty
    @Size(min = 4, message = "username must be min of 4 characters")
    private String name;
    @Email(message = "Email address is not valid")
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be of min 3 chars and max 10 chars")
    private String password;
    @NotNull
    private String about;
}
