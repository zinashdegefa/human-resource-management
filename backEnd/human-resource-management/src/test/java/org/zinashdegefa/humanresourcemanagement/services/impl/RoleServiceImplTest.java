package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.Role;
import org.zinashdegefa.humanresourcemanagement.repositories.RoleRepository;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleServiceImplTest {

    @Autowired
    private RoleServiceImpl roleService;

    @MockBean
    private RoleRepository roleRepository;

    private static Stream<Arguments> parametersValue() {
        return Stream.of(
                Arguments.of("TestRoleName", "TestRoleName"),
                Arguments.of("TestRoleName ", "TestRoleName"),
                Arguments.of("TestRoleName      ", "TestRoleName"),
                Arguments.of(" TestRoleName", "TestRoleName"),
                Arguments.of(" TestRoleName ", "TestRoleName")
        );
    }

    @ParameterizedTest
    @MethodSource("parametersValue")
    void saveRole(String value, String expected) {

        Role role = getRole(value);

        Mockito.when(roleRepository.save(role)).thenReturn(role);
        Role savedRole = roleService.saveRole(role);

        System.out.println("Saved Role: " + role);
        Assertions.assertEquals(expected, savedRole.getRoleName());
    }

    private Role getRole(String roleName) {
        return Role
                .builder()
                .roleName(roleName)
                .build();
    }
}